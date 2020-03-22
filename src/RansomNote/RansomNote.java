package RansomNote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public void checkMagazine(String[] magazine, String[] note) {
        if (magazine.length < note.length) {
            System.out.println("No");
            return;
        }

        Map<String, Integer> magazineWordsToCount = initializeMagazineAsMap(magazine);
        for (String word : note) {
            if (canWordAppearInNote(magazineWordsToCount, word)) {
                int updatedWordCount = magazineWordsToCount.get(word) - 1;
                magazineWordsToCount.put(word, updatedWordCount);
            } else {
                System.out.println("No");
                return;
            }

        }

        System.out.println("Yes");
    }

    private boolean canWordAppearInNote(Map<String, Integer> magazineAsMap, String word){
        return magazineAsMap.containsKey(word) && magazineAsMap.get(word) > 0;
    }

    private Map<String, Integer> initializeMagazineAsMap(String[] magazine) {
        Map<String, Integer> magazineWordToCount = new HashMap<>();

        for (String word : magazine) {
            if (magazineWordToCount.containsKey(word)) {
                int updatedWordCount = magazineWordToCount.get(word) + 1;
                magazineWordToCount.put(word, updatedWordCount);
            } else {
                magazineWordToCount.put(word, 1);
            }
        }

        return magazineWordToCount;
    }

}
