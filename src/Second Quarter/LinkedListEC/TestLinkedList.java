
// you will not need to change this class
// other than removing comments below after
// you have implemented the LinkedListInterface
// for the LinkedList class.
// you will need to follow the FINISH ME
// statements in the following classes
// in the following order.
// Student
// LinkedNode
// LinkedList


import static java.lang.System.*;

public class TestLinkedList
{
	public static void main(String[] args)
	{
		// FINISH ME
		// put your name on it
		System.out.println("TestLinkedList written by Neo Wang");
		System.out.println();
		System.out.println();



		// creates a new LinkedList object
		LinkedList test = new LinkedList();


		test.add(new Student("Don", "Adams", 55));
		System.out.println(test); // calls toString() method

		test.add(new Student("Sue", "Smart", 99));
		System.out.println(test); // calls toString() method

		test.add(new Student("Bill", "Gates", 100));
		System.out.println(test); // calls toString() method

		System.out.println();
		System.out.println();

		// FINISH ME
		// uncomment the rest of this code once you
		// have implemented all of  the methods in the
		// LinkedListInterface
		// You may want to remove them 1 by 1 as you write
		//    the methods




		test.add(new Student("Steve", "Jobs", 100));
		System.out.println(test); // calls toString() method
		test.remove();
		System.out.println();
		System.out.println("========================");
		System.out.println("remove() Don Adams");
		System.out.println(test); // calls toString() method


		test.add(new Student("Don", "Adams", 55));
		System.out.println();
		System.out.println("========================");
		System.out.println("added Don Adams");
		System.out.println(test); // calls toString() method


		test.enque(new Student("Elon", "Musk", 100));
		System.out.println();
		System.out.println("========================");
		System.out.println("enque Elon Musk");
		System.out.println(test); // calls toString() method


		test.remove(3);
		System.out.println();
		System.out.println("========================");
		System.out.println("remove(3) Don Adams");
		System.out.println(test); // calls toString() method


		test.removeLast();
		System.out.println();
		System.out.println("========================");
		System.out.println("removeLast() Elon Musk");
		System.out.println(test); // calls toString() method

		test.removeFirst();
		System.out.println();
		System.out.println("========================");
		System.out.println("removeFirst() Sue Smart");
		System.out.println(test); // calls toString() method

		test.push(new Student("Elon", "Musk", 100));
		System.out.println();
		System.out.println("========================");
		System.out.println("push() Elon Musk");
		System.out.println(test); // calls toString() method


		System.out.println();
		System.out.println("========================");
		System.out.println("pop() "+test.pop());
		System.out.println(test); // calls toString() method


		test.push(new Student("Elon", "Musk", 100));
		System.out.println();
		System.out.println("========================");
		System.out.println("push() Elon Musk");
		System.out.println("getLast() "+test.getLast());
		System.out.println(test); // calls toString() method


		test.addFirst(new Student("Don", "Adams", 55));
		System.out.println();
		System.out.println("========================");
		System.out.println("addFirst() Don Adams");
		System.out.println("getFirst() "+test.getFirst());
		System.out.println(test); // calls toString() method


		System.out.println();
		System.out.println("========================");
		System.out.println("deque() "+test.deque());
		System.out.println(test); // calls toString() method

		System.out.println();
		System.out.println("========================");
		System.out.println("peek() "+test.peek());
		System.out.println("get(0) "+test.get(0));
		System.out.println("get(1) "+test.get(1));
		System.out.println("get(2) "+test.get(2));
		System.out.println(test); // calls toString() method

		System.out.println();
		System.out.println("========================");
		System.out.println("isEmpty() "+test.isEmpty());
		System.out.println(test); // calls toString() method

		test.clear();
		System.out.println();
		System.out.println("========================");
		System.out.println("clear() ");
		System.out.println("isEmpty() "+test.isEmpty());
		System.out.println(test); // calls toString() method











		System.out.println();
		System.out.println();



		

	}
}
