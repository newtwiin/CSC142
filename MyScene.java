// Allow short name access to java.awt.Color
import java.awt.Color;

/**
 * This is the shell for assignment 4: MyScene.
 * This program draws a simple scene using additional
 * classes that the student creates.
 * 
 * @author Evan Newton
 * @author Dan Jinguji 
 * @version Assignment 4: MyScene Challenge
 */
public class MyScene extends NscWindow {

  // instance variables
  //houses
  private MyHouse house;
  private MyHouse house2;
  private MyHouse house3;
  
  //trees
  private MyTree tree1;
  private MyTree tree2;
  private MyTree tree3;
  
  
  /**
   * Constructor for objects of class MyScene
   */
  public MyScene() {
    // Specify the constructor for the superclass
    super(10, 10, 400, 300);
    // set characteristics for the object
    setTitle("My Scene");
    
    // Draw the sky
    getContentPane().setBackground(new Color(0x00, 0xCC, 0xFF));
    
    // Draw some grass
    NscRectangle grass = new NscRectangle(0, 100, 400, 200);
    grass.setBackground(new Color(0x00, 0x99, 0x00));
    grass.setFilled(true);
    add(grass);
    
    // Draw houses
    house = new MyHouse(100, 50);
    add(house);
    house2= new MyHouse(50, 100, Color.ORANGE);
    add(house2);
    house3 = new MyHouse(200, 200, new Color(78, 237, 131));
    add(house3);
    
    //Draw Trees
    tree1 = new MyTree(25, 75);
    add(tree1);
    tree2 = new MyTree(175, 100, new Color(20, 102, 30));
    add(tree2);
    tree3 = new MyTree(200, 100, new Color(114, 109, 9));
    add(tree3);
    
    // request a rerendering of the window
    repaint();
  }
  
  /**
   * Alter the scene, by changing color
   */
  public void change1() {
    // change the color of the houses
    house.setColor(Color.red);
    house2.setColor(new Color(255, 131, 0));
    house3.setColor(new Color(133, 237, 73));
    
    //change the color of the trees
    
    tree1.setColor(new Color(216, 93, 17));
    tree2.setColor(new Color(198, 242, 169));
    tree3.setColor(new Color(81, 130, 104));
    // request a rerendering of the window
    repaint();
  }
  
  /**
   * Alter the scene, by changing location
   */
  public void change2() {
    // change the location of the houses
    house.setLocation(50, 125);
    house2.setLocation(125, 175);
    house3.setLocation(200, 25);
    
    //change the location of the houses
    tree1.setLocation(40, 175);
    tree2.setLocation(150, 20);
    tree3.setLocation(60, 175);
    // request a rerendering of the window
    repaint();
  }
  
  /**
   * Alter the scene, by changing size
   */
  public void change3() {
    
    // change the sizes of the houses
    house.setSize(10, 30);
    house2.setSize(80, 60);
    house3.setSize(200, 200);
    
    // change the sizes of the trees
    tree1.setSize(20, 20);
    tree2.setSize(20, 120);
    tree3.setSize(50, 30);
    // request a rerendering of the window
    repaint();
  }
  
  /**
   * Alter the scene, restoring original settings
   */
  public void reset() {
    // reset the initial values for the house
    house.setLocation(100, 50);
    house.setColor(Color.blue);
    house.setSize(120, 90);
    
    //house 2 init
    house2.setLocation(50, 100);
    house2.setColor(Color.ORANGE);
    house2.setSize(120, 90);
    
    //house 3 init
    house3.setLocation(200, 200);
    house3.setColor(new Color(78, 237, 131));
    house3.setSize(120, 90);
    
    //tree 1 init
    tree1.setLocation(25, 75);
    tree1.setColor(new Color(92, 175, 43));
    tree1.setSize(50, 90);
    
    //tree 2 init
    tree2.setLocation(175, 100);
    tree2.setColor(new Color(20, 102, 30));
    tree2.setSize(50, 90);
    
    //tree 3 init
    tree3.setLocation(200, 100);
    tree3.setColor(new Color(114, 109, 9));
    tree3.setSize(50, 90);
    
    // request a rerendering of the window
    repaint();
  }
  
  /**
   * The application method, to test your code
   *
   * @param args The command-line arguments
   */
  public static void main(String[] args) {

     // declare a MyScene reference
     MyScene aScene;
     // instantiate MyScene
     aScene = new MyScene();
     // pause
     javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

     // test setColor
     aScene.change1();
     javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

     // test setLocation
     aScene.change2();
     javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

     // test setSize
     aScene.change3();
     javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

     // reset initial values
     aScene.reset();
  }
  
}
