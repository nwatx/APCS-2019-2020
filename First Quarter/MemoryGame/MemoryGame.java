// what you need to do:
// 1) finish all of the finish me lines
// 2) get ?? (36 or change the size smaller) icons and resize slightly smaller
// 3) EC play sad music when you miss, happy music when you guess right
// 4) EC EC play against the computer with levels



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
import sun.audio.AudioPlayer;

public class MemoryGame extends JFrame implements ActionListener,Runnable
{

  // thread for the animation
  Thread runThread = null;

  int threadDelay = 150;  // the paintComponent method will be called every 150 milliseconds

  // this will be the amount of time the 2 overturned pics will show before flipping back
  int totalTimeToShowPieces = 1500;


  boolean debugMode = true;


  int clickCount = 0; // which click, 1st to mark a spot, 2nd to swap an item

  // r,c value for 1st and 2nd click
  int click1r = -1;
  int click1c = -1;
  int click2r = -1;
  int click2c = -1;
  String data1; // filename of click1r,click1c item
  String data2; // filename of click2r,click2c

  int player;   // 1 or 2   // maybe play against the computer
  int scorePlayer1;
  int scorePlayer2;

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

  // define buttons
  MyButton [][] button;    // to hold image and to click on
  int rows;
  int cols;

  JButton      startButton;
  JButton      scoreButton;
  JButton      cancelButton;
  JButton      playerButton;

  JLabel       titleLabel; // for top JPanel (northPanel)

  boolean      gameIsPlaying; // is a game in progress

  ArrayList <String> itemsList;  // list of board items (in pairs of two) filenames to start with
  ArrayList <String> pics;  // current list of items on the board



  // ***** public void initialize *****

  public void initialize( )
  {
  	rows = 4;
  	cols = 4;

  	gameIsPlaying = false;
  	player = 1;
  	scorePlayer1 = 0;
  	scorePlayer2 = 0;

  	scoreButton = new JButton("Score= 0   0");
  	cancelButton = new JButton("Cancel");
   	playerButton = new JButton("Player = 1");

  	clickCount = 0;

  	data1 = "";
    click1r = -1;
    click1c = -1;

    data2 = "";
    click2r = -1;
    click2c = -1;

  	// this is the list of filenames

  	itemsList = new ArrayList<String>();  // list of all items (filenames)

  	// add all of your items filenames to the list (in pairs)
  	// the files must be in the same folder as MemoryGame.java

  	// FINISH ME
  	// add 36 icons or change the size downward (but not too low)

  	// etc.

    for(int i = 0; i < 2; i++)
    {
      itemsList.add("blue.png");
      itemsList.add("red.png");
      itemsList.add("purple.jpg");
      itemsList.add("green.png");
      itemsList.add("creeper.jpg");
      itemsList.add("tnt.jpg");
      itemsList.add("dirt.png");
      itemsList.add("glowstone.jpg");
    }

    Collections.shuffle(itemsList);


  	// shuffle the list do this when you are all done testing
  	//Collections.shuffle(itemsList);


  	pics = new ArrayList<String>();  // items to start our game


  	// we will need to add all of the pics to our screen and later to our board

  	int x = -1;
  	for (int r=0; r<rows; r++)
  	{
  		for (int c=0; c<cols; c++)
  		{
  			x++;
  			if (x < itemsList.size())
  			{
  				String filename = itemsList.get(x);
  				pics.add(filename);
  			}
  			else
  			{
  				String filename = itemsList.get(0);
  				pics.add(filename);
  				System.out.println("Not enough pics");
  			}
  		}
  	}





    // create a mainPanel for components
    mainPanel = new JPanel();

    // ***** assignments for menu variables *****

    menuBar            = new JMenuBar();


    // FINISH ME
    // create the fileMenu and exitMenuItem
    fileMenu           = new JMenu();
    exitMenuItem       = new JMenuItem();


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
    centerPanel.setLayout(new GridLayout(rows,cols,10,10));

    northPanel.setBackground(new Color(115,205,255));
    southPanel.setBackground(new Color(115,205,255));
    westPanel.setBackground(new Color(115,205,255));
    eastPanel.setBackground(new Color(115,205,255));


  	button = new MyButton[rows][cols];

  	x = -1;
  	for (int r=0; r<rows; r++)
  	{
  		for (int c=0; c<cols; c++)
  		{
  			x++;
  			if (x<pics.size())
  			{
				button[r][c] = new MyButton(pics.get(x),r,c);
				button[r][c].addActionListener(this);
				centerPanel.add(button[r][c]);
  			}
  			else
  			{
				button[r][c] = new MyButton(pics.get(0),r,c);
				button[r][c].addActionListener(this);
				centerPanel.add(button[r][c]);
  			}
  		}
  	}



  	// FINISH ME
  	// create a new JLabel with a parameter of "The Memory Game by first last"
	// put your first name and last name on it
    titleLabel = new JLabel("The Memory Game by Neo Wang");

	Font font = new Font("Courier New",Font.BOLD,24);
    titleLabel.setFont(font);
	northPanel.add(titleLabel);

	// FINISH ME
	// create a JButton with the text "New Game"
	startButton = new JButton("New Game");

	font = new Font("Courier New",Font.BOLD,24);
	startButton.setFont(font);
	startButton.addActionListener(this);
	southPanel.add(startButton);

	// scoreButton.addActionListener(this);
	southPanel.add(playerButton);
	southPanel.add(scoreButton);
	cancelButton.addActionListener(this);
	southPanel.add(cancelButton);

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

  public MemoryGame( )
  {
    // initialize variables

    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // FINISH ME
    // call the JFrame's setTitle method and set it to "The Memory Game by first last"
    setTitle("The Memory Game by Neo Wang");


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
    else if (source == startButton)
    {
    	// clear the board, buttons, etc.
    	clickCount = 0;
    	scorePlayer1 = 0;
    	scorePlayer2 = 0;

		clearBoard();

    	setToPlayer1();

		updateScoreOnScreen();

     	gameIsPlaying = true;

    }  // end of if (source == startButton)

    else if (source == cancelButton)
    {
    	resetClickInfo();
    }
    else
    {
     if (!gameIsPlaying)
     {
     	JOptionPane.showMessageDialog(this,"You must start a new game!");
     	return;
     }

     if (runThread != null)
     {
     	// get out, we have to wait for the timer to end
     	return;
     }


     //if(player == 1)
     //{
       for (int r=0; r<rows; r++)
    	 {
    		for (int c=0; c<cols; c++)
    		{
  			if (source == button[r][c])
  			{
  				if (button[r][c].isPlayedOn())
  				{
  					return;
  				}

  				System.out.println("inside source =");
  				clickCount++;

  				if (clickCount == 1)
  				{
  					// 1st item to compare with
  					// so remember its location
  					System.out.println("click 1");

  					// FINISH ME
  					// get the r,c button's data
  					data1 = button[r][c].getData();


  					// FINISH ME
  					// set the button's hidden property to false
  					// and the button's playedOn property to true
  					button[r][c].setHidden(false);
  					button[r][c].setPlayedOn(true);


  					// now we save the click info
  					click1r = r;
  					click1c = c;
  					click2r = -1;
  					click2c = -1;


  					centerPanel.repaint();
  					return;
  				}

  				else if (clickCount == 2)
  				{
  					// 2nd item to compare with
  					// so remember its location and do a equals
  					// if it does result in an equals leave both items turned over
  					// else have a thread turn them back over after a certain amount of time has happened

  					System.out.println("click 2");


  					// FINISH ME
  					// get the r,c button's data
  					data2 = button[r][c].getData();


  					// FINISH ME
  					// set the button's hidden property to false
  					// and the button's playedOn property to true
  					button[r][c].setHidden(false);
  					button[r][c].setPlayedOn(true);


  					// now we save the click info
  					click2r = r;
  					click2c = c;


  					// these are the items to compare
  					String dataTemp1 = button[click1r][click1c].getData();
  					String dataTemp2 = button[click2r][click2c].getData();

  					// FINISH ME
  					if (dataTemp1.equals(dataTemp2))
  					{
  						// if they are the same then we do this
  						System.out.println("valid compare");

  						button[click1r][click1c].setHidden(false);
  						button[click2r][click2c].setHidden(false);

  						// maybe play some happy music clip
              try
              {
                InputStream in = new FileInputStream("happy.au");
                AudioStream as = new AudioStream(in);
                AudioPlayer.player.start(as);
              }
              catch(Exception ex)
              {
                ex.printStackTrace();
              }

  						// add to the current player's score
  						if (player == 1)
  						{
  							scorePlayer1++;
  						}
  						else
  						{
  							scorePlayer2++;
  						}


  						// FINISH ME
  						// call updateScoreOnScreen
  						// ???;

              updateScoreOnScreen();


  						// see if the game is over
  						if (checkForWinner()==1)
  						{
  							// FINISH ME
  							// update screen with player 1 being the winner
  							// set the titleLabel's text to Player 1 is the winner!!!!!!!
  							titleLabel.setText("Player 1 is the winner!!!!!");
  							return;
  						}
  						else if (checkForWinner()==2)
  						{
  							// FINISH ME
  							// update screen with player 2 being the winner
  							// set the titleLabel's text to Player 2 is the winner!!!!!!!
  							titleLabel.setText("Player 2 is the winner!!!!!");
  							return;
  						}
  						else if (checkForWinner()==3)
  						{
  							// FINISH ME
  							// update screen with a tie
  							// set the titleLabel's text to Tie Game!!!!!!!
  							titleLabel.setText("Tie game!!!!!");
  							return;
  						}


  						// FINISH ME
  						// change players - call the changePlayers method
    					changePlayers();

  						resetClickInfo();
  					}
  					else
  					{
  						// it was NOT an equals

  						// start the timer and time it
  						// maybe play some sad music clip

              try
              {
                InputStream in = new FileInputStream("sad.au");
                AudioStream as = new AudioStream(in);
                AudioPlayer.player.start(as);
              }
              catch(Exception ex)
              {
                ex.printStackTrace();
              }
  						// we will change players at the end of the thread run, but NOT here
  						startStopTheThread(true);

  					}


  					centerPanel.repaint();

  					return;
  				}

  				resetClickInfo();
  			}

    		}
    	 }
    // }
     /* else
     {
       System.out.println("Player 2 turn");
       int row;
       int col;
       do {
         row = (int)(Math.random() * 8);
         col = (int)(Math.random() * 9);

       } while (!button[row][col].isPlayedOn());

       button[row][col].setPlayedOn(true);
       button[row][col].setHidden(false);

       changePlayers();
       updateScoreOnScreen();
     } */
     // what cell got clicked





    } // end of else


  }  // end of actionPerformed


  public void changePlayers()
  {
  	if (player == 1)
  	{
  		// change to player = 2 and
  		// change the side colors to player 2 colors
  		setToPlayer2();
  	}
  	else
  	{
  		// change to player = 1 and
  		// change the side colors to player 1 colors
  		setToPlayer1();
  	}
  }


  public void setToPlayer1()
  {
  		player = 1;
	 	northPanel.setBackground(new Color(255,0,0));
     	westPanel.setBackground(new Color(255,0,0));
     	eastPanel.setBackground(new Color(255,0,0));
     	titleLabel.setForeground(Color.BLACK);
     	playerButton.setText("Player = 1");
     	playerButton.setBackground(Color.RED);
  }


  public void setToPlayer2()
  {
  		player = 2;
	 	northPanel.setBackground(new Color(255,255,0));
     	westPanel.setBackground(new Color(255,255,0));
     	eastPanel.setBackground(new Color(255,255,0));
     	titleLabel.setForeground(Color.BLACK);
     	playerButton.setText("Player = 2");
     	playerButton.setBackground(Color.YELLOW);
  }


  public void resetClickInfo()
  {
      data1 = "";
      click1r = -1;
      click1c = -1;

      data2 = "";
      click2r = -1;
      click2c = -1;

	  clickCount = 0;

	  System.out.println("click reset");
  }


  public void updateScoreOnScreen()
  {
  	 if (scoreButton != null)
	 	scoreButton.setText("Score= " + String.format("%2d",scorePlayer1) + "  " + String.format("%2d",scorePlayer2));
  }


  public void clearBoard()
  {
  	 resetClickInfo();

     titleLabel.setText("The Memory Game");
	 scoreButton.setText("Score= 0  0");


	 // we set all the buttons

	 // Collections.shuffle(pics);  // do this after debugging

	 int x=-1;
  	 for (int r=0; r<rows; r++)
  	 {
  		for (int c=0; c<cols; c++)
  		{
  			x++;
  			if (x < pics.size())
  			{
				button[r][c].setText("");
				button[r][c].setData(pics.get(x));
				button[r][c].setHidden(true);
        button[r][c].setPlayedOn(false);
  			}
  			else
  			{
  				button[r][c].setText("");
  				button[r][c].setData(pics.get(0));
  				button[r][c].setHidden(true);
  				System.out.println("NOT enough pics");
  			}
  		}
  	 }
	 northPanel.setBackground(new Color(115,205,255));
     westPanel.setBackground(new Color(115,205,255));
     eastPanel.setBackground(new Color(115,205,255));
     titleLabel.setForeground(Color.BLACK);
  }





  // ***** main method *****
  public static void main(String[] arguments)
  {
    MemoryGame game = new MemoryGame( );
  }


public void startStopTheThread(boolean start)
{
    if (start)
    {
    		runThread = null;

			runThread = new Thread(this); // the animation is inactive, so let's animate the move

			// start the thread to show the animation
			runThread.start();

	}
    else if (runThread != null) // they want to stop the animation
    {
			runThread.interrupt();
			runThread = null;
	}

}



// this is the Thread's loop that animates the move from
// position to position
public void run()
  {
  	  boolean loop = true;
   	  try
   	  {
   		if (debugMode)
   		{
   			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("+++ start timing ++++++++++++");
			System.out.println();
   		}

    	double time = 0;

   		while(loop)
   		{
   		    setFocusable(true);
		   	requestFocus();

		   	time += threadDelay;

		   	// FINISH ME
		   	// flash screen to show a delay
		   	// choose a random int between 0-255
		   	// call Math.random and multiply it by 256
		   	// do an int typecast on the result

		   	int red = (int)(Math.random() * 256);
		   	int green = (int)(Math.random() * 256);
		   	int blue = (int)(Math.random() * 256);
		   	northPanel.setBackground(new Color(red,green,blue));


		   	if (time >= totalTimeToShowPieces)
		   	{
		   		loop = false;
		   	}





			centerPanel.repaint();

		   	Thread.currentThread().sleep(threadDelay);



        } // end of while(true)
      }
      catch(Exception e)
      {
      	loop = false;
      	runThread = null;
      }
      loop = false;
      runThread = null;

	  // reset the cells so that they are hidden again
	  button[click1r][click1c].setHidden(true);
	  button[click2r][click2c].setHidden(true);
	  button[click1r][click1c].setPlayedOn(false);
	  button[click2r][click2c].setPlayedOn(false);

	  // FINISH ME
	  // call the changePlayers method
	  changePlayers();


	  // FINISH ME
	  // call the resetClickInfo method
	  resetClickInfo();

      if (debugMode)
      	System.out.println("Finished with delay");
  }


	public int checkForWinner()
	{
				if (scorePlayer1 + scorePlayer2 < 0.5*rows*cols)
					return 0;

    			if (scorePlayer1 > scorePlayer2)
				{
     				gameIsPlaying = false;

     				return 1;
				}
    			else if (scorePlayer2 > scorePlayer1)
				{
     				gameIsPlaying = false;


     				return 2;
				}
				else if (scorePlayer1 == scorePlayer2)
				{
     				gameIsPlaying = false;


     				return 3;

				}

				centerPanel.repaint();
				return 0;

	}



} // end of class MemoryGame



class MyButton extends JButton
{
	String data = "";  // filename of image
	String hiddenData = "cut.gif";  // filename if pic is not to show
	int row=0;
	int col=0;
	boolean hidden;
	boolean isPlayedOn;

	public MyButton(String s, int row, int col)
	{
		super("");
		this.row = row;
		this.col = col;
		setText("");
		data = s;
		hidden = true;
		isPlayedOn = false;
	}


	public void setData(String data)
	{
		// FINISH ME
		this.data = data;
	}

	public String getData()
	{
		// FINISH ME
		return data;
	}

	public void setHidden(boolean value)
	{
		// FINISH ME;

    hidden = value;
	}

	public boolean isHidden()
	{
		// FINISH ME
		return hidden;
	}

	public void setPlayedOn(boolean value)
	{
		isPlayedOn = value;
	}

	public boolean isPlayedOn()
	{
		return isPlayedOn;
	}

    public void paintComponent(Graphics window)
    {
		super.paintComponent((Graphics2D)window);
		Graphics2D g2 = (Graphics2D) window;

		if (hidden)
		{
			ImageIcon img = new ImageIcon(hiddenData);
			setIcon(img);
		}
		else
		{
			ImageIcon img = new ImageIcon(data);
			setIcon(img);
		}

    }  // end of method paintComponent

}
