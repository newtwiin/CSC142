import java.util.*;
/*
 * This clss sorts and prints the names of the seven dwarves in different ways
 * 
 * @author Evan Newton
 * @version Lab 11: Dwarves Plus
 * 
 */
public class Dwarves {
    
    // The collect to hold the names
    private ArrayList<String> dwarves;
    
    /**
     * Zero parameter constructor which initializes the ArrayList
     */
    public Dwarves(){
      dwarves = new ArrayList<String>();
    }
    
    /**
     * Add the names of the dwarves to the collection.
     */
    public void addNames() {
        add("Doc");
        add("Grumpy");
        add("Happy");
        add("Sleepy");
        add("Bashful");
        add("Sneezy");
        add("Dopey");
    }
    
    /**
     * Add a single name to the collection
     * @param name The name to be added
     */
    public void add(String name) {
      dwarves.add(name);
      
      //driver for the alphabetizing loop
      boolean sorted = false;
      while(! sorted){
        sorted = isSortedYet();
      }
    }
    
    //helper method for add which sorts dwarves, it returns true when all the names have been sorted
    private boolean isSortedYet(){
      //passed is marked false if the method finds an adjustment to make
      boolean passed = true;
      
      //initialize temporary name holders
      String temp = dwarves.get(0);
      String temp0;
      
      for(int i = 0; i < dwarves.size(); i++){
        
        if(dwarves.get(i).compareTo(temp) < 0){ 
          temp0 = dwarves.get(i);
          
          //set can be used to replace the out of order elements in order
          dwarves.set(i, temp);
          dwarves.set(i-1, temp0);
          
          //since there were adjustments, method must be run again
          passed = false;
        }
        //prepare the next temp to use (the element before the next one)
        temp = dwarves.get(i);
      }
      //this runs until the list is totally sorted
      return passed;
    }
    
    /**
     * A simple method to print out the contents of
     * the collection, using the get method.
     */
    public void print() {
      System.out.println("Print the list using a simple for loop and get:");
      for (int i = 0; i < dwarves.size(); i++){
        
        System.out.print(dwarves.get(i) + " "); 
      }
      System.out.println("\n");
    }
    
    /**
     * A second method to print out the contents of
     * the collection, using an explicit Iterator object.
     */
    public void print2() {
      System.out.println("Print the list using an explicit iterator:");
      
      //declaring the string iterator
      Iterator<String> nameIter = dwarves.iterator();
      
      while( nameIter.hasNext()){
        System.out.println("\"" + nameIter.next() + "\"");
      }
    }
    
    /**
     * A third method to print out the contents of
     * the collection, using an implicit Iterator,
     * the for-each loop.
     */
    public void print3() {
      System.out.println("Print the list using a for-each loop:");
      for(Object name : dwarves) {
        System.out.println("\"" +name + "\"");
      }
    }
    
    /**
     * The application method
     * @param args Command-line parameters
     */
    public static void main(String[] args) {
        // instantiate the Dwarves class
        Dwarves theGuys = new Dwarves();
        theGuys.addNames();
        theGuys.print();
        theGuys.print2();
        theGuys.print3();
    }
    
}

