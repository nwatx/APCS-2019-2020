
// class Fibo

// Find the FINISH ME statements


import java.util.*;


// FINISH ME
// write the class header
public class Fibo
        {

private static final int MAX_VALUE = 20;
private static final int MIN_VALUE = 1;


public Fibo() {

        }


// finds the nth fibonacci number recursively
// assume n >= 1  && n <= 20
public static int fibo(int n)
        {
        // general algorithm
        // if n is less than 3, return 1
        // other wise, return fibo(n-1) plus fibo(n-2)

            if(n < 3)
            {
                return 1;
            }
            return fibo(n-1) + fibo(n-2);

        // FINISH ME
        // handle the base case (stopping point)




        // FINISH ME
        // recursively find fibo of n and return it




        }



// Finds the first n integers fibonacci numbers
// and returns the numbers in an ArrayList<Integer>.
// For example, if n is 6, then the list should be
// 1 1 2 3 5 8

// FINISH ME
// finish the header so that it can return an ArrayList of Integer objects
public static ArrayList<Integer> fiboList(int n)
        {
        // FINISH ME
        // create an ArrayList that can hold Integer objects
        ArrayList<Integer> list = new ArrayList<>();


        // FINISH ME
        // loop from 1 to n
        for (int i = 1; i < n; i++)
        {
        // FINISH ME
        // add the ith fibonacci number to the list (call the fibo() method
            list.add(fibo(i));

        }


        // FINISH ME
        // return your list of the Fibonacci numbers


return list;
        }


// main method
public static void main(String[] args) {

        // FINISH ME
        // print out your name
        System.out.println("My name is Neo Wang");
        System.out.println();
        System.out.println();
        System.out.println("The list of the fibonacci numbers from 1 to 20:");

        // FINISH ME
        // get a list of all of the fibonacci numbers from 1 to 20
        // call a method from above (fiboList(20))
        System.out.println(fiboList(20));


        System.out.println();
        System.out.println();


        // FINISH ME
        // create a Scanner object that can read from the keyboard (System.in)
        Scanner scan = new Scanner(System.in);



        boolean finished = false;


        while (!finished)
        {
        System.out.print("Enter the fibonnaci term that you want to see. (1-20 or Q) ");


        // FINISH ME
        // see if the next element in the scan object is not an int

        if (!scan.hasNextInt())
        {
        // FINISH ME
        // set finished to true
            finished = true;
        }
        else
        {
        // FINISH ME
        // ask the Scanner object called scan to give you back what the user typed
        //    in as an int
        int n = scan.nextInt();


        // FINISH ME
        // clear scan's input buffer (call the scan's ? method)
        scan.nextLine();


        System.out.println();


        // FINISH ME
        // Check to see if the number is out of range
        if (n < MIN_VALUE || n > MAX_VALUE)
        {
        System.out.println("Your input number " + n + " is out of range.");
        }
        else
        {

        // FINISH ME
        // call the fibo() method and print the term on the console
        System.out.println(fibo(n));
        }

        } // end of else

        System.out.println();
        System.out.println();

        }



        System.out.println("Goodbye!");
        System.out.println();
        System.out.println();

        }
        }