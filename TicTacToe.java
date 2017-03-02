import java.awt.Color;
/**
 * This class is an NscWindow which facilitates the playing of Tic-Tac-Toe
 * 
 * @author Evan Newton
 * @version Assignment 8: Tic-Tac-Toe, The Game challenge
 */
public class TicTacToe extends NscWindow implements java.awt.event.ActionListener {
  
  //javax buttons and label declaration
  private javax.swing.JButton [] cells;
  private javax.swing.JButton resetBtn;
  private javax.swing.JLabel prompt;
  
  //the current turn
  private String turn;
  private Color turnColor;
  
  //colors
  private Color blue = new Color(0, 0, 204);
  private Color red = new Color(204, 0, 0);
  
  //the number of moves made
  private int turnNo;
  
  //font declarations
  private java.awt.Font cellFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
  
  //text for the prompt
  private final String X = "X";
  private final String O = "O";
  
  //array of rectangles for the borders
  NscRectangle [] borders;
  
  /**
   * Parameterless constructor of TicTacToe uses the superclass NscWindow
   * constructor with parameters for location and size of the window "Tic-Tac-Toe". 
   * This constructor also sets up the initial game state, buttons and labels.
   */
  public TicTacToe() { 
    //super constructor x, y, width, height of the game window
    super(10, 10, 235, 300);
    setTitle("Tic-Tac-Toe");
    turn = X;
    turnColor = red;
    turnNo = 1;
    
    //game board initialization
    initCells(); 
    
    //prompt JLabel initialization
    prompt = new javax.swing.JLabel((turn +"'s turn"), javax.swing.JLabel.CENTER);
    prompt.setLocation(30, 200);
    prompt.setSize(160, 20);
    add(prompt);
    
    //reset button initialization
    resetBtn = new javax.swing.JButton("New Game");
    resetBtn.setLocation(40, 225);
    resetBtn.setSize(140, 20);
    
    //keep the button invisible and do not add an action listener just yet
    resetBtn.setVisible(false);
    add(resetBtn);
    
    //repaint the window
    repaint();  
  }
  
  /**
   * Application method for single file operation
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) { 
    //new TicTacToe objects need only be instantiated to play
    new TicTacToe();
    
  }
  
  //method for detecting a win
  private boolean isWin(String play){
    //helpful int for vertical cell indices
    int y;
    
    //loop through straight line victory paths
    for(int i = 0; i < 9; i+=3 ){
      //y will either be 0, 1 or 2
      y = i/3;
      //horizontal paths
      if(hasSame(play, i, i+1, i+2)){          
        return true;
      }
      //vertical paths
      if(hasSame(play, y, y+3, y+6)){
        return true;
      }
    }
    //diagonal paths
    if(hasSame(play, 0, 4, 8) || hasSame(play, 2, 4, 6)){
      return true;
    }
    return false;
  }
  
  //helper method for isWin that detects if three cells are "equal", disables all other cells
  private boolean hasSame(String play, int a, int b, int c){
    //if each of the cells a, b, and c contain the same string "play"
    if (play.equals(cells[a].getText()) && play.equals(cells[b].getText()) && play.equals(cells[c].getText())){
      
      //disables all buttons
      enableAll(false);
      
      //enables the buttons that won but takes away actions
      cells[a].setEnabled(true);
      cells[a].removeActionListener(this);
      cells[b].setEnabled(true);
      cells[b].removeActionListener(this);
      cells[c].setEnabled(true);
      cells[c].removeActionListener(this);
      
      //return of true tells isWin to also return true
      return true;
    } else {
      //tells isWin to keep checking
      return false;
    }
  }
  
  //create the button array and get the position of the cells with algebra
  private void initCells(){
    cells = new javax.swing.JButton[9];
    borders = new NscRectangle[4];
    for(int x = 0; x < 9; x++){
      cells[x] = new javax.swing.JButton();
      cells[x].setSize(50, 50);
      cells[x].setLocation(30+55*(x%3), 30+55*(x/3));
      cells[x].addActionListener(this);
      cells[x].setFont(cellFont);
      add(cells[x]);
    }
    for(int x = 0; x < 4; x++){
      borders[x] = new NscRectangle(30+50*(x/2)+x/3*55, 30+(105-x*55)*((4-x)/3), 5+155*((4-x)/3), 5+155*(x/2));
      borders[x].setFilled(true);
      borders[x].setBackground(Color.BLACK);
      add(borders[x]);
    }
  }
  
  //this method enables (true) or disables (false) all cells
  private void enableAll(boolean able){
    for(int i = 0; i < 9; i++){
      cells[i].setEnabled(able);
    }    
  }
  
  /**
   * This method shows the reset button
   */
  public void showReset(){
    resetBtn.addActionListener(this);
    resetBtn.setVisible(true);
  }
  
  /**
   * This method allows the game to be reset to its initial state
   */
  public void reset(){
    
    //hide the reset button again
    resetBtn.setVisible(false);
    resetBtn.removeActionListener(this);
    
    //enable the disabled cells
    enableAll(true);
    
    //set the game state to its initial value
    turn = X;
    turnColor = red;
    turnNo = 1;
    prompt.setText(turn+"'s turn");
    
    //reset text and action listeners for each cell
    for(int i = 0; i < 9; i++){
      cells[i].setText("");
      cells[i].removeActionListener(this);
      cells[i].addActionListener(this);
    }
  }
  
  /**
   * This is the event listener which is triggered when a button is clicked. 
   * It handles the bulk of the other method calls and workflow.
   * System beep, setting the turn & prompt, calling for a win check, showing 
   * the reset button, calling a cat's game and calling for a reset are all handled
   * by actionPerformed.
   * 
   * @param e an ActionEvent 
   */
  public void actionPerformed(java.awt.event.ActionEvent e) {
    
    //cell is the handle for the button that just got clicked
    javax.swing.JButton cell;
    cell = (javax.swing.JButton)e.getSource();
    
    //beeps if cell already has an X or an O
    if(cell.getText().equals(X) || cell.getText().equals(O)){
      getToolkit().beep();
      
      //if the cell is blank, adds the players mark and changes the turn
    } else if(cell.getText().equals("")){
      
      //the text to set the cell to is held in turn
      cell.setText(turn);
      cell.setForeground(turnColor);
      
      //this switch changes the turn
      switch(turn){
        case X:
          turn = O;
          turnColor = blue;
          break;
        case O:
          turn = X;
          turnColor = red;
          break;
      }
      //cell.setEnabled(false);
      turnNo++;
      
      //after a tile is filled, it's text is sent to isWin to see if that player has won
      if(isWin(cell.getText())){
        showReset();
        prompt.setText(cell.getText() + " Wins!");
        
        //if it is turn 10 and nobody won, it's a cat's game
      } else if (turnNo == 10){
        //cat's game disables all buttons
        enableAll(false);
        prompt.setText("Cat's Game!");
        showReset();
      } else {
        //if nobody has one but there are still tiles, prompt reflects that
        prompt.setText(turn+"'s Turn");
        repaint();
      }
      //if the button that was pressed is the reset button, a call to reset is made
    } else if(cell.getText().equals("New Game")) {
      reset();
    } 
  }
}
