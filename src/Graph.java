import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 * 
 * class Graph
 * extends JPanel
 * pre-condition: JComponent to put the Graph on
 * post-condition: graph object appears on JComponent
 * 
 * Graph initializes with an array of no points on the gui
 * 
 * This class was created in project 1 and will be useful here for the checking collisions
 * 
 */
public class Graph extends JPanel{
	
	//Set global constants for all of graph features
	private final int HEIGHT = 200;
	private final int WIDTH = 500;
	private final int NOTCHES = 5;
	private final int HINTERVAL = HEIGHT/NOTCHES;
	private final int WINTERVAL = WIDTH/NOTCHES;
	private final int POINT_DIAMETER = 8;
	private final int STARTING_POINT = HEIGHT/2;
	private final int MAX_POINTS = 5;
	

	//set array to push certain number of points
	public Point[] points;
	
	//set graph colors
	private Color graphColor = Color.blue;
	private Color backgroundColor = new Color(1,0,0,0);

	//variables
    public int xlocation, ylocation;
    public String graphTitle;

    /**
     * Graph() constructor - calls function to initialize board
     * 
     * sets the array of points to a max number of points
     * adds the first point at (0,startingpoint) location
     * 
     * 
     */
    
    public Graph(int x, int y, String title) {
        initializeBoard(x, y, title);
        points = new Point[MAX_POINTS + 1];
        points[0] = new Point(0,STARTING_POINT);
    }
    
    /**
     * initializeBoard()
     * 
     * Setup all parameters for the board including the upper left point location of the graph
     * in the JComponent
     * @param - x,y,title
     * @return - none
     * 
     */
    
    private void initializeBoard(int x, int y, String title) 
    {
    	 xlocation = x;
    	 ylocation = y;
    	 graphTitle = title;
    }
  
    //This methods overrides the paintComponent function
    //Call the paintComponent of the parent class 
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        drawGraph(g);//puts the graph
        drawNotches(g);//adds the notches
        drawTitle(g);//draws the title in the middle
        drawPoints(g);//draws ALL points each time depending on Array of points
    }
    
    
    //Setting up the graph axis
    //
    
    private void drawGraph(Graphics g)
    {
        Graphics2D graphicsObject = (Graphics2D) g; 
        graphicsObject.setPaint(graphColor); 
        if(graphTitle == "invisible")//if the graph title is invisible the paint color will be clear
        {
            graphicsObject.setPaint(backgroundColor); //clear color
        }

        graphicsObject.draw(new Line2D.Double(xlocation, ylocation, xlocation, ylocation + HEIGHT));//y axis
        graphicsObject.draw(new Line2D.Double(xlocation, ylocation + HEIGHT, xlocation + WIDTH, ylocation + HEIGHT));//x axis
    }
    
    //sets the JLabel title of the graph passed from the constructor
    private void drawTitle(Graphics g)
    {
        Graphics2D graphicsObject = (Graphics2D) g; 
        graphicsObject.setPaint(graphColor); 
        if(graphTitle == "invisible")
        {
            graphicsObject.setPaint(backgroundColor); 
        }
        graphicsObject.drawString(graphTitle, WIDTH/2-5*(graphTitle.length()), 10);
        
    }
    
    //adds all the steps in the graph. Each steph is converted based on how many NOTCHES you chose
    private void drawNotches(Graphics g)
    {
        Graphics2D graphicsObject = (Graphics2D) g; 
        graphicsObject.setPaint(graphColor); 
        if(graphTitle == "invisible")
        {
            graphicsObject.setPaint(backgroundColor); 
        }
        for(int i = 0; i < NOTCHES; i++){
        graphicsObject.draw(new Line2D.Double(xlocation, ylocation + i*HINTERVAL, xlocation + 5, ylocation + i*HINTERVAL));
        graphicsObject.draw(new Line2D.Double(xlocation + (i+1)*WINTERVAL, ylocation + HEIGHT, xlocation + (i+1)*WINTERVAL, ylocation + HEIGHT - 5));
        }
    }
    
    /**
     * drawPoints()
     * 
     * @param g
     * 
     * adds all points to the GUI to be called in paintcomponent
     * if the list is null it won't paint anything
     * the array of points will always have one point on it starting at 0
     * 
     */
    public void drawPoints(Graphics g)
    {
    	for(int i = 1; i<points.length; i++)
    	{
    		if(points[i]==null)
    		{
    			
    		}
    		else
    		{
				int xlocation = points[i].x;
				int ylocation = points[i].y;
				int oldXLocation = points[i-1].x;
				int oldYLocation = points[i-1].y;
				
				Graphics2D graphicsObject = (Graphics2D) g; 
				graphicsObject.setPaint(graphColor); 
				if(graphTitle == "invisible")
		        {
		            graphicsObject.setPaint(backgroundColor); 
		        }
				graphicsObject.fillOval(xlocation-POINT_DIAMETER/2, ylocation-POINT_DIAMETER/2, POINT_DIAMETER, POINT_DIAMETER); //uses same diameter at all times but different locations
				graphicsObject.draw(new Line2D.Double(oldXLocation, oldYLocation, xlocation,ylocation));
    		}
    	}
    }
   
    //adds a single point to the array of points
    //This point will be added to the notch in the x direction and its y
    //value will be based on the previous point
    
    public void addPoint(int y)
    {
    	for(int i = 1; i<points.length; i++){
    		
    		if(points[i]==null)
    		{
    			Point newPoint = new Point(i*(WIDTH/NOTCHES), points[i-1].y - y);
    			points[i] = newPoint;
    			break;
    		}
    	}
    	repaint();
    }
 
    
}