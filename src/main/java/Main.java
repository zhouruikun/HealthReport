
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;


/**
 * <h3>HealthReport</h3>
 * <p></p>
 *
 * @author : ZhouKun
 * @date : 2020-03-19 11:23
 **/
public class Main {
    public  static void main(String[] args) throws SchedulerException {
        String mobile="15867867810";
        String password="zhoukun123.";
        if (args.length==2)
        {
            mobile = args[0];
            password=args[1];
        }
        System.out.println("mobile="+mobile+"   password="+password);
        //创建调度器
        //将具体的作业类（RamJob）绑定到调度任务详情中
        //创建触发器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobDetail jobDetail = newJob(ReportJop.class)
                .withDescription("this is a job")
                .withIdentity("job","group")
                .usingJobData("mobile",mobile)
                .usingJobData("password",password)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("this is a trigger1")
                //              .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(1,3))
               .withSchedule(CronScheduleBuilder.cronSchedule("0 15 9 ? * *"))
                .withIdentity("trigger1","group1")
                .build();

        //将触发器以及调度任务详情绑定到调度器上
        scheduler.scheduleJob(jobDetail,trigger);
        //启动调度器
        scheduler.start();
    }

}
