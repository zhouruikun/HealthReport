import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <h3>HealthReport</h3>
 * <p></p>
 *
 * @author : ZhouKun
 * @date : 2020-03-19 14:46
 **/
public class ReportJop implements Job {
//    private static final Logger logger = LoggerFactory.getLogger(ReportJop.class);
private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    static int count=0;
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
        String date = sDateFormat.format(new Date());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        logger.info(date + "开始自动打卡");
        try {
            if (Report(Login(jobDataMap.getString("mobile"), Crypt.getEncryped(jobDataMap.getString("password"))))) {
                logger.info(date + "自动打卡成功");
                count++;
                logger.info("已经自动打卡"+count+"次");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    static LoginResModel Login(String mobile, String password) throws IOException, URISyntaxException {
        logger.info("开始自动登陆账号：" + mobile);
        // 2. 使用标准的JRE代理选择器，即使用系统代理
        SystemDefaultRoutePlanner routePlanner = new SystemDefaultRoutePlanner(
                ProxySelector.getDefault());
        CloseableHttpClient httpclient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .build();

        HttpPost httpPost = new HttpPost("http://www.cncico.group/loginapi/login");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("mobile", mobile));
        nvps.add(new BasicNameValuePair("password", password));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        LoginResModel loginResModel;
        CloseableHttpResponse response2 = httpclient.execute(httpPost);
        try {
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            loginResModel = JSON.parseObject(EntityUtils.toString(entity2), LoginResModel.class);
            httpPost.setURI(new URI("http://www.cncico.group/apis/loginByToken"));
            nvps.clear();
            nvps.add(new BasicNameValuePair("token", loginResModel.getResult().getToken()));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            response2 = httpclient.execute(httpPost);
            entity2 = response2.getEntity();
            loginResModel = JSON.parseObject(EntityUtils.toString(entity2), LoginResModel.class);
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }
        logger.info("登陆成功：" + mobile);
        return loginResModel;
    }

    static boolean Report(LoginResModel loginResModel) throws IOException {
        logger.info("开始上报信息：" + loginResModel.getResult().getUserName());
        boolean status = false;
        SystemDefaultRoutePlanner routePlanner = new SystemDefaultRoutePlanner(
                ProxySelector.getDefault());
        CloseableHttpClient httpclient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .build();
        HttpPost httpPost = new HttpPost("http://www.cncico.group/apis/attendance/save");
        httpPost.addHeader("Authorization", loginResModel.getResult().getToken());
//        httpPost.addHeader("Content-Type","multipart/form-data; boundary=--------------------------498543378463759254353955");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDateFormat.format(new Date());
        nvps.add(new BasicNameValuePair("staffId", loginResModel.getResult().getId()));
        nvps.add(new BasicNameValuePair("date", date));
        nvps.add(new BasicNameValuePair("address", "鄞州区"));
        nvps.add(new BasicNameValuePair("attendance", "2"));
        nvps.add(new BasicNameValuePair("cityId", "330200"));
        nvps.add(new BasicNameValuePair("cityName", "宁波市"));
        nvps.add(new BasicNameValuePair("codeColor", "1"));
        nvps.add(new BasicNameValuePair("codeDes", ""));
        nvps.add(new BasicNameValuePair("company", "05D"));
        nvps.add(new BasicNameValuePair("companyId", "工商职院"));
        nvps.add(new BasicNameValuePair("hbConcat", "2"));
        nvps.add(new BasicNameValuePair("health", "1"));
        nvps.add(new BasicNameValuePair("healthdes", ""));
        nvps.add(new BasicNameValuePair("isFace", "2"));
        nvps.add(new BasicNameValuePair("otherConcat", "2"));
        nvps.add(new BasicNameValuePair("otherConcatDes", ""));
        nvps.add(new BasicNameValuePair("outConcatMan", "1"));
        nvps.add(new BasicNameValuePair("outConcatManDes", ""));
        nvps.add(new BasicNameValuePair("outPlayStatus", "1"));
        nvps.add(new BasicNameValuePair("outPlayStatusDes", ""));
        nvps.add(new BasicNameValuePair("proviceId", "330000"));
        nvps.add(new BasicNameValuePair("proviceName", "浙江省"));
        nvps.add(new BasicNameValuePair("togetherHealth", "1"));
        nvps.add(new BasicNameValuePair("togetherHealthDes", ""));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

        ReportResModel reportResModel;
        CloseableHttpResponse response2 = httpclient.execute(httpPost);
        try {
            HttpEntity entity2 = response2.getEntity();
            String res = EntityUtils.toString(entity2);
            logger.debug(res);
            // do something useful with the response body
            reportResModel = JSON.parseObject(res, ReportResModel.class);
            logger.debug(reportResModel.getMsg());
            status = reportResModel.isSuccess();
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }

        return status;
    }
}
