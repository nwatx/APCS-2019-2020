
public interface LinkedListInterface
{
	// You can only have public static final variables
	// and abstract methods
	// NO Constructors
	// NO code
	// NO instance variables




	// returns the memory address of the first Student object
	// in the list or null if the list is empty
	// it does NOT remove the node element
	public Student peek();


	// *****************************************************
	// *****************************************************
	// *****************************************************
	// remove methods so we can get rid of stuff
	// *****************************************************
	// *****************************************************
	// *****************************************************

	// returns the memory address of the first Student object
	// in the list or null if the list is empty
	// it also removes the node element from the list
	public Student removeFirst();


	// returns the memory address of the last Student object
	// in the list or null if the list is empty
	// it also removes the node element from the list
	public Student removeLast();


	// returns the memory address of the first Student object
	// in the list or null if the list is empty
	// it also removes the node element from the list
	public Student remove();


	// removes the node at the index position of index
	// it also returns the student object that was removed
	// or null if the student was not found
	public Student remove(int index);


	// creates a new LinkedNode containing student
	// and puts it as the last element in the list
	public void add(Student student);


	// creates a new LinkedNode containing student
	// and puts it as the first element in the list
	public void addFirst(Student student);


	// clears the linked list
	public void clear();


	// returns the memory address of the
	// Student object in the index position
	// it does NOT remove anything
	public Student get(int index);


	// returns the memory address of the first Student object
	// in the list or null if the list is empty
	// it does NOT remove the element
	public Student getFirst();


	// returns the memory address of the first Student object
	// in the list or null if the list is empty
	// it does NOT remove the element
	// call a method
	public Student peekFirst();


	// returns the memory address of the last Student object
	// in the list or null if the list is empty
	// it does NOT remove the node element
	public Student getLast();

	// returns the memory address of the last Student object
	// in the list or null if the list is empty
	// it does NOT remove the node element
	// call a method
	public Student peekLast();


	// *****************************************************
	// *****************************************************
	// *****************************************************
	// push and pop methods so we can treat this as a stack
	// *****************************************************
	// *****************************************************
	// *****************************************************


	// adds student to the end of the list
	// call a method
	public void push(Student student);


	// returns the memory address of the last Student object
	// in the list or null if the list is empty
	// it also removes the node element from the list
	// call a method
	public Student pop();



	// *******************************************************
	// *******************************************************
	// *******************************************************
	// enque and deque methods so we can treat this as a queue
	// *******************************************************
	// *******************************************************
	// *******************************************************


	// adds student to the end of the list
	// call a method
	public void enque(Student student);


	// returns the memory address of the first Student object
	// in the list or null if the list is empty
	// it also removes the node element from the list
	public Student deque();



	// returns true if the list is empty else returns false
	public boolean isEmpty();


	// returns the number of elements in the list
	public int size();



} // end of interface LinkedListInterface
