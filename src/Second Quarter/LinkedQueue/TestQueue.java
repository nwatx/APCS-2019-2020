
import static java.lang.System.*;

public class TestQueue<T>
{
	public static void main(String[] args)
	{
		// FINISH ME
		// put your name on it
		System.out.println("TestQueue written by Neo Wang");

		System.out.println();
		System.out.println();

		// An Integer Queue
		Queue<Integer> test = new Queue<Integer>(null);
		test.enque(new Integer(5));
		test.enque(new Integer(8));
		test.enque(new Integer(7));
		test.enque(new Integer(4));
		test.enque(new Integer(2));
		System.out.println(test);

		Integer object = test.deque();
		System.out.println(object + " has been removed.");
		System.out.println(test);
		System.out.println();
		System.out.println("========================");
		System.out.println();



		// A Double Queue
		Queue<Double> testDouble = new Queue<Double>(null);
		testDouble.enque(new Double(5.6));
		testDouble.enque(new Double(8));
		testDouble.enque(new Double(3.14159));
		testDouble.enque(new Double(4));
		testDouble.enque(new Double(2.71));
		System.out.println(testDouble);
		System.out.println();
		System.out.println("========================");
		System.out.println();


		// A String Queue
		Queue<String> testString = new Queue<String>(null);
		testString.enque(new String("DJ"));
		testString.enque(new String("Sidharth"));
		testString.enque(new String("Joseph"));
		testString.enque(new String("Olympia"));
		testString.enque(new String("Punit"));
		System.out.println(testString);
		System.out.println();
		System.out.println("========================");
		System.out.println();


		// A String Queue
		Queue<Student> testStudent = new Queue<Student>(null);
		testStudent.enque(new Student("Bill","Smith", 98.5));
		testStudent.enque(new Student("Sue","Adams", 99.4));
		testStudent.enque(new Student("Tom", "Super", 100.0));
		System.out.println(testStudent);
		System.out.println();
		System.out.println("========================");
		System.out.println();

		System.out.println();
		System.out.println();

	}
}
