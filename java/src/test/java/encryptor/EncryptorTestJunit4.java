package encryptor;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;

public class EncryptorTestJunit4 {
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

    @Test(expected = IllegalArgumentException.class)
    public void cryptWordWithSpaces() {
        new Encryptor().cryptWord("coding is like cooking");
    }

    @Test
    public void cryptWordToNumbers() {
        Approvals.verify(new Encryptor().cryptWordToNumbers("coding"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void cryptWordToNumbersWithSpaces() {
        new Encryptor().cryptWordToNumbers("coding  is like cooking");
    }

    @Test(expected = InvalidParameterException.class)
    public void cryptWordAndReplaceWithSpaces() {
        new Encryptor().cryptWord("coding is like cooking", "");
    }

    @Test
    public void cryptWordAndReplace() {
        Approvals.verify(new Encryptor().cryptWord("coding", "cooking"));
    }
}
