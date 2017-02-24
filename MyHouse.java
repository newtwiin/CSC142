//import declaration allowing short name access  to java.awt.Color
import java.awt.Color;

/**
 * Assignment 4: MyHouse
 * A new graphic component. This component is used in
 * the notes to highlight the process of designing a 
 * new object and then implementing it.
 *
 * @author Evan Newton
 * @author Dan Jinguji
 * @version Assignment 4: MyHouse Challenge
 */
public class MyHouse extends NscComponent {
  
  // instance variables
  private NscUpTriangle theRoof;
  private NscRectangle theWalls;
  private NscRectangle theDoor;
  
  /**
   * Constructor for objects of class MyHouse.
   * This creates a MyHouse object at the specified
   * location
   * @param x the x-coordinate for the object
   * @param y the y-coordinate for the object
   */
  public MyHouse(int x, int y)
  {
    // Specify the constructor for the superclass
    super(x, y, 120, 90);
    
    // Create the roof object
    theRoof = new NscUpTriangle(0, 0, 120, 40);
    // Set the characteristics of the roof
    theRoof.setFilled(true);
    theRoof.setBackground(new Color(0x99, 0x33, 0x00));
    // Place the roof in the MyHouse object
    add(theRoof);
    
    // Create the walls object
    theWalls = new NscRectangle(10, 40, 100, 50);
    // Set the characteristics of the walls
    theWalls.setFilled(true);
    theWalls.setBackground(Color.blue);
    // Place the walls in the MyHouse object
    add(theWalls);
    
    // Create the door object
    theDoor = new NscRectangle(48, 50, 24, 40);
    // Set the characteristics of the door
    theDoor.setFilled(true);
    theDoor.setBackground(new Color(0x99, 0x66, 0x33));
    // Place the door in the MyHouse object
    add(theDoor);
  }
  
  /**
   * The three parameter constructor for MyHouse
   * can be used to specify a color for the walls
   * 
   * @param x the x-coordinate for the object
   * @param y the y-coordinate for the object
   * @param color the color of the walls of the house
   */
  public MyHouse(int x, int y, Color color){
    this(x, y);
    setColor(color);
  }

  /**
   * Change the color of the house
   * 
   * @param c The color for the walls of the house
   */
  public void setColor(Color c) {
    theWalls.setBackground(c);
    repaint();
  }
  
  /**
   * Retrieve the color of the house
   * 
   * @return The color of the walls of the house
   */
  public Color getColor() {
    return theWalls.getBackground();
  }
  
  /**
   * Method for resizing the House
   * Adjusts the height, width, and
   * locations of the underlying NscComponent
   * and all of its interior components.
   * 
   * @param w the new width of the house
   * @param h the new height of the house
   */
  public void setSize(int w, int h){
    //set the underlying NscComponent's size
    super.setSize(w, h);
    
    //adjust the roof
    theRoof.setSize(w, (int)(h*(40.00/90.00)));
    
    //adjust the walls
    theWalls.setLocation((int)(w*(10.00/120.00)), (int)(h*(40.00/90.00)));
    theWalls.setSize(w-(int)(w*(10.00/120.00)*2.00), h - (int)(h*(40.00/90.00)));
    
    //adjust the door
    theDoor.setSize((int)(w*(24.00/120.00)), (int)(h*(40.00/90.00)));
    theDoor.setLocation((int)(w/2.00 -((w*(24.00/120.00))/2.00)), (int)(h*50.00/90.00));
    
   
      
  }
  
}
