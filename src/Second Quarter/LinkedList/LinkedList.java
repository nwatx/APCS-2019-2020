
import static java.lang.System.*;

public class LinkedList
{
	// instance variables (attributes, properties, global)
	private LinkedNode first;
	private LinkedNode last;


	// default constructor
	public LinkedList( )
	{
		// FINISH ME
		// we do not have any objects,
		// so first and last should both
		// be set to null
    first = null;
    last = null;
	}

	// if letter exists in some node,
	// then the count is incremented by 1
	// otherwise, a new LinkedNode object is created
	// to hold this letter, and the count is set to 1
	public void add(char letter)
	{
		if (first == null)
		{
			first = new LinkedNode(letter);
			last  = first;
			return;
		}

		LinkedNode current = indexOf(letter);

		if (current == null) // the letter does not exist
		{
			LinkedNode newLastNode = new LinkedNode(letter);
      last.setNextLinkedNode(newLastNode);
      last = newLastNode;

		}
		else // the letter does exist
		{
      current.incrementCount();
		}

	}

	public LinkedNode indexOf(char letter)
	{
		// returns the memory address of the LinkedNode
		// that holds the letter or null if the letter
		// does not exist



		LinkedNode current = first;

		while(current != null)
		{
      if(current.getLetter() == letter)
      {
        break;
      }

      current = current.getNextLinkedNode();
		}

		return current;

	}




	public String toString()
	{
		String output = "[";

		LinkedNode current = first;

		while(current != null)
		{
			// FINISH ME
			// get the letter and count of the current
			// LinkedNode object
			// uncomment and
			// replace the ??? below
			// output = output + ??? + "-" + ???;
      output = output + current.getLetter() + "-" + current.getCount();

			if (current.getNextLinkedNode() == null)
			{
				output += "]";
			}
			else
			{
				output += ", ";
			}

      current = current.getNextLinkedNode();
		}

		// return the output String
		return output;
	}
}
