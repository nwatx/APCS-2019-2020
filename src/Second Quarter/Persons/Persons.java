
// This program gets data in the form of a single
// String for each person.  The String that holds
// the data for a person has spaces to separate
// the name, street, city, and state.
// The name starts in position 0 of the String.
// The street starts in position 20 of the String.
// The city starts in position 50 of the String.
// The state starts in position 70 of the String.
// an example of the data is shown below.
// The name is always first space last
// "Tom Smart           7843 Lamar Bldv               Austin              Texas"


import java.util.*;
import java.io.*;



// Write the header for the Persons class (make it public)
public class Persons
{


	public static void printPersons(ArrayList<Person> persons)
	{
		// FINISH ME
		// print out each person in the following format:
		// Person 1
		// First Name: xxxxx
		// Last Name:  xxxxx
		// Address:    xxxxx xxxx
		// City:       xxxxx
		// State:      xxxxx

    for(int i = 0; i < persons.size(); i++)
    {
      System.out.println("Person " + i);
      System.out.println("First Name: " + persons.get(i).getName());
      System.out.println("Last Name: " + persons.get(i).getLastName());
      System.out.println("Address: " + persons.get(i).getCity() + " " + persons.get(i).getState());
      System.out.println("City: " + persons.get(i).getCity());
      System.out.println("State: " + persons.get(i).getState());
    }


	}


	public static void printPersons2(ArrayList<Person> persons)
	{
		// print out each person in persons
		// by calling the toString() method of each
		// Person object
		// i.e. loop through all of the persons

    for(int i = 0; i < persons.size(); i++)
    {
      System.out.println(persons.get(i));
    }

	}


	public static void main(String [] args)
	{
		System.out.println();


		// FINISH ME
		// put your name on this
		System.out.println("My name is Neo Wang");
		System.out.println();
		System.out.println();



		// FINISH ME
		// create an ArrayList of Person objects
		ArrayList<Person> persons = new ArrayList<Person>();



		persons.add(new Person("Tom Smart           7843 RAM Bldv                 Austin              Texas"));
		persons.add(new Person("Sue Baker           6579 CPU Ave.                 Austin              Texas"));
		persons.add(new Person("Ali Adams           6523 CompSci St.              Austin              Texas"));



		System.out.println("Here are the persons in the list");

		// FINISH ME
		// call the printPersons method to print out
		//    all of the persons (pass it persons)
		printPersons(persons);


		System.out.println();
		System.out.println();

		persons.get(0).setName("Tommy Bright");
		persons.get(0).setStreet("Star Street");
		persons.get(0).setCity("Lansing");
		persons.get(0).setState("Michigan");


		System.out.println("Here are the persons in the list");

		// FINISH ME
		// call the printPersons method to print out
		//    all of the persons (pass it persons)
		printPersons(persons);

		System.out.println();
		System.out.println();

		System.out.println("Here are the persons in the list");
		printPersons2(persons);

		System.out.println();
		System.out.println();
	}

} // end of class Persons



// an interface for class Person
interface PersonInterface
{
	public abstract String getName();

	public abstract String getFirstName();

	public abstract String getLastName();

	public abstract String getStreet();

	public abstract String getCity();

	public abstract String getState();


	public abstract void setName(String name);

	public abstract void setStreet(String street);

	public abstract void setCity(String city);

	public abstract void setState(String state);

} // end of interface PersonInterface



// FINISH ME
// Write the header for the Person class
// The Person class should implement PersonInterface
// (do NOT make it public, just say class ...)
class Person implements PersonInterface
{
	// FINISH ME
	// define 4 instance variables, all of type String
	// the names should be: name, street, city, and state
	// DO NOT ADD ANY OTHER instance variables

  String name;
  String street;
  String city;
  String state;


	// FINISH ME
	// write your init constructor for Person here
	// it should have only 1 parameter, a String
	// that holds the name, street, city, and state
	public Person (String s)
	{
		// FINISH ME
		// initialize the four instance variables
		// with the correct data from the String parameter
		// The name starts in position 0 of the String.
		// The street starts in position 20 of the String.
		// The city starts in position 50 of the String.
		// The state starts in position 70 of the String.
		// you can use s.substring(?,?) to dig out the
		//    the correct data and then trim() it.

    name = s.substring(0,20).trim();
    street = s.substring(20,50).trim();
    city = s.substring(50,70).trim();
    state = s.substring(70,s.length()).trim();

	}


	// FINISH ME
	// implement your interface methods (PersonInterface)
	// put your methods below


  public String getName()
  {
    return name;
  }

  public String getFirstName()
  {
    String[] thing = name.split(" ");
    return thing[0];
  }

  public String getLastName()
  {
    String[] thing = name.split(" ");
    return thing[thing.length - 1];
  }

  public String getStreet()
  {
    return street;
  }

  public String getCity()
  {
    return city;
  }

  public String getState()
  {
    return state;
  }


  public void setName(String name)
  {
    this.name = name;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  public String toString()
  {
    return "Name: " + name + " Street: " + street + " City: " + city + " State: " + state + " ";
  }

} // end of class Person
