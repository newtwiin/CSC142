import java.text.CharacterIterator;

/**
 * The class SieveDriver is used query a user for upper bounds
 * with which it calculates and prints all prime numbers between 2
 * and said bound inclusive.
 *
 * @author Evan Newton
 * @version Assignment 9: Sieve of Eratosthenes Challenge
 */
public class SieveDriver {

   //A scanner must be used to collect the user's input for upper bounds
   private java.util.Scanner scan;
   //Sieve interface
   private Sieve theSieve;

   /**
    *Parameterless constructor which initializes all fields
    */
   public SieveDriver(){
      scan = new java.util.Scanner(System.in);
      theSieve = new MySieve();

   }

   /**
    * go is a method which executes the functions of Sieve in sequence
    */
   public void go() {

      java.util.List<Integer> primes;
      /**
       * The number n holds the upper bound of the algorithm
       */
      int n = getNumber();

      while(n != 0){
         //theSieve contains the algorithm which calculates primes
         primes = theSieve.getPrimes(n);
         //print the primes using the method printPrimes, which uses an iterator and formatting
         printPrimes(n, primes);
         n = getNumber();
      }
   }

   /**
    * This method uses a scanner to collect an upper bounds for the algorithm
    *
    * @return the value entered by the user to be used as an upper bound
    */
   public int getNumber() {
      /**
       * int n is the upper bound, to be passed to getPrimes as well as printPrimes for statistical analysis
       */
      int n = 0;
      /**
       * needValue is a boolean that is set to false when a correct positive integer
       */
      boolean needValue = true;
      //begin looping while a suitable value is still needed
      while(needValue) {
         System.out.println("Enter the upper bound (0 to exit): ");
         if (scan.hasNextInt()) {
            n = scan.nextInt();
            //block negative numbers
            if(n<0){
               System.out.println("Must enter a positive integer");
            } else {
               needValue = false;
            }
            //non integer input reaches this filter
         } else {
            while((!scan.hasNextInt()) && scan.hasNext()){
               System.out.println("Must enter a positive integer");
               //clean out non integers
               scan.next();
            }
         }
      }
      return n;
   }

   /**
    * Print primes iterates the list and formats the printing of all its values
    *
    * @param list is the list of integers received by getPrimes
    * @param bnd is the upper bound to search for primes and is used to calculate statistics on them
    */
   public void printPrimes(int bnd, java.util.List<Integer> list) {
      /**
       * counter holds the number of primes printed
       */
      int counter = 0;
      /**
       * nPerLine holds the number of primes to print per line
       */
      int nPerLine = 12;

      System.out.print("The primes up to "+bnd+ " are:");
      /**
       * printer is an iterator used to work through the list
       */
      java.util.Iterator<Integer> printer = list.iterator();

      //begin the printing loop
      while(printer.hasNext()){
         //prints a newline when counter is a factor of nPerLine, thus limiting the number of primes per line
         if((counter+nPerLine)%nPerLine == 0) {
            System.out.print("\n" + printer.next());
         } else {
            //primes that are not the first of a line get a space before them
            System.out.print(" " + printer.next());
         }
         counter++;
      }
      System.out.println();
      //prints the percentage of numbers between 1 and n that are prime
      System.out.println("\n" + (int)(counter*100.0/bnd) +"% of the numbers between 1 and " + bnd +" are prime.");
      System.out.println();
   }

   /**
    * Application method which runs go()
    *
    * @param args command line arguments
    */
   public static void main(String[] args) {
      new SieveDriver().go();
   }
}