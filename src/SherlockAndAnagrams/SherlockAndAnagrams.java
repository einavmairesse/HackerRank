package SherlockAndAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    public int sherlockAndAnagrams(String str) {
        Map<String, Integer> substringToCount = initializeSubstringToCount(str);
        return countAnagramInMap(substringToCount);
    }

     private Map<String, Integer> initializeSubstringToCount(String str) {
        char[] strAsArray = str.toCharArray();
        Map<String, Integer> substringToCount = new HashMap<>();
        for (int i = 0; i < strAsArray.length; i++) {
            for (int j = i; j < strAsArray.length; j++) {
                int newValue;
                char[] sortCurrentSubstring = sortCharArray(strAsArray, i, j);
                String currentSubstring = String.copyValueOf(sortCurrentSubstring);
                if ( isAllCharactersTheSame(str) && i == j && substringToCount.containsKey(currentSubstring)) {
                    newValue = substringToCount.get(currentSubstring) + strAsArray.length - i - 1;
                    substringToCount.put(String.valueOf(sortCurrentSubstring), newValue);
                } else if (isAllCharactersTheSame(str) && i == j) {
                    newValue =  strAsArray.length - i - 1;
                    substringToCount.put(currentSubstring, newValue);
                }
                else if(substringToCount.containsKey(currentSubstring)) {
                    newValue = substringToCount.get(currentSubstring) + 1;
                    substringToCount.put(currentSubstring, newValue);
                } else {
                    substringToCount.put(currentSubstring, 1);
                }
            }
        }
        return substringToCount;
    }

    private int countAnagramInMap(Map<String , Integer> anagramsToCount) {
        int anagramCounter = 0;
        for (int value : anagramsToCount.values()) {
            if (value == 2)
                anagramCounter++;
            else if (value > 2)
                anagramCounter += value;
        }
        return anagramCounter;
    }

    private char[] sortCharArray(char[] array, int startIndex, int endIndex) {
        char[] charsToSort = new char[endIndex - startIndex + 1];
        copyArray(array, charsToSort, startIndex);
        Arrays.sort(charsToSort);
        return charsToSort;
    }

    private void copyArray(char[] origin, char[] copyTo, int startIndex) {
        for(int i = 0; i < copyTo.length; i++) {
            copyTo[i] = origin[startIndex];
            startIndex++;
        }
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