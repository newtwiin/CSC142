import java.awt.Color;

/**
 * This is a class which uses the DrawingPanel to create two images,
 * a traffic light, and picture of nested shapes
 *
 * @author Evan Newton
 * @version Lab 13: DrawingPanel Check
 */
public class PicLab {

    //colors for the lights, the array also allows the color to loop with coordinate generation
    private final static Color [] colors = new Color[] {Color.RED, Color.YELLOW, new Color(0, 127, 0)};

    /**
     * This method draws a traffic light on a DrawingPanel
     */
    public void drawLights() {
        /*
         * win is the DrawingPanel on which the traffic light shall be drawn
         * width 130
         * height 290
         */
        DrawingPanel win = new DrawingPanel(130, 290);
        win.setTitle("Traffic Light");
        
        //g is the graphics context for win and is used to draw on win
        java.awt.Graphics g = win.getGraphics();

        //make the grey rectangle base
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(20, 20, 90, 250);

        //y starts at 30 (20px margin + 10px border) and increments by 80px (70px width+10px border)
        for(int y = 30; y < 270; y += 80) {

            //the index of correct color can be selected with integer division which yields 0, 1, then 2.
            g.setColor(colors[(y - 30) / 80]);
            g.fillOval(30, y, 70, 70);
            g.setColor(Color.BLACK);
            g.drawOval(30, y, 70, 70);
        }
        //draw the border for the gray base (no need to change color now)
        g.drawRect(20, 20, 90, 250);
    }

    /**
     * This method makes an image of three nested shapes
     */
    public void drawShapes() {

        /*
         * win is the DrawingPanel on which the nested shapes shall be drawn
         * width 250
         * height 250
         */
        DrawingPanel win = new DrawingPanel(250, 250);
        win.setTitle("Nested Shapes");
        
        //g is the graphics context for win and is used to draw on win
        java.awt.Graphics g = win.getGraphics();

        //make the green rectangle first, because it's the bottom layer
        g.setColor(Color.GREEN);
        g.fillRect(25, 25, 200, 200);

        //magenta oval is second
        g.setColor(Color.MAGENTA);
        g.fillOval(25, 25, 200, 200);

        //finally the cyan polygon (diamond) coordinates are listed in the order W, N, E, S
        g.setColor(Color.CYAN);
        g.fillPolygon(new int[]{25, 125, 225, 125}, new int[]{125, 25, 125, 225}, 4);

        //go back and do the outlines in black
        g.setColor(Color.BLACK);
        g.drawRect(25, 25, 200, 200);
        g.drawOval(25, 25, 200, 200);
        g.drawPolygon(new int[]{25, 125, 225, 125}, new int[]{125, 25, 125, 225}, 4);
    }

    /**
     * Application Method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //create an instance of PicLab
        PicLab lab = new PicLab();
        //traffic light method
        lab.drawLights();
        //nested shapes method
        lab.drawShapes();
    }
}