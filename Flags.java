import java.awt.Color;
  
/**
 * This class contains methods that will use NscWindow
 * to draw the flads of Niger, Sweden, Norway, Seychelles,
 * and Alabama
 * 
 * @author Evan Newton
 * @version Assignment 2: Flags Challenge
 */
public class Flags {
  
    /**
   * the rect method returns rectangles with
   * position, height, width, and color determined 
   * by parameters. Coordinate origins are upper left corner
   * Y coordinates increase downward and are negative above origin.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param fly horizontal width in pixels
   * @param hoist vertical height in pixels
   * @param fill Color to be filled
   * @return returns an NscRectangle
   */
  public NscRectangle rect(int x, int y, int fly, int hoist, Color fill){
    NscRectangle rectangle = new NscRectangle(x, y, fly, hoist);
    rectangle.setFilled(true);
    rectangle.setBackground(fill);
    
    return rectangle;
  }
  
  /**
   * this method will produce the flag of Niger
   * Calculations:
   *  whole flag:
   *   fly:hoist::7:6::526:450
   *   fly adjusted by 1 pixel
   *   position: (25, 25)
   * 
   *  horizontal color bars:
   *   (255,127,0):WHITE:(0, 204, 0)::1:1:1::526:150
   *   positions = (0,0)(Background)(0, 300)
   * 
   *  circle diameter = 75% 1/3 hoist ~= 112
   *  diameter adjusted by 0.5
   *  color:(255,127,0) 
   *  position: (1/2 fly - 1/2 diameter, 1/2 hoist - 1/2 diameter)
   */
  public void drawNigerFlag(){
    
    //new window to contain the flag
    NscWindow niger = new NscWindow(25, 25, 600, 600);
    niger.setTitle("Flag of Niger");
    
    //add a white rectangle to serve as the base for the flag
    int fly = 526;
    int hoist = 450;
    NscRectangle flag = rect(25, 25, fly, hoist, Color.WHITE);
    niger.add(flag);
    
    //add the upper orange bar
    Color nigerOrange = new Color(255,127,0);
    flag.add(rect(0, 0, fly, 150, nigerOrange));
    
    //add the lower green bar
    Color nigerGreen = new Color(0, 204, 0);
    flag.add(rect(0, 300, fly, 150, nigerGreen));
    
    //add the circle
    int dia = 112;
    NscEllipse circle = new NscEllipse(fly/2 - dia/2, hoist/2 - dia/2, dia, dia);
    circle.setFilled(true);
    circle.setBackground(nigerOrange);
    flag.add(circle);
    
    //repaint flag
    flag.repaint();
     
  }
  
  /**
   * this method will produce the flag of Sweden
   * Calculations:
   *  portions:
   *   unit = 40
   *   fly:
   *    5:2:9::BLUE:YELLOW:BLUE::200:80:360
   *   hoist:
   *    4:2:4::BLUE:YELLOW:BLUE::160:80:160
   * 
   *  whole flag:
   *   fly:hoist::8:5::640:400
   *   position = (25, 25)
   *   color = YELLOW
   *   
   *  Rectangles:
   *   color = Blue
   *   upperLeft: 
   *     position: 0,0
   *     size: 200*160
   * 
   *   lowerLeft:
   *     position: 0, 240
   *     size: 200*160
   * 
   *   upperRight:
   *     position: 280, 0
   *     size: 360*160
   * 
   *   lowerRight:
   *     position: 280, 240
   *     size: 360*160
   */
  public void drawSwedenFlag(){

    //create window for swedish flag
    NscWindow sweden = new NscWindow(25, 25, 720, 500);
    sweden.setTitle("Flag of Sweden");
    
    //create yellow flag base
    NscRectangle flag = rect(25, 25, 640, 400, Color.YELLOW);
    sweden.add(flag);
    
    //add four blue rectangles
    //upper left
    flag.add(rect(0, 0, 200, 160, Color.BLUE));
    //lower left
    flag.add(rect(0, 240, 200, 160, Color.BLUE));
    //upper right
    flag.add(rect(280, 0, 360, 160, Color.BLUE));
    //lower right
    flag.add(rect(280, 240, 360, 160, Color.BLUE));
    
    sweden.repaint();
  }
  
  /**
   * this method draws the flag of Norway
   * Calculations:
   *  portions:
   *   unit: 30
   *    fly:
   *     6:1:2:1:12::RED:WHITE:BLUE:WHITE:RED::180:30:60:30:360
   *    
   *    hoist:
   *     6:1:2:1:6:RED:WHITE:BLUE:WHITE:RED::180:30:60:30:180
   * 
   *  whole flag:
   *   color: BLUE
   *   position: 25, 25
   *   fly:hoist::660:480
   * 
   *  Rectangles:
   *  color: WHITE
   *  added to: Flag
   *   Upper Left:
   *    position: 0, 0
   *    size: 210*210
   *   Lower Left:
   *    position: 0, 270
   *    size: 210*210
   *   Upper Right:
   *    position: 270, 0
   *    size: 390*210
   *   Lower Right:
   *    position: 270, 270
   *    size: 390*210
   * 
   *  color: RED
   *  added to: WHITE rectangles
   *   Upper Left:
   *    position: 0,0
   *    size: 180*180
   *   Lower Left:
   *    position: 0,30
   *    size: 180*180
   *   Upper Right:
   *    position: 30,0
   *    size: 360*180
   *   Lower Right:
   *    position: 30,30
   *    size: 360*180
   */
  public void drawNorwayFlag(){
    
    //create window for Norwegian Flag
    NscWindow norway = new NscWindow(25, 25, 720, 580);
    norway.setTitle("Flag of Norway");
    
    //add blue base
    NscRectangle flag = rect(25, 25, 660, 480, Color.BLUE);
    norway.add(flag);
    
    //add white rectangles containing red rectangles
    //upper left
    NscRectangle upL = rect(0, 0, 210, 210, Color.WHITE);
    flag.add(upL);
    upL.add(rect(0, 0, 180, 180, Color.RED));
    
    //lower left
    NscRectangle loL = rect(0, 270, 210, 210, Color.WHITE);
    flag.add(loL);
    loL.add(rect(0, 30, 180, 180, Color.RED));
    
    //upper right
    NscRectangle upR = rect(270, 0, 390, 210, Color.WHITE);
    flag.add(upR);
    upR.add(rect(30, 0, 360, 180, Color.RED));
    
    //lower right
    NscRectangle loR = rect(270, 270, 390, 210, Color.WHITE);
    flag.add(loR);
    loR.add(rect(30, 30, 360, 180, Color.RED));
          
    //repaint the window
    norway.repaint();
 
  }
  
  /**
   * This method draws the flag of Seychelles
   * All colors are built-in except green,
   * defined as seyGreen=(0, 128, 0)
   * 
   * Calculations:
   *    Fly:Hoist::2:1:600:300
   *  Portions:
   *    Fly:
   *     1:1:1::BLUE:YELLOW:RED::200:200:200
   *    Hoist:
   *     1:1:1::RED:WHITE:GREEN::100:100:100
   * 
   *   Base:
   *    Color: Red
   *    Position: 25, 25
   *    Size : 600*300
   * 
   *   Yellow:
   *    method: NscDownTriangle
   *    position: -400, 0
   *    size: 800*300
   * 
   *   Blue:
   *    method: NscDownTriangle
   *    position -200, 0
   *    size: 400*300
   * 
   *   White: 
   *    method: NscLeftTriangle
   *    position: 0, 100
   *    size: 600*400
   * 
   *   Green:
   *    method: NscLeftTriangle
   *    position 0, 100
   *    size: 600*200
   */
  public void drawSeychellesFlag(){
    
    //create seychelles flag window
    NscWindow seychelles = new NscWindow(25, 25, 680, 400);
    seychelles.setTitle("Flag of Seychelles");
    
    //create a red base and add to the window
    NscRectangle flag = new NscRectangle(25, 25, 600, 300);
    flag.setFilled(true);
    flag.setBackground(Color.RED);
    seychelles.add(flag);
    
    //add the yellow triangle
    NscDownTriangle triYellow = new NscDownTriangle(-400, 0, 800, 300);
    triYellow.setFilled(true);
    triYellow.setBackground(Color.YELLOW);
    flag.add(triYellow);
    
    //add the blue triangle
    NscDownTriangle triBlue = new NscDownTriangle(-200, 0, 400, 300);
    triBlue.setFilled(true);
    triBlue.setBackground(Color.BLUE);
    flag.add(triBlue);
    
    //Redraw the outline on the left side
    NscLine lLine = new NscLine(0, 0, 0, 300);
    flag.add(lLine);
    
    //add the white Triangle
    NscLeftTriangle triWhite = new NscLeftTriangle(0, 100, 600, 400);
    triWhite.setFilled(true);
    triWhite.setBackground(Color.WHITE);
    flag.add(triWhite);
    
    //define green
    Color seyGreen = new Color(0, 128, 0);
    
    //add the green Triangle
    NscLeftTriangle triGreen = new NscLeftTriangle(0, 200, 600, 200);
    triGreen.setFilled(true);
    triGreen.setBackground(seyGreen);
    flag.add(triGreen);
    
    //redraw the bottom line
    NscLine bLine = new NscLine(0, 299, 600, 299);
    flag.add(bLine);
    
    //repaint the window
    seychelles.repaint();
  }
  
  /**
   * this method draws the flag of Alabama
   * Calculations:
   * 
   *  Fly:Hoist::10:6::1100:660
   * 
   *  Fly::1:9:1::White:Red:White:100:900:100
   * 
   *  Hoist::1:9:1:White:Red:White:60:540:60
   * 
   *  Base:
   *   Color: RED
   *   Position: 25,25
   * 
   *  Triangles: WHITE
   * 
   *   NscDownTriangle: 
   *    position: 100, 0
   *    Width = 900 
   *    Height = (Hoist/2-60) = 270
   * 
   *   NscUpTriangle:
   *    position: 100, (Hoist/2+60) = 390
   *    Width = 900
   *    Height = 270
   * 
   *   NscRightTriangle:
   *    position: 0, 60
   *    Width = (Fly/2-100) = 450
   *    Height = 540
   * 
   *   NscLeftTriangle:
   *    position: (Fly/2+100) = 650, 60
   *    width = 450
   *    height = 540
   */
  public void drawAlabamaFlag(){
    
    //creates the Alabama flag window
    NscWindow alabama = new NscWindow(25, 25, 1180, 760);
    alabama.setTitle("Flag of Alabama");
    
    //adds a red base for the flag
    NscRectangle flag = rect(25, 25, 1100, 660, Color.RED);
    alabama.add(flag);
    
    //add white triangles to the flag
    //upper triangle
    NscDownTriangle upper = new NscDownTriangle(100, 0, 900, 270);
    upper.setFilled(true);
    upper.setBackground(Color.WHITE);
    flag.add(upper);
    
    //lower triangle
    NscUpTriangle lower = new NscUpTriangle(100, 390, 900, 270);
    lower.setFilled(true);
    lower.setBackground(Color.WHITE);
    flag.add(lower);
    
    //right triangle
    NscLeftTriangle right = new NscLeftTriangle(650, 60, 450, 540);
    right.setFilled(true);
    right.setBackground(Color.WHITE);
    flag.add(right);
    
    //left triangle
    NscRightTriangle left = new NscRightTriangle(0, 60, 450, 540);
    left.setFilled(true);
    right.setBackground(Color.WHITE);
    flag.add(left);
    
    //repaint
    alabama.repaint();
  }
  
  /**
   * application method
   * @param args command line arguments
   */
  public static void main(String[] args){
  
    Flags test = new Flags();
    test.drawNigerFlag();
    test.drawSwedenFlag();
    test.drawNorwayFlag();
    test.drawSeychellesFlag();
    test.drawAlabamaFlag();
  }
}