
// this is the main program
// other than writing your name on it,
// there is nothing else to do here

import static java.lang.System.*;

public class TestStoreSearchTree
{
    public static void main(String[] args)
    {
        // FINISH ME
        // put your name on it
        System.out.println("TestStoreSearchTree written by Neo Wang");
        System.out.println();
        System.out.println();



        StoreSearchTree test = new StoreSearchTree();

        test.add(new StoreItemNode(500,"Chicken Soup",2.49,"8 oz can"));
        System.out.println(test);


        test.add(new StoreItemNode(250,"Waffles",5.60,"Box of 10"));
        System.out.println(test);


        test.add(new StoreItemNode(750,"Grapes",6.79,"per pound"));
        System.out.println(test);


        test.add(new StoreItemNode(100,"Chicken",6.99,"Whole"));
        System.out.println(test);


        test.add(new StoreItemNode(350,"Turkey",5.99,"Whole"));
        System.out.println(test);



        test.add(new StoreItemNode(650,"Apples",2.79,"Bag"));
        System.out.println(test);


        StoreItemNode temp = new StoreItemNode(850,"Blueberrys",3.99,"Pint");
        test.add(temp);
        System.out.println(test);

        temp.setPrice(6.99);
        temp.setItemName("Blueberries");
        temp.setPricePer("Quart");
        System.out.println(test);



        System.out.println();
        System.out.println();

    }
}