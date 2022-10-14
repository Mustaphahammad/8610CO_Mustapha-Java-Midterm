package string_problems;

import java.util.Scanner;

public class Palindrome {

    /**
     * INSTRUCTIONS
     * A palindrome is a word that can be reversed, and still remain the same.
     * <p>
     * Example: MOM, DAD, MADAM, RACECAR
     * <p>
     * Create a method to check if any given String is a palindrome or not.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To check if your word is palindrome ,please enter the String word: ");
        String userIn = scanner.nextLine();

      // we check first if the user enters  input
        if (userIn.isEmpty() == true) {

            System.out.println("Please enter a valid word!");
            // Checking the user input by calling isPalindrome method
        } else if (isPalindrome(userIn)) {

            System.out.println(userIn + " is palindrome");

        } else {
            System.out.println(userIn + "is not palindrome");
        }
    }

        // This method is meant to check whether the string is palindrome or not
        // by checking the start & the end  char of the array if the same then checking next char
        // from both ends . By the end we will be able to identify the palindrome words.
    public static boolean isPalindrome(String st) {
        int startOfString = 0;
        int endOfString = st.length() - 1;

        while (startOfString < endOfString) {
            if (st.charAt(startOfString) != st.charAt(endOfString)) {
                return false;
            }
            startOfString++;
            endOfString--;
        }
        return true;

    }
}