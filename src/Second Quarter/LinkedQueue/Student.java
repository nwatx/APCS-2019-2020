
public class Student
{
	// object will point to some object of type T
	private String firstName;
	private String lastName;
	private double gpa;


	// init constructor
	public Student(String firstName, String lastName, double gpa)
	{
		// FINISH ME
    this.firstName = firstName;
    this.lastName = lastName;
    this.gpa = gpa;
	}




	public String toString()
	{
		return firstName + " " + lastName + "  gpa=" + gpa;
	}
}
