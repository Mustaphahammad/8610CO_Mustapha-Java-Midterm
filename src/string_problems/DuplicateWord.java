package string_problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DuplicateWord {

    /**
     * INSTRUCTIONS
     * Write a java program to find duplicate words and the number of occurrences of those words in the given string.
     * Also, find the average length of all the words
     */

    public static void main(String[] args) {
        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        Map<String, Integer> finalOccur = DuplicateWord.getWordOccurrence(st);

        DuplicateWord.display(finalOccur, st);

        DuplicateWord.getAverage(st);
    }
        // This method meant to get the words and store them in Map
    private static Map<String, Integer> getWordOccurrence(String st) {
        String userIn = st;
       // We use split() method to get an array of strings
        String[] words = userIn.split(" ", userIn.length());
       // we create our map
        Map<String, Integer> wordOccur = new HashMap<>();
       // looping through the array and store the string words with their number of occurrence in map as key and values
        for (int i = 0; i < words.length; i++) {
            if (wordOccur.containsKey(words[i]) == true) {
                wordOccur.put(words[i], wordOccur.get(words[i]) + 1);
            } else {
                wordOccur.put(words[i], 1);
            }

        }
        return wordOccur;
    }
   // This method meant to display only the duplicated Strings
    private static void display(Map<String, Integer> finalOccur, String st) {
        Map<String, Integer> wordOccur = finalOccur;

        String userSt = st;

        Set<String> keySet = wordOccur.keySet();
   //Iterator to iterate through the map
        Iterator<String> itr = keySet.iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            Integer value = wordOccur.get(key);
            if (value > 1) {
                System.out.println("The word "+"'"+key+"'"+" is duplicated "+value+" times");
            }

        }


    }
     //This method meant to get the average length of all words
    private static void getAverage(String st) {
        String sentence = st;
        String [] word = sentence.split(" ");
          String wordNoSpace = sentence.replace(" ","");
        String wordNoSpaceNoDots = wordNoSpace.replace(".","" );

        System.out.println("The average length of all words is: "+wordNoSpace.length()/ word.length);

    }


}
