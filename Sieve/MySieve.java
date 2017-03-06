import java.util.ArrayList;

/**
 * This class implements the Sieve interface to generate lists of prime numbers
 *
 * @author Evan Newton
 * @version Assignment 9: Sieve of Eratosthenes Challenge
 */
public class MySieve implements Sieve {

    //numberList holds all numbers between 2 and n, it is systematically shaved down before adding primes to primeList
    private java.util.LinkedList<Integer> numberList;
    //primeList is built from the numbers in numberList that are not ruled out as composite numbers
    private java.util.LinkedList<Integer> primeList;
    //current prime holds the last prime number fetched by the iterator while it is being used
    private Integer currentPrime;
    //iterator for modifying numberList before adding it
    private java.util.Iterator<Integer> iter;

    /**
     * This method overrides the one abstracted in Sieve to produce a list of primes using
     * The Sieve of Eratosthenes
     *
     * @param n the upper bound of the numbers searched for primes
     * @return a list of prime numbers less than or equal to n
     */
    public java.util.List<Integer> getPrimes(int n) {

        /**
         * M is the square root of n, which is the highest possible value of a prime whose multiples
         * could exist on a list of numbers between 2 and n
         */
        double M = Math.sqrt(n);
        //initialize the LinkedLists
        numberList = new java.util.LinkedList<Integer>();
        primeList = new java.util.LinkedList<Integer>();

        //initialize numberList
        for(int i = 2; i <= n; i++) {
            numberList.add(i);
        }
        //the first prime number will always be 2
        currentPrime = 2;

        //get the next prime from numberList, remove it, and add it to primeList
        while(currentPrime.intValue() <= M) {
            iter = numberList.iterator();
            currentPrime = iter.next();
            primeList.add(currentPrime);
            iter.remove();

            //remove all multiples of the current prime from the list
            while (iter.hasNext()) {
                if (iter.next().intValue() % currentPrime.intValue() == 0) {
                    iter.remove();
                }
            }

        }
        //add the remaining numbers to the list
        iter = numberList.iterator();
        while (iter.hasNext()) {
            primeList.add(iter.next());
        }
        //return the list of primes
        return primeList;
    }
}