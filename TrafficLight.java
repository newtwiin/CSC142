import java.awt.Color;

/**
 * this class builds and displays a traffic light
 * 
 * @author Evan Newton
 * @version Lab 2: Traffic Light plus
 */
public class TrafficLight {
   
  /**
   * This method creates a window and puts a traffic light in it. 
   * It makes the background itself and uses newLight to generate ellipses, just for you.
   */
   public void drawTheLight() {
     
      //creates a window for the light
      NscWindow win;
      win = new NscWindow(10, 10, 140, 330);
      
      //creates a rectangle for the background
      NscRectangle bRect;
      bRect = new NscRectangle(20, 20, 90, 250);
      
      //make the background LIGHT_GRAY
      bRect.setFilled(true);
      bRect.setBackground(Color.LIGHT_GRAY);
      bRect.setForeground(Color.LIGHT_GRAY);
      
      //adds bRect to win
      win.add(bRect);
      
      //define green
      Color green = new Color(0, 160, 0);
      
      //adds the Lights
      NscEllipse redLight = newLight(10, 10, Color.RED);
      bRect.add(redLight);
      NscEllipse yelLight = newLight(10, 90, Color.YELLOW);
      bRect.add(yelLight);
      NscEllipse grnLight = newLight(10, 170, green);
      bRect.add(grnLight);
      
      //repaint win
      win.repaint();
   }
   
   /**
    * This method returns the lights as NscEllipses after creating them using the parameters.
    * The lights are then painted onto NscWindow by drawTheLight.
    * @param x the horizontal position of the upper left corner of the bounding box. Origin is the upper left
    * corner of the container.
    * @param y the vertical position of the upper left corner of the bounding box. Origin is the upper left
    * corner of the container, coordinates count up but stretch downwards from the origin, no negative values.
    * @param color the color to fill in the lights
    * @return returns a colored ellipse to be painted on win by drawTheLight
    */
   public NscEllipse newLight(int x, int y, Color color){
      
      //standard diameter of a light
      int dia = 70;
      
      //instantiate the light with the given parameters
      NscEllipse light = new NscEllipse(x, y, dia, dia);
      
      //color the light in one hue
      light.setFilled(true);
      light.setBackground(color);
      light.setForeground(color);
     
      //return light to be added to bRect
      return light;
   }
   
   /**
    * the application method to create a traffic light
    * @param args the command-line arguments
    */
   public static void main(String[] args){
     TrafficLight pict;
     pict = new TrafficLight();
     pict.drawTheLight();
   }
}