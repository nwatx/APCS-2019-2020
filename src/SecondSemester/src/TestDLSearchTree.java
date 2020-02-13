
import static java.lang.System.*;

public class TestDLSearchTree
{
    public static void main(String[] args)
    {
        // FINISH ME
        // put your name on it
        System.out.println("TestDLSearchTree written by Neo Wang");
        System.out.println();
        System.out.println();

        DLSearchTree test = new DLSearchTree();

        DLRecordNode temp = new DLRecordNode("500","Gorge Washington","02/22/1731","Blue",6);
        test.add( temp );
        System.out.println(test);

        test.add(new DLRecordNode("750","John Adams","10/30/1735","Brown",0));
        System.out.println(test);

        test.add( new DLRecordNode("250","Ben Franklin","01/17/1705","Blue",6) );
        System.out.println(test);

        temp.setPersonName("George Washington");
        temp.setEyeColor("Blue-Gray");
        temp.setDateOfBirth("02/22/1732");
        System.out.println(test);

        System.out.println();
        System.out.println();

    }
}