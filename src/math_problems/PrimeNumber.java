package math_problems;

public class PrimeNumber {

    /**
     * INSTRUCTIONS
     * Write a method to print a list of all prime numbers from 2 to 1,000,000.
     * Print out the prime numbers in the given range.
     * <p>
     * BONUS: Figure out how to improve algorithmic efficiency
     */


    public static void main(String[] args) {
    printPrime(2,1000000);
    }
   static void printPrime(int start,int end) {
    for(int i = start; i <= end; i++){
      if(isPrime(i)) System.out.print(" "+ i);
    }
   }


    private static boolean isPrime(int num){
        for (int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true ;
  }
}
