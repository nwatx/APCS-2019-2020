
//treeMap example

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class TreeMapString
{
    public static void main(String args[])
    {
        System.out.println();
        System.out.println();
        System.out.println("A TreeMap of String objects  (0rdered)");
        System.out.println("======================================");
        System.out.println();
        System.out.println();
        System.out.println("Methods:  put(key, object)   get(key)     remove(key)    containsKey(key)       keySet()");
        System.out.println("          size()             clear()      isEmpty()");
        System.out.println("NOTE: There is no indexOf(object) method.");
        System.out.println();
        System.out.println();


        // FINISH ME
        // create a new TreeMap that can hold a String object for the key and a String for the value
        Map<String, String> stringMap = new  TreeMap<String, String>();


        // FINISH ME
        // add the key "11111" to your map with a value of "Hillary"
        stringMap.put("11111","Hillary");



        // FINISH ME
        // add the key "22222" to your map with a value of "Donald"
        stringMap.put("22222","Donald");


        // FINISH ME
        // add the key "33333" to your map with a value of "Sam"
        stringMap.put("33333","Sam");


        // FINISH ME
        // add the key "33333" to your map with a value of "Jack"
        stringMap.put("33333","Jack");


        // FINISH ME
        // add the key "44444" to your map with a value of "Jill"
        stringMap.put("44444","Jill");


        // stringMap.put(0, "ab"); // ERROR The key was specified as a String




        System.out.println();
        System.out.println("My map of objects after adding objects are:   " + stringMap);




        // We will build an Iterator Object and fill it
        System.out.print("My map of objects using an Iterator are:      ");



        // FINISH ME
        // call the stringMap's keySet() method  and then the iterator() method of the returned Set
        // to create (build) an Iterator object with all of the keys in the map
        Iterator<String> it = stringMap.keySet().iterator();


        // FINISH ME
        // check to see if the iterator has a next object
        while (   it.hasNext()  )
        {
            // FINISH ME
            // get the next String in the iterator (key)
            // NOTE: The string object will automatically be removed from the iterator
            String key = it.next();


            // FINISH ME
            // we now have the key
            // let's look up the value for the given key
            String value = stringMap.get(key);

            // now we print it
            if (it.hasNext())
                System.out.print(key + " " + value + ", ");
            else
                System.out.print(key + " " + value);
        }
        System.out.println();  // finishes the line



        // Let's traverse the map using a for each loop
        System.out.print("My map of objects using a for each loop are:  ");

        int count = 0;


        // FINISH ME
        // call the stringMap's method that will give back a Set of all the keys
        for (   String key : stringMap.keySet()  )
        {
            count++;

            // FINISH ME
            // we now have the key
            // let's look up the value
            String value = stringMap.get(key);


            // now we print it
            if (count < stringMap.size())
                System.out.print(key + " " + value + ", ");
            else
                System.out.print(key + " " + value);
        }
        System.out.println();  // finishes the line



        // FINISH ME
        // remove the key "11111" (value of "Hillary") from your map (use the key)
        stringMap.remove("11111");


        // FINISH ME
        // remove the key "22222" (value of "Donald") from your map	(use the key)
        stringMap.remove("22222");



        // FINISH ME
        // remove the key "33333" (value of "Sam" ???)  from your map (use the key)
        stringMap.remove("33333");




        // stringMap.remove(0);  // NOT an ERROR, but Integer object with key 0 is NOT found  (returns null)
        // stringMap.get(0);     // NOT an ERROR, but Integer object with key 0 is NOT found  (returns null)
        // stringMap.indexOf(0); // ERROR, no method indexOf()

        System.out.println("My map of objects after removing objects are: " + stringMap);



        // FINISH ME
        // add code to see if the treeMap contains "11111"
        System.out.println("Does stringMap contain 11111 (Hillary) --> " +   stringMap.containsKey("11111")     );  // true or false


        // FINISH ME
        // add code to see if the treeMap contains "22222"
        System.out.println("Does stringMap contain 22222 (Donald) --> " +   stringMap.containsKey("22222")     );  // true or false


        // FINISH ME
        // add code to see if the treeMap isEmpty
        System.out.println("Is stringMap empty -->        " +     stringMap.isEmpty()      ); // true or false


        // FINISH ME
        // add code to get the size of the treeMap
        System.out.println("The size of stringMap is -->  " +      stringMap.size()     );




        if (stringMap.toString().equals("{44444=Jill}"))
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