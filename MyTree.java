//import declaration allowing short name access  to java.awt.Color
import java.awt.Color;

/**
 * This class creates trees of different shapes
 * and colors. It extends NscComponent
 * 
 * @author Evan Newton
 * @version Assignment: 4 MyTree Challenge
 */
class MyTree extends NscComponent{
  
  //instance variables
  private NscRectangle theTrunk;
  private NscEllipse theTop;
  private int height;
  private int width;
  
  /**
   * Constructor for objects of MyTree
   * which creates trees at
   * the specificed location. 
   * 
   * @param x the x coordinate of the tree
   * @param y the y coordinate of the tree
   */
  public MyTree(int x, int y){
    //specify the constructor for the super class
    super(x, y, 50, 90);
    
    //set overal width and height of instance
    height = getHeight();
    width = getWidth();
    
    //create the top object
    theTop = new NscEllipse(0, 0, width, height/3*2);
    theTop.setFilled(true);
    theTop.setBackground(new Color(92, 175, 43));
    
    //create theTrunk
    theTrunk = new NscRectangle(width/2-width/3/2, height/3, width/3, height/3*2);
    theTrunk.setFilled(true);
    theTrunk.setBackground(new Color(175, 120, 40));
    
    //add theTrunk
    add(theTrunk);
    
    //add theTop to MyTree object
    add(theTop);
  }
  
  /**
   * Three parameter
   * Default top constructor for objects of MyTree
   * which creates lolly trees of specified color
   * at the specificed location. 
   * 
   * @param x the x coordinate of the tree
   * @param y the y coordinate of the tree
   * @param color the color of theTop
   */
  public MyTree(int x, int y, Color color){
    this(x, y);
    setColor(color);
  }
  
  /**
   * Change the color of the tree
   * 
   * @param c The color for the top
   */
  public void setColor(Color c) {
    theTop.setBackground(c);
    repaint();
  }
  
  /**
   * Retrieve the color of the tree
   * 
   * @return c the color of theTop
   */
  public Color getColor() {
    return theTop.getBackground();
  }
  
  /**
   * Method for resizing the tree
   * Adjusts the height, width, and
   * locations of the underlying NscComponent
   * and all of its interior components.
   * 
   * @param w new width for the tree
   * @param h new height for the tree
   */
  public void setSize(int w, int h){
    //set the underlying NscComponent's size
    super.setSize(w, h);
    
    //reassign instance variables
    height = h;
    width = w;
   
    //adjust the top
    theTop.setSize(w, (int)(h/3.00*2.00));
    
    //adjust the trunk
    theTrunk.setSize((int)(w/3.00), (int)(h/3.00*2.00));
    theTrunk.setLocation((int)(w/2.00-w/6.00), (int)(h/3.00));
      
  }
}