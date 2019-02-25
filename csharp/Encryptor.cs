using System;

public class Encryptor
{
    public static void Main(string[] args)
    {
        var encryptor = new Encryptor();
        encryptor.PrintWords(encryptor.CryptSentence("This is just a test"));
    }

    public String CryptWord(String word)
    {
        if (word.Contains(" "))
            throw new ArgumentException();

        char[] wordArray = word.ToCharArray();
        String newWord = "";
        for (int i = 0; i < word.Length; i++)
        {
            int charValue = wordArray[i];
            newWord += (char) (charValue + 2);
        }

        return newWord;
    }

    public String CryptWordToNumbers(String word)
    {
        if (word.Contains(" "))
            throw new ArgumentException();

        char[] wordArray = word.ToCharArray();
        String newWord = "";
        for (int i = 0; i < word.Length; i++)
        {
            int charValue = wordArray[i];
            newWord += charValue + 2;
        }

        return newWord;
    }

    public String CryptWord(String word, String charsToReplace)
    {
        if (word.Contains(" "))
            throw new ArgumentException();

        char[] wordArray = word.ToCharArray();
        char[] replacement = charsToReplace.ToCharArray();
        char[] result = (char[]) wordArray.Clone();
        for (int i = 0; i < wordArray.Length; i++)
        {
            for (int j = 0; j < replacement.Length; j++)
            {
                if (replacement[j] == wordArray[i])
                {
                    int charValue = wordArray[i];
                    result[i] = (char) (charValue + 2);
                }
            }
        }
        return new String(result);
    }

    public String CryptSentence(String sentence)
    {
        char[] sentenceArray = sentence.ToCharArray();
        String newWord = "";
        for (int i = 0; i < sentence.Length; i++)
        {
            int charValue = sentenceArray[i];
            newWord += (char) (charValue + 2);
        }

        return newWord;
    }

    public String[] GetWords(String sentence)
    {
        return sentence.Split(' ');
    }


    public void PrintWords(String sentence)
    {
        String[] words = GetWords(sentence);
        foreach (String word in words)
        {
            Console.WriteLine("<" + word + ">");
        }
    }
}

