import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;  //ArrayList, Stack

// FIND ALL OF THE FINISH ME comments



// FINISH ME
// My name is first last



public class ArrayListStudentRunner extends JFrame implements ActionListener {

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
  JPanel     centerPanel; // for entire middle area
  JPanel     centerPanel1; // to hold the array
  JPanel     centerPanel15; // to hold the student name
  JPanel     centerPanel2; // to hold the answers
  JPanel     centerPanel3; // to hold the answers
  JPanel     centerPanelSpacer; // to hold space

  ArrayList<JButton> buttons1;
  ArrayList<JButton> buttons2;


  // a button to move to the first student
  JButton firstStudentButton;

  // a button to move to the last student
  JButton lastStudentButton;


  // FINISH ME
  // add two more buttons to move to the next student and previous student

  JButton nextStudentButton;
  JButton previousStudentButton;



  int    numStudents = 8;

  JLabel studentInfoLabel;

  JLabel spacer1;
  JLabel spacer2;
  JLabel spacer3;
  JLabel spacer4;
  JLabel spacer11;
  JLabel spacer22;
  JLabel spacer33;
  JLabel spacer44;


  // JLabel objects to display a Student's data
  JLabel sumValueLabel;
  JLabel averageValueLabel;
  JLabel largestValueLabel;
  JLabel smallestValueLabel;
  JLabel rangeLabel;
  JLabel num100sLabel;
  JLabel gte90ValueLabel;
  JLabel lt70ValueLabel;


  // the list of Student objects
  ArrayList<Student> list;


  // a temporary list of Student objects
  // used for rearranging in order by average
  PriorityQueue<Student> pqList;


   // the index position of the student being shown on the screen
  int currentStudentIndex;


  // ***** public void initialize *****


  public void initialize( )
  {

	Font fontForValueLabels = new Font("Courier New",Font.BOLD,24);


	// FINISH ME
	// create an ArrayList to hold the Student objects
	list = new ArrayList<Student>();


	currentStudentIndex = 0;



	// FINISH ME
	// create a PriorityQueue to hold the students
	pqList = new PriorityQueue<Student>();


	// FINISH ME
	// create an ArrayList to hold Integer objects
	ArrayList<Integer> grades = new ArrayList<>();



	grades.add(100);
	grades.add(98);
	grades.add(100);
	grades.add(100);
	Student temp = new Student("Tom", "TC34529", "16", grades);
	list.add(temp);

	studentInfoLabel = new JLabel("");
	studentInfoLabel.setFont(fontForValueLabels);
	//studentInfoLabel.setText("Name: Tom   ID: TC34529  Age:16    Grades: 100 98 100 100");

	String [] nameList = {"Sue", "Bill", "Al", "Bob", "Mary", "Will", "Su"};
	String [] idList = {"SU12345", "BI54321", "AL56879", "BO45761", "MA41238", "WI71836", "SU49356"};
	String [] ageList = {"17", "16", "15", "18", "16", "17", "14"};


	for (int k=0; k<numStudents-1; k++)
	{
		grades = new ArrayList<Integer>();
		for (int i=0; i<4; i++)
		{
			int x = (int) (Math.random() * 41 + 60);
			grades.add(x);
		}
		if (k==0)
		{
			grades.clear();
			grades.add(30);
			grades.add(40);
			grades.add(90);
			grades.add(100);
		}
		temp = new Student(nameList[k], idList[k], ageList[k], grades);
		list.add(temp);
	}


	// FINISH ME
	// now add the students to the PriorityQueue
	for (int k=0; k<numStudents; k++)
	{
		pqList.add(list.get(k));
	}



	// FINISH ME
	// clear your list of students
	list.clear();



	int k=-1;

	// FINISH ME
	// while the priority queue is NOT empty keep going
	while (!pqList.isEmpty())
	{
		k++;

		// FINISH ME
		// now remove a student from the priority queue and add them to your list
		list.add(pqList.remove());
	}



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
    northPanel          = new JPanel();
    southPanel          = new JPanel();
    westPanel           = new JPanel();
    eastPanel           = new JPanel();
    centerPanel         = new JPanel();
    centerPanel1        = new JPanel(); // to hold the array
	centerPanel15       = new JPanel(); // holds student name, ...
    centerPanel2        = new JPanel(); // Answers
    centerPanel3        = new JPanel(); // Answers
	centerPanelSpacer   = new JPanel(); // space
  nextStudentButton = new JButton("Next Student");
  previousStudentButton = new JButton("Previous Student");
  previousStudentButton.addActionListener(this);

	sumValueLabel = new JLabel("Sum: ");
	sumValueLabel.setFont(fontForValueLabels);


	spacer1 = new JLabel("   |   ");

	averageValueLabel = new JLabel("Average: ");
	averageValueLabel.setFont(fontForValueLabels);

	spacer2 = new JLabel("   |   ");

	largestValueLabel = new JLabel("Largest: ");
	largestValueLabel.setFont(fontForValueLabels);

	spacer3 = new JLabel("   |   ");

	smallestValueLabel = new JLabel("Smallest: ");
	smallestValueLabel.setFont(fontForValueLabels);


	rangeLabel = new JLabel("Range: ");
	rangeLabel.setFont(fontForValueLabels);

	spacer11 = new JLabel("   |   ");

	num100sLabel = new JLabel("Number of 100's: ");
	num100sLabel.setFont(fontForValueLabels);

	spacer22 = new JLabel("   |   ");

	gte90ValueLabel = new JLabel("Number >= 90: ");
	gte90ValueLabel.setFont(fontForValueLabels);


	spacer33 = new JLabel("   |   ");

	lt70ValueLabel = new JLabel("Number < 70: ");
	lt70ValueLabel.setFont(fontForValueLabels);


  	nextStudentButton  = new JButton("Next Student");
	nextStudentButton.addActionListener(this);

  	firstStudentButton  = new JButton("First Student");
	firstStudentButton.addActionListener(this);

  lastStudentButton = new JButton("Last Button");
  lastStudentButton.addActionListener(this);

	// FINISH ME
	// do your other two buttons



	centerPanel15.add(studentInfoLabel);
	centerPanel2.add(averageValueLabel);
	centerPanel2.add(spacer1);
	centerPanel2.add(sumValueLabel);
	centerPanel2.add(spacer2);
	centerPanel2.add(largestValueLabel);
	centerPanel2.add(spacer3);
	centerPanel2.add(smallestValueLabel);

	centerPanel3.add(rangeLabel);
	centerPanel3.add(spacer11);
	centerPanel3.add(num100sLabel);
	centerPanel3.add(spacer22);
	centerPanel3.add(gte90ValueLabel);
	centerPanel3.add(spacer33);
	centerPanel3.add(lt70ValueLabel);

	centerPanelSpacer.add(new JLabel("   "));


	centerPanel.setLayout(new GridLayout(5,1));
	centerPanel1.setLayout(new GridLayout(2,8));

	southPanel.add(firstStudentButton);
	southPanel.add(nextStudentButton);

	// FINISH ME
	// add your other buttons to the southPanel

  southPanel.add(previousStudentButton);

  southPanel.add(lastStudentButton);


	Font titleFont = new Font("Courier New",Font.BOLD,24);

	// FINISH ME
	// add your name to the title
	String titleString = "ArrayList <Student> BY NEO WANG";


	JLabel titleLabel = new JLabel(titleString);
	titleLabel.setFont(titleFont);
	northPanel.add(titleLabel);

	Font font = new Font("Courier New",Font.BOLD,18);


	buttons1 = new ArrayList<JButton>();

	Stack <JButton> stack = new Stack<JButton>();

	k = 0;  // shows the indexes on the buttons 0,1,2,...
	for (int i=1; i<=numStudents; i++,k++)
	{
		JButton button = new JButton(""+k);
		button.setFont(font);
		button.addActionListener(this);


		// FINISH ME
		// add your button object to your stack
		stack.add(button);


		centerPanel1.add(button);
	}

	for (int i=1; i<=numStudents; i++)
	{
		// FINISH ME
		// pop your stack
		buttons1.add(stack.pop());
	}


    // FINISH ME
    // create a new ArrayList of JButton objects
    buttons2 = new ArrayList<JButton>();


	String theText = "";

	// these are the Student names

	for (int i=0; i<numStudents; i++)
	{
		// FINISH ME
		// get the name of the student from list
		theText = list.get(i).getName();

		// FINISH ME
		// create a new JButton and pass theText to the constructor
		JButton button = new JButton(theText);



		button.setFont(font);
		buttons2.add(button);
		centerPanel1.add(button);
		buttons2.get(i).setBackground(Color.BLACK);
		buttons2.get(i).setForeground(Color.CYAN);

	}

	buttons2.get(0).setBackground(Color.darkGray);
	buttons2.get(0).setForeground(Color.RED);

    mainPanel.setLayout(new BorderLayout());

    northPanel.setBackground(new Color(115,205,255));
    southPanel.setBackground(new Color(115,205,255));
    westPanel.setBackground(new Color(115,205,255));
    eastPanel.setBackground(new Color(115,205,255));
    // ***** You need to add buttons, etc. to the 5 panels *****

	centerPanel.add(centerPanel1);
	centerPanel.add(centerPanelSpacer);
	centerPanel.add(centerPanel15); // name, ...
	centerPanel.add(centerPanel2);
	centerPanel.add(centerPanel3);

    // ***** add the panels to the mainPanel 5 areas *****
    mainPanel.add(northPanel,BorderLayout.NORTH);
    mainPanel.add(southPanel,BorderLayout.SOUTH);
    mainPanel.add(eastPanel,BorderLayout.EAST);
    mainPanel.add(westPanel,BorderLayout.WEST);
    mainPanel.add(centerPanel,BorderLayout.CENTER);

    // make the mainPanel be the main content area and show it
    setContentPane(mainPanel);

    displayStudent("first");

    setVisible(true);  // always show the screen last
  }   // end of public void initialize

  // ***** default constructor *****

  public ArrayListStudentRunner( )
  {
    // initialize variables

    setSize(1120,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    // FINISH ME
    setTitle("ArrayList Math by NEO WANG");


    initialize( );

  }




 // ***** ActionListener interface methods *****

  // start of actionPerformed (ActionListener interface)
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == exitMenuItem) {
      System.exit(0);
    }  // end of if

	else if (firstStudentButton == source)
	{
		displayStudent("first");
	}

	else if (nextStudentButton == source)
	{
		displayStudent("next");
	}


	// FINISH ME
	// check for your other two buttons
	// pass "previous" and "last" as parameters

  else if(source == previousStudentButton)
  {
    displayStudent("previous");
  }

  else if(source == lastStudentButton)
  {
    displayStudent("last");
  }




  }  // end of actionPerformed



  // ***** main method *****
  public static void main(String[] arguments) {
    ArrayListStudentRunner arrayListStudent = new ArrayListStudentRunner( );
  }



  public void displayStudent(String moveTo)
  {

  		if (currentStudentIndex >= 0)
  		{
			buttons2.get(currentStudentIndex).setBackground(Color.BLACK);
			buttons2.get(currentStudentIndex).setForeground(Color.CYAN);
  		}

  		if (moveTo.equals("next"))
  		{
			currentStudentIndex++;
			if (currentStudentIndex==list.size())
				currentStudentIndex = list.size()-1;

  		}
		else if (moveTo.equals("previous"))
		{
			currentStudentIndex--;
			if (currentStudentIndex < 0)
				currentStudentIndex = 0;
		}
		else if (moveTo.equals("first"))
		{
			// FINISH ME
			// set currentStudentIndex to the zero position in the list
      currentStudentIndex = 0;

		}
		else if (moveTo.equals("last"))
		{
			// FINISH ME
			// set currentStudentIndex to the last position in the list
      currentStudentIndex = list.size() - 1;
		}


		// FINISH ME
		// get the name of the currentStudentIndex Student from list
		String name = list.get(currentStudentIndex).getName();


		// FINISH ME
		// get the id of the currentStudentIndex Student from list
		String id   = list.get(currentStudentIndex).getId();


		// FINISH ME
		// get the age of the currentStudentIndex Student from list
		String age  = list.get(currentStudentIndex).getAge();


		// FINISH ME
		// get the gradeList of the currentStudentIndex Student  from list
		String gradeList = list.get(currentStudentIndex).getGradeList();



		studentInfoLabel.setText("Name: " + name + "   ID: " + id + "   Age: " + age + "    Grades: " + gradeList);

		buttons2.get(currentStudentIndex).setBackground(Color.darkGray);
		buttons2.get(currentStudentIndex).setForeground(Color.RED);

		studentInfoLabel.setText("Name: " + name + "   ID: " + id + "   Age: " + age + "    Grades: " + gradeList);

		int sum = list.get(currentStudentIndex).getSum();  // call the appropriate method in class Student
		// FINISH ME
		// set the text on the label for the sum
		sumValueLabel.setText("Sum: " + sum);


		double average = list.get(currentStudentIndex).getAverage(); // call the appropriate method in class ArrayListLibrary
		// FINISH ME
		// set the text on the label for the average
		averageValueLabel.setText("Average: " + average );


		int largest = list.get(currentStudentIndex).getHighestGrade(); // call the appropriate method in class ArrayListLibrary
		largestValueLabel.setText("Largest: "+largest);


		int smallest = list.get(currentStudentIndex).getLowestGrade(); // call the appropriate method in class ArrayListLibrary
		smallestValueLabel.setText("Smallest: "+smallest);


		int range = list.get(currentStudentIndex).getRange(); // call the appropriate method in class ArrayListLibrary
		rangeLabel.setText("Range: "+range);


		int num100s = list.get(currentStudentIndex).getCountOf(100);  // call the appropriate method in class ArrayListLibrary
		num100sLabel.setText("Number of 100's: "+num100s);

		int numGTE90 = list.get(currentStudentIndex).getNumGTE(90);  // call the appropriate method in class ArrayListLibrary
		gte90ValueLabel.setText("Number >= 90: "+numGTE90);

		int numLT70 = list.get(currentStudentIndex).getNumLT(70);  // call the appropriate method in class ArrayListLibrary
		lt70ValueLabel.setText("Number < 70: "+numLT70);

  }


} // end of class ArrayListStudentRunner
