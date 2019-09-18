import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;

class AddressBook extends JFrame implements ActionListener
{
    // the draw panel
    JPanel mainPanel = new JPanel();

	// the panels for the BorderLayout
	JPanel northPanel;
    JPanel southPanel;
    JPanel westPanel;
    JPanel eastPanel;
    JPanel centerPanel;


    // Menu Bar
	JMenuBar bar;

    // file menu
    JMenu     fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;


	// Record menu
	JMenu     recordMenu;
	JMenuItem firstItem;
	JMenuItem lastItem;
	JMenuItem previousItem;
	JMenuItem nextItem;

	//search menu
	JMenu searchMenu;
	JMenuItem idItem;
	JMenuItem nameItem;

	//textfields
	JTextField idTextField = new JTextField("");
	JTextField nameTextField = new JTextField("");
	JTextField streetTextField = new JTextField("");
	JTextField phoneTextField = new JTextField("");

	//labels
	// FINISH ME
	// create the JLabel objects for the ID, Name, Street, and Phone fields
	JLabel enterId      = new JLabel("ID");
	JLabel enterName    = new JLabel("Name");
	JLabel enterStreet  = new JLabel("Street");
	JLabel enterKeyword = new JLabel("Phone");

	//buttons
	JLabel fillerButton1 = new JLabel("           ");
	JLabel fillerButton2 = new JLabel("           ");
	JLabel fillerButton3 = new JLabel("           ");
	JLabel fillerButton4 = new JLabel("           ");
	JLabel fillerButton5 = new JLabel("           ");
	JLabel fillerButton6 = new JLabel("           ");

	JButton addButton;
	JButton clearButton;
	JButton firstButton;
	JButton previousButton;
	JButton nextButton;
	JButton lastButton;


	// an array list to hold all the person objects
	ArrayList<Person> list;

	// variable to show the index position of what Person
	// object is showing on the screen
	// -1 indicates that no records are available
	int pos = -1;

	boolean saved = true;


	// constructor
    public AddressBook()
	{
		// FINISH ME
		super("Address Book");


		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FINISH ME
        // create a new JPanel for each reference variable (no parameters)
    	northPanel = new JPanel();
    	southPanel = new JPanel();
    	westPanel = new JPanel();
    	eastPanel = new JPanel();
    	centerPanel = new JPanel();


		// create layout managers for the panels
        BorderLayout b1 = new BorderLayout();
        mainPanel.setLayout(b1);

        GridLayout eastLayout = new GridLayout(5,1);
        eastPanel.setLayout(eastLayout);

        GridLayout centerLayout = new GridLayout(4,2);
        centerPanel.setLayout(centerLayout);

        GridLayout westLayout = new GridLayout(5,1);
        westPanel.setLayout(westLayout);

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        southPanel.setLayout(fl);
        northPanel.setLayout(fl);


        // FINISH ME
        // create (new) each JButton for Add, Clear, First, Previous, Next, and Last
		addButton = new JButton("Add");
		clearButton = new JButton("Clear");
		firstButton = new JButton("First");
		previousButton = new JButton("Previous");
		nextButton = new JButton("Next");
		lastButton = new JButton("Last");

        // FINISH ME
        // call the addActionListener method for each button
        // and pass it this
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        firstButton.addActionListener(this);
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);
        lastButton.addActionListener(this);


		// FINISH ME
        // create the menu bar (JMenuBar())
        bar = new JMenuBar();


		// FINISH ME
        // create the menus
        fileMenu = new JMenu("File");

        recordMenu = new JMenu("Record");

        searchMenu = new JMenu("Search");




        // **** create the menu items
        // file menu items

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);

        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);


        // mode menu items
        firstItem = new JMenuItem("First");
        firstItem.addActionListener(this);

        lastItem = new JMenuItem("Last");
        lastItem.addActionListener(this);

        previousItem = new JMenuItem("Previous");
        previousItem.addActionListener(this);

        nextItem = new JMenuItem("Next");
        nextItem.addActionListener(this);


        // search menu items
        idItem = new JMenuItem("By ID");
        idItem.addActionListener(this);

        nameItem = new JMenuItem("By Name");
        nameItem.addActionListener(this);


        // **** add menu items to the menus
        // fileMenu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // record Menu
        recordMenu.add(firstItem);
        recordMenu.add(lastItem);
        recordMenu.add(previousItem);
        recordMenu.add(nextItem);

        // search Menu
        searchMenu.add(idItem);
        searchMenu.add(nameItem);

        // **** add the menus to the bar
        bar.add(fileMenu);
        bar.add(recordMenu);
        bar.add(searchMenu);

        // **** set the bar to be the menu bar
        setJMenuBar(bar);


        centerPanel.add(enterId);
        centerPanel.add(idTextField);


        centerPanel.add(enterName);
        centerPanel.add(nameTextField);


        centerPanel.add(enterStreet);
        centerPanel.add(streetTextField);


        centerPanel.add(enterKeyword);
        centerPanel.add(phoneTextField);


        // FINISH ME
        // add all of the buttons to the southPanel
        // addButton, clearButton, firstButton, previousButton, nextButton, lastButton

        southPanel.add(addButton);
        southPanel.add(clearButton);
        southPanel.add(firstButton);
        southPanel.add(previousButton);
        southPanel.add(nextButton);
        southPanel.add(lastButton);

        // add your name
        northPanel.add(new JLabel("Address Book by Neo Wang"));


        for (int i=1; i<=5; i++)
        {
        	eastPanel.add(fillerButton1);
        	westPanel.add(fillerButton1);
        }

         // add each panel to the mainPanel
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        mainPanel.add(eastPanel,BorderLayout.EAST);
        mainPanel.add(westPanel,BorderLayout.WEST);
		mainPanel.add(centerPanel,BorderLayout.CENTER);


        // create the list (empty for now)
        // FINISH ME
        // create a new ArrayList of Person objects
 		list = new ArrayList<Person>();


 		pos = -1; // no Person objects have been loaded yet


 		// disable all of the input fields on the screen
 		enablePersonFieldsOnScreen(false);

		setContentPane(mainPanel);
        setVisible(true);
    }


    public static void main(String[] args)
	{
		AddressBook ab = new AddressBook();
	}

    public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();

		if (source == exitItem)
		{
			System.exit(0);

		}

		else if (source == addButton)
		{
			if (pos != -1)
			{
				// copy all input fields to our ArrayList
				updateArrayListFromScreen();
			}

			// now create a new Person object and add them
			// to the end of the list
			// the fields of the Person object will all be empty ("")
			pos++;
			Person person = new Person(nameTextField.getText(),idTextField.getText(), streetTextField.getText(),phoneTextField.getText());


			// FINISH ME
			// add this person object to our list
			list.add(person);

      System.out.println("Added : " + person);


			// copy this person's fields to the input fields
			displayPersonOnScreen();


			enablePersonFieldsOnScreen(true);
			saved = false;
		}

		// handle opening of a file
		else if (source == openItem)
		{
			// FINISH ME

			// read in all the Person data from a disk file
			// call openFile()

      openFile();

      if(list.size() > 0)
      {
        pos = 0;
        displayPersonOnScreen();
        enablePersonFieldsOnScreen(true);
      }


			// if you found at least one person in the file (if (list.size() > 0) )
			// then
			// set pos to 0
			// and call displayPersonOnScreen();
			// and call enablePersonFieldsOnScreen(true);
		}


		else if (source == clearButton)
		{
			// FINISH ME
			// clear all of the input fields on the screen
			// call each input field's setText method (pass it "")

      idTextField.setText("");
      phoneTextField.setText("");
      streetTextField.setText("");
      nameTextField.setText("");

		}

		else if (source == firstItem || source == firstButton)
		{
			// you can show message dialog boxes as you are debugging
			// to help you trace your logic
			// or use System.out.println to display messages on the
			// console
			// JOptionPane.showMessageDialog(this,"Heh, you clicked firstButton.");

			if (list.size()==0) // nothing to do, we don't have any persons
				return;

			if (pos == 0)
				return;

			// copy all input fields to our ArrayList
			updateArrayListFromScreen();

			// now move to the first Person
			pos = 0;

			// display the new Person on the screen
			displayPersonOnScreen();

		}

		else if (source == nextItem || source == nextButton)
		{
			// you can show message dialog boxes as you are debugging
			// to help you trace your logic
			// or use System.out.println to display messages on the
			// console
			// JOptionPane.showMessageDialog(this,"Heh, you clicked nextButton.");
			if (list.size()==0)
				return;
			if (pos >= list.size()-1)
				return;

			// copy all input fields to our ArrayList
			updateArrayListFromScreen();

			// now move to the next Person
			pos++;

			// display the new Person on the screen
			displayPersonOnScreen();

		}

		else if (source == previousButton)
		{
			if (list.size()==0)
				return;
			if (pos == 0)
				return;

      updateArrayListFromScreen();
      pos--;

      displayPersonOnScreen();

			// FINISH ME
			// copy all input fields to our ArrayList
			// call a method


			// FINISH ME
			// now move to the previous Person


			// FINISH ME
			// display the new Person on the screen
			// call a method



		}





		// FINISH ME
		// handle all other buttons and menu items
		else if (source == nameItem)
		{
			System.out.println("Inside nameItem");
			if (list.size()==0)
				return;

			// copy all input fields to our ArrayList
			updateArrayListFromScreen();

			// pop up a JOptionPane and have them enter
			//    the name of the person to search for
			String s = JOptionPane.showInputDialog(this,"Enter the name to search for ");

			if (s == null)  // the user pressed the escape key
			{
				return;
			}
      //int pos = -1;

      for(int i = 0; i < list.size(); i++)
      {
        if(s.equals(list.get(i)))
        {
          pos = i;
          break;
        }
      }

			// now search here
			// loop through all of the records
			// find the pos of the one that you want to
			//    display and set the pos =



			// display the new Person on the screen
			displayPersonOnScreen();

		}
    else if(source == saveItem)
    {
      saveFile();
    }





	} // end of actionPerformed method


	public void updateArrayListFromScreen()
	{
		Person person = list.get(pos);


		// FINISH ME
		// copy all of the data in the input fields to the ArrayList
		// object referred to by person

		person.setId(idTextField.getText());
    person.setName(nameTextField.getText());
    person.setPhone(phoneTextField.getText());
    person.setAddress(streetTextField.getText());




	}


	public void openFile()
	{
		// first we clear the list of Person objects
		list.clear();

        try{
		// open the file
		// You can use the Scanner class to read in the data
		Scanner scan = new Scanner(new File("persons.dat"));


		// read in all of the Person data from the file "persons.dat"
		// into a Person object
		// you will need to use a loop and build new Person objects each time
		// and then add the person to the list ArrayList

		while (scan.hasNext())
		{
			// read in each data element from the file

      String[] yoov = scan.nextLine().split(" ");

      list.add(new Person(yoov[0],yoov[1],yoov[2],yoov[3]));


			// build (create) a new Person object with the data


			// add the person object to the ArrayList list

		}




		// close the file





		pos = 0;


		// update the screen
		// call a method

        }

        catch(Exception e)
        {
            System.out.println("error");
            e.printStackTrace();
        }

	}



	public void saveFile()
	{
		// save the file

		try
    	{
      		FileWriter fw = new FileWriter("persons.dat");
      		BufferedWriter bw = new BufferedWriter(fw);

	  	  	// FINISH ME
	  	  	// we will be moving through (traversing) all person objects
	  	  	// in our list
      		for (int j = 0; j < list.size(); j++)
      		{
      			// FINISH ME
      			// write each Person object to the file
        		bw.write(list.get(j).getName() + " " + list.get(j).getId() + " " + list.get(j).getAddress() + " " + list.get(j).getPhone());
        		bw.newLine();
        		// write all the other fields to the file
      		}

      		bw.close();  // closes the file
    	}
    	catch (IOException e1)
    	{
        	System.out.println("Error writing Data");
    	}
    	catch (Exception e2)
    	{
        	System.out.println("Error writing Data");
    	}


	}


	public void displayPersonOnScreen()
	{
		if (pos<0)
			return;

		// pos is the index of the ArrayList item that
		// we want to copy to the screen input fields
		idTextField.setText(list.get(pos).getId());
    nameTextField.setText(list.get(pos).getName());
    phoneTextField.setText(list.get(pos).getPhone());
    streetTextField.setText(list.get(pos).getAddress());

		// FINISH ME
		// call the setText() method for all of the input fields on the screen


	}

	public void clearAllPersonFieldsOnScreen()
	{
		// FINISH ME
		// clear all the input fields on the screen
		// by calling the setText method of each input fields

    idTextField.setText("");
    nameTextField.setText("");
    phoneTextField.setText("");
    streetTextField.setText("");
	}

	public void enablePersonFieldsOnScreen(boolean value)
	{
		// FINISH ME
		// call the setEnabled method for all input fields on the screen
		// and pass to it value
		idTextField.setEnabled(value);
    nameTextField.setEnabled(value);
    phoneTextField.setEnabled(value);
    streetTextField.setEnabled(value);


	}

}


// class person
class Person implements Comparable
{
	String name;
	String id;
	String address;
	String phone;

	public Person(String name, String id, String address, String phone)
	{
		// FINISH ME
		// copy all input parameters to the instance variables

    this.name = name;
    this.id = id;
    this.address = address;
    this.phone = phone;


	}

	// implement the one method in interface Comparable
	public int compareTo(Object obj)
	{
		Person p = (Person) obj;

    return (this.id.compareTo(p.getId()));

		// FINISH ME
		// we will compare by the id
		// return a negative number if this person is less than person p
		// return a positive number if this person is greater than person p
		// return 0 if this person is the same as person p



	}


    // override the method equal in Object
	public boolean equal(Object obj)
	{
		Person p = (Person) obj;

    return this.id.equals(p.id);

		// FINISH ME
		// return true if this person has the same id as person p



	}


	public String toString()
	{
		// FINISH ME

    return ("Name: " + name + " ID: " + id + " Address: " + address + " Phone: " + phone);
	}

	public void setName(String name)
	{
		// FINISH ME

    this.name = name;
	}

	public String getName()
	{
		// FINISH ME
    return name;

	}

	public void setId(String id)
	{
		// FINISH ME

    this.id = id;
	}

	public String getId()
	{
		// FINISH ME
    return id;

	}

	public void setAddress(String address)
	{
		// FINISH ME

    this.address = address;
	}

	public String getAddress( )
	{
		// FINISH ME
    return address;
	}

	public void setPhone(String phone)
	{
		// FINISH ME

    this.phone = phone;
	}

	public String getPhone( )
	{
		// FINISH ME

    return this.phone;
	}

    // class which knows how to compare two Persons
    class ComparePersons implements Comparator
    {
      	public int compare(Object p1, Object p2)
      	{
      		return ((Person)p1).compareTo(p2);
      	}
    }

}
