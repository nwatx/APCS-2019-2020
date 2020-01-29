
import static java.lang.System.*;


// FINISH ME
// first get it working without the interface
// once the basics work, then uncomment the
// implements statement and implement all of the
// methods in the interface

public class LinkedList // implements LinkedListInterface
{
	// instance variables (attributes, properties, fields, global)
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

	public LinkedNode get(int index)
	{
		LinkedNode copy = first;
		for(int i = 0; i < index; i++)
		{
			copy = copy.getNext();
		}

		return copy;
	}

	public Student peek()
	{
		return first.getStudent();
	}

	public Student getFirst()
	{
		return first.getStudent();
	}

	public void addFirst(Student student)
	{
		first = new LinkedNode(null, student, first);
	}

	public void addLast(Student student)
	{
		last = new LinkedNode(last, student, null);
	}

	public Student remove()
	{
		Student output = first.getStudent();
		first = first.getNext();
		return output;
	}

	public void remove(int a)
	{
		LinkedNode b = first;
		for(int i = 0; i < a; i++)
		{
			b = b.getNext();
		}

		b.getPrevious().setNext(b.getNext());


	}

	public void push(Student a)
	{
		last = new LinkedNode(last, a, null);
		last.getPrevious().setNext(last);
	}

	public Student deque()
	{
		/* LinkedNode a = first;

		while(a != null)
		{
			 a = a.getPrevious();
		}

		return a.getStudent(); */

		return first.getStudent();
	}

	public void enque(Student a)
	{
		push(a);
	}

	public LinkedNode removeLast()
	{
		LinkedNode output = last;
		last = last.getPrevious();
		//last.setNext(null);
		//System.out.println("YEA EYA EAYEYA " + last);
		return output;
	}

	public LinkedNode pop()
	{
		return removeLast();
	}

	public void removeFirst()
	{
		first = first.getNext();
	}

	public LinkedNode getLast()
	{
		return last;
	}

	public void clear()
	{
		first = null;
		last = null;
	}

	public boolean isEmpty()
	{
		return ((first == null) && (last == null));
	}


	// creates a new LinkedNode object containing student
	// and puts it at the end of the list
	public void add(Student student)
	{
		LinkedNode node = new LinkedNode(null, student, null);

		if (first == null) // the list is empty
		{
			// FINISH ME
			// point first and last to node
			// i.e. first should refer to node
			// and last should refer to node

			first = node; // change me ???
			last  = node; // change me ???
			return;
		}

		// add the node to the end of the list


		// FINISH ME
		// point last.next to where node is pointing
		// call a method (it's private)

    last.setNext(node);


		// FINISH ME
		// point node.previous to where last is pointing
		// call a method (it's private)

    node.setPrevious(last);

		// FINISH ME
		// now point last to where node is pointing
    last = node;

	}


	// returns the number of elements in the list
	public int size()
	{
		if (first == null)
		{
			return 0;
		}

		// FINISH ME
		// current should point to where first is pointing
		LinkedNode current = first; // change me ???

		int count = 0;


		while(current != null)
		{
			// FINISH ME
			// add 1 to your count
      count++;

			// FINISH ME
			// make current refer to the next LinkedNode
      current = current.getNext();
		}


		// FINISH ME
		// return the count
		return count;  // change me ???

	}




	public String toString()
	{
		if (isEmpty())
		{
			return "[]";
		}

		String output = "[";

		LinkedNode current = first;

		while(current != null)
		{
			// FINISH ME
			// replace the ??? below so that
			// we show the student's info from the
			// toString() method
			output = output + current.toString();


			// FINISH ME
			// see if the next field is null
			if (current.getNext() == null)
			{
				// we are on the last node of the list
				// so we will add the "]" to our output
				output += "]";
			}
			else
			{
				// we are NOT on the last node of the list
				// so we will add the ", " to our output
				output += ", ";
			}


			// FINISH ME
			// make current refer to the next object
			// uncomment the line below
			current = current.getNext();
		}

		// FINISH ME
		// return the output String
		return output; // change me
	}
}
