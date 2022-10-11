package math_problems;

public class Fibonacci {

    /** INSTRUCTIONS
     *
     * Write a method that will print or return at least 40 Fibonacci number
     * e.g. - 0,1,1,2,3,5,8,13
     **/

    public static void main(String[] args) {
    int n1 = 0;
    int n2 = 1;
    int n = 40;
    int counter = 0;
    while(counter <= n) {
        System.out.print(n1 +",");
        int n3 = n1 + n2;
        n1 = n2;
        n2 = n3;
        counter++;
    }



    }

    }

