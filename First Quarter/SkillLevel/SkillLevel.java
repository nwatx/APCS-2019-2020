// This program is for Extra Credit
// 120 points
//
//
// THIS IS DUE NO LATER THAN Tuesday, Sept. 27!!!!!!!!!!
// YOU MUST HAVE ALL OTHER LABS FINISHED OR NO CREDIT (CarGraphics, AddressBook)
//
//
// FINISH ME
// My name is ???????????????????????????

import java.util.*; // for the ArrayList
import java.io.*;

public class SkillLevel
{

	public static void printSkillLevels(int [] array, String comment)
	{
	   	for (int i=0; i<11; i++)
	   	{
	   		System.out.printf("%3d", array[i]);
	   	}
		System.out.println(comment);
	}


	public static void readSkillLevels(Scanner scan, int [] array)
	{
	   	for (int i=0; i<11; i++)
	   	{
	   		array[i] = scan.nextInt();
	   	}
		scan.nextLine();
	}


	// *****************************************************************
	// *****************************************************************
	// *****************************************************************
	// method main  It all starts here *********************************
	// *****************************************************************
	// *****************************************************************
	// *****************************************************************
    public static void main(String[] args) throws FileNotFoundException {

       System.out.println();
       System.out.println();
       System.out.println("Extra credit lab - SkillLevel");
       System.out.println();

       // FINISH ME
       // print out your name
       System.out.println("My name is Neo Wang"); // CHANGE ME!!!!!!!!!
       System.out.println();
       System.out.println();


	   try
	   {
	   		Scanner scan = new Scanner(  new File("skills.dat")  );

	   		int dataSets = scan.nextInt();
	   		scan.nextLine();

	   		for (int set = 1; set<=dataSets; set++)
	   		{
          String[][] data = new String[4][14];
          int difference = 0;
          for(int i = 0; i < 4; i++)
          {
            //System.out.println(Arrays.toString(data[0]));
            //System.out.println(Arrays.toString(data[1]));
            //System.out.println(Arrays.toString(data[2]));
            //System.out.println(Arrays.toString(data[3]));
            //System.out.println(Arrays.toString(scan.nextLine().split(" ")));
            System.out.println(Arrays.toString(data[i]));

            String[] yoov = scan.nextLine().split(" ");

            for(int ng = 0; ng < yoov.length; ng++)
            {
              data[i][ng] = yoov[ng];
            }

            for(int z = 0; z < 11 && (i%2 == 0); z++)
            {
              difference += Integer.parseInt(data[i][z]) - Integer.parseInt(data[i+1][z]);
            }
          }
          if(difference > 0)
          {
            System.out.println("Team 1 is gonna win");
          }
          else if(difference < 0)
          {
            System.out.println("Team 2 is gonna win");
          }
          else
          {
            System.out.println("They are the same");
          }
	   		}
	   }
	   catch (Exception e)
	   {
	   		//System.out.println("Error reading in file skilllevel.dat");
        e.printStackTrace();
	   }



       System.out.println();
       System.out.println();


    } // end of main method


} // end of public class SkillLevel
