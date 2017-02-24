import java.awt.Color;

/**
 * This class will be used to create a window with a button
 * 
 * @author Evan Newton
 * @version Lab 10 plus
 */
public class ButtonButton implements java.awt.event.ActionListener {
 
  //declaration of NscWindow and Ellipse 
  private NscWindow win;
  private NscEllipse oval;
  
  //the ellipses color state is stored as an integer
  private int state;
  
  //things for buttons to say (also how the event listener differentiates them)
  private final String ty = "Thanks, I needed that"; 
  private final String pls = "Plaes halp! Click!";
  private final String sin = "Sinister other...";  
  private final String brv = "ur brave waow";  
  
  /**
   * Parameterless constructor initiallizes many objects 
   * like the buttons, the state, the window, and the circle.
   */
  public ButtonButton() { 
    
    //State initially at zero will be incremented to state 1: red on the first call to cycle
    state = 0;
    
    //make a window
    win = new NscWindow();
    win.setTitle("Buttonbutton");
    
    //button making
    javax.swing.JButton btn;
    javax.swing.JButton backbtn;
    
    //first btn cycles through three colors
    btn = new javax.swing.JButton(pls);
    btn.setSize(170, 35);
    btn.setLocation(110, 10);
    win.add(btn);
    btn.addActionListener(this);
    
    //second backbtn cycles in the reverse order
    backbtn = new javax.swing.JButton(sin);
    backbtn.setSize(120, 20);
    backbtn.setLocation(20, 220);
    win.add(backbtn);
    backbtn.addActionListener(this);
    
    //here is the oval's instantiation
    oval = new NscEllipse(100, 70, 200, 150);
    oval.setFilled(true);
    
    //start the first cycle which fills the circle in red
    cycle(false);
    
    //add the oval to the window and repaint
    win.add(oval);
    win.repaint();
  }
  /**
   * Application Method
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) { 
    
    /**
     * Instantiation of ButtonButton
     */
    new ButtonButton();
  }
  
  //this method is used to change the color of the button
  private void cycle(Boolean back){
    
    //these are colors
    Color reyd = new Color(200, 10, 30);
    Color gurn = new Color(10, 230, 30);
    Color blew = new Color(0, 30, 250);
      
    //advances the state by 1 or if back is true, by -1
    if(back){
      state--;
    } else {
      state++;
    }
    
    //this switch does the actual changing of the color
    switch(state){
      //if state has been advanced to four, it changes to state/case 1
      case 4: state = 1;
      case 1: oval.setBackground(reyd);
      break;
      case 2: oval.setBackground(gurn);
      break;
      //if state has been reduced to zero, it changes state/case to 3
      case 0: state = 3;
      case 3: oval.setBackground(blew);
      break; 
    }
    //remember to repaint that window ya hear?
    win.repaint();
  } 
  
  /**
   * This is the event listener which is triggered when a button is clicked
   * 
   * @param e an ActionEvent 
   */
  public void actionPerformed(java.awt.event.ActionEvent e) {
    
    /**
     * Declaration of button reference to whatever button just got clicked
     */
    javax.swing.JButton btn;
    
    /**
     * This actually binds the button that triggered the event to its handle
     */
    btn = (javax.swing.JButton)e.getSource();
    
    /**
     * a switch statement uses the text contained within button to control the color 
     * blurb is where that string is stored on each event.
     */
    String blurb = btn.getText();
    switch(blurb){
      
      //pls and ty move it forward while sin and brv move it back
      case pls:
        btn.setText(ty);
        cycle(false);
        break;
        
      case ty:
        btn.setText(pls);
        cycle(false);
        break;
        
      case sin:
        btn.setText(brv);
        cycle(true);
        break;
        
      case brv:
        btn.setText(sin);
        cycle(true);
        break;
        
      default:
        btn.setText("I broke :(");
        break;
    }
  } 
}