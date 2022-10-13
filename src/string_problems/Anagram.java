package string_problems;

import java.util.Arrays;

public class Anagram {

    /** INSTRUCTIONS
     * Write a Java Program, `isAnagram`, to check if any two strings are anagrams
     *
     *  An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all of the
     *  original letters exactly once.
     *
     *         Ex: "CAT" & "ACT",
     *             "ARMY" & "MARY",
     *             "FART" & "RAFT"
     */

    // Implement Here

        public static void main(String[] args) {
            String str1 = "cat";
            String str2 = "act";

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            // First we need to exclude any empty String .
            if (str1.isEmpty() || str2.isEmpty()) {
                System.out.println("invalid input , String is empty!");
            }
            // check if both strings have the same length
            else if(str1.length() == str2.length()) {

                char[] charArray1 = str1.toCharArray();
                char[] charArray2 = str2.toCharArray();

                Arrays.sort(charArray1);
                Arrays.sort(charArray2);

                boolean result = Arrays.equals(charArray1, charArray2);

                if(result) {
                    System.out.println(str1 + " and " + str2 + " are anagram.");
                } else {
                    System.out.println(str1 + " and " + str2 + " are not anagram.");
                }
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagram.");
            }
        }
    }

