import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * <h3>HealthReport</h3>
 * <p></p>
 *
 * @author : ZhouKun
 * @date : 2020-03-19 16:09
 **/
public class Crypt {
    static String getEncryped(String password) {
        String encryptedData = null;
       //zhoukun123.  =》   GJi45a9ab5MwPxAO9T5SXA==
        Cipher cipher;
        try {

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(new DESKeySpec("oiubtpwx".getBytes()));
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 加密，并把字节数组编码成字符串
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(password.getBytes()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return encryptedData;
    }
}
