
// find the FINISH ME comments
// you also need to follow what is happening
// you will be asked to build your own programs
// later on (with some help ofcourse)



// FINISH ME
// put your name here


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PostfixEvaluator extends JFrame implements  ActionListener
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

  JButton    calculateButton;
  JButton    clearButton;

  // define all of the fields and place holders for the main screen
  // 9 x 4



  // FINISH ME
  // add your name to the titleLabel
  JLabel     titleLabel = new JLabel("Postfix Evaluator by Neo Wang");



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
  JLabel     postfixLabel;
  JTextField postfixTextField;  // input field for postfix expression
  JLabel     filler23;

  // row 3
  JLabel     filler30;
  JLabel     filler31;
  JLabel     filler32;
  JLabel     filler33;

  // row 4
  JLabel     filler40;
  JLabel     filler41;
  JLabel     filler42;
  JLabel     filler43;

  // row 5
  JLabel     filler50;
  JLabel     filler51;
  JLabel     filler52;
  JLabel     filler53;

  // row 6
  JLabel     filler60;
  JLabel     outputLabel;
  JLabel     outputLabelResult;
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
    filler20 = new JLabel("  ");
	filler20.setFont(font);



	// FINISH ME
	// create a JLabel with the String "Postfix" showing
    postfixLabel = new JLabel("Postfix");
    postfixLabel.setFont(font);


    // FINISH ME
    // create a JTextField with an empty string and
    // room for 30 characters
    // AN EMPTY STRING IS "" NOT NOT NOT " "
    postfixTextField = new JTextField("                                "); // NOT NOT NOT " "


    postfixTextField.setFont(font);
    filler23 = new JLabel("  ");
	filler23.setFont(font);


    filler30 = new JLabel(" ");
	filler30.setFont(font);
    filler31 = new JLabel(" ");
    filler31.setFont(font);
    filler32 = new JLabel(" ");
    filler32.setFont(font);
    filler33 = new JLabel(" ");
	filler33.setFont(font);

    // row 4
    filler40 = new JLabel(" ");
	filler40.setFont(font);
    filler41 = new JLabel(" ");
    filler41.setFont(font);
    filler42 = new JLabel(" ");
    filler42.setFont(font);
    filler43 = new JLabel(" ");
	filler43.setFont(font);


    filler50 = new JLabel(" ");
	filler50.setFont(font);
    filler51 = new JLabel(" ");
    filler51.setFont(font);
    filler52 = new JLabel(" ");
    filler52.setFont(font);
    filler53 = new JLabel(" ");
	filler53.setFont(font);

    // row 6
    filler60 = new JLabel(" ");
	filler60.setFont(font);
    outputLabel = new JLabel("Answer");
    outputLabel.setFont(font);
    outputLabelResult = new JLabel("");
    outputLabelResult.setFont(font);
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


    postfixTextField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
            	calculateResult();
               	System.out.println("enter key pressed");
            }
        }

    });



    // create a mainPanel for components
    mainPanel = new JPanel();

    // ***** assignments for menu variables *****


	// FINISH ME
	// create a JMenuBar
    menuBar            = new JMenuBar();


	// FINISH ME
	// create a JMenu with File displayed on it
    fileMenu           = new JMenu("File");


	// FINISH ME
	// create a JMenuItem with Exit displayed on it
    exitMenuItem       = new JMenuItem("Exit");


    // add mnemonics to the menu system
    fileMenu.setMnemonic('F');


    // FINISH ME
    // set the mnemonic for the exitMenuItem to 'x'
    exitMenuItem.setMnemonic('x');



    // add the menuItem addActionListener(this) calls


    // FINISH ME
    // add an addActionListener call with this as the argument
    exitMenuItem.addActionListener(this);
    fileMenu.add(exitMenuItem);


    // add menuItems to the fileMenu


    // FINISH ME
    // add the exitMenuItem to the fileMenu
    //fileMenu.???


    // add menus to the menuBar
    // FINISH ME
    // add the fileMenu to the menuBar
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
    titleLabel.setFont(font);

    northPanel.add(titleLabel);


    // FINISH ME  create a new JButton object that displays Convert
    calculateButton = new JButton("Convert");

    // FINISH ME  call the addActionListener method and pass it this
    calculateButton.addActionListener(this);

    // FINISH ME  add the calculateButton to the southPanel (call the add method)
	southPanel.add(calculateButton);


    // FINISH ME  create a new JButton object that displays Clear
    clearButton = new JButton("Clear");

    // FINISH ME  call the addActionListener method and pass it this
    clearButton.addActionListener(this);

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
	centerPanel.add(postfixLabel);
	centerPanel.add(postfixTextField);
	centerPanel.add(filler23);

	// fill row 3
	centerPanel.add(filler30);
	centerPanel.add(filler31);
	centerPanel.add(filler32);
	centerPanel.add(filler33);

	// fill row 4
	centerPanel.add(filler40);
	centerPanel.add(filler41);
	centerPanel.add(filler42);
	centerPanel.add(filler43);

	// fill row 5
	centerPanel.add(filler50);
	centerPanel.add(filler51);
	centerPanel.add(filler52);
	centerPanel.add(filler53);

	// fill row 6
	centerPanel.add(filler60);
	centerPanel.add(outputLabel);
	centerPanel.add(outputLabelResult);
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


    // FINISH ME
    // show the screen (call or invoke setVisible and pass it true)
    setVisible(true);  // always show the screen last



    // FINISH ME
    // Put your name on the console (debug window)
    System.out.println("My name is UH ???? I FORGOT ???");

  }   // end of public void initialize

  // ***** default constructor *****

  public PostfixEvaluator( )
  {
    // initialize variables

    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    // FINISH ME
    // Put your first and last name on the title
    // we call the JFrame's setTitle method (we inherited all of the methods and variables)
    // and pass to it a String
	setTitle("Postfix Evaluator  written by  I forgot my name????");


    initialize( );

  }



  public void calculateResult()
  {
    	// FINISH ME
    	// get the text from postfixTextField and trim() it

    	String postfixExpression = postfixTextField.getText().trim(); // replace ??? with the call statement to get the text



    	// FINISH ME
    	// check and see if postfixExpression is empty
    	// check for it being ""
    	// NOT NOT NOT NOT " "

    	if (postfixExpression.equals(""))
    		return;


    	// FINISH ME
		// evaluate the Postfix expression (to a number)
		// and then put it on the screen


		String answer = "";



    	// FINISH ME
		// create a Scanner object and pass to it
		// postfixExpression
		Scanner scanExpression = new Scanner(postfixExpression);


    	// FINISH ME
		// create a Stack object
		Stack <Integer> stack = new Stack<Integer>();

    char[] exp = postfixExpression.toCharArray();


		boolean error = false;


		// FINISH ME
		// see if we have a next element in the scanExpression
		while (  scanExpression.hasNext()  )
		{
			// we now have a next element


			// FINISH ME
			// see if the next element in the scanExpression
			// is an int
			if (scanExpression.hasNextInt())
			{
				// FINISH ME
				// get the next integer from scanExpression
				int x = scanExpression.nextInt();

				// FINISH ME
				// push x onto your stack
				stack.push(x);
			}
			else // it must be an operator
			{
				// FINISH ME
				// get the next element from the scanExpression
				String op = scanExpression.next();

				int rightValue = 0;


				// FINISH ME
				// see if the stack is not empty
				if (!stack.isEmpty())
				{
					rightValue = stack.pop();
				}
				else
				{
					error = true;
					break;
				}


				int leftValue = 0;
				// FINISH ME
				// see if the stack is not empty
				if (!stack.isEmpty())
				{
					leftValue = stack.pop();
				}
				else
				{
					error = true;
					break;
				}


				// FINISH ME
				// see if the op (operator) is a plus sign ("+")
				if (op.equals("+"))
				{
					// FINISH ME
					// add the leftValue and the rightValue
					int result = leftValue + rightValue;

					// FINISH ME
					// push the result onto the stack
					stack.push(result);
				}
				else if (op.equals("-")) // minus sign
				{
					// FINISH ME
					// subtract the rightValue from the left value
					int result = leftValue - rightValue;

					// FINISH ME
					// push the result onto the stack
					stack.push(result);
				}
        else if (op.equals("*")) // minus sign
				{
					// FINISH ME
					// subtract the rightValue from the left value
					int result = leftValue * rightValue;

					// FINISH ME
					// push the result onto the stack
					stack.push(result);
				}
        else if (op.equals("/")) // minus sign
				{
					// FINISH ME
					// subtract the rightValue from the left value
					int result = leftValue / rightValue;

					// FINISH ME
					// push the result onto the stack
					stack.push(result);
				}
        else if (op.equals("%")) // minus sign
				{
					// FINISH ME
					// subtract the rightValue from the left value
					int result = leftValue % rightValue;

					// FINISH ME
					// push the result onto the stack
					stack.push(result);
				}
				// FINISH ME
				// add code to handle *, /, and %
				// else if ????



				else
				{
					// we must have an error so we break out
					error = true;
					break;
				}

			} // end of else it must be an operator


		} // end of while ()





		// when finished, your output should be at the top of your stack
		// and it should be the only item on your stack

		int theAnswer = 0;
		String theAnswerResult = "";

		// FINISH ME
		// if the stack's size is 1
		if (!error && stack.size() == 1)
		{
			// FINISH ME
			// pop your answer off the stack
			theAnswer = stack.pop();  // pop your stack
			theAnswerResult = ""+theAnswer;
		}
		else
		{
			theAnswerResult = "Error";
		}


		// FINISH ME
		// put theAnswerResult on the outputLabelResult
		// outputLabelResult is a reference or pointer to the
		//     JLabel object
		// It holds the address of the object
		// call the setter method (or modifier method)
		outputLabelResult.setText(theAnswerResult);

  }





  // ***** ActionListener interface methods *****

  // start of actionPerformed (ActionListener interface)

  // this method gets called by the JVM when a JButton
  // or a JMenuItem object is clicked
  // (provided we called the addActionListener method)
  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();
    if (source == exitMenuItem)
    {
      System.exit(0);
    }  // end of if
    else if (source == calculateButton)
    {
    	// FINISH ME
    	// call or invoke the calculateResult()
      calculateResult();

    } // end of else if (source == calculateButton)
    else if (source == clearButton)
    {
    	// FINISH ME
    	// clear the postfixTextField
    	// Make sure that you set it to hold the empty String
    	// The empty String is "" NOT NOT NOT NOT " "
    	// NOT NOT NOT NOT " "
    	// NOT NOT NOT NOT " "
    	// NOT NOT NOT NOT " "
    	// clear the outputLabelResult
    	// (call the setter method for each object)
    	postfixTextField.setText("                              ");
      outputLabelResult = new JLabel("");
    } // end of  else if (source == clearButton)

  }  // end of actionPerformed


  // ***** main method *****
  public static void main(String[] arguments)
  {
    PostfixEvaluator postfixEvaluator = new PostfixEvaluator( );
  }


} // end of class PostfixEvaluator
