
public class LinkedNode
{
	// instance variables (attributes, properties, fields, global variables)


	// the letter that we are counting
	private char       letter;

	// how many of these letters do we have
	private int        count;

	// reference (memory address) of next LinkedNode
	private LinkedNode nextLinkedNode;




	// init constructor
	public LinkedNode(char letter)
	{
		// FINISH ME
		// store the letter, set the count to 1,
		// and the pointer to null
		this.letter    = letter; // change me ???
		count          = 1;  // change me ???  How many do letters have we found so far?
		nextLinkedNode = null;
	}


	public char getLetter()
	{
		// FINISH ME
		// return the letter
		return letter; // change me ???
	}


	public int getCount()
	{
		// FINISH ME
		return count; // change me ???
	}


	public void incrementCount()
	{
		// FINISH ME
		// increment the count by 1
		// ???

    count++;
	}


	public LinkedNode getNextLinkedNode()
	{
		// FINISH ME
		// returns the memory address of the nextLinkedNode
		return nextLinkedNode; // change me ???
	}


	public void setNextLinkedNode(LinkedNode nextLinkedNode)
	{
		// FINISH ME
		// store the memory address of the nextLinkedNode
		// nextLinkedNode should hold the memory address
		// ???

    this.nextLinkedNode = nextLinkedNode;
	}
}
