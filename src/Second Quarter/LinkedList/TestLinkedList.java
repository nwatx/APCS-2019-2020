
import static java.lang.System.*;

public class TestLinkedList
{
	public static void main(String[] args)
	{
		// FINISH ME
		// put your name on it
		System.out.println("TestLinkedList written by Neo Wang");



		// A A A A B V S E A S A A
		LinkedList test = new LinkedList();
		test.add('A');
		test.add('A');
		test.add('A');
		test.add('A');
		test.add('B');
		test.add('V');
		test.add('S');
		test.add('E');
		test.add('A');
		test.add('S');
		test.add('A');
		test.add('A');
		System.out.println(test);


		// A B C
		test = new LinkedList();
		test.add('A');
		test.add('B');
		test.add('C');
		System.out.println(test);


		// A B C A B C A B C A B C A B C
		test = new LinkedList();
		test.add('A');
		test.add('B');
		test.add('C');
		test.add('A');
		test.add('B');
		test.add('C');
		test.add('A');
		test.add('B');
		test.add('C');
		test.add('A');
		test.add('B');
		test.add('C');
		test.add('A');
		test.add('B');
		test.add('C');
		System.out.println(test);
	}
}
