package encryptor;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class EncryptorTest {

    @Test
    public void cryptSentence() {
      Approvals.verify(new Encryptor().cryptSentence("coding is like cooking"));
    }


    @Test
    public void printWords() throws UnsupportedEncodingException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos,true,"UTF-8");
        new Encryptor().printWords("coding is like cooking", ps);
        String output = baos.toString("UTF-8");
        Approvals.verify(output);
    }

    @Test
    public void cryptWord() {
        Approvals.verify(new Encryptor().cryptWord("cooking"));
    }

    @Test
    public void cryptWordWithSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new Encryptor().cryptWord("coding is like cooking"));
    }

    @Test
    public void cryptWordToNumbers() {
        Approvals.verify(new Encryptor().cryptWordToNumbers("coding"));
    }


    @Test
    public void cryptWordToNumbersWithSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new Encryptor().cryptWordToNumbers("coding  is like cooking"));
    }

    @Test
    public void cryptWordAndReplaceWithSpaces() {
        assertThrows(InvalidParameterException.class, () -> new Encryptor().cryptWord("coding is like cooking", ""));
    }

    @Test
    public void cryptWordAndReplace() {
        Approvals.verify(new Encryptor().cryptWord("coding", "cooking"));
    }
}
