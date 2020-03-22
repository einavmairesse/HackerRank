package TwoStrings;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {

    public String twoStrings(String s1, String s2) {
        Map<Character, Integer> existingCharacters = initCharactersMap(s1);
        for (char ch : s2.toCharArray()){
            if (existingCharacters.containsKey(ch)) {
                return "YES";
            }
        }

        return "NO";
    }

   private Map<Character, Integer> initCharactersMap(String word) {
        Map<Character, Integer> existingCharacters = new HashMap<>();
        for (char ch : word.toCharArray()) {
            if (!existingCharacters.containsKey(ch))
                existingCharacters.put(ch, 1);
        }

        return existingCharacters;
   }
}