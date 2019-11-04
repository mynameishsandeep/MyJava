import org.json.JSONObject;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EncryptorDecryptorTest {

  @Test(dataProvider = "get-secrets")
  public void testEncryptDecryptWithDifferentSecrets(String payload, String secret) {
    try {
      EncryptorDecryptor encryptorDecryptor = Mockito.spy(EncryptorDecryptor.getInstance());
      String encrypted = encryptorDecryptor.encrypt(payload, secret);
      String decrypted = encryptorDecryptor.decrypt(encrypted, secret);
      Assert.assertEquals(payload, decrypted);
    } catch (Exception ex) {
      Assert.fail("Test is not expected to throw exception: " + ex.getMessage());
    }
  }

  @DataProvider(name = "get-secrets")
  private Object[][] getSecrets() {
    JSONObject testJson = new JSONObject();
    JSONObject testJson2 = new JSONObject();
    JSONObject testJson3 = new JSONObject();
    createTestJsons(testJson, testJson2, testJson3);

    return new Object[][] {{"dummy-string", "dummy-secret"}};
  }

  private void createTestJsons(JSONObject testJson, JSONObject testJson2, JSONObject testJson3) {
    testJson.put("1", "12");
    testJson.put("2", "22");
    testJson2.put("a", "12");
    testJson2.put("b", "12-2");
    testJson2.put("ab", "12%12");
    testJson2.put("ab#", "12==1/2");
    testJson2.put("abc*123", "12!12");
    testJson3.put("json1", testJson);
    testJson3.put("json2", testJson2);
  }
}
