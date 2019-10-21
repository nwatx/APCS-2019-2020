
// FIND THE FINISH ME STATEMENTS

// YOU WILL EVALUATE INFIX EXPRESSIONS
// BUT YOU DO NOT NEED TO HANLDE PARENTHESIS
// YOU SHOULD HANDLE + - * / AND %


import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Variables extends JFrame implements ActionListener
{


    boolean debugMode = false;

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

    JButton      calculateButton;

    JLabel       titleLabel; // for top JPanel (northPanel)


    // elements to fill blank cells on the screen 6x6 grid

    // Label fillers
    ArrayList <JLabel> labelsC0;
    ArrayList <JLabel> labelsC1;
    ArrayList <JLabel> labelsC4;
    ArrayList <JLabel> labelsC5;



    JLabel variableLabel; // for text Expression
    JLabel valueLabel; // for text Expression
    JLabel answerLabel; // for the answer
    JLabel filler52;
    JLabel filler53;

    // input fields
    JLabel xVariable;
    JLabel yVariable;
    JLabel zVariable;

    JTextField xValue;
    JTextField yValue;
    JTextField zValue;
    JTextField inputExpression;


    // FINISH ME
    // create a HashMap with a String key and a String value
    HashMap<String, String> variableMap;


    // FINISH ME
    // create a HashMap with a String key and an Integer value
    HashMap<String,Integer> operatorMap;


    public ArrayList<JLabel> buildJLabelArrayList()
    {
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        for (int i = 1; i<=6; i++)
        {
            labels.add(new JLabel("  "));
        }
        return labels;
    }


    // ***** public void initialize *****

    public void initialize( )
    {

        // FINISH ME
        // the variableMap contains variables and their values
        // both as Strings
        // create the HashMap
        variableMap = new HashMap<String, String>();


        // put the variables x,y, and z into the variableMap
        // with values of "0"
        // remember that the keys are Strings and the values
        //    are also Strings

        variableMap.put("x","0");
        variableMap.put("y","0");
        variableMap.put("z","0");


        // FINISH ME
        // the operatorMap contains operators and their priority values
        // create the HashMap with String keys and Integer values
        operatorMap = new HashMap<String,Integer>();



        operatorMap.put("+",2);
        operatorMap.put("-",2);
        operatorMap.put("*",4);
        operatorMap.put("/",4);
        operatorMap.put("%",4);


        labelsC0 = buildJLabelArrayList();
        labelsC1 = buildJLabelArrayList();
        labelsC4 = buildJLabelArrayList();
        labelsC5 = buildJLabelArrayList();

        filler52 = new JLabel("  ");
        filler53 = new JLabel("  ");


        variableLabel = new JLabel("Variable");
        valueLabel = new JLabel("Value");
        answerLabel = new JLabel("Result");

        Font fontForLabels = new Font("Courier New",Font.BOLD,18);
        variableLabel.setFont(fontForLabels);
        valueLabel.setFont(fontForLabels);
        answerLabel.setFont(fontForLabels);



        // input fields
        xVariable = new JLabel("x");
        xVariable.setFont(fontForLabels);

        yVariable = new JLabel("y");
        yVariable.setFont(fontForLabels);

        zVariable = new JLabel("z");
        zVariable.setFont(fontForLabels);

        xValue = new JTextField("0",10);
        yValue = new JTextField("0",10);
        zValue = new JTextField("0",10);
        inputExpression = new JTextField("",10);


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

        mainPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new GridLayout(6,4,10,10));

        // fill the layout

        // row 0  Filler  Filler  Variable  Value  Filler Filler
        centerPanel.add(labelsC0.get(0)); // 0,0 element
        centerPanel.add(labelsC1.get(0)); // 0,1 element
        centerPanel.add(variableLabel);
        centerPanel.add(valueLabel);
        centerPanel.add(labelsC4.get(0)); // 0,4 element
        centerPanel.add(labelsC5.get(0)); // 0,5 element

        // row 1
        centerPanel.add(labelsC0.get(1)); // 0,0 element
        centerPanel.add(labelsC1.get(1)); // 0,1 element
        centerPanel.add(xVariable);
        centerPanel.add(xValue);
        centerPanel.add(labelsC4.get(1)); // 0,4 element
        centerPanel.add(labelsC5.get(1)); // 0,5 element


        // row 2
        centerPanel.add(labelsC0.get(2)); // 0,0 element
        centerPanel.add(labelsC1.get(2)); // 0,1 element
        centerPanel.add(yVariable);
        centerPanel.add(yValue);
        centerPanel.add(labelsC4.get(2)); // 0,4 element
        centerPanel.add(labelsC5.get(2)); // 0,5 element


        // row 3
        centerPanel.add(labelsC0.get(3)); // 0,0 element
        centerPanel.add(labelsC1.get(3)); // 0,1 element
        centerPanel.add(zVariable);
        centerPanel.add(zValue);
        centerPanel.add(labelsC4.get(3)); // 0,4 element
        centerPanel.add(labelsC5.get(3)); // 0,5 element


        // row 4
        centerPanel.add(labelsC0.get(4)); // 0,0 element
        centerPanel.add(labelsC1.get(4)); // 0,1 element
        centerPanel.add(inputExpression);
        centerPanel.add(answerLabel);
        centerPanel.add(labelsC4.get(4)); // 0,4 element
        centerPanel.add(labelsC5.get(4)); // 0,5 element


        // row 5
        centerPanel.add(labelsC0.get(5)); // 0,0 element
        centerPanel.add(labelsC1.get(5)); // 0,1 element
        centerPanel.add(filler52);
        centerPanel.add(filler53);
        centerPanel.add(labelsC4.get(5)); // 0,4 element
        centerPanel.add(labelsC5.get(5)); // 0,5 element



        northPanel.setBackground(new Color(115,205,255));
        southPanel.setBackground(new Color(115,205,255));
        westPanel.setBackground(new Color(115,205,255));
        eastPanel.setBackground(new Color(115,205,255));

        // FINISH ME
        // add your name
        titleLabel = new JLabel("Variables by ");
        Font font = new Font("Courier New",Font.BOLD,32);
        titleLabel.setFont(font);
        northPanel.add(titleLabel);



        calculateButton = new JButton("Calculate");
        font = new Font("Courier New",Font.BOLD,24);
        calculateButton.setFont(font);
        calculateButton.addActionListener(this);
        southPanel.add(calculateButton);



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

    public Variables( )
    {
        // initialize variables

        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // FINISH ME
        // add your name
        setTitle("Variables by ");


        initialize( );

    }


    public boolean isNumber(String number)
    {
        // FINISH ME
        // loop through the String number and if you find
        // a character that is not in the range of '0'..9' inclusive
        // then return false

        List<String> numbers = Arrays.asList("0","1","2","3","4","5","6","7","8","9");



        for(String a : numbers)
        {
            return number.contains(a);
        }

        return false;
    }


    public boolean isOperator(String operator)
    {
        // FINISH ME
        // see if operator is a key in the map
        if (operatorMap.containsKey(operator))
        return true;

        return false;
    }


    public boolean isVariable(String variable)
    {
        // FINISH ME
        // see if variable is a key in the variableMap

        if (variableMap.containsKey(variable))
        return true;

        return false;
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
        else if (source == calculateButton)
        {
            // here we update our variableMap with the values
            // that the user entered on the screen
            int x = Integer.parseInt(xValue.getText().trim());
            variableMap.put("x",""+x);

            int y = Integer.parseInt(yValue.getText().trim());
            variableMap.put("y",""+y);

            int z = Integer.parseInt(zValue.getText().trim());
            variableMap.put("z",""+z);




            // FINISH ME
            // get the expression from the textfield and store in variable expression
            // It should look something like  x + 10 * y / 2 - 1

            String expression = inputExpression.getText();


            String expressionWithValues = "";


            // FINISH ME
            // put the expression into a Scanner object
            System.out.println(expression);
            Scanner scan = new Scanner(expression);


            // FINISH ME
            // create a Linked List
            // to hold the expression as we evaluate it
            // it should hold String objects
            LinkedList <String> list = new LinkedList<>();



            boolean error = false;



            // loop through the Scanner objects
            // and put items into the list (the LinkedList)
            // we will carry out the *,/,and %
            // example:  5 + 3 * 5 would end up as
            //           5 + 15 in the list

            // FINISH ME
            // is there a next element in the Scanner?
            while (scan.hasNext())
            {

                // FINISH ME
                // get the next element from the Scanner as a String
                String item = scan.next();

                if (variableMap.containsKey(item))
                {
                    // get the value of the variable as a String
                    // and add it to the end of the list
                    list.add(variableMap.get(item));

                    System.out.println("found variable " + item);

                    expressionWithValues += variableMap.get(item) + " ";

                }
                else if (isNumber(item))
                {
                    // add the number onto the end of the list (as a String)
                    list.add(item);
                    expressionWithValues += item + " ";
                    System.out.println("found number " + item);


                }
                else if (isOperator(item)) {
                    expressionWithValues += item + " ";
                    System.out.println("found operator " + item);

                    // FINISH ME
                    // if the item is a + or a - just add it the list (the end)
                    //     we will solve those last
                    List<String> items = Arrays.asList("+", "-");
                    if (items.contains(item)) {
                        list.add(item);


                        if (!scan.hasNext()) {
                            error = true;
                            break;
                        }
                    }
                    else
                    {
                        list.add(item);
                    }

                    // FINISH ME
                    // if the item is a *, /, or %
                }
				else {

				    System.out.println("I'm inside...");
                        if (!scan.hasNext())
                        {
                            error = true;
                            break;
                        }

                        // FINISH ME
                        // we will carry out the operation, but we need the right operand
                        // so get the next item from the Scanner
                        // it better be a variable or a number
                        String rightOperandAsString = scan.next();

                        int rightOperandValue = 0;


                        if (isNumber(rightOperandAsString))
                        {
                            rightOperandValue = Integer.parseInt(rightOperandAsString);
                            expressionWithValues += "" + rightOperandValue + " ";
                        }
                        else if (isVariable(rightOperandAsString))
                        {
                            // get the value from the variableMap
                            rightOperandAsString = variableMap.get(rightOperandAsString);
                            expressionWithValues += "" + rightOperandAsString + " ";

                            // FINISH ME
                            // now convert it to an integer
                            // use Integer.parseInt(?)
                            rightOperandValue = Integer.parseInt(rightOperandAsString);
                        }
                        else
                        {
                            // ERROR
                            error = true;
                            break;
                        }

                        String leftOperandAsString = list.remove(list.size()-1);

                        int leftOperandValue = 0;
                        try
                        {
                            leftOperandValue = Integer.parseInt(leftOperandAsString);
                        }
                        catch(Exception ee)
                        {
                            error = true;
                            break;
                        }


                        int answer = 0;


                        // FINISH ME
                        // get the answer for leftOperandValue operator rightOperandValue
                        // and store it in answer
                        System.out.println("Item: " + item);
                        if (item.equals("*"))
                        {
                            System.out.println("Operation *");
                            answer = leftOperandValue * rightOperandValue;

                            System.out.println(answer);
                            list.add("" + answer);
                        }

                        else if(item.equals("/")) {
                            answer = leftOperandValue / rightOperandValue;

                            list.add("" + answer);
                        }
                        else if(item.equals("%")) {
                            answer = leftOperandValue % rightOperandValue;

                            list.add("" + answer);
                        }
                        /* else if(item.equals("+"))
                        {
                            answer = leftOperandValue + rightOperandValue;

                            list.add("" + answer);
                        }
                        else if(item.equals("-"))
                        {
                            answer = leftOperandValue - rightOperandValue;

                            list.add("" + answer);
                        } */
                        else
                        {

                            // FINISH ME
                            // add answer to the list as a String

                            list.add("" + answer);

                        }

                }
                /* else
                {
                    // ERROR
                    break;
                } */


            } // end of while() loop


            // FINISH ME
            // println on the console the list
            // this should leave only the + and -
            System.out.println("The list after */%=" + list);
            String output = "";
            for(String a : list)
            {
                output += a + " ";
            }
            System.out.println(output);
            inputExpression.setText(output);


            // result will hold the answer
            //int result = Integer.parseInt(list.get(0));


            if (!error)
            {

                // continue on to solve the + and -
                for (int i=0; i<list.size()-1; )
                {
                    // we should have left op right

                    String leftOperandAsString = list.remove(i);
                    int leftOperandValue = 0;

                    try
                    {
                        leftOperandValue = Integer.parseInt(leftOperandAsString);
                    }
                    catch(Exception eee)
                    {
                        error = true;
                        break;
                    }


                    if (i+1 < list.size())
                    {
                        String operandAsString = list.remove(i);

                        String rightOperandAsString = list.remove(i);
                        int rightOperandValue;

                        try
                        {
                            rightOperandValue = Integer.parseInt(rightOperandAsString);
                        }
                        catch(Exception eeeee)
                        {
                            error = true;
                            break;
                        }


                        int answer = 0;

                        if (operandAsString.equals("+"))
                            answer = leftOperandValue + rightOperandValue;
                        else if (operandAsString.equals("-"))
                            answer = leftOperandValue - rightOperandValue;
                        else if(operandAsString.equals("*"))
                        {
                            answer = leftOperandValue * rightOperandValue;
                        }
                        else if(operandAsString.equals("/"))
                        {
                            answer = leftOperandValue / rightOperandValue;
                        }
                        else if(operandAsString.equals("%"))
                        {
                            answer = leftOperandValue % rightOperandValue;
                        }
                        list.add(0,""+answer);
                    }
                    else
                    {
                        error = true;
                        break;
                    }

                }

            }
            else
            {
                // display error
            }

            // FINISH ME
            // println on the console the list
            // this should leave only the + and -
            //System.out.println("The final list=" + "[" + solve);

            // FINISH ME
            // put the answer on the result label
            // it should be in the zero position of list
            if (!error && list.size()==1)
                answerLabel.setText("" + list.get(0));
  	 	else
            answerLabel.setText("ERROR");


            try
            {

                answerLabel.setText("" + solve(expressionWithValues));
            }
            catch(Exception lol)
            {
                System.out.println("lol u failed epciallyl");
            }
        }



    }  // end of actionPerformed

    public Object solve(String a) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(a);
        return result;
    }




    // ***** main method *****
    public static void main(String[] arguments) throws ScriptException
    {
        Variables variables = new Variables( );
    }


} // end of class Variables

class MyButton extends JButton
{
    String  data;

    public MyButton(String s, String data)
    {
        super(s);
        this.data = data;
    }


    public void paintComponent(Graphics window)
    {
        super.paintComponent((Graphics2D)window);
        Graphics2D g2 = (Graphics2D) window;
        Font font=null;
    }

    public Object solve(String a) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(a);
        return result;
    }

}

