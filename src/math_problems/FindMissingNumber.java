package math_problems;

public class FindMissingNumber {

    /** INSTRUCTIONS
     * Write a method to find the missing number from the array.
     */

    public static void main(String[] args) {
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};
    int sum1 = 0;
    for (int i = 0; i < array.length; i++){
        sum1 = sum1 + array[i];
    }
        System.out.println("The total of the array elements is: "+ sum1);
    int sum2 = 0;
    for (int i = 1 ; i <= 10; i++){
    sum2 = sum2 + i;
    }
        System.out.println("The range total of the array elements is: "+ sum2);
        System.out.println("The missing number is: "+ (sum2 - sum1));
}

}
