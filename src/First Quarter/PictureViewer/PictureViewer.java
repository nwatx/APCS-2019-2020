package PictureViewer;
// PictureViewer

// You will need to find all of the
// FINISH ME  comments and finish the code
// You will also need at least 4 pictures
// make sure that the pics are either
// jpg, gif, or png file formats
// gif files can not be animated
// files should not be too large
// Also, make sure your filenames are spelled exactly as they
//    they are here. (CASE MATTERS)
// Your code should work for any number of pictures, so don't say
// something like:   pictureIndex = 3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class
PictureViewer extends JFrame implements  ActionListener
{

  // ***** declaration of JFrame variables *****


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

  // define a JLabel to add to the northPanel
  JLabel     northPanelLabel;


  JPanel     southPanel;
  JPanel     westPanel;
  JPanel     eastPanel;
  DrawPanel  centerPanel;

  // for buffering
  BufferedImage back;



  // JButtons to move to first, next, previous, and last pictures
  // we will add these JButtons to the southPanel
  // we will need to create the objects and call
  // each objects addActionListener(this) method
  JButton    firstButton;
  JButton    nextButton;
  JButton    previousButton;
  JButton    lastButton;


  // define instance variables that you need
  ArrayList<String> pictureFilenames;

  int pictureIndex;

  private Image currentImage;


  // ***** public void initialize *****

  public void initialize( )
  {
  	// FINISH ME
	// create the pictureFilenames object (new it!)
	// notice that it is of what type?
	// (Look above in your instance variables)
	pictureFilenames = new ArrayList<String>();


  	// FINISH ME
	// now add the filenames to the ArrayList
	// by calling the add method of pictureFilenames
	// you should have at least 4 pictures added
	pictureFilenames.add("woody.jpg");
  pictureFilenames.add("yuvraj.jpg");
  pictureFilenames.add("freddy.jpg");
  pictureFilenames.add("robot.png");




  	// FINISH ME
	// we will start by showing the first picture in our list
	// so we will set pictureIndex to zero
	pictureIndex = 0;


    // create a mainPanel for components
    mainPanel = new JPanel();


    // ***** assignments for menu variables *****

	// FINISH ME
	// create a JMenuBar object
    menuBar            = new JMenuBar();


	// FINISH ME
	// create a JMenu object with the text "File"
    fileMenu           = new JMenu("File");


	// FINISH ME
	// create a JMenuItem object with the text "Exit"
    exitMenuItem       = new JMenuItem("Exist");



     // add mnemonics to the menu system
    fileMenu.setMnemonic('F');

    // FINISH ME
    // set the mnemonic 'x' for the exitMenuItem
    exitMenuItem.setMnemonic('x');



    // FINISH ME
    // call the addActionListener(this) method
    // for the exitMenuItem
    // this allows the click event to be sent to this program
    // where we can handle it
    exitMenuItem.addActionListener(this);


    // FINISH ME
    // add the exitMenuItem to the fileMenu
    fileMenu.add(exitMenuItem);


    // add menus to the menuBar
    // FINISH ME
    // add the fileMenu to the menuBar
    menuBar.add(fileMenu);


    // FINISH ME
    // attach the JMenuBar called menuBar to the Window
    // by calling the setJMenuBar method and
    // passing it menuBar
    setJMenuBar(menuBar);


    // ***** create JPanels for a BorderLayout *****
    northPanel   = new JPanel();
    southPanel   = new JPanel();
    westPanel    = new JPanel();
    eastPanel    = new JPanel();

	centerPanel  = new DrawPanel();


    mainPanel.setLayout(new BorderLayout());


	// FINISH ME
	// create each JButton object (new it!)
	// and call the JButton's addActionListener(this) method
	// the first JButton has been done for you
	firstButton = new JButton("First");
	firstButton.addActionListener(this);

	previousButton = new JButton("Previous");
	previousButton.addActionListener(this);

	nextButton = new JButton("Next");
	nextButton.addActionListener(this);

	lastButton = new JButton("Last");
	lastButton.addActionListener(this);



	// FINISH ME
	// now add the JButton objects to the southPanel
	// the Layout Manager is by default a FlowLayout
	// from left to right as added (and centered)
	// the firstButton has been added for you
	southPanel.add(firstButton);
	southPanel.add(previousButton);
	southPanel.add(nextButton);
	southPanel.add(lastButton);


    // FINISH ME
    // add your first and last name
    northPanelLabel = new JLabel("Picture Viewer by Neo Wang");
    Font font = new Font("Courier New",Font.BOLD,24);
    northPanelLabel.setFont(font);


    northPanel.setBackground(new Color(115,205,255));
    southPanel.setBackground(new Color(115,205,255));
    westPanel.setBackground(new Color(115,205,255));
    eastPanel.setBackground(new Color(115,205,255));
    // ***** You need to add buttons, etc. to the 5 panels *****


    // ***** add the panels to the mainPanel 5 areas *****
    mainPanel.add(northPanel,BorderLayout.NORTH);
    mainPanel.add(southPanel,BorderLayout.SOUTH);
    mainPanel.add(eastPanel,BorderLayout.EAST);
    mainPanel.add(westPanel,BorderLayout.WEST);
    mainPanel.add(centerPanel,BorderLayout.CENTER);

    // make the mainPanel be the main content area and show it
    setContentPane(mainPanel);


    // FINISH ME
    // call the showImage() method to show the image
    // this method is in this call (see below)
    showImage();


    // FINISH ME
    // call the setVisible method and pass it true
    // setVisible is inherited from your JFrame class
    // (extends JFrame)
    setVisible(true);  // always show the screen last

  }   // end of public void initialize



  // ***** default constructor *****

  public PictureViewer( )
  {
    // initialize variables

    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    // FINISH ME
    // add your name to the title
    setTitle("Picture Viewer Neo Wang");


    initialize( );

  }

  // ***** ActionListener interface methods *****

  // start of actionPerformed (ActionListener interface)

  // IMPORTANT - READ READ READ
  // this method gets called when you click on a JButton,
  // a JMenu, a JMenuItem (or any object which accepts clicks)
  public void actionPerformed(ActionEvent e)
  {
  	// e is a reference variable that refers to an ActionEvent object
  	// I could have called it event or whatever name that I want
  	// e.getSource() returns the memory address of the object that
  	//     was clicked on


  	// source will hold the memory address of the object
  	// that got clicked on
    Object source = e.getSource(); // returns address of clicked object


    // did they click on the exitMenuItem?
    if (source == exitMenuItem)
    {
      System.exit(0);
    }  // end of if


    // FINISH ME
    // HANDLE THE JButton objects to move
    // to the first picture, next picture, etc.
    // the first button has been handled for you
    // here we check to see if they clicked on the firstButton
    else if (source == firstButton)
    {
    	// source references the JButton that got clicked
    	// set the index of the picture that you want to show
    	pictureIndex = 0;
      showImage();

    	// FINISH ME
    	// call showImage() to show the image



    }  // end of if
    else if (source == nextButton)
    {
      if(pictureIndex + 1 < pictureFilenames.size())
      {
        pictureIndex++;
        showImage();
      }
    }
    else if (source == previousButton) {
      if(pictureIndex - 1 >= 0)
      {
        pictureIndex--;
        showImage();
      }
    }
    else if (source == lastButton)
    {
      pictureIndex = pictureFilenames.size()-1;
      showImage();
    }

    // FINISH ME
    // HANDLE THE other JButtons
    // THERE ARE 3 MORE BUTTONS




  }  // end of actionPerformed





  // *************************************************
  // *************************************************
  // ***** main method *******************************
  // *************************************************
  // *************************************************
  public static void main(String[] arguments)
  {
  	// FINISH ME
  	// create a new PictureViewer object
    PictureViewer pictureViewer = new PictureViewer();
  }


  public void showImage()
  {
  	// FINISH ME
  	// load in the image that you want to display
  	// the getImage method below needs the filename of the image
  	// remember that the ArrayList reference is
  	// called pictureFilenames
  	// and the index is called pictureIndex
	currentImage = Toolkit.getDefaultToolkit().getImage(pictureFilenames.get(pictureIndex));

	// FINISH ME
	// update the centerPanel
	// repaint will call the update method and pass it the Graphics library reference
	// the update() method will then call the paintComponent method
	// call the centerPanel's repaint() method (centerPanel.????)
	centerPanel.repaint();
  }







// *************************************************************************************
// *************************************************************************************
// *************************************************************************************
// *************************************************************************************
// this is the centerPanel for the picture  (this is an inner class)
// THIS CLASS HAS BEEN DONE FOR YOU
// *************************************************************************************
// *************************************************************************************
// *************************************************************************************
class DrawPanel extends JPanel
{

	public DrawPanel()
	{
		super();
	}

	// DO NOT CALL THIS METHOD, it will get
	// called by the repaint() method
    public void update(Graphics window)
    {
	   paintComponent(window);
    }


	// DO NOT CALL THIS METHOD, it will get
	// called by the update() method above
	public void paintComponent(Graphics g)
	{
		super.paintComponent((Graphics2D)g);
		Graphics2D g2 = (Graphics2D) g;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		// if(back==null)
		back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics gMemory = back.createGraphics();

		// clear the screen (not really needed here)
		//gMemory.setColor(Color.BLACK);
		//gMemory.fillRect(0,0,getWidth(),getHeight());

		// we will draw the currentImage and take up
		//    the entire centerPanel
		gMemory.drawImage(currentImage,
			0,
			0,
			getWidth(),
			getHeight(),
			centerPanel);


   		g2.drawImage(back, null, 0, 0);
	}



}  // end of class DrawPanel



} // end of class PictureViewer
