
// class Fact

// Find the FINISH ME statements


import java.util.*;


// FINISH ME
// write the class header for class Fact
public class Factorial {

    private static final int MAX_VALUE = 20;
    private static final int MIN_VALUE = 1;


    public Factorial() {

    }


    // finds n! recursively
// assume n >= 1  && n <= 20
    public static int fact(int n) {
        if(n == 1 || n == 0)
        {
            return 1;
        }

        return n * fact(n-1);
    }


// Finds the n integers of the factorials from large to 1
// and return the numbers in an ArrayList<Integer>.
// For example, if n is 5, then the list should be
// 5 4 3 2 1

// FINISH ME
// finish the header so that it can return an ArrayList of Integer objects
public static ArrayList<Integer> factList(int n)
        {
        // FINISH ME
        // create an ArrayList that can hold Integer objects
        ArrayList<Integer> list = new ArrayList<>();


        // FINISH ME
        // loop from n downto 1
        for (int i = n; i >= 1; i--)
        {
        // FINISH ME
        // add the ith fact number to the list
            list.add(i);
        }


        // FINISH ME
        // return your list of the facts
            return list;

    }


// main method
public static void main(String[] args) {

        // FINISH ME
        // print out your name
        System.out.println("My name is Neo Wang");
        System.out.println();
        System.out.println();


        // FINISH ME
        // create a Scanner object that can read from the keyboard (System.in)
        Scanner scan = new Scanner(System.in);



        boolean finished = false;


        while (!finished)
        {
        System.out.print("Enter the factorial that you want to see. (1-20 or Q) ");


        // FINISH ME
        // see if the next element in the scan object is not an int

        if (!scan.hasNextInt())
        {
        // the next element in the scan object is NOT an int

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
        // clear scan's input buffer (call the scan's ??? method)
        scan.nextLine();


        System.out.println();


        // FINISH ME
        // Check to see if the number is out of range
        if (!(n > MIN_VALUE && n < MAX_VALUE))
        {
        System.out.println("Your input number " + n + " is out of range.");
        }
        else
        {
        System.out.println();
        System.out.println(factList(n));
        System.out.println();


        // FINISH ME
        // call the fact() method and print the result on the console
        // pass the value of n
        System.out.println(fact(n));
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