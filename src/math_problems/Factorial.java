package math_problems;

public class Factorial {

    /**
     * INSTRUCTIONS
     * <p>
     * Write a method to return the Factorial of any given number using Recursion, and also another way, using iteration
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     * <p>
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {
    //factorial of any given number using iteration.
        int i,fact=1;
        int number = 5;
        for(i=1;i<=number;i++){
            fact=fact*i;
        }
        System.out.println("Factorial of "+number+" is: "+fact);
    }
    //factorial of any given number using recursion.
     /* This is an new object to test the recursion way (has to be inside main() method)
      Factorial obj_one = new Factorial();
        int a = obj_one.fact(5);
        System.out.println("The factorial of the number is : " + a);
*/
    int fact(int n) {
        int result;
        if ( n == 1)
            return 1;
        result = fact(n - 1) * n;
        return result;
    }

}
