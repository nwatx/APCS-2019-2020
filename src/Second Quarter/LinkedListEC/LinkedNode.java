
public class LinkedNode
{
	// instance variables (attributes, properties, fields, global variables)


	// the student reference
	private Student student;

	// reference (memory address) of next LinkedNode
	private LinkedNode next;

	// reference (memory address) of previous LinkedNode
	private LinkedNode previous;


	// init constructor to initialize your instance variables
	public LinkedNode(LinkedNode previous,
	                  Student    student,
	                  LinkedNode next)
	{
		// FINISH ME
		// initialize your instance variables
    this.student = student;
    this.next = next;
    this.previous = previous;

	}


	public Student getStudent()
	{
		// FINISH ME
		// returns the memory address of student
		return student; // change me ???
	}



	public LinkedNode getNext()
	{
		// FINISH ME
		// returns the memory address of next
		return next; // change me ???
	}


	public void setNext(LinkedNode next)
	{
		// FINISH ME
		// store the memory address of next
		this.next = next;
	}

	public LinkedNode getPrevious()
	{
		// FINISH ME
		// returns the memory address of previous
		return previous; // change me ???
	}


	public void setPrevious(LinkedNode previous)
	{
		// FINISH ME
		// store the memory address of previous
		this.previous = previous;
	}

	public String toString()
	{
		return student.toString();
	}

}
