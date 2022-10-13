package string_problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {

    /**
     * INSTRUCTIONS
     * Implement a solution to find the length of the longest word in the given sentence below
     * Your solution should return a map containing the length of the word as the key & the word itself as the value
     * "10: biological"
     */

    public static void main(String[] args) {
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);

        System.out.println(wordNLength);
    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        String largest = "";
        int wordKey = largest.length();

        String[] array = wordGiven.split(" ");

        for (int i = 0; i < array.length; i++) {
            if (array[i].length() >= largest.length()) {
                largest = array[i];
            }
        }      map.put(wordKey, largest);

        return map;
    }

}

