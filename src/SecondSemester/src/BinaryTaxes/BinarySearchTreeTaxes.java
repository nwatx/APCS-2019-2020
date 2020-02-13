package BinaryTaxes;
import static java.lang.System.*;

public class BinarySearchTreeTaxes
{
    public static void main(String[] args)
    {
        // FINISH ME
        // put your name on it
        System.out.println("BinarySearchTreeTaxes written by Neo Wang");
        System.out.println();
        System.out.println();



        BinarySearchTree test = new BinarySearchTree();



        PersonRecord temp = new PersonRecord("507-22-8458","Bill Adams","02/22/1731",60000);
        test.add( temp );
        System.out.println(test);

        temp = new PersonRecord("507-22-8458","Bill Adams","02/22/1731",60000);
        test.add( temp );
        System.out.println(test);

        temp = new PersonRecord("518-26-7345","Tom Adams","05/26/1733",100000);
        test.add( temp );
        System.out.println(test);

        temp = new PersonRecord("549-22-2858","Alice Adams","07/18/1734",500000);
        test.add( temp );
        System.out.println(test);

        temp = new PersonRecord("588-22-3858","Sally Adams","09/14/1736",600000);
        test.add( temp );
        System.out.println(test);



        System.out.println();
        System.out.println();

    }
}