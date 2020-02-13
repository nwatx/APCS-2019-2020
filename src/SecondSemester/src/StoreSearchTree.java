
// FIND THE FINISH ME comments
// and finish them

import static java.lang.System.*;

public class StoreSearchTree
{
    // instance variables (attributes, properties, global)
    private StoreItemNode first;



    // default constructor
    public StoreSearchTree( )
    {
        // FINISH ME
        // we do not have any objects,
        // so first should
        // be set to null
        first = null;

    }



    public boolean add(StoreItemNode item)
    {
        if (first == null)
        {
            // FINISH ME
            // point first to the StoreItemNode
            // that is pointed to by item
            // i.e. first should refer to item
            first = item;
            return true;
        }


        StoreItemNode currentItem = first;

        boolean finished = false;

        while (!finished)
        {
            if (item.getBarCode() < currentItem.getBarCode())
            {
                // FINISH ME
                // see if the currentItem's left pointer is null
                if (currentItem.getLeft() == null)
                {
                    // FINISH ME
                    // set the left pointer of currentItem to point
                    // to where item is pointer
                    currentItem.setLeft(item);
                    return true;
                }

                // FINISH ME
                // update currentItem so that it points to
                // currentItem's left subtree
                currentItem = currentItem.getLeft();
            }
            else if (item.getBarCode() > currentItem.getBarCode())
            {
                // FINISH ME
                // see if the currentItem's right pointer is null
                if (currentItem.getRight() == null)
                {
                    // FINISH ME
                    // set the right pointer of currentItem to point
                    // to where item is pointer
                    currentItem.setRight(item);
                    return true;
                }
                // FINISH ME
                // update currentItem so that it points to
                // currentItem's right subtree
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


    public void inOrder(StoreItemNode item)
    {
        if (item != null)
        {
            // FINISH ME
            // call yourself and pass a pointer
            // to your left subtree
            inOrder(item.getLeft());
            output += item.toString();


            // FINISH ME
            // call yourself and pass a pointer
            // to your right subtree
            inOrder(item.getRight());
        }

    }

    public String toString()
    {
        output = "[\n\n";

        // FINISH ME
        // call inOrder and pass it a pointer to the
        // first item (root node or element) in your tree
        inOrder(first);

        output += "]\n\n";
        // return the output String
        return output;
    }
}