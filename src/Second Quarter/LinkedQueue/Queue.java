
// Extra Credit
// make your own Queue class and support Queue methods
// You should use your LinkedList class but change it's
// name to Queue and use an interface with the following
// abstract methods.

import static java.lang.System.*;

public class Queue <T> // a generic type
{
	// instance variables
	// also known as attributes, properties, fields, global variables
	private QueueNode <T> first;
	private QueueNode <T> last;


	// default constructor
	public Queue(T object )
	{
		// FINISH ME
		// we do not have any objects,
		// so first and last should both
		// be set to null
    first = null;
    last = null;
	}


	// adds an object to the end of the list
	public void enque(T object)
	{
		if (first == null)
		{
			// FINISH ME
			// create a new QueueNode and point both
			// first and last to the new QueueNode
			// i.e. first should refer to the QueueNode object
			// and last should refer to the QueuNode object
			first = new QueueNode(object);
			last  = first;
			return;
		}

		// add to the end of the queue


		// FINISH ME
		// create a new QueueNode to hold object
		QueueNode newLastNode = new QueueNode(object);


		// FINISH ME
		// set the nextQueueNode that last is
		// referring to so that it points to the
		// newLastNode
		last.setNextQueueNode(newLastNode);


		// FINISH ME
		// point last to the new last node
		last = newLastNode;

	}


	// removes the first object in queue
	public T deque()
	{
		if (first == null)
		{
			// FINISH ME
			// I don't have any objects, so I should
			// return ??? (and it is NOT -1)
			return null;
		}


		// the queue is NOT empty if it gets here


		// get a pointer to the object stored in
		// this first QueueNode (call a method to get the
		// pointer to the object)
		T firstObject = first.getObject();

		// get first to point to the next object in the queue
		// if there is no next object in the queue, you
		// will get back null
		first = first.getNextQueueNode();


		// maybe it was the only object in the queue
		if (first == null)
		{
			last = null;
		}

		return firstObject;

	}



	public String toString()
	{
		String output = "[";

		QueueNode current = first;

		while(current != null)
		{
			// FINISH ME
			// add the current object's toString() return value
			output = output + current.toString() + " ";


			// FINISH ME
			// see if the nextQueueNode is null
			if (current.getNextQueueNode() == null)
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
			// make current refer to the nextQueueNode object
			current = current.getNextQueueNode();
		}

		// return the output String
		return output;
	}
}
