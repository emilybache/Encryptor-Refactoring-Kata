package encryptor;

import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Encryptor {

    public void printWords(String sentence, PrintStream stream) {
        String[] words = getWords(sentence);
        for (String word : words) {
            stream.println("<" + word + ">");
        }
    }

    public String cryptSentence(String sentence) {
        return encrypt(sentence, this::encryptAsChar);
    }

    String cryptWord(String word) {
        if (word.contains(" ")) throw new InvalidParameterException();
        return cryptSentence(word);
    }

    String cryptWordToNumbers(String word) {
        if (word.contains(" ")) throw new InvalidParameterException();
        return encrypt(word, this::encryptAsNumber);
    }

    String cryptWord(String word, String charsToReplace) {
        if (word.contains(" ")) throw new InvalidParameterException();
        return encrypt(word, encryptWithFilter(charsToReplace));
    }

    String[] getWords(String sentence) {
        return sentence.split(" ");
    }

    private String encryptAsChar(char charValue) {
        return "" + (char) (charValue + 2);
    }

    private String encryptAsNumber(char charValue) {
        return "" + (charValue + 2);
    }

    private Function<Character, String> encryptWithFilter(String charsToReplace) {
        return charValue -> {
            if (charsToReplace.contains("" + charValue)) {
                return encryptAsChar(charValue);
            } else {
                return "" + charValue;
            }
        };
    }

    private String encrypt(String word, Function<Character, String> encryptorFunction) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .map(encryptorFunction)
                .collect(Collectors.joining(""));

    }


}