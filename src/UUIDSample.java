import java.util.UUID;

public class UUIDSample {
  public static void main(String[] args) {
    System.out.println(UUID.randomUUID().toString());

    for (int i = 0; i < 20; i++) {
      System.out.println(UUID.randomUUID().toString());
    }
  }
}
