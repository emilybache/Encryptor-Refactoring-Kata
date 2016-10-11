
class Encryptor:
    def cryptWord(self, word):
        if " " in word:
            raise ValueError()

        new_word = "";
        for i in range(len(word)):
            char_value = ord(word[i])
            new_word += chr( char_value + 2)

        return new_word

    def cryptWordToNumbers(self, word):
        if " " in word:
            raise ValueError()

        new_word = "";
        for i in range(len(word)):
            char_value = ord(word[i])
            new_word += str(char_value + 2)

        return new_word

    def cryptWordWithCharsToReplace(self, word, chars_to_replace):
        if " " in word:
            raise ValueError()
        result = list(word)
        for i in range(len(word)):
            for j in range(len(chars_to_replace)):
                if chars_to_replace[j] == word[i]:
                    char_value = ord(word[i])
                    result[i] = chr( char_value + 2)
        return "".join(result)

    def cryptSentence(self, sentence):
        new_word = "";
        for i in range(len(sentence)):
            char_value = ord(sentence[i])
            new_word += chr( char_value + 2)

        return new_word

    def getWords(self, sentence):
        return sentence.split()

    def printWords(self, sentence):
        words = self.getWords(sentence)
        for word in words:
            print("<%s>" % word)


