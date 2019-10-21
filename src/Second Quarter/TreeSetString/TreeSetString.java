//© A+ Computer Science
// www.apluscompsci.com

//treeset vs array string example

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetString
{
    public static void main(String args[])
    {
        System.out.println();
        System.out.println();
        System.out.println("A TreeSet of String objects  (0rdered)");
        System.out.println("======================================");
        System.out.println();
        System.out.println();
        System.out.println("Methods:  add(object)   remove(object)    contains(object)       iterator()");
        System.out.println("          size()        clear()           isEmpty()");
        System.out.println("NOTE 1: There is no get(int) method.");
        System.out.println("NOTE 2: There is no remove(int) method.");
        System.out.println("NOTE 3: There is no indexOf(object) method.");
        System.out.println();
        System.out.println();


        // FINISH ME
        // create a new TreeSet that can hold String objects
        Set<String> stringSet = new TreeSet<String>();


        // FINISH ME
        // add the String "AB" to your set
        stringSet.add("AB");

        // FINISH ME
        // add the String "23" to your set
        stringSet.add("23");

        // FINISH ME
        // add the String "ab" to your set
        stringSet.add("ab");

        // FINISH ME
        // add the String "ab" to your set
        stringSet.add("ab");

        // FINISH ME
        // add the String "ab" to your set

        stringSet.add("ab");

        System.out.println();
        System.out.println("My set of objects after adding objects are:   " + stringSet);



        // stringSet.add(0, "ab");  ERROR NO OVERLOADED add method

        // We will build an Iterator Object and fill it
        System.out.print("My set of objects using an Iterator are:      ");



        // FINISH ME
        // call the stringSet's iterator() method to create (build) an Iterator object
        Iterator<String> it = stringSet.iterator();



        // FINISH ME
        // check to see if the iterator has a next object
        while (   it.hasNext()  )
        {
            // FINISH ME
            // get the next String in the iterator
            // NOTE: The string object will automatically be removed from the iterator
            String s = it.next();


            // now we print it
            System.out.print(s + " ");
        }
        System.out.println();  // finishes the line



        // FINISH ME
        // remove the String "ab" from your set
        stringSet.remove("ab");


        // FINISH ME
        // remove the String "ab" from your set

        stringSet.remove("ab");

        // FINISH ME
        // remove the String "CD" from your set


        stringSet.remove("CD");

        // stringSet.remove(0);  NOT an ERROR but it won't find it (mismatch of types)

        System.out.println("My set of objects after removing objects are: " + stringSet);


        // System.out.println("getting element 0 --> " + stringSet.get(0));  ERROR NO get method
        // System.out.println("getting indexOf("AB") --> " + stringSet.indexOf("AB"));  // ERROR NO indexOf method



        // FINISH ME
        // add code to see if the treeSet contains "AB"
        System.out.println("Does stringSet contain AB --> " +   stringSet.contains("AB")     );  // true or false


        // FINISH ME
        // add code to see if the treeSet isEmpty
        System.out.println("Is stringSet empty -->        " +     stringSet.isEmpty()      ); // true or false


        // FINISH ME
        // add code to get the size of the treeSet
        System.out.println("The size of stringSet is -->  " +      stringSet.size()     );




        if (stringSet.toString().equals("[23, AB]"))
        {
            System.out.println("Your lab\'s final output is correct.");
        }
        else
        {
            System.out.println("Your lab is NOT correct.");
        }
        System.out.println();
        System.out.println();


    }
}