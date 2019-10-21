package GraphIt;
// GraphIt

// You will need to find all of the
// FINISH ME  comments and finish the code

// FINISH ME
// My name is: __________________


// Some Graphics Reminders:
//
// SETTING THE DRAW COLOR
// You will need a referenceVariable to refer
// to the graphics library
// EXAMPLES:
// referenceVariable.setColor(Color.???)
// referenceVariable.setColor(Color.BLACK);

// DRAWING A RECTANGLE OR FILLING A RECTANGLE
// the parameters are x,y,width,height
// EXAMPLES:
// referenceVariable.drawRect(50,20,100,200);
// referenceVariable.fillRect(0,0,getWidth(),getHeight());

// DRAWING A LINE
// the parameters are x1,y1,x2,y2
// EXAMPLES:
// referenceVariable.drawLine(50,20,90,80);


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class GraphIt extends JFrame implements  ActionListener
{

    // ***** declaration of JFrame variables *****
    int   pixelsPerUnit = 10;   // 10 pixels will represent 1 x value
    int   markHeight    = 5;    // marks on the graph are 5 pixels on each side
    float graphByUnit   = 0.2f;  // x will increase by 0.2 each time

    // define a mainPanel for components
    JPanel mainPanel;

    // ***** declaration of menu variables *****

    // define a menu bar variable to hold JMenus
    JMenuBar  menuBar;

    // define some JMenus and their JMenuItems
    // define a JMenu called fileMenu and add menuItems
    JMenu     fileMenu;
    JMenuItem exitMenuItem;



    // define JPanels for a BorderLayout
    JPanel     northPanel;
    JLabel     northPanelLabel;

    JPanel     southPanel;
    JPanel     westPanel;
    JPanel     eastPanel;
    DrawPanel  centerPanel;

    // for buffering
    BufferedImage back;



    // JButtons to set the equation
    // and zoom in and zoom out
    // we will add these JButtons to the southPanel
    // we will need to create the objects and call
    // each objects addActionListener(this) method
    private JButton    equationButton;
    private JButton    zoomInButton;
    private JButton    zoomOutButton;


    String equation = "2*x + 5";


    // ***** public void initialize *****

    public void initialize( )
    {



        // FINISH ME
        // create a JPanel for components and drawing
        mainPanel = new JPanel();


        // ***** assignments for menu variables *****

        // FINISH ME
        // create a JMenuBar object
        menuBar            = new JMenuBar();


        // FINISH ME
        // create a JMenu object for the "File" Menu
        fileMenu           = new JMenu("File");


        // FINISH ME
        // create a JMenuItem object for the "Exit" exit menu item
        exitMenuItem       = new JMenuItem("Exit");


        // add mnemonics to the menu system
        fileMenu.setMnemonic('F');


        // FINISH ME
        // set a mnemonic 'X' for the exitMenuItem
        exitMenuItem.setMnemonic('X');


        // FINISH ME
        // call the exitMenuItem addActionListener(this) method
        exitMenuItem.addActionListener(this);


        // FINISH ME
        // add the exitMenuItem to the fileMenu
        fileMenu.add(exitMenuItem);


        // FINISH ME
        // add the fileMenu to the menuBar
        menuBar.add(fileMenu);

        // attach the menuBar to the Window
        setJMenuBar(menuBar);


        // ***** create JPanels for a BorderLayout *****
        northPanel   = new JPanel();


        // FINISH ME
        // add your first and last name
        northPanelLabel = new JLabel("Graph It! by Neo Wang");


        Font font = new Font("Courier New",Font.BOLD,24);
        northPanelLabel.setFont(font);

        // FINISH ME
        // create JPanel() objects
        southPanel   = new JPanel();
        westPanel    = new JPanel();
        eastPanel    = new JPanel();


        centerPanel  = new DrawPanel();


        mainPanel.setLayout(new BorderLayout());


        // FINISH ME
        // create each JButton object (new it!)
        // and call the JButton's addActionListener(this) method
        // the first JButton has been done for you
        equationButton = new JButton("y = 2x + 5");
        equationButton.addActionListener(this);

        zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(this);


        zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(this);

        // FINISH ME
        // now add the JButton objects to the southPanel
        // the Layout Manager is by default a FlowLayout
        // from left to right as added
        // the equationButton has been added for you
        southPanel.add(equationButton);
        southPanel.add(zoomInButton);
        southPanel.add(zoomOutButton);



        northPanel.setBackground(new Color(115,205,255));
        northPanel.add(northPanelLabel);

        southPanel.setBackground(new Color(115,205,255));
        westPanel.setBackground(new Color(115,205,255));
        eastPanel.setBackground(new Color(115,205,255));    // ***** You need to add buttons, etc. to the 5 panels *****


        // ***** add the panels to the mainPanel 5 areas *****
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        mainPanel.add(eastPanel,BorderLayout.EAST);
        mainPanel.add(westPanel,BorderLayout.WEST);
        mainPanel.add(centerPanel,BorderLayout.CENTER);

        // make the mainPanel be the main content area and show it
        setContentPane(mainPanel);


        // FINISH ME
        // call setVisible and pass it true to show the screen
        setVisible(true);  // always show the screen last
    }   // end of public void initialize



    // ***** default constructor *****

    public GraphIt( )
    {
        // initialize variables


        // FINISH ME
        // set the size of the window
        // (call setSize and pass it 800 and 600)
        setSize(800,600);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // FINISH ME
        // add your name to the title
        setTitle("Graph It!  by   NEO WANG");


        // FINISH ME
        // call the initialize() method
        initialize();

    }

    // ***** ActionListener interface methods *****

    // start of actionPerformed (ActionListener interface)
    public void actionPerformed(ActionEvent e)
    {

        // source references the JButton or JMenuItem
        // that got clicked

        // FINISH ME
        // call the ActionEvent's getSource() method to
        // get the memory address of the object that got
        // clicked
        Object source = e.getSource();


        if (source == exitMenuItem)
        {
            System.exit(0);
        }  // end of if
        // FINISH ME
        // see if the variable source contains the same
        // memory address as the variable equationButton
        else if (source == equationButton)
        {
            // FINISH ME
            // show an input dialog box
            // String s = JOptionPane.?????
            String s = JOptionPane.showInputDialog(this,"Enter an equation: y = ???");

            // FINISH ME
            // what if they clicked on the cancel button?
            // (hint: variable s would contain null)
            if (s == null) // they pressed cancel
            {
                return; // nothing to do so quit the method
            }

            equation = s;

            equationButton.setText(equation);

            // FINISH ME
            // tell the centerPanel to repaint()
            repaint();

        }  // end of if


        else if (source == zoomInButton)
        {
            pixelsPerUnit += 5;

            // FINISH ME
            // make sure that pixelsPerUnit does not go
            // past 50.  If it does, reset it to 50
            if(pixelsPerUnit > 50)
            {
                //System.out.println("px: " + pixelsPerUnit);
                pixelsPerUnit = 50;
            }


            // FINISH ME
            // tell the centerPanel to repaint() itself.
            repaint();
        }  // end of if

        else if (source == zoomOutButton)
        {
            pixelsPerUnit -= 5;


            // FINISH ME
            // make sure that pixelsPerUnit does not go
            // under 5.  If it does, reset it to 5
            if(pixelsPerUnit < 5)
            {
                pixelsPerUnit = 5;
            }

            // FINISH ME
            // tell the centerPanel to repaint() itself.
            repaint();
        }  // end of if


    }  // end of actionPerformed






    // *************************************************
    // *************************************************
    // ***** main method *******************************
    // *************************************************
    // *************************************************
    public static void main(String[] arguments)
    {
        // FINISH ME
        // this is where the program begins
        // so we will create GraphIt object
        GraphIt graphIt = new GraphIt();
    }









    // *************************************************************************************
// *************************************************************************************
// *************************************************************************************
// *************************************************************************************
// this is the centerPanel for the Graph  (this is an inner class)
// *************************************************************************************
// *************************************************************************************
// *************************************************************************************
    public class DrawPanel extends JPanel
    {

        public DrawPanel()
        {
            // FINISH ME
            // call the super constructor
            super();
        }


        // DO NOT CALL THIS METHOD, it will get
        // called by the repaint() method
        // this overrides the update method in the super class
        public void update(Graphics window)
        {
            paintComponent(window);
        }


        // DO NOT CALL THIS METHOD, it will get
        // called by the update() method above
        // this overrides the method in the super class
        public void paintComponent(Graphics g)
        {
            super.paintComponent((Graphics2D)g);
            Graphics2D g2 = (Graphics2D) g;

            //take a snap shop of the current screen and same it as an image
            //that is the exact same width and height as the current screen

            back = (BufferedImage)(createImage(getWidth(),getHeight()));

            //create a graphics reference to the back ground image
            //we will draw all changes on the background image
            Graphics gMemory = back.createGraphics();


            // FINISH ME
            // clear the screen (fill the screen with BLACK)
            // So, set the draw color to Color.BLACK
            // gMemory.???(???)
            // Then, call the fillRect method
            gMemory.setColor(Color.BLACK);
            gMemory.fillRect(0,0,getWidth(),getHeight());


            // now set the draw color to Color.WHITE
            gMemory.setColor(Color.WHITE);



            drawXAxis(gMemory,"X",markHeight, pixelsPerUnit);
            drawYAxis(gMemory,"Y",markHeight, pixelsPerUnit);
            drawGraph(gMemory, equation);


            // DON'T CHANGE THIS LINE
            // this will copy the buffered image to the monitor
            g2.drawImage(back, null, 0, 0);
        }

        // draw the x axis
        public void drawXAxis(Graphics gMemory, String label, int markHeight, int pixelsPerUnit)
        {
            // middleX and middleY is the origin of the graph
            int middleX = getWidth()/2;
            int middleY = getHeight()/2;


            int lastX = getWidth();


            // FINISH ME
            // draw the x axis
            gMemory.drawRect(0,middleY, getWidth(), middleY);



            // show hash marks
            // center point of (0,0) is (middleX,middleY)
            // draw hash marks to the right of (middleX,middleY)
		    /* gMemory.drawRect(middleX, middleY, middleX + pixelsPerUnit, middleY + markHeight);
            gMemory.drawRect(middleX, middleY, middleX - pixelsPerUnit, middleY + markHeight); */

		    for(int i = middleX; i < getWidth(); i += pixelsPerUnit)
            {
                gMemory.drawRect(i, middleY - markHeight/2, 1, markHeight);
            }

            for(int i = middleX; i > 0; i -= pixelsPerUnit)
            {
                gMemory.drawRect(i, middleY - markHeight/2, 1, markHeight);
            }


            // now label it
            gMemory.drawString(label,5,middleY-markHeight-5);

        }


        public void drawYAxis(Graphics gMemory, String label,
                              int markWidth, int pixelsPerUnit)
        {
            // FINISH ME
            // get the origin
            int middleX = getWidth()/2;
            int middleY = getHeight()/2;


            int lastY = getHeight();


            // FINISH ME
            // draw the y axis
            gMemory.drawRect(middleX, 0, 1, getHeight());


            // show hash marks
            // center point of (0,0) is (middleX,middleY)
            for(int i = middleY; i < getHeight(); i += pixelsPerUnit)
            {
                gMemory.drawRect(middleX - markWidth/2, i, markWidth, 1);
            }
            for(int i = middleY; i > 0; i -= pixelsPerUnit)
            {
                gMemory.drawRect(middleX - markWidth/2, i, markWidth, 1);
            }

            // FINISH ME
            // draw the Y axis marks
            // draw axis marks for positive y values up
            // remember y should decrease each time
            // 1 unit is pixelsPerUnit, so start at
            // middleY - pixelsPerUnit
		    //???;


            // draw down
		//???;


            // now label it
            gMemory.drawString(label,middleX+markWidth+5,20);

        }



        public void drawGraph(Graphics gMemory, String equation)
        {
            int firstX = -300;
            int lastX = 300;
            float y = 2*firstX + 5;
            Point point1 = translate(firstX,y,pixelsPerUnit);

            for (float x=firstX; x<lastX; x += graphByUnit)
            {
                ExpressionParser parser = new ExpressionParser();
                Results results = parser.parseInfixExpression(equation);
                parser.replaceVariableWithValueInNumList('x',x);
                results = parser.evaluatePostFixExpression(results.getNS());
                System.out.println("output = " + x + ", "+ results.getN());

                y = (float) results.getN();

                // now translate it to the screen coordinates
                Point point2 = translate(x,y,pixelsPerUnit);


                // now draw from point to point
                gMemory.drawLine(point1.getXRounded(),point1.getYRounded(),
                        point2.getXRounded(),point2.getYRounded());

                point1 = point2;
            }


            // FINISH ME
            // set the text on the northPanelLabel to say:
            // "f(x) = " + equation
		    northPanelLabel.setText("f(x) = " + equation);
        }


        public Point translate(float x, float y, int pixelsPerUnit)
        {
            int middleY = getHeight()/2;
            int middleX = getWidth()/2;

            float screenX = 0;
            float screenY = 0;

            if (x>=0)
            {
                screenX = middleX + x * pixelsPerUnit;
            }
            else
            {
                screenX = middleX + x * pixelsPerUnit;
            }

            if (y>=0)
            {
                screenY = middleY - y * pixelsPerUnit;
            }
            else
            {
                screenY = middleY - y * pixelsPerUnit;
            }


            // FINISH ME
            // create a Point object with screenX and screenY
            // and return it
		    return new Point(screenX, screenY);
        }


    }  // end of class DrawPanel



    // FINISH ME
// write the point class
    public class Point
    {
        float x,y;

        // FINISH ME
        public Point(float x, float y)
        {
            this.x = x;
            this.y = y;
        }

        // FINISH ME
        public float getX()
        {
            return x;
        }

        // FINISH ME
        public float getY()
        {
            return y;
        }

        public int getXRounded()
        {
            // FINISH ME
            // return the rounded value of x
            return (int)x;
        }

        public int getYRounded()
        {
            // FINISH ME
            // return the rounded value of y
            return (int)y;
        }
    } // end of class Point


} // end of class GraphIt
