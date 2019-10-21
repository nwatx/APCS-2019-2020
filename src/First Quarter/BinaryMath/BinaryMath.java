package BinaryMath;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;  // for the ArrayList and Stack


// *********************************************************
// FIND THE FINISH ME statements and finish them
// *********************************************************

// FINISH ME
// My name is ???? ??????

public class BinaryMath extends JFrame implements ActionListener {

  // FINISH ME
  // add your name
  private final String myName = "Neo Wang";

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
  JPanel     southPanel;
  JPanel     westPanel;
  JPanel     eastPanel;
  JPanel     centerPanel;

  ArrayList<JButton> buttons1; // references 0 or 1
  ArrayList<JButton> buttons2; // shows the place value (not clickable)

  int    theBits = 8;  // we will only show 8 bits

  JLabel spacer1;
  JLabel spacer2;
  JLabel spacer3;
  JLabel spacer4;
  JLabel spacer5;

  JLabel baseTenValueLabel;
  JLabel baseEightValueLabel;
  JLabel baseSixteenValueLabel;

  // ***** public void initialize *****


  public void initialize( ) {



	// FINISH ME
    // create a JPanel for components
    mainPanel = new JPanel();

    // ***** assignments for menu variables *****

    menuBar = new JMenuBar();


	// FINISH ME
    // create a JMenu for the File menu
    fileMenu           = new JMenu("File");


	// FINISH ME
    // create a JMenuItem for the Exit menu item
    exitMenuItem       = new JMenuItem("Exit");


    // add mnemonics to the menu system
    fileMenu.setMnemonic('F');
    exitMenuItem.setMnemonic('x');


    // FINISH ME
    // add the menuItem addActionListener(this) calls
    // fileMenu
    exitMenuItem.addActionListener(this);


    // FINISH ME
	// add the exitMenuItem to the fileMenu
    fileMenu.addActionListener(this);
    fileMenu.add(exitMenuItem);

    // add menus to the menuBar
    menuBar.add(fileMenu);


    // attach the JMenuBar to the Window
    setJMenuBar(menuBar);


	// FINISH ME
    // ***** create JPanels for a BorderLayout *****
    northPanel          = new JPanel();
    southPanel          = new JPanel();
    westPanel           = new JPanel();
    eastPanel           = new JPanel();
    centerPanel         = new JPanel();


	Font fontForValueLabels = new Font("Courier New",Font.BOLD,18);

	baseTenValueLabel = new JLabel("Base 10 Value = 0");
	baseTenValueLabel.setFont(fontForValueLabels);
	// this has no affect
	baseTenValueLabel.setBackground(Color.CYAN);

	// this works for the text color
	baseTenValueLabel.setForeground(Color.RED);


	spacer1 = new JLabel("   |   ");

	baseEightValueLabel = new JLabel("Base 8 Value = 0");
	baseEightValueLabel.setFont(fontForValueLabels);

	spacer2 = new JLabel("   |   ");

	baseSixteenValueLabel = new JLabel("Base 16 Value = 0");
	baseSixteenValueLabel.setFont(fontForValueLabels);


	southPanel.add(baseEightValueLabel);
	southPanel.add(spacer1);
	southPanel.add(baseTenValueLabel);
	southPanel.add(spacer2);
	southPanel.add(baseSixteenValueLabel);


	centerPanel.setLayout(new GridLayout(2,8));

	spacer1 = new JLabel("          ");
	spacer2 = new JLabel("          ");
	spacer3 = new JLabel("          ");
	spacer4 = new JLabel("          ");
	spacer5 = new JLabel("          ");

	Font titleFont = new Font("Courier New",Font.BOLD,24);
	String titleString = "Base Two Converter";
	JLabel titleLabel = new JLabel(titleString);
	titleLabel.setFont(titleFont);
	northPanel.add(titleLabel);

	Font font = new Font("Courier New",Font.BOLD,18);


	buttons1 = new ArrayList<JButton>();

	Stack <JButton> stack = new Stack<JButton>();

	for (int i=1; i<=theBits; i++)
	{
		// FINISH ME
		// create a JButton with the text "0" on it
		JButton button = new JButton("0");


		// FINISH ME
		// set the font of the JButton
		// call the button's setFont method and pass it font
		button.setFont(font);


		// FINISH ME
		// call the addActionListener method of the button
		//    and pass it this (meaning this class will have
		//    the actionPerformed method that will handle the
		//    event)
		button.addActionListener(this);


		stack.add(button);  // dont' worry about this for now



		// FINISH ME
		// add the button to the centerPanel
		// call the centerPanel's add method and
		// pass it the button
		centerPanel.add(button);
	}


	for (int i=1; i<=theBits; i++)
	{
		buttons1.add(stack.pop());
	}

    buttons2 = new ArrayList<JButton>();
	String theText = "";
	int value = 128;
	for (int i=1; i<=theBits; i++)
	{
		theText = value + "'s";

		// FINISH ME
		// create a JButton object and pass it theText
		JButton button = new JButton(theText);


		// FINISH ME
		// call the button's setFont method and pass it font
		button.setFont(font);


		buttons2.add(button);
		centerPanel.add(button);



		// FINISH ME
		// update the value variable by dividing it by 2
		// the value variable represents the value for that bit position
		value /= 2;
	}



    mainPanel.setLayout(new BorderLayout());

    northPanel.setBackground(new Color(115,205,255));
    southPanel.setBackground(new Color(115,205,255));
    westPanel.setBackground(new Color(115,205,255));
    eastPanel.setBackground(new Color(115,205,255));


    // ***** add the panels to the mainPanel 5 areas *****
    mainPanel.add(northPanel,BorderLayout.NORTH);
    mainPanel.add(southPanel,BorderLayout.SOUTH);
    mainPanel.add(eastPanel,BorderLayout.EAST);
    mainPanel.add(westPanel,BorderLayout.WEST);
    mainPanel.add(centerPanel,BorderLayout.CENTER);

    // make the mainPanel be the main content area and show it
    setContentPane(mainPanel);
    setVisible(true);  // always show the screen last
  }   // end of public void initialize






  // ***** default constructor *****

  public BinaryMath( ) {
    // initialize variables

    setSize(820,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    // FINISH ME
    // put your name on the title
    setTitle("Base Two Conversion   My name is Neo Wang");


    initialize( );

  }




 // ***** ActionListener interface methods *****

  // start of actionPerformed (ActionListener interface)
  public void actionPerformed(ActionEvent e)
  {

    Object source = e.getSource();

    if (source == exitMenuItem)
    {
      System.exit(0);
    }  // end of if

	else
	{
		// find the button that got clicked
		// and get the value, then add the value to the base 10 result

		int baseTenValue = 0;

		int valueOfBit = 1;

		for (int i=0; i<theBits; i++)
		{

			String theBit;

			if (buttons1.get(i) == source)
			{
				// FINISH ME
				// get the text on the ith button
				// (buttons1.get(i) will get you the reference
				//    to the ith button
				// and later we will flip from 0 to 1 or 1 to 0
				theBit = buttons1.get(i).getText();

				if (theBit.equals("1"))
				{
					// FINISH ME
					// set the text on the ith button to "0"
					// you will need to get a reference or
					// pointer to the button first and then
					// call the setText method
					buttons1.get(i).setText("0");
				}
				else
				{
					// FINISH ME
					// set the text on the ith button to "1"
					// pointer to the button first and then
					// call the setText method
					buttons1.get(i).setText("1");
				}
			}


			// FINISH ME
			// get the text on the ith button
			theBit = buttons1.get(i).getText();

			// FINISH ME
			// check to see if theBit equals "1"
			// and if so, we will add on the value of the bit
			// (valueOfBit) to our variable baseTenValue
			if (theBit.equals("1"))
				baseTenValue += Integer.parseInt(theBit);


			// FINISH ME
			// update valueOfBit
			// multiply valueOfBit by 2 and store it in valueOfBit
			valueOfBit *= 2;
		}



		// FINISH ME
		// put the value of the base ten number on the baseTenValueLabel
		//baseTenValueLabel.setText("Base 10 Value = " + baseTenValueLabel);
		// FINISH ME
		// find the base eight number (Integer class method)Refer to Charleston Lab
		// the variable baseTenValue holds the base 10 number
		String baseEightValue = "";

		// FINISH ME
		// find the base sixteen number (Integer class method)
		// the variable baseTenValue holds the base 10 number
		String baseSixteenValue = "";

    String lol = "";

    for(JButton a : buttons1)
    {
      lol = a.getText() + lol;
    }

    System.out.println(lol);

		// FINISH ME
		// now we will update the screen
		baseEightValueLabel.setText("Base 8 Value = " +   Integer.toString(Integer.parseInt(lol, 2), 8));
    baseTenValueLabel.setText("Base 10 Value = " +    Integer.toString(Integer.parseInt(lol, 2), 10));
		baseSixteenValueLabel.setText("Base 16 Value = " + Integer.toString(Integer.parseInt(lol, 2), 16));

	}
  }  // end of method actionPerformed



  // ***** main method *****
  public static void main(String[] arguments) {
    BinaryMath binaryMath = new BinaryMath( );
  } // end of method main





} // end of class BinaryMath4
