package MakingAnagrams;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {
     int makeAnagram(String str1, String str2) {
        int similarLettersCounter;
        if (str1.compareTo(str2) >= 0) {
            similarLettersCounter = getSimilarLettersCounter(str1, str2);
        } else {
            similarLettersCounter = getSimilarLettersCounter(str2, str1);
        }

        return str1.length() + str2.length() - similarLettersCounter * 2;
    }

    private int getSimilarLettersCounter(String str1, String str2) {
        int similarLettersCounter = 0;
        int newElementValue;
        Map<Character, Integer> str1ElementsMap = strElementsToCount(str1.toCharArray());
        char[] str2AsArray = str2.toCharArray();
        for (int i = 0; i < str2.length(); i++){
            if (str1ElementsMap.containsKey(str2AsArray[i]) && str1ElementsMap.get(str2AsArray[i]) > 0){
              similarLettersCounter++;
              newElementValue = str1ElementsMap.get(str2AsArray[i]) - 1;
              str1ElementsMap.put(str2AsArray[i], newElementValue);
        }
    }
        return similarLettersCounter;
    }


    static private Map<Character, Integer> strElementsToCount(char[] arr){
        Map<Character,Integer> elementsToCount = new HashMap<>();
        int newElementValue;
        for (char ch : arr) {
            if (elementsToCount.containsKey(ch)) {
                newElementValue = elementsToCount.get(ch) + 1;
                elementsToCount.put(ch, newElementValue);
            } else {
                elementsToCount.put(ch, 1);
            }
        }
        return elementsToCount;
    }
}
