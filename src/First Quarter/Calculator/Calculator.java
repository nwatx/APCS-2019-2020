package Calculator;
// **************************************************
// **************************************************
// **************************************************
// You will need to finish all of the FINISH ME
// commented statements.  You should also start to
// understand how to use the following components or
// GUI objects:
// JPanel, JMenuBar, JMenu, JMenuItem
// JButton, JTextField, JLabel
// This program also reviews inheritance and
// interfaces.
// **************************************************
// **************************************************
// **************************************************


// FINISH ME
// replace  xxxxxx xxxxxxxx  with your first and last name
// My name is  xxxxxx xxxxxxxx



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.script.*;
import java.text.*;

public class Calculator extends JFrame implements ActionListener,FocusListener
{
  public Object solve(String a) throws ScriptException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");
    Object result = engine.eval(a);
    return result;
  }
	// *****************************************************************
	// *****************************************************************
	// *****************************************************************
	// global or instance variables go here  (no commands)
	// These are also sometimes called fields, attributes, or properties
	// *****************************************************************
	// *****************************************************************
	// *****************************************************************


    // the main panel on the screen
    JPanel mainPanel = new JPanel();

    // Menu Bar
	JMenuBar menuBar = new JMenuBar();

    // file menu
    JMenu     fileMenu = new JMenu("File");
    JMenuItem exitMenuItem = new JMenuItem("Exit");


	// calculate menu
	JMenu     calcMenu = new JMenu("Calculate");
	JMenuItem calcMenuItem = new JMenuItem("Calculate");

	//textfields
	JTextField number1Field     = new JTextField("",8);
  JTextField parsingField = new JTextField("", 15);
	JTextField operatorField   = new JTextField("",2);
	JTextField number2Field = new JTextField("",8);
	JTextField finalNumField = new JTextField("",8);


    // buttons
    JButton calcButton = new JButton("Calculate");
    JButton exitButton = new JButton("Exit");
    JButton clearButton = new JButton("Clear");

    JButton exponentButton = new JButton("^");
    JButton multiplyButton = new JButton("*");
    JButton divideButton = new JButton("/");
    JButton plusButton = new JButton("+");
    JButton subtractButton = new JButton("-");
    JButton modButton = new JButton("Mod");

    JButton oneButton = new JButton("1");
    JButton twoButton = new JButton("2");
    JButton threeButton = new JButton("3");
    JButton fourButton = new JButton("4");
    JButton fiveButton = new JButton("5");
    JButton sixButton = new JButton("6");
    JButton sevenButton = new JButton("7");
    JButton eightButton = new JButton("8");
    JButton nineButton = new JButton("9");
    JButton zeroButton = new JButton("0");

    JButton negativeButton = new JButton("-");
    JButton periodButton = new JButton(".");
    JButton divideFractionButton = new JButton("/");

	//labels
	JLabel equalLabel   = new JLabel("=");


	//buttons for filler
	JLabel fillerLabel1 = new JLabel("           ");
	JLabel fillerLabel2 = new JLabel("           ");
	JLabel fillerLabel3 = new JLabel("           ");
	JLabel fillerLabel4 = new JLabel("           ");
	JLabel fillerLabel5 = new JLabel("           ");
	JLabel fillerLabel6 = new JLabel("           ");
	JLabel fillerLabel7 = new JLabel("           ");
	JLabel fillerLabel8 = new JLabel("           ");
	JLabel fillerLabel9 = new JLabel("           ");

    // create a panel for each BorderLayout position
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel centerPanel = new JPanel();


	int whichBox = 1;  // indicates which box the digit goes in
	char whichOperator = '+'; // indicates the current operator



	// constructor to initialize global or instance variables
	public Calculator()
	{
		// ****************************
		// ****************************
		// ****************************
		// FINISH ME
		// Add your first and last name
		// to replace xxxxxx xxxxxx
		// ****************************
		// ****************************
		// ****************************
		super("CALCULATOR - Written by Neo Wang");
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// we will call each button's addActionListener method
		calcMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		calcButton.addActionListener(this);
		exitButton.addActionListener(this);
		clearButton.addActionListener(this);

		zeroButton.addActionListener(this);

		plusButton.addActionListener(this);
		subtractButton.addActionListener(this);

		periodButton.addActionListener(this);
		divideFractionButton.addActionListener(this);
		negativeButton.addActionListener(this);

	    // ********************************************************
	    // ********************************************************
	    // ********************************************************
		// FINISH ME
		// Make sure that all other buttons call their
		//     addActionListener method.
		// Look at your instance variables above to make sure that
		//    you get them all.

    oneButton.addActionListener(this);
    twoButton.addActionListener(this);
    threeButton.addActionListener(this);
    fourButton.addActionListener(this);
    fiveButton.addActionListener(this);
    sixButton.addActionListener(this);
    sevenButton.addActionListener(this);
    eightButton.addActionListener(this);
    nineButton.addActionListener(this);

    multiplyButton.addActionListener(this);
    modButton.addActionListener(this);
    divideButton.addActionListener(this);
    exponentButton.addActionListener(this);
	    // ********************************************************
	    // ********************************************************
	    // ********************************************************





        // this will allow us to see who has the focus
        number1Field.addFocusListener(this);
        parsingField.addFocusListener(this);
        number2Field.addFocusListener(this);


        // we will create layout managers for the panels
        BorderLayout b1 = new BorderLayout();
        mainPanel.setLayout(b1);

        GridLayout eastLayout = new GridLayout(5,1);
        eastPanel.setLayout(eastLayout);

        GridLayout centerLayout = new GridLayout(5,3);
        centerPanel.setLayout(centerLayout);

        GridLayout westLayout = new GridLayout(4,1);
        westPanel.setLayout(westLayout);

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        southPanel.setLayout(fl);
        northPanel.setLayout(fl);



        // we will add components to the center panel (i.e. labels, fields, etc.)
		centerPanel.add(sevenButton);
		centerPanel.add(eightButton);
		centerPanel.add(nineButton);
		centerPanel.add(fourButton);
		centerPanel.add(fiveButton);
		centerPanel.add(sixButton);
		centerPanel.add(oneButton);
		centerPanel.add(twoButton);
		centerPanel.add(threeButton);
		centerPanel.add(zeroButton);
		centerPanel.add(periodButton);
		centerPanel.add(negativeButton);
		centerPanel.add(divideFractionButton);
		centerPanel.add(fillerLabel8);
		centerPanel.add(fillerLabel9);

		eastPanel.add(plusButton);
		eastPanel.add(subtractButton);
		eastPanel.add(multiplyButton);
		eastPanel.add(divideButton);
		eastPanel.add(modButton);

		westPanel.add(clearButton);
		westPanel.add(exponentButton);
		westPanel.add(fillerLabel1);
		westPanel.add(fillerLabel2);

        // add components to the other panels
		northPanel.add(number1Field);
		northPanel.add(operatorField);
		northPanel.add(number2Field);
		northPanel.add(equalLabel);
		northPanel.add(finalNumField);

		southPanel.add(calcButton);
		southPanel.add(exitButton);

    northPanel.add(parsingField);



        // **** add menu items to the menus
		calcMenu.add(calcMenuItem);
		fileMenu.add(exitMenuItem);

        // **** add the menus to the bar
		menuBar.add(fileMenu);
        menuBar.add(calcMenu);
        // **** set the bar to be the menu bar
		setJMenuBar(menuBar);


        // add each panel to the mainPanel
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        mainPanel.add(eastPanel,BorderLayout.EAST);
        mainPanel.add(westPanel,BorderLayout.WEST);
		mainPanel.add(centerPanel,BorderLayout.CENTER);



        // make the mainPanel be the main content area and show it
        setContentPane(mainPanel);
        setVisible(true);

	}

    public static void main(String[] args) throws ScriptException
	{
		Calculator cal = new Calculator();
	}



    // ********************************************************
    // ********************************************************
    // focusGained and focusLost methods
    // These methods get called when a button gains or loses the
    // focus.
    // (provided the addFocusListener method has been called.
    // these methods are in the FocusListener interface
    // ********************************************************
    // ********************************************************
    public void focusGained(FocusEvent fe)
    {
		Object source = fe.getSource();
    	if (source == number1Field)
    	  whichBox = 1;
    	else if (source == number2Field)
    	  whichBox = 2;
    }

    // this method is in the FocusListener interface
    public void focusLost(FocusEvent fe)
    {
    	// nothing we want to do, but it must be here
    }






    // this method adds a string to the right of a number field
    public void addDigit(String key)
    {
		if (whichBox == 1) // if whichBox is number1Field
		{
			String s = number1Field.getText();
			if (key.equals("-"))
				number1Field.setText(key+s); // put negative at front
			else
				number1Field.setText(s+key);
		}
		else if (whichBox == 2) // if whichBox is number2Field
		{
			String s = number2Field.getText();
			if (key.equals("-"))
				number2Field.setText(key+s); // put negative at front
			else
				number2Field.setText(s+key);
		}
    }




    // ********************************************************
    // ********************************************************
    // public void actionPerformed(ActionEvent e)
    // This method gets called when a button is clicked.
    // (provided the addActionListener method has been called.
    // This method receives information about what object
    //     got clicked
    // ********************************************************
    // ********************************************************

    public void actionPerformed(ActionEvent e)
	{
		// e.getSource() returns the address of the GUI
		// object that got clicked
		Object source = e.getSource();

		if ( (source == exitMenuItem) || (source == exitButton) )
		{
			System.exit(0);
		}

		else if (source == zeroButton)
		{
			addDigit("0");
		}

		else if (source == oneButton)
		{
			addDigit("1");
		}

		else if (source == twoButton)
		{
			addDigit("2");
		}

		else if (source == threeButton)
		{
			addDigit("3");
		}
    else if(source == fourButton)
    {
      addDigit("4");
    }
    else if(source == fiveButton)
    {
      addDigit("5");
    }
    else if(source == sixButton)
    {
      addDigit("6");
    }
    else if(source == sevenButton)
    {
      addDigit("7");
    }
    else if(source == eightButton)
    {
      addDigit("8");
    }
    else if(source == nineButton)
    {
      addDigit("9");
    }




		else if (source == divideFractionButton)
		{
			addDigit("/");
		}


		else if (source == negativeButton)
		{
			addDigit("-");
		}


		// ****************************************************
		// ****************************************************
		// ****************************************************
		// FINISH ME - add more button checks for the number
		//    buttons.
		// You will need to add more else if statements for all
		// of the number button clicks.
		// Look at the variables names in the instance variable
		//    section at the top of this file.






		else if (source == plusButton)
		{
			operatorField.setText("+");
			whichOperator = '+';
		}

		else if (source == subtractButton)
		{
			operatorField.setText("-");
			whichOperator = '-';
		}
    else if (source == divideButton) {
      operatorField.setText("/");
      whichOperator = '/';
    }
    else if (source == multiplyButton)
    {
      operatorField.setText("*");
      whichOperator = '*';
    }
    else if(source == modButton)
    {
      operatorField.setText("%");
      whichOperator = '%';
    }
    else if(source == exponentButton)
    {
      operatorField.setText("^");
      whichOperator = '^';
    }
		// ****************************************************
		// ****************************************************
		// ****************************************************
		// FINISH ME - add more button checks for the operators
		// You will need to add more else if statements for all
		// of the operator button clicks.
		// Look at the variables names in the instance variable
		//    section at the top of this file.
		// multiplyButton '*'
		// divideButton   '/'
		// the mod and exponent will get you 5 bonus points
		// modButton      '%'
		// exponentButton '^'






		else if (source == clearButton)
		{
			number1Field.setText("");
			number2Field.setText("");
			operatorField.setText("");
			finalNumField.setText("");
      parsingField.setText("");
			whichBox = 1;
		}

		else if ( (source == calcMenuItem) || (source == calcButton) )
		{
      String fieldText = parsingField.getText();

      if(fieldText.length() > 0)
      {
        try
        {
          finalNumField.setText("" + solve(fieldText));
        }
        catch (Exception event)
        {
          System.out.println("Failed parsing");
        }
      }
      else
      {
        try
  		  {

              String s1 = number1Field.getText().trim();
              String s2 = number2Field.getText().trim();
              String tempOperator = operatorField.getText().trim();

              if ( s1.equals("") || s2.equals("") || tempOperator.equals("") )
              	return;

              whichOperator = tempOperator.charAt(0);


             	// ******************************************
             	// ******************************************
             	// ******************************************
             	// This if statement if true means that both
             	// input fields contain a fraction.
             	// Therefore, our answer will also
             	// show as a fraction in reduced form.
             	// ******************************************
             	// ******************************************
             	// ******************************************
              if (s1.contains("/") && s2.contains("/"))
              {
              	// display the result as a fraction
              	Fraction f1 = new Fraction(s1);
              	Fraction f2 = new Fraction(s2);
              	Fraction result = null;

              	if (whichOperator == '+')
              	{
              		result = f1.add(f2);
              	}
              	else if (whichOperator == '-')
              	{
              		result = f1.subtract(f2);
              	}
                else if(whichOperator == '*')
                {
                  result = f1.multiply(f2);
                }
                else if(whichOperator == '/')
                {
                  result = f1.divide(f2);
                }
              	// ******************************************
              	// ******************************************
              	// ******************************************
              	// FINISH ME - add more whichOperation checks
              	// You will only need to do * and /
              	// ******************************************
              	// ******************************************
              	// ******************************************
  				// NOTE: % means mod, ^ means raise to a power
  				//       but you will NOT do these for fractions






              	finalNumField.setText(result.toString());
              } // end of if (s1.contains("/") && s2.contains("/"))


             	// ******************************************
             	// ******************************************
             	// ******************************************
             	// This else section means that the input
             	// fields are not both fractions, so we will
             	// show the result as a decimal number.
             	// ******************************************
             	// ******************************************
             	// ******************************************
              else
              {
              	// display the result as a decimal
              	double x=0; // x will hold the value of the number stored in s1
              	double y=0; // y will hold the value of the number stored in s2
              	double z=0; // z will hold our answer


              	// first, we will get the value of the number stored in s1
              	// and store it in x
              	if (s1.contains("/"))
              	{
              		// build a Fraction object and call getDoubleValue()
              		Fraction f1 = new Fraction(s1);
              		x = f1.getDoubleValue();
              	}
              	else
              	{
              		// this will convert the number stored in the variable s1
              		// into a primitive double
              		x = Double.parseDouble(s1);
              	}



              	// second, we will get the value of the number stored in s2
              	// and store it in y
              	if (s2.contains("/"))
              	{
              		// *************************************************
              		// *************************************************
              		// *************************************************
              		// FINISH ME
                  Fraction f2 = new Fraction(s2);
                  y = f2.getDoubleValue();
              		// build a Fraction object and call getDoubleValue()
              		// see above
              		// *************************************************
              		// *************************************************
              		// *************************************************

              		// Fraction f2 = ?
              		// y = ?
              	}
              	else
              	{
              		// this will convert the number stored in the variable s2
              		// into a primitive double
              		y = Double.parseDouble(s2);
              	}






  				if (whichOperator == '+')
  				{
  			  		z = x + y;
  				}
  				else if (whichOperator == '-')
  				{
  			  		z = x - y;
  				}
          else if(whichOperator == '*')
          {
            z = x * y;
          }
          else if(whichOperator == '/')
          {
            z = x / y;
          }
          else if(whichOperator == '%')
          {
            z = x % y;
          }
          else if(whichOperator == '^')
          {
            z = Math.pow(x,y);
          }
  				// ***************************************************
  				// ***************************************************
  				// ***************************************************
  				// FINISH ME - handle other whichOperator conditionals
  				// Use else if statements
  				// NOTES:
  				// (handle '*', '/', "%" (which is modulus), and '^')
  				// DO NOT USE ^ in your calculation, use Math.pow(x,y)
  				// ***************************************************
  				// ***************************************************
  				// ***************************************************




  				// String.format(format specifier, one or more replacement values)
  				// the % means a replacement value should be inserted into
  				// the String at this position
  				// the .4 means round to four decimal positions
  				// the f means a double value or float value must be used to replace the format specifier
  				// the z is the replacement value
  		 		String answer = String.format("%.4f",z);

  				finalNumField.setText(answer);
              }

  		  }
  		  catch (Exception event)
  		  {
  		  	System.out.println("Error in Calculating");
  		  }
      }
		  try
		  {

            String s1 = number1Field.getText().trim();
            String s2 = number2Field.getText().trim();
            String tempOperator = operatorField.getText().trim();

            if ( s1.equals("") || s2.equals("") || tempOperator.equals("") )
            	return;

            whichOperator = tempOperator.charAt(0);


           	// ******************************************
           	// ******************************************
           	// ******************************************
           	// This if statement if true means that both
           	// input fields contain a fraction.
           	// Therefore, our answer will also
           	// show as a fraction in reduced form.
           	// ******************************************
           	// ******************************************
           	// ******************************************
            if (s1.contains("/") && s2.contains("/"))
            {
            	// display the result as a fraction
            	Fraction f1 = new Fraction(s1);
            	Fraction f2 = new Fraction(s2);
            	Fraction result = null;

            	if (whichOperator == '+')
            	{
            		result = f1.add(f2);
            	}
            	else if (whichOperator == '-')
            	{
            		result = f1.subtract(f2);
            	}
              else if(whichOperator == '*')
              {
                result = f1.multiply(f2);
              }
              else if(whichOperator == '/')
              {
                result = f1.divide(f2);
              }
              else if(whichOperator == '%')
              {
                result = f1.mod(f2);
              }
              else if(whichOperator == '^')
              {
                result = f1.exponent(f2);
              }
            	// ******************************************
            	// ******************************************
            	// ******************************************
            	// FINISH ME - add more whichOperation checks
            	// You will only need to do * and /
            	// ******************************************
            	// ******************************************
            	// ******************************************
				// NOTE: % means mod, ^ means raise to a power
				//       but you will NOT do these for fractions






            	finalNumField.setText(result.toString());
            } // end of if (s1.contains("/") && s2.contains("/"))


           	// ******************************************
           	// ******************************************
           	// ******************************************
           	// This else section means that the input
           	// fields are not both fractions, so we will
           	// show the result as a decimal number.
           	// ******************************************
           	// ******************************************
           	// ******************************************
            else
            {
            	// display the result as a decimal
            	double x=0; // x will hold the value of the number stored in s1
            	double y=0; // y will hold the value of the number stored in s2
            	double z=0; // z will hold our answer


            	// first, we will get the value of the number stored in s1
            	// and store it in x
            	if (s1.contains("/"))
            	{
            		// build a Fraction object and call getDoubleValue()
            		Fraction f1 = new Fraction(s1);
            		x = f1.getDoubleValue();
            	}
            	else
            	{
            		// this will convert the number stored in the variable s1
            		// into a primitive double
            		x = Double.parseDouble(s1);
            	}



            	// second, we will get the value of the number stored in s2
            	// and store it in y
            	if (s2.contains("/"))
            	{
            		// *************************************************
            		// *************************************************
            		// *************************************************
            		// FINISH ME
                Fraction f2 = new Fraction(s2);
                y = f2.getDoubleValue();
            		// build a Fraction object and call getDoubleValue()
            		// see above
            		// *************************************************
            		// *************************************************
            		// *************************************************

            		// Fraction f2 = ?
            		// y = ?
            	}
            	else
            	{
            		// this will convert the number stored in the variable s2
            		// into a primitive double
            		y = Double.parseDouble(s2);
            	}






				if (whichOperator == '+')
				{
			  		z = x + y;
				}
				else if (whichOperator == '-')
				{
			  		z = x - y;
				}
        else if(whichOperator == '*')
        {
          z = x * y;
        }
        else if(whichOperator == '/')
        {
          z = x / y;
        }
        else if(whichOperator == '%')
        {
          z = x % y;
        }
        else if(whichOperator == '^')
        {
          z = Math.pow(x,y);
        }
				// ***************************************************
				// ***************************************************
				// ***************************************************
				// FINISH ME - handle other whichOperator conditionals
				// Use else if statements
				// NOTES:
				// (handle '*', '/', "%" (which is modulus), and '^')
				// DO NOT USE ^ in your calculation, use Math.pow(x,y)
				// ***************************************************
				// ***************************************************
				// ***************************************************




				// String.format(format specifier, one or more replacement values)
				// the % means a replacement value should be inserted into
				// the String at this position
				// the .4 means round to four decimal positions
				// the f means a double value or float value must be used to replace the format specifier
				// the z is the replacement value
		 		String answer = String.format("%.4f",z);

				finalNumField.setText(answer);
            }

		  }
		  catch (Exception event)
		  {
		  	System.out.println("Error in Calculating");
		  }

		} // end of else if ( (source == calcMenuItem) || (source == calcButton) )


	} // end of actionPerformed method



	// *************************************************************
	// *************************************************************
	// *************************************************************
	// class Fraction handles numbers in a fraction form
	// this is an inner class (a class defined within another class)
	// *************************************************************
	// *************************************************************
	// *************************************************************

	class Fraction
	{
		int numerator;
		int denominator;

		public Fraction(int numerator, int denominator)
		{
			// ***************************************
			// ***************************************
			// ***************************************
			// FINISH ME
			// assign values to the instance variables
			// numerator and denominator
			// ***************************************
			// ***************************************
			// ***************************************
			this.numerator = numerator;
      this.denominator = denominator;

      reduce();



			// ***************************************
			// ***************************************
			// ***************************************
			// FINISH ME
			// call the reduce method to reduce the
			//     fraction (i.e. simplify)
			// ***************************************
			// ***************************************
			// ***************************************


		}

		public Fraction(String fraction)
		{
			// parse the input  (Example: "4/8")  think Scanner and useDelimeter
			Scanner scan = new Scanner(fraction);
			scan.useDelimiter("/"); // the separator will be a / instead of a space

			// ***************************************
			// ***************************************
			// ***************************************
			// FINISH ME
			// assign values to the instance variables
			// numerator and denominator
			// ***************************************
			// ***************************************
			// ***************************************

			numerator = scan.nextInt();
      denominator = scan.nextInt();
      reduce();



			// ***************************************
			// ***************************************
			// ***************************************
			// FINISH ME
			// call the reduce method to reduce the
			//     fraction (i.e. simplify)
			// ***************************************
			// ***************************************
			// ***************************************


		}

		private void reduce()
		{
			// Euclid's algorithm to simply the fraction  (google it!)

			int x = numerator;
			int y = denominator;
			int remainder = 1;

			while (remainder != 0)
			{
				remainder = x % y;
				x = y;
				y = remainder;
			}

			int gcf = x;

			numerator = numerator/gcf;
			denominator = denominator/gcf;

		}

		public Fraction add(Fraction other)
		{
			// do not modify this Fraction!!!!!!
			// add this Fraction and the other Fraction
			// create a new Fraction object and return it
			int a = numerator;
			int b = denominator;
			int c = other.numerator;
			int d = other.denominator;


			// a     c     a*d     b*c     a*d + b*c
			// -  +  -  =  ---  +  ---  =  ---------
			// b     d     b*d     b*d        b*d

			int newNum = a*d + b*c;

			// *********
			// FINISH ME
			// *********
			int newDen = b*d; // CHANGE ME (LOOK ABOVE)

      reduce();


			return new Fraction(newNum,newDen);
		}

		public Fraction subtract(Fraction other)
		{
			// *********************************************
			// *********************************************
			// *********************************************
			// FINISH ME
			// do not modify this Fraction
			// subtract this Fraction and the other Fraction
			// create a new Fraction object and return it
			// *********************************************
			// *********************************************
			// *********************************************

      int numerator = (this.numerator*other.denominator - other.numerator*this.denominator);
      int denominator = (this.denominator*other.denominator);

      Fraction output = new Fraction(numerator,denominator);
      output.reduce();

			return output;
		}

    public Fraction multiply(Fraction other)
    {
      return new Fraction(this.numerator*other.numerator,this.denominator*other.denominator);
    }

    public Fraction divide(Fraction other)
    {
      return new Fraction(this.numerator*other.denominator,this.denominator*other.numerator);
    }

    public Fraction mod(Fraction other)
    {
      int numerator = (this.numerator*other.denominator) % (other.numerator*this.denominator);
      int denominator = (this.denominator*other.denominator);

      System.out.println(numerator);
      System.out.println(denominator);

      Fraction output = new Fraction(numerator,denominator);
      reduce();

      return output;
    }

    public Fraction exponent(Fraction other)
    {
      return new Fraction((int)Math.pow(this.numerator, other.getDoubleValue()),(int)Math.pow(this.denominator, other.getDoubleValue()));
    }


		// ***********************************
		// ***********************************
		// ***********************************
		// FINISH ME
    // TODO:
		// add methods to multiply, and divide
		// Mod and Exponent button is extra credit
		// ***********************************
		// ***********************************
		// ***********************************




		public double getDoubleValue()
		{
			// FINISH ME
			// return the value of numerator/denominator as a double (use a type cast)
			return (double)numerator/denominator; // change this line
		}

		public String toString()
		{
			if (denominator == 1)
			{
				// *********
				// *********
				// *********
				// FINISH ME
				// *********
				// *********
				// *********
				return numerator + "";  // change me!!! (think about what you should return) (Example:  5/1, return 5)
			}


			// *********
			// *********
			// *********
			// FINISH ME
			// return in fractional form
			// Example:  numerator 5, denominator 7   return 5/7
			// So join together the numerator plus "/" plus denominator
			// Use the + operator
			// *********
			// *********
			// *********
			return numerator + " / " + denominator; // change me!!!
		}


	} // end of class Fraction


} // end of public class Calculator
