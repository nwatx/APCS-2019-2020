
import java.util.*;

// FIND ALL OF THE FINISH ME comments
// and add the necessary code

public class Student implements Comparable
{
	String name;
	String id;
	String age;
	ArrayList <Integer> grades;

	public Student(String theName, String theId, String theAge,
	               ArrayList<Integer> theGrades)
	{
		name = theName;

		grades = theGrades;
    id = theId;
    age = theAge;
    grades = theGrades;

	 	// FINISH ME


	}


	public String getName()
	{
	 	// FINISH ME

		return name;  // replace me
	}

	public String getId()
	{
	 	// FINISH ME

		return id;  // replace me
	}

	public String getAge()
	{
	 	// FINISH ME

		return age;  // replace me
	}


	// finds the sum of grades
	public int getSum()
	{
		// FINISH ME
    int sum = 0;

    for(int i = 0; i < grades.size(); i++)
    {
      sum += grades.get(i);
    }



		return sum;  // replace me
	}


	// finds the average of grades
	public double getAverage()
	{
		// FINISH ME
		// you may assume there is at least 1 grade

		return ((double)getSum())/grades.size();  // replace me
	}


	// finds the highest grade of grades
	public int getHighestGrade()
	{
		// FINISH ME

    int highest = 0;

    for(int i = 0 ;i < grades.size(); i++)
    {
      if(grades.get(i) > highest)
      {
        highest = grades.get(i);
      }
    }

		return highest;  // replace me
	}


	// finds the lowest grade of grades
	public int getLowestGrade()
	{
    int lowest = 10000000;

    for(int i = 0 ;i < grades.size(); i++)
    {
      if(grades.get(i) < lowest)
      {
        lowest = grades.get(i);
      }
    }

		return lowest;   // replace me
	}


	// finds the difference of the highest and lowest grade
	public int getRange()
	{
		// FINISH ME

		return getHighestGrade() - getLowestGrade();  // replace me
	}


	// finds the number of val grades found in grades
	// for example if val is 100, it would count the
	//     number of times 100 appears in the list grades
	public int getCountOf(int val)
	{
		// FINISH ME

    int count = 0;

    for(int i = 0; i < grades.size(); i++)
    {
      if(grades.get(i) == val)
      {
        count++;
      }
    }

		return count;  // replace me
	}


	// finds the number of grades greater than or equal to val
	public int getNumGTE(int val)
	{
    int count = 0;

    for(int i = 0; i < grades.size(); i++)
    {
      if(grades.get(i) >= val)
      {
        count++;
      }
    }

		return count;  // replace me
	}

	// finds the number of grades less than val
	public int getNumLT(int val)
	{
    int count = 0;

    for(int i = 0; i < grades.size(); i++)
    {
      if(grades.get(i) < val)
      {
        count++;
      }
    }

		return count;  // replace me
	}

	public String getGradeList()
	{
		String output = "";

		// FINISH ME
		// get a list of all of the grades separated with " "

    for(int i = 0; i < grades.size(); i++)
    {
      output += grades.get(i) + " ";
    }

		return output;
	}


	// a Priority Queue uses the compareTo method to get the order
	public int compareTo(Object other)
	{
		Student otherStudent = (Student) other;

		// FINISH ME
		// order by average of grades



		// get the average of this student
		double average = getAverage();

		// get the average of the other student
		double averageOther = otherStudent.getAverage();


		// now compare this student's average to the other student's average (<)
		// if less than, return -1

    if(this.getAverage() > averageOther)
    {
      return 1;
    }
    else if(this.getAverage() < averageOther)
    {
      return -1;
    }


		// now compare this student's average to the other student's average (>)
		// if greater than, return 1





		return 0;
	}

}  // end of class Student
