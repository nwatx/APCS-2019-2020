// Finish all of the FINISH ME's
// This is the only file
// see https://bitstorm.org/gameoflife/
// for more about Conway's Game of Life



// FINISH ME
// MY NAME IS XXXX XXXXX



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOfLife extends JFrame implements  ActionListener
{
  int SCREEN_WIDTH = 800;
  int SCREEN_HEIGHT = 600;

  int MAX_GENERATIONS = 20;
  int MAX_ROWS = 10;
  int MAX_COLS = 10;

  // ***** declaration of JFrame variables *****


  // define a mainPanel for components
  JPanel mainPanel;

  // ***** declaration of menu variables *****

  // define a menu bar variable to hold JMenus
  JMenuBar  menuBar;

  // define some JMenus and their JMenuItems
  // define a JMenu called fileMenu and add menuItems
  JMenu     fileMenu;
  JMenuItem newGameMenuItem;
  JMenuItem exitMenuItem;



  // define JPanels for a BorderLayout
  JPanel     northPanel;
  JPanel     southPanel;
  JPanel     westPanel;
  JPanel     eastPanel;
  JPanel     centerPanel;

  JButton [][] jButton;   // buttons for the screen

  char board [][][];     // generation, row, column
  // board.length would be the number of generations
  // board[0].length would be the number of rows for generation 0
  // board[0][2].length would be the number of columns for generation 0 row 2


  // buttons for first board, previous, next, and last
  JButton firstButton;
  JButton previousButton;
  JButton nextButton;
  JButton lastButton;


  int generation;  // the generation to show

  JLabel   northTitle;

  boolean  canEdit;

  // ***** public void initialize *****

  public void initialize( )
  {

	canEdit = true;
	generation = 0;  // we will display generation 0 in the beginning

	// FINISH ME
	// create the char 3d array
	// twenty boards (generations) 0..19, each board is 10x10
	board = new char[MAX_GENERATIONS][MAX_ROWS][MAX_COLS];

	// FINISH ME
	// create your JButton objects for First, Previous, Next, Last, etc.
	// (instance variables are firstButton, previousButton, nextButton, lastButton)
	// don't forget to call the addActionListener
	// the firstButton has been done for you

	firstButton = new JButton("First");
	firstButton.addActionListener(this);

  previousButton = new JButton("Previous");
  previousButton.addActionListener(this);

  nextButton = new JButton("Next");
  nextButton.addActionListener(this);

  lastButton = new JButton("Last");
  lastButton.addActionListener(this);





    // FINISH ME
    // create a mainPanel (a JPanel) for holding components
    mainPanel = new JPanel();


    // ***** assignments for menu variables *****

    menuBar            = new JMenuBar();


    // FINISH ME
    // create a JMenu for the File menu
    fileMenu           = new JMenu();



    // FINISH ME
    // create JMenuItems for a new Game and the Exit
    newGameMenuItem    = new JMenuItem();
    exitMenuItem       = new JMenuItem();



    // add mnemonics to the menu system
    fileMenu.setMnemonic('F');
    newGameMenuItem.setMnemonic('n');
    exitMenuItem.setMnemonic('x');


    // add the menuItem addActionListener(this) calls
    // fileMenu
    newGameMenuItem.addActionListener(this);
    exitMenuItem.addActionListener(this);


    // add menuItems to the fileMenu
    fileMenu.add(newGameMenuItem);
    fileMenu.addSeparator(); // this adds a separator to the menu list
    fileMenu.add(exitMenuItem);


    // add the menus to the menuBar
    menuBar.add(fileMenu);

    // attach the JMenuBar to the Window
    setJMenuBar(menuBar);


    // FINISH ME
    // ***** create JPanels for a BorderLayout *****
    northPanel   = new JPanel();
    southPanel   = new JPanel();
    westPanel    = new JPanel();
    eastPanel    = new JPanel();
    centerPanel  = new JPanel();



    mainPanel.setLayout(new BorderLayout());
	centerPanel.setLayout(new GridLayout(MAX_ROWS,MAX_COLS));

    northPanel.setBackground(new Color(115,205,255));
    southPanel.setBackground(new Color(115,205,255));
    westPanel.setBackground(new Color(115,205,255));
    eastPanel.setBackground(new Color(115,205,255));

    // ***** You need to add buttons, etc. to the 5 panels *****



    southPanel.add(firstButton);
    // Finish Me!
    // add the previousButton, nextButton, and lastButton to the southPanel
    southPanel.add(previousButton);
    southPanel.add(nextButton);
    southPanel.add(lastButton);



    // FINISH ME
    // add your first and last name to the JLabel below
    northTitle = new JLabel("T H E  G A M E  O F  L I F E   by  NEO WANG");

	// FINISH ME
	// add the northTitle to the northPanel (call the add method)
	northPanel.add(northTitle);



	jButton = new JButton[MAX_ROWS][MAX_COLS];

	for (int r=0; r < MAX_ROWS; r++)
	{
		for (int c=0; c < MAX_COLS; c++)
		{
			board[0][r][c] = ' ';

			// FINISH ME
			// create a new JButton with a space on it (" ")
			JButton temp = new JButton(" ");


			temp.addActionListener(this);
			temp.setFont(new Font("Courier New",Font.BOLD,32));
			temp.setForeground(Color.BLUE);
			jButton[r][c] = temp; // stores the address of temp

			// FINISH ME
			// add temp to the center panel (call the add method)
			// you can either use temp or jButton[r][c] because they are
			// both pointing the button (you are passing an address)
			centerPanel.add(temp);
		}
	}


	displayGeneration(0);  // assign the 0 generation to the jButton 2d array


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

  public GameOfLife( )
  {
    // initialize variables

    setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // FINISH ME
    // add your title (Game of Life) and name
    setTitle("NEO WANG");


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
    else if (source == newGameMenuItem)
    {
       newGame();
    }  // end of if
    else if (source == firstButton)
    {
    	// set the generation to 0
    	generation = 0;
    	canEdit = true;  // let them edit the 0 generation
    	displayGeneration(generation);
    }
    else if (source == nextButton)
    {
      System.out.println("Next clicked");
    	generation++;
    	if (generation > MAX_GENERATIONS-1)
    		generation = MAX_GENERATIONS-1;
    	if (canEdit) // if we are in edit mode for generation 0, then calculate all generations
    	{
    		// calculate each generation 1..19
    		for (int g=1; g<MAX_GENERATIONS; g++)
    			calculateGeneration(g);
    	}
    	canEdit = false;
    	displayGeneration(generation);

    }
    else if (source == lastButton)
    {
      generation = MAX_GENERATIONS-1;
      canEdit = false;
      displayGeneration(generation);
    }
    else if (source == previousButton)
    {
      if(generation > 0)
      {
        generation--;
      }
      if(generation == 0)
      {
        canEdit = true;
      }
      else
      {
        canEdit = false;
      }
      displayGeneration(generation);
    }

    // Finish Me!
    // do all four buttons



    else if (canEdit)
    {
       	// Finish Me!
		// look for the button that got clicked


		// here we loop through all of the elements
		// in row major order (row by row)
		for (int r = 0;  r < MAX_ROWS;  r++)
		{
			for (int c = 0;  c < MAX_COLS;  c++)
			{
    			if (jButton[r][c] == source)
    			{
			    	System.out.println("I found the button that got clicked!");

    				if (jButton[r][c].getText().equals("*"))
    				{
    					// FINISH ME
    					// set the text on the button to the " "
    					jButton[r][c].setText(" ");


    					// FINISH ME
    					// set the text on the board to a ' ' (space character)
    					board[generation][r][c] = ' ';
    				}
    				else
    				{
    					// FINISH ME
    					// set the text on the button to the "*"
    					jButton[r][c].setText("*");

    					// FINISH ME
    					// set the text on the board to a '*' (asterisk character)
    					board[generation][r][c] = '*';
    				}

    			} // end of if (jButton[r][c] == source)
			} // end of for c loop
		} // end of for r loop





    } // end of else if (canEdit)



  }  // end of actionPerformed


  // ***** main method *****
  public static void main(String[] arguments)
  {
    GameOfLife gameOfLife = new GameOfLife( );
  }


  public void newGame()
  {
  	  generation = 0;
  	  clearBoard();
  	  canEdit =  true;  // allow the user to edit the board

	  // Finish Me!
      // set the JButtons (call displayGeneration and pass it 0)

      displayGeneration(0);
  }


  public void calculateGeneration(int whichGeneration)
  {
  	if (whichGeneration == 0)
  	{
		// do nothing, the beginning board is clicked on
      return;
  	}
  	else  // calculate the generation using whichGeneration
  	{
  		// Finish Me!
  		// calculate the board
		for (int r = 0;  r < MAX_ROWS;  r++)
		{
			for (int c = 0;  c < MAX_COLS; c++)
			{
				// we will find the number of neighbors for the previous
				// generation at the r,c position
				// notice that the current generation in this method is
				// named whichGeneration
				// FINISH ME
				int numNeighbors = countNeighbors(whichGeneration-1,r,c);

				if (board[whichGeneration-1][r][c] == '*')
				{
					// FINISH ME
					// if 2 or 3 neighbors, board[whichGeneration][r][c] gets a '*'
					// else board[whichGeneration][r][c] gets a ' '
					if (numNeighbors == 2 || numNeighbors == 3)
					{
            board[whichGeneration][r][c] = '*';
					}
					else
					{
            board[whichGeneration][r][c] = ' ';
					}
				} // end of if (board[whichGeneration-1][r][c] == '*')
				else
				{
          if(numNeighbors == 3)
          {
              board[whichGeneration][r][c] = '*';
          }
          else
          {
            board[whichGeneration][r][c] = ' ';
          }
					// if exactly 3 neighbors, board[whichGeneration][r][c] gets a '*'
					// else board[whichGeneration][r][c] gets a ' '
					// (use an if else statement

				} // end of else for if (board[whichGeneration-1][r][c] == '*')
			} // end of inner for loop
		} // end of outer for loop
  	}
  }	// end of public void calculateGeneration(int whichGeneration)


  public int countNeighbors(int g, int r, int c)
  {
    //System.out.println("countNeighbors()");
  	int numNeighbors = 0;

  	// this only checks one position
  	// you can do all possible surrounding cells (8) or use a nested loop
  	// if you use nested loops, then remove the code below
  	/* if (isValid(r-1,c-1) &&  board[g][r-1][c-1] == '*')
  	{
  		numNeighbors++;
  	} */
  	// Finish Me!
  	// Do all other surrounding cells
  	// A loop would actually be better
  	// but don't count yourself

    for(int i = r-1; i <= r+1; i++)
    {
      for(int j = c-1; j<= c+1; j++)
      {
        try
        {
          //System.out.println("isValid(" + i + ", " + j + ")");
          if(isValid(i,j) && board[g][i][j] == '*')
          {
            numNeighbors++;
          }
          else
          {
            continue;
          }
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
      }
    }










  	// this prints out the number of neighbors for r=3 c=3
  	// check to see if you are doing it right!
	// this is to help you debug
  	if (r==3 && c==3)
  	{
  		System.out.println("for r=3 c=3 numNeighbors="+numNeighbors);
  	}


  	return numNeighbors;
  } // end of public int countNeighbors(int g, int r, int c)


  public boolean isValid(int r, int c)
  {
    if(r >= 0 && r < board[0].length && c >= 0 && c < board[0][r].length)
    {
      return true;
    }
    return false;
  } // end of public boolean isValid(int r, int c)


  public void displayGeneration(int whichGeneration)
  {
  	// board[whichGeneration][r][c]
  	// loop through all of the cells for this generation (whichGeneration)
	// remember:
	// board.length is the number of generations
	// board[whichGeneration].length is the number of rows for generation whichGeneration
	// board[whichGeneration][r] would be the number of columns for generation whichGeneration on row r

	for ( int r = 0; r < jButton.length; r++ )
	{
		for ( int c = 0; c < jButton[r].length; c++ )
		{
      if(isValid(r,c))
      {
  			jButton[r][c].setText(""+board[whichGeneration][r][c]);
      }
		}
	}
  	centerPanel.repaint();
  } // end of public void displayGeneration(int whichGeneration)


  public void clearBoard()
  {
  	// Finish Me!
	// clear the board (all generations)
	// set each element to a space character ' '
	// remember:
	// board.length is the number of generations (outer loop)
	// board[generation].length is the number of rows for generation generation
	// board[generation][r] would be the number of columns for generation generation on row r

  for ( int r = 0; r < board.length; r++ )
	{
		for ( int c = 0; c < board[r].length; r++ )
		{
      for(int gen = 0; gen < board.length; gen++)
      {
  			board[gen][r][c] = ' ';
      }
		}
	}




  } // end of public void clearBoard()


} // end of class GameOfLife
