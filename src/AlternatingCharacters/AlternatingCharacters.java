package AlternatingCharacters;

public class AlternatingCharacters {
    public int alternatingCharacters(String word) {
        int deletionCounter = 0;

        if (word.length() == 1)
            return 0;
        if (isAllCharactersTheSame(word))
            return word.length() - 1;

        char[] sAsArray = word.toCharArray();
        for (int i = 0; i < sAsArray.length; i++) {
            if (i + 1 < sAsArray.length && sAsArray[i] == sAsArray[i + 1])
                deletionCounter++;
        }
        return deletionCounter;
    }


     private boolean isAllCharactersTheSame(String word) {
        char[] wordAsArray = word.toCharArray();
        char firstChar = wordAsArray[0];
        for (char ch : wordAsArray) {
            if (ch != firstChar)
                return false;
        }

        return true;
    }
}
