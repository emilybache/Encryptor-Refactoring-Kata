package encryptor;

import static org.junit.Assert.*;

import org.junit.Test;

public class Encryptor_should {

  @Test
  public void cryptWordWithPlainAscii() {
    String encrypted = new Encryptor().cryptWord("foobar!");
    assertEquals("hqqdct#", encrypted);
  }


    @Test
    public void cryptWordWithSwedishChars() {
        String encrypted = new Encryptor().cryptWord("åäö!");
        assertEquals("çæø#", encrypted);
    }

}
