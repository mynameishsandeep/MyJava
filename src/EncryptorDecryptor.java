import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import lombok.extern.log4j.Log4j;

/**
 * This Class provides encrypt() and decrypt() functionality using a secret provided by the user.
 * Its using AES encryption with GCM mode and No padding for encryption and decryption cipher. Its
 * also using a 16 length Initialization Vector as a nonce.
 */
@Log4j
public class EncryptorDecryptor {
  @SuppressWarnings("squid:S3077")
  private static volatile EncryptorDecryptor encryptorDecryptor;
  /**
   * Get singleton instance of EncryptorDecryptor class
   *
   * @return new instance if null
   */
  public static EncryptorDecryptor getInstance() {
    if (encryptorDecryptor == null) {
      synchronized (EncryptorDecryptor.class) {
        if (encryptorDecryptor == null) {
          encryptorDecryptor = new EncryptorDecryptor();
        }
      }
    }
    return encryptorDecryptor;
  }

  /** Private Constructor to hide the default public one. */
  private EncryptorDecryptor() {}

  public String encrypt(String strToEncrypt, String secret) {
    try {
      SecretKeySpec secretKey = null;
      MessageDigest sha = null;
      try {
        byte[] key = secret.getBytes("UTF-8");
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        secretKey = new SecretKeySpec(key, "AES");
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }

      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }

  public String decrypt(String strToDecrypt, String secret) {
    try {

      SecretKeySpec secretKey = null;
      MessageDigest sha = null;
      try {
        byte[] key = secret.getBytes("UTF-8");
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        secretKey = new SecretKeySpec(key, "AES");
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }

      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    } catch (Exception e) {
      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }

  public static void main(String[] args) {

    EncryptorDecryptor e = new EncryptorDecryptor();
    String encryptedData = e.encrypt("Test", "Secret");
    String decryptedData = e.decrypt(encryptedData, "Secret");
    System.out.println(decryptedData);
  }
}
