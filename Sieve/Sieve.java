/**
 * Sieve abstract to be implemented by MySieve
 *
 *  @author Evan Newton
 *  @version Assignment 9: Sieve of Eratosthenes Challenge
 */
public interface Sieve {
   /**
    * getPrimes is the method which must be overridden by all classes which implement Sieve
    *
    * @param n the upper bound to search for primes
    * @return a list of Integers that contains all prime numbers between 2 and N
    */
   public java.util.List<Integer> getPrimes(int n);
   
}