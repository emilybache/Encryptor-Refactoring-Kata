package encryptor;

import java.io.PrintStream;
import java.security.InvalidParameterException;

public class Encryptor {

    public String cryptSentence(String sentence) {
        char[] sentenceArray = sentence.toCharArray();
        String newWord = "";
        for (int i = 0; i < sentence.length(); i++) {
            int charValue = sentenceArray[i];
            newWord += String.valueOf((char) (charValue + 2));
        }

        return newWord;
    }

    public void printWords(String sentence, PrintStream stream) {
        String[] words = getWords(sentence);
        for (String word : words) {
            stream.println("<" + word + ">");
        }
    }

    String cryptWord(String word) {
        if (word.contains(" "))
            throw new InvalidParameterException();

        char[] wordArray = word.toCharArray();
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            int charValue = wordArray[i];
            newWord += String.valueOf((char) (charValue + 2));
        }

        return newWord;
    }

    String cryptWordToNumbers(String word) {
        if (word.contains(" "))
            throw new InvalidParameterException();

        char[] wordArray = word.toCharArray();
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            int charValue = wordArray[i];
            newWord += String.valueOf(charValue + 2);
        }

        return newWord;
    }

    String cryptWord(String word, String charsToReplace) {
        if (word.contains(" "))
            throw new InvalidParameterException();

        char[] wordArray = word.toCharArray();
        char[] replacement = charsToReplace.toCharArray();
        char[] result = wordArray.clone();
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 0; j < replacement.length; j++) {
                if (replacement[j] == wordArray[i]) {
                    int charValue = wordArray[i];
                    result[i] = (char) (charValue + 2);
                }
            }
        }
        return String.valueOf(result);
    }

    String[] getWords(String sentence) {
        return sentence.split(" ");
    }


}