// Find the FINISH ME comments
// You also need to follow what is happening in the code.
// You will be asked to build your own programs
// 	 later on (with some help ofcourse)

// **********************
// **********************
// **********************
// FINISH ME
// My name is  first last
// **********************
// **********************
// **********************

// In this program, the user will be able to enter
// a Charleston number.  The program will output that
// number in bases 10, 2 (Binary), 8 (Octal), and 16 (Hex).
// The letters from the word Charleston are unique.
// The C will represent the number 0
// The H will represent the number 1
// The A will represent the number 2
// etc.
//
//    For example, the user might enter:
//       AC
//    The program should convert this to:
//       20
//       10100
//       24
//       14
//
//    For example, the user might enter:
//       HA
//    The program should convert this to:
//       12
//       1100
//       14
//       C



// Quick Review
// String methods
// 	charAt(index)
//	length()
// Example 1:
//  String s = "Catalog";
//  System.out.println(s.charAt(2));  // prints t

// Example 2:
//  String s = "Cat";
//  System.out.println(s.length());  // prints 3

// Example 3:
//  String s = "Cat";
//  System.out.println(s.substring(1,2);  // prints a

// Example 4:
//  String s = "Cat";
//  System.out.println(s.indexOf("a");  // prints 1


// For Loops
//  for (init section;  boolean expression;   finalization section)
//  {
//
//  }
//
//  Example:
// 	for (int i=0; i<str.length(); i++)
//  {
//
//  }


// Key Concepts
//	Inheritance (with extends)
//  Interfaces  (with implements)


// Key GUI (components, widgits) classes
//	JPanel
//	JMenuBar, JMenu, JMenuItem
//  JButton, JLabel, JTextField
//  JFont


// Key VARIABLES  (KNOW YOUR VARIABLES)
//
//  JTextField codeTextField;  // input field for the Charleston number
//	JLabel     base10Result;   // output label for base 10 result
//	JLabel     binaryResult;   // output label for binary result
//	JLabel     octalResult;    // output label for octal result
//	JLabel     hexResult;      // output label for hex result


// Key Methods for a JLabel and JTextField
//	getText()  - returns the text stored on the component
//  setText(String parameter) - sets the text on the component
// Examples:
//  String charleston = codeTextField.getText();
//  base10Result.setText(""+result);

// Key Static Methods (class methods) for the Integer class
//  REMINDER:  You can call these methods by using the name of the class,
//             since the methods are marked as Static.
//             Methods that are marked as Static do NOT belong to the objects.
//             They are loaded into RAM memory once when the program is loaded into
//             the RAM memory (i.e. at the very beginning of the run).
//      Example:   Integer.toBinaryString(12)
//                 returns the String "1100"
//  toBinaryString(an int parameter)   returns the number in binary (2) as a String
//  toOctalString(an int parameter)    returns the number in octal  (8) as a String
//  toHexString(an int parameter)      returns the number in hex   (16) as a String


// Key HELP ideas:
//   Draw a picture of your output screen and label all of the
//   	key components with your variable names.
//   Next, think about the key methods that each component contains,
//      and how you would call those methods.
//   In order to convert the charleston number into base 10,
//      think about how you would do it yourself!
//      If you don't know how to do something yourself, it is very
//      hard to tell the computer what to do!
//      Rememeber, computers do what we tell them to do!!!
//   PLAN, PLAN, PLAN!!!!!!!!!!!!!!!!



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Charleston extends JFrame implements  ActionListener
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
  JPanel     southPanel;
  JPanel     westPanel;
  JPanel     eastPanel;
  JPanel     centerPanel;

  JButton    convertButton;
  JButton    clearButton;

  // define all of the fields and place holders for the main screen
  // 9 x 4

  // row 0
  JLabel     filler00;
  JLabel     filler01;
  JLabel     filler02;
  JLabel     filler03;


  // row 1
  JLabel     filler10;
  JLabel     filler11;
  JLabel     filler12;
  JLabel     filler13;


  // row 2
  JLabel     filler20;
  JLabel     codeTextLabel;

  // this variable represents the input field where we will type in the
  //    charleston number
  JTextField codeTextField;
  JLabel     filler23;


  // row 3
  JLabel     filler30;
  JLabel     base10Label;

  // This variable represents the output label where we will put
  //    the base 10 value of the charleston number.
  JLabel     base10Result;
  JLabel     filler33;


  // row 4
  JLabel     filler40;
  JLabel     binaryLabel;

  // This variable represents the output label where we will put
  //    the binary value of the charleston number.
  JLabel     binaryResult;
  JLabel     filler43;

  // row 5
  JLabel     filler50;
  JLabel     octalLabel;

  // This variable represents the output label where we will put
  //    the octal value of the charleston number.
  JLabel     octalResult;
  JLabel     filler53;

  // row 6
  JLabel     filler60;
  JLabel     hexLabel;

  // This variable represents the output label where we will put
  //    the hex value of the charleston number.
  JLabel     hexResult;
  JLabel     filler63;

  // row 7
  JLabel     filler70;
  JLabel     filler71;
  JLabel     filler72;
  JLabel     filler73;

  // row 8
  JLabel     filler80;
  JLabel     filler81;
  JLabel     filler82;
  JLabel     filler83;



  Font       font;


  // ***** public void initialize *****

  public void initialize( )
  {
  	font = new Font("Courier New",Font.PLAIN, 24);


  	// row 0
	filler00 = new JLabel("  ");
	filler00.setFont(font);
	filler01 = new JLabel("  ");
	filler01.setFont(font);
	filler02 = new JLabel("  ");
	filler02.setFont(font);
	filler03 = new JLabel("  ");
	filler03.setFont(font);


  	// row 1
	filler10 = new JLabel("  ");
	filler10.setFont(font);
	filler11 = new JLabel("  ");
	filler11.setFont(font);
	filler12 = new JLabel("  ");
	filler12.setFont(font);
	filler13 = new JLabel("  ");
	filler13.setFont(font);


    // row 2
    filler20 = new JLabel("  ");;
	filler20.setFont(font);
    codeTextLabel = new JLabel("Charleston Code");
    codeTextLabel.setFont(font);

    // input field for the Charleston code number
    codeTextField = new JTextField("",30);
    codeTextField.setFont(font);
    filler23 = new JLabel("  ");;
	filler23.setFont(font);


    // row 3 - base 10 result
    filler30 = new JLabel("  ");;
	filler30.setFont(font);
    base10Label = new JLabel("Base 10");
    base10Label.setFont(font);

	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME
    // base10Result label to show the base ten number
    // Create a new JLabel object and pass it ""
    base10Result = new JLabel("");
    base10Result.setFont(font);
    filler33 = new JLabel("  ");;
	filler33.setFont(font);


    // row 4 - binary result
    filler40 = new JLabel("  ");;
	filler40.setFont(font);
    binaryLabel = new JLabel("Binary");
    binaryLabel.setFont(font);

	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME
    // binaryResult label to show the base 2 number
    // Create a new JLabel object and pass it ""
    binaryResult = new JLabel("");
    binaryResult.setFont(font);
    filler43 = new JLabel("  ");;
	filler43.setFont(font);


    // row 5 - octal result
    filler50 = new JLabel("  ");;
	filler50.setFont(font);
    octalLabel = new JLabel("Octal");
    octalLabel.setFont(font);

	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME
    // octalResult label to show the base 8 number
    // Create a new JLabel object and pass it ""
    octalResult = new JLabel("");
    octalResult.setFont(font);
    filler53 = new JLabel("  ");;
	filler53.setFont(font);


    // row 6 - hex result
    filler60 = new JLabel("  ");
	filler60.setFont(font);
    hexLabel = new JLabel("Hex");
    hexLabel.setFont(font);

	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME
    // hexResult label to show the base 16 number
    // Create a new JLabel object and pass it ""
    hexResult = new JLabel("");
    hexResult.setFont(font);
    filler63 = new JLabel("  ");;
	filler63.setFont(font);


  	// row 7
	filler70 = new JLabel("  ");
	filler70.setFont(font);
	filler71 = new JLabel("  ");
	filler71.setFont(font);
	filler72 = new JLabel("  ");
	filler72.setFont(font);
	filler73 = new JLabel("  ");
	filler73.setFont(font);


  	// row 8
	filler80 = new JLabel("  ");
	filler80.setFont(font);
	filler81 = new JLabel("  ");
	filler81.setFont(font);
	filler82 = new JLabel("  ");
	filler82.setFont(font);
	filler83 = new JLabel("  ");
	filler83.setFont(font);


    // create a mainPanel for components
    mainPanel = new JPanel();

    // ***** assignments for menu variables *****

    menuBar            = new JMenuBar();

    fileMenu           = new JMenu("File");
    exitMenuItem       = new JMenuItem("Exit");


    // add mnemonics to the menu system
    fileMenu.setMnemonic('F');
    exitMenuItem.setMnemonic('x');

    // add the menuItem addActionListener(this) calls
    // fileMenu
    exitMenuItem.addActionListener(this);


    // add menuItems to the fileMenu
    fileMenu.add(exitMenuItem);

    // add menus to the menuBar
    menuBar.add(fileMenu);

    // attach the JMenuBar to the Window
    setJMenuBar(menuBar);


    // ***** create JPanels for a BorderLayout *****
    northPanel   = new JPanel();
    southPanel   = new JPanel();
    westPanel    = new JPanel();
    eastPanel    = new JPanel();
    centerPanel  = new JPanel();

	centerPanel.setLayout(new GridLayout(9,4));

    mainPanel.setLayout(new BorderLayout());

    northPanel.setBackground(new Color(115,205,255));
    southPanel.setBackground(new Color(115,205,255));
    westPanel.setBackground(new Color(115,205,255));
    eastPanel.setBackground(new Color(115,205,255));


    // ***** You need to add buttons, etc. to the 5 panels *****

	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME  create a new JButton object that displays Convert
    convertButton = new JButton("Convert");


	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME  call the addActionListener method and pass it this
    convertButton.addActionListener(this);


	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME  add the convertButton to the southPanel (call the add method)
	southPanel.add(convertButton);


	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME  create a new JButton object that displays Clear
    clearButton = new JButton("Clear");


	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME  call the addActionListener method and pass it this
    clearButton.addActionListener(this);


	// **********************************************
	// **********************************************
	// **********************************************
    // FINISH ME  add the clearButton to the southPanel (call the add method)
	southPanel.add(clearButton);



	// add all of the components to the centerPanel

	// fill row 0
	centerPanel.add(filler00);
	centerPanel.add(filler01);
	centerPanel.add(filler02);
	centerPanel.add(filler03);

	// fill row 1
	centerPanel.add(filler10);
	centerPanel.add(filler11);
	centerPanel.add(filler12);
	centerPanel.add(filler13);

	// fill row 2
	centerPanel.add(filler20);
	centerPanel.add(codeTextLabel);
	centerPanel.add(codeTextField);
	centerPanel.add(filler23);

	// fill row 3
	centerPanel.add(filler30);
	centerPanel.add(base10Label);
	centerPanel.add(base10Result);
	centerPanel.add(filler33);

	// fill row 4
	centerPanel.add(filler40);
	centerPanel.add(binaryLabel);
	centerPanel.add(binaryResult);
	centerPanel.add(filler43);

	// fill row 5
	centerPanel.add(filler50);
	centerPanel.add(octalLabel);
	centerPanel.add(octalResult);
	centerPanel.add(filler53);

	// fill row 6
	centerPanel.add(filler60);
	centerPanel.add(hexLabel);
	centerPanel.add(hexResult);
	centerPanel.add(filler63);

	// fill row 7
	centerPanel.add(filler70);
	centerPanel.add(filler71);
	centerPanel.add(filler72);
	centerPanel.add(filler73);

	// fill row 8
	centerPanel.add(filler80);
	centerPanel.add(filler81);
	centerPanel.add(filler82);
	centerPanel.add(filler83);



    // ***** add the panels to the mainPanel 5 areas *****
    mainPanel.add(northPanel,BorderLayout.NORTH);
    mainPanel.add(southPanel,BorderLayout.SOUTH);
    mainPanel.add(eastPanel,BorderLayout.EAST);
    mainPanel.add(westPanel,BorderLayout.WEST);
    mainPanel.add(centerPanel,BorderLayout.CENTER);

    // make the mainPanel be the main content area and show it
    setContentPane(mainPanel);
    setVisible(true);  // always show the screen last

    // *****************************************************************
    // *****************************************************************
    // *****************************************************************
    // FINISH ME
    // put your name instead of UH ???? I FORGOT ???
    System.out.println("My name is NEO ACTUALLY");

  }   // end of public void initialize

  public int getCharleston(char a)
  {
    return new String("CHARLESTON").indexOf(a);
  }




  // ***** default constructor *****

  public Charleston( )
  {
    // initialize variables

    setSize(900,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // *****************************************************************
    // *****************************************************************
    // *****************************************************************
    // FINISH ME
    // call the JFrame's setTitle method (we inherited all of the methods and variables)
    // and pass to it a String     INCLUDE YOUR NAME!!!
    // set the title to an appropriate title
	  this.setTitle("Charleston Code - Neo Wang");


    initialize( );

  }

  // ***** ActionListener interface methods *****

  // start of actionPerformed (ActionListener interface)

  // this method gets called by the JVM when a JButton
  // or a MenuItem object is clicked
  // (provided we called the addActionListener method
  public void actionPerformed(ActionEvent e)
  {
  	// this gets the memory address of the object that got clicked
    Object source = e.getSource();


    if (source == exitMenuItem)
    {
      System.exit(0);
    }  // end of if
    else if (source == convertButton)
    {
    	// do the conversions and place the results into the appropriate label


    	// ***************************************************************************
    	// ***************************************************************************
    	// ***************************************************************************
    	// FINISH ME
    	// get the text from the codeTextField input field
    	String charleston = codeTextField.getText();
    	if (charleston.equals(""))
    		return;



    	int result = 0; // this will hold the answer in base 10
    	int value = 0;
    	boolean valid = true;


    	// ***************************************************************************
    	// ***************************************************************************
    	// ***************************************************************************
		// FINISH ME
		// Loop through all of the characters of the charleston String
    	for (int i=0; i<charleston.length(); i++)
    	{
    		// ************************************************************************
    		// ************************************************************************
    		// ************************************************************************
    		// FINISH ME
    		// get the character at the i position from the charleston String
    		char ch = charleston.charAt(i);


    		// ************************************************************************
    		// ************************************************************************
    		// ************************************************************************
    		// FINISH ME
    		// change it to upper case
    		// find a static method in the Character class to help you
    		// or write your own method for the fun of it
    		// Remember that static methods (class methods) are loaded into RAM
    		//    memory at the start of the run and are always available.
    		//    You can call them by using the name of the class.
    		ch = Character.toUpperCase(ch);

    		switch(ch)
    		{
    			case 'C' : value = 0; break;
    			case 'H' : value = 1; break;
    			case 'A' : value = 2; break;
    			case 'R' : value = 3; break;
          case 'L' : value = 4; break;
          case 'E' : value = 5; break;
    			case 'S' : value = 6; break;
    			case 'T' : value = 7; break;
    			case 'O' : value = 8; break;
          case 'N' : value = 9; break;
				// handle each charleston character in order
	    		// ********************************************************************
    			// ********************************************************************
    			// ********************************************************************
	    		// FINISH ME
    			// get the value of each character


				// if we find an illegal character we then show a pop up message and quit the method
				default : {
							JOptionPane.showMessageDialog(this,"Unknown character");
							valid = false;
							value = 0;
				}

    		}

    		result = result*10 + value;

    		// for debugging purposes
    		System.out.println("result="+result);
    	}




    	// result is the base 10 value (holds the number in base 10)


    	if (valid)
    	{

    		// ************************************************************************
    		// ************************************************************************
    		// ************************************************************************
    		// FINISH ME
    		// call the appropriate static method in the Integer class to convert the
    		//    result into octal and hex
    		// Remember that Static methods (class methods) are always in RAM memory,
    		//    and thus are always available.
    		String binary = Integer.toBinaryString(result) + "";
    		String octal = Integer.toString(result,8);
    		String hex = Integer.toString(result,16);


    		// ************************************************************************
    		// ************************************************************************
    		// ************************************************************************
    		// FINISH ME
    		// set the text in the result labels to hold the results
    		// remember that we have already stored our answers into the variables
    		// result  (an int variable)
    		// binary, octal and hex  (String variables)
	    	base10Result.setText(""+result);
        binaryResult.setText(""+binary);
        octalResult.setText(""+octal);
        hexResult.setText(""+hex);




    	}
    	else
    	{
    		// ************************************************************************
    		// ************************************************************************
    		// ************************************************************************
    		// FINISH ME
    		// set the text in the result labels to the empty String   ""
    		// DO NOT SET IT TO " "    USE  ""
    		// IT MUST BE EMPTY!!!!

        base10Result.setText("");
        binaryResult.setText("");
        octalResult.setText("");
        hexResult.setText("");


    	}


    }
    else if (source == clearButton)
    {
    	// ***************************************************************************
    	// ***************************************************************************
    	// ***************************************************************************
    	// FINISH ME
    	// clear the input textfield and result labels
    	// (call the setText("") method of each textfield or label)
    	codeTextField.setText("");
      base10Result.setText("");
      binaryResult.setText("");
      octalResult.setText("");
      hexResult.setText("");

		// do the rest of the result labels here




    }

  }  // end of actionPerformed


  // ***** main method *****
  public static void main(String[] arguments)
  {
    Charleston charleston = new Charleston( );
  }


} // end of class Charleston
