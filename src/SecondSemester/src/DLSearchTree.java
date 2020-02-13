
import static java.lang.System.*;

public class DLSearchTree
{
    // instance variables (attributes, properties, global)
    private DLRecordNode first;



    // default constructor
    public DLSearchTree( )
    {
        // FINISH ME
        // we do not have any objects,
        // so first should
        // be set to null
        first = null;

    }



    public boolean add(DLRecordNode item)
    {
        if (first == null)
        {
            // FINISH ME
            // point first to the DLRecordNode
            // i.e. first should refer to item
            first = item;
            return true;
        }


        DLRecordNode currentItem = first;

        boolean finished = false;

        while (!finished)
        {
            // FINISH ME
            // see if item's driversLicense is less than
            // currentItem's driversLicense
            // remember that driversLicense is a String
            // so you need to compare these Strings
            if (item.getDriversLicense().compareTo(currentItem.getDriversLicense()) < 0)
            {
                // FINISH ME
                // see if currentItem's left pointer is null
                if ( currentItem.getLeft() == null )
                {
                    // FINISH ME
                    // change currentItem's left pointer so
                    // that it points to where item is pointing
                    currentItem.setLeft(item);
                    return true;
                }
                // FINISH ME
                // change currentItem so that it points to
                // where currentItems's left pointer is pointing
                currentItem = currentItem.getLeft();
            }
            // FINISH ME
            // see if item's driversLicense is greater than
            // currentItem's driversLicense
            // remember that driversLicense is a String
            // so you need to compare these Strings
            else if (item.getDriversLicense().compareTo(currentItem.getDriversLicense()) > 0)
            {
                // FINISH ME
                // see if currentItem's right pointer is null
                if (currentItem.getRight() == null)
                {
                    // FINISH ME
                    // change currentItem's right pointer so
                    // that it points to where item is pointing
                    currentItem.setRight(item);
                    return true;
                }
                // FINISH ME
                // change currentItem so that it points to
                // where currentItems's right pointer is pointing
                currentItem = currentItem.getRight();
            }
            else
            {
                // it must be equal, and we cannot have duplicate keys
                finished = true;
            }

        }


        return false;
    }


    private String output = "";


    public void inOrder(DLRecordNode item)
    {
        if (item != null)
        {
            // FINISH ME
            // go left
			inOrder(item.getLeft());

            output += item.toString();
            // FINISH ME
            // go right
			inOrder(item.getRight());
        }

    }

    public String toString()
    {
        output = "[\n\n";

        inOrder(first);

        output += "]\n\n";
        // return the output String
        return output;
    }
}