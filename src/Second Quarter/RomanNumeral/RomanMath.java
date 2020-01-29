import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;  //ArrayList, Stack
import java.io.*;


// *********************************************************
// FIND THE FINISH ME statements and finish them
// *********************************************************

// FINISH ME
// Name: first last
//

public class RomanMath extends JFrame implements ActionListener {

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

  ArrayList<JButton> buttons1; // references a button with a -,I,V,X,L,C,D,or M
  ArrayList<JButton> buttons2; // shows the value of the button (not clickable)

  int    numberOfRomanDigits = 8;  // we will only show 8 possible digits


  JLabel spacer1;
  JLabel spacer2;
  JLabel spacer3;
  JLabel spacer4;
  JLabel spacer5;

  JLabel baseTenValueLabel;
  JLabel baseEightValueLabel;
  JLabel baseSixteenValueLabel;


  // holds the keys (-,I,V,X,L,C,D,M) and the values for easy look up
  Map<String, Integer> map; // a map of each roman digit and its value

  Map<String, Integer> validMap; // a map of valid roman numbers from 1-1000


  // an ArrayList of Roman Digits a their value
  // using the class RomanDigitAndValue
  ArrayList<RomanDigitAndValue> listOfRomanDigitsAndValues;

  // ***** public void initialize *****


  public void initialize( ) {


	// FINISH ME
	// create a new ArrayList of RomanDigitAndValue objects
	// the class RomanDigitAndValue is at the bottom of this file
	listOfRomanDigitsAndValues = new ArrayList<RomanDigitAndValue>();



	// FINISH ME
    // add to your ArrayList the Roman digits and their values
    // I, V,  X,  L,   C,   D,    M
    // 1, 5, 10, 50, 100, 500, 1000


	listOfRomanDigitsAndValues.add(new RomanDigitAndValue("-",0));
	listOfRomanDigitsAndValues.add(new RomanDigitAndValue("I",1));
  listOfRomanDigitsAndValues.add(new RomanDigitAndValue("V",5));
	listOfRomanDigitsAndValues.add(new RomanDigitAndValue("X",10));
  listOfRomanDigitsAndValues.add(new RomanDigitAndValue("L",50));
	listOfRomanDigitsAndValues.add(new RomanDigitAndValue("C",100));
  listOfRomanDigitsAndValues.add(new RomanDigitAndValue("D",500));
	listOfRomanDigitsAndValues.add(new RomanDigitAndValue("M",1000));




	// FINISH ME
	// create a new TreeMap object
	// with a String for the key
	// and an Integer object for the value

    map = new TreeMap<String, Integer>();



	// FINISH ME
	// create a new TreeMap object
	// with a String for the key
	// and an Integer object for the value
	validMap = new TreeMap<String,Integer>();

	// fill the valid map (a list of all valid roman numbers 1-1000)
	fillValidMap();


    // FINISH ME
    // add to your map the keys and values
    // I, V,  X,  L,   C,   D,    M
    // 1, 5, 10, 50, 100, 500, 1000
    // http://artlung.com/smorgasborg/roman-numerals/

    map.put("-", new Integer(0));
    map.put("I", new Integer(1));
    map.put("V", new Integer(5));
    map.put("X", new Integer(10));
    map.put("L", new Integer(50));
    map.put("C", new Integer(100));
    map.put("D", new Integer(500));
    map.put("M", new Integer(1000));




    // FINISH ME
    // create a new JPanel for holding components
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
    northPanel          = new JPanel();
    southPanel          = new JPanel();
    westPanel           = new JPanel();
    eastPanel           = new JPanel();
    centerPanel         = new JPanel();


	Font fontForValueLabels = new Font("Courier New",Font.BOLD,18);

	baseTenValueLabel = new JLabel("Base 10 Value = ?");
	baseTenValueLabel.setFont(fontForValueLabels);
	// this has no affect
	baseTenValueLabel.setBackground(Color.CYAN);

	// this works for the text color
	baseTenValueLabel.setForeground(Color.RED);


	spacer1 = new JLabel("   |   ");

	baseEightValueLabel = new JLabel("Base 8 Value = ?");
	baseEightValueLabel.setFont(fontForValueLabels);

	spacer2 = new JLabel("   |   ");

	baseSixteenValueLabel = new JLabel("Base 16 Value = ?");
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


	// FINISH ME
	// put your first and last name on the titleString
	String titleString = "Roman Number Converter by Neo Wang";


	JLabel titleLabel = new JLabel(titleString);
	titleLabel.setFont(titleFont);
	northPanel.add(titleLabel);

	Font font = new Font("Courier New",Font.BOLD,18);


	buttons1 = new ArrayList<JButton>();

	// create a Stack Object that can hold JButton objects
	Stack <JButton> stack = new Stack<JButton>();



	for (int i=1; i<=numberOfRomanDigits; i++)
	{
		// create a JButton with the text "-" on it
		JButton button = new JButton("-");


		// set the font of the JButton
		// call the button's setFont method and pass it font
		button.setFont(font);

		// call the addActionListener method of the button
		//    and pass it this (meaning this class will have
		//    the actionPerformed method that will handle the
		//    event)
		button.addActionListener(this);



		// FINISH ME
		// push this button onto the top of the stack
		stack.push(button);



		// FINISH ME
		// add the button to the centerPanel
		// call the centerPanel's add method and
		// pass it the button
		centerPanel.add(button);
	}


	for (int i=1; i<=numberOfRomanDigits; i++)
	{

		// FINISH ME
		// pop the stack
		buttons1.add(stack.pop());
	}


	// FINISH ME
	// clear the stack
	stack.clear();


    buttons2 = new ArrayList<JButton>();
	String theText = "";


	for (int i=1; i<=numberOfRomanDigits; i++)
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



		// FINISH ME
		// push this button onto the top of the stack
		stack.push(button);



		// FINISH ME
		// add the button to the centerPanel
		// call the centerPanel's add method and
		// pass it the button
		centerPanel.add(button);
	}


	for (int i=1; i<=numberOfRomanDigits; i++)
	{

		// FINISH ME
		// pop the stack
		buttons2.add(stack.pop());
	}




    mainPanel.setLayout(new BorderLayout());

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
    setVisible(true);  // always show the screen last
  }   // end of public void initialize




  // ***** default constructor *****

  public RomanMath( )
  {
    // initialize variables

    setSize(820,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // FINISH ME
    // put your name on the title
    setTitle("Roman Math  by  Neo WAng");


    initialize( );

  } // end of public RomanMath()




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
		// we will find the button that got clicked
		// and then find what is on it
		// and then up it to the next roman digit
		// finally we will update the results
		System.out.println("===========================================");

		int baseTenValue = 0;


		for (int i=0; i<numberOfRomanDigits; i++)
		{

			if (buttons1.get(i) == source)
			{
				// FINISH ME
				// get the text on the ith button
				// (buttons1.get(i) will get you the reference
				//    to the ith button
				//
				// and then we will show the correct value for
				// that roman digit
				String textOnButton = buttons1.get(i).getText();

				System.out.println("text on button=" + textOnButton);
				System.out.println("index of button in buttons1=" + i);


				// FINISH ME
				// get the index of the next roman digit from the list
				int indexOfRomanDigit = 0;

				for (int k=0; k<listOfRomanDigitsAndValues.size(); k++)
				{
					if (listOfRomanDigitsAndValues.get(k).getRomanDigit().equals(textOnButton))
					{
						indexOfRomanDigit = k;
						break;
					}
				}


				System.out.println("index of " + textOnButton+ " in ArrayList=" + indexOfRomanDigit);


				indexOfRomanDigit++;

				// but did we go too far
				if (indexOfRomanDigit >= listOfRomanDigitsAndValues.size())
				{
					indexOfRomanDigit = 0;
				}


				// now get the Roman digit
				String newTextOnButton = "" + listOfRomanDigitsAndValues.get(indexOfRomanDigit).getRomanDigit();

				System.out.println("new Text on Button =" + newTextOnButton);


				// FINISH ME
				// now put the text of newTextOnButton on the button
				buttons1.get(i).setText(newTextOnButton);



				// FINISH ME
				// get its value from the map
				// newTextOnButton should be a -,I,V,etc.
				int valueOfRomanDigit = map.get(newTextOnButton);

				System.out.println("new value of Roman Digit =" + valueOfRomanDigit);



				// FINISH ME
				// now put this value on buttons2.get(i)
				// valueOfRomanDigit should be a 0,1,5,10, etc.
				buttons2.get(i).setText(""+valueOfRomanDigit);
				System.out.println("index of button in buttons2=" + i);
				System.out.println("===========================================");

				// break out of the loop
				break;
			}

		}


		// FINISH ME
		// now we need to get the value of the Roman Number
		// (we are NOT assuming that it is a valid roman number)

		String romanNumber = "";
		// we will start at the end button downto the zero button
		for (int i=numberOfRomanDigits-1; i > 0; i--)
		{
			romanNumber += buttons1.get(i).getText();
		}

		if (isValidRomanNumeral(romanNumber))
		{
			baseTenValue = convertRomanNumeralToBaseTen(romanNumber);
			baseTenValueLabel.setText("Base 10 Value = "+baseTenValue);

			// FINISH ME
			// find the base eight number (Integer class method to?????)
			String baseEightValue = Integer.toString(baseTenValue, 8);


			// FINISH ME
			// find the base sixteen number (Integer class method to?????)
			String baseSixteenValue = Integer.toString(baseTenValue, 16);


			// FINISH ME
			// now we will update the screen
			baseEightValueLabel.setText("Base 8 Value = "+ baseEightValue);
			baseSixteenValueLabel.setText("Base 16 Value = "+ baseSixteenValue);
		}
		else
		{
			// it was NOT a valid Roman Number
			baseTenValueLabel.setText("Base 10 Value = ?");
			baseEightValueLabel.setText("Base 8 Value = ?");
			baseSixteenValueLabel.setText("Base 16 Value = ?");
		}

	}
  }  // end of method actionPerformed



  // ***** main method *****
  public static void main(String[] arguments) {
    RomanMath romanMath = new RomanMath( );
  } // end of method main


  public boolean isValidRomanNumeral(String romanNumber)
  {
  	// we will not test for everything, only a few things
  	// this is NOT efficient

	System.out.println("++++++++++++++++++++++++++++++");
	System.out.println("romanNumber="+romanNumber);
	System.out.println("++++++++++++++++++++++++++++++");

	String roman = romanNumber.replaceAll("-"," ").trim();
	System.out.println("roman number ="+roman);
	if (validMap.get(roman)!=null)
		return true;

	String aString = "";


	// you can't have all dashes
	if (romanNumber.substring(0,romanNumber.length()).equals("--------"))
		return false;

	// once you have a valid number, no more dashes
	// i.e. only dashes on the left
	boolean foundRomanDigit = false;
	for (int i=0; i<romanNumber.length(); i++)
	{
		if (!romanNumber.substring(i,i+1).equals("-"))
			foundRomanDigit = true;
		else if (foundRomanDigit && romanNumber.substring(i,i+1).equals("-"))
			return false;
	}

  	// you can't have 5 in a row of any one roman numeral
  	// but don't count the dashes (they are place holders)


  	// FINISH ME
  	// we will look through listOfRomanDigitsAndValues
  	for (int k=1; k<listOfRomanDigitsAndValues.size(); k++)
  	{
  		String aCharacter = listOfRomanDigitsAndValues.get(k).getRomanDigit();
  		aString = "";
  		for (int i=1; i<= 5; i++)
  			aString += aCharacter;

  		// FINISH ME
  		// we will look through romanNumber (the String holds the roman number)
  		for (int i=0; i<=romanNumber.length()-5; i++)
  		{
  			// FINISH ME
  			// get a substring from i to i+5 and see if it equals aString
  			if (romanNumber.substring(i,i+5).equals(aString))
  				return false;
  		}
  	}

  	String vvString = "VV";
  	String llString = "LL";
  	String ddString = "DD";
  	// V L and D can not be VV or LL or DD
  	// FINISH ME
  	// we will loop through the romanNumber
  	for (int i=0; i<romanNumber.length()-1; i++)
  	{
  		// get a substring from i to i+2
  		if (romanNumber.substring(i,i+2).equals(vvString))
  			return false;
  		if (romanNumber.substring(i,i+2).equals(llString))
  			return false;
   		if (romanNumber.substring(i,i+2).equals(ddString))
  			return false;
 	}



  	for (int startPos=1; startPos<listOfRomanDigitsAndValues.size()-1; startPos++)
  	{
  		String iiString = listOfRomanDigitsAndValues.get(startPos).getRomanDigit() +
  		                  listOfRomanDigitsAndValues.get(startPos).getRomanDigit();

  		// you can't have IIV or IIX or ... (2 smaller before a bigger)
  		// FINISH ME
  		// we will loop through the romanNumber
  		// romanNumber is a String
  		for (int i=0; i<romanNumber.length()-2; i++)
  		{
  			String badList = iiString;

  			for (int p=startPos+1; p<listOfRomanDigitsAndValues.size(); p++)
  			{
  				String nextRomanDigit = listOfRomanDigitsAndValues.get(p).getRomanDigit();
  				if (romanNumber.substring(i,i+3).equals(badList+nextRomanDigit))
  					return false;
  			}
  		}
  	}


  	// you can't have 3 values in a row that are increasing
  	// for example, you can't have  XLC

	String digit1 = "";
	String digit2 = "";
	String digit3 = "";


	// FINISH ME
	// we will loop through the romanNumber
	// romanNumber is a String that holds our Roman Number
  	// romanNumber might be something like "XIV"
  	for (int i=0; i<romanNumber.length()-2; i++)
  	{
  		digit1 = romanNumber.substring(i,i+1);
  		digit2 = romanNumber.substring(i+1,i+2);
  		digit3 = romanNumber.substring(i+2,i+3);

  		if ((map.get(digit1)> 0) && (map.get(digit1) < map.get(digit2) && map.get(digit2) < map.get(digit3)))
  			return false;
  	}


  	return true;


  } // end of public boolean isValidRomanNumeral(String romanNumber)


  public int convertRomanNumeralToBaseTen(String romanNumber)
  {
  	int baseTenValue = 0;

  	// romanNumber is a String, so it has a length() method
  	// romanNumber might be something like "XIV"
 	for (int i=0; i<romanNumber.length(); i++)
	{
		// FINISH ME
		// get the ith roman digit from romaNumber as a String
		// use the substring method
		String romanDigit = romanNumber.substring(i,i+1);


		// FINISH ME
		// get the value for the key romanDigit from the map
		int currentValue = map.get(romanDigit);


		if (i==romanNumber.length()-1) // we are on the last roman digit
		{
			// FINISH ME
			// add on the value of romanDigit to baseTenValue
			// get the value for the key romanDigit from the map
			baseTenValue += map.get(romanDigit);
		}
		else
		{
			// FINISH ME
			// get the i+1 roman digit from romanNumber as a String (use substring)
			String nextRomanDigit = romanNumber.substring(i+1,i+2);


			// FINISH ME
			// get the value for the key nextRomanDigit from the map
			int nextValue = map.get(nextRomanDigit);



			// FINISH ME
			// if the currentValue is greater than or equal to nextValue
			//     add currentValue to baseTenValue
			// else
			//     subtract currentValue from baseTenValue


      if(currentValue >= nextValue)
      {
        baseTenValue += currentValue;
      }
      else{
        baseTenValue -= currentValue;
      }


		}



	}



  	return baseTenValue;

  } // end of method convertRomanNumeralToBaseTen(String romanNumber)


  public boolean fillValidMap()
  {
  	try
  	{
  		// FINISH ME
  		// create a new Scanner object to read in the valid roman numbers from 1 to 1000
  		// you will also need to create a new File object
  		// and pass the filename to the constructor
  		// we will read from the file  "ValidRomans.txt"
  		// the Scanner constructor can take different parameters
  		//    it could be System.in which means read from the keyboard
  		//    it also can be a File object, which means to read from the file
  		Scanner scan = new Scanner(new File("ValidRomans.txt"));

  		// FINISH ME
  		// we will loop as long as the scan object has a next line to read
  		while(scan.hasNext())
  		{
  			// FINISH ME
  			// get the next integer value from scan
  			int value = scan.nextInt();


  			// FINISH ME
  			// get the rest of the line from scan as a String
  			//     (there is NO nextString() method)
  			// and then we will trim it (erases spaces before and after)
  			String romanNumber = scan.nextLine().trim();


  			// FINISH ME
  			// now we will put it in the validMap
  			// the key is romanNumber - the roman number
  			// the value is - value
  			validMap.put(romanNumber, value);

  		}
  	}
  	catch (Exception e)
  	{
  			System.out.println("++++++++++++++++++++++++++++++");
  			System.out.println("Unable to load ValidRomans.txt");
  			System.out.println("++++++++++++++++++++++++++++++");
  			return false;
  	}
  	return true;
  } // end of public boolean fillValidMap()


} // end of class RomanMath



// *********************************************************
// *********************************************************
// *********************************************************
// class RomanDigitAndValue
// *********************************************************
// *********************************************************
// *********************************************************

class RomanDigitAndValue
{
	String romanDigit;
	int value;


	// FINISH ME
	// write an init constructor with parameters
	// (String romanDigit, int value)
	public RomanDigitAndValue(String romanDigit, int value)
	{
		// FINISH ME
		// assign the parameter values to the instance variables

    this.romanDigit = romanDigit;
    this.value = value;
	}


	// FINISH ME
	// write a getter method called getRomanDigit()
	// that returns romanDigit (return a String)

	public String getRomanDigit()
	{
		return romanDigit;
	}


	// FINISH ME
	// write a getter method called getValue()
	// that returns the value (return an int)
	public int getValue()
	{
		return value;
	}



	public boolean equals(Object obj)
	{
		RomanDigitAndValue other = (RomanDigitAndValue) obj;

		if (this.romanDigit.equals(other.romanDigit))
			return true;

		return false;
	}

} // end of class RomanDigitAndValue
