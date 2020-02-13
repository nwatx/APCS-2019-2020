package BinaryTaxes;
import static java.lang.System.*;

public class BinarySearchTree
{
    // instance variables (attributes, properties, global)
    private TreeNode root;



    // default constructor
    public BinarySearchTree( )
    {
        // FINISH ME
        // we do not have any TreeNode objects,
        // so root should
        // be set to null

        root = null;

    }



    public boolean add(PersonRecord person)
    {
        // we create a TreeNode object and wrap up the person
        // and then add it to the BinarySearchTree
        TreeNode temp = new TreeNode(null,person,null);


        if (root == null)
        {
            // FINISH ME
            // point root to where temp is pointing
            // i.e. root should refer to temp

            root = temp;

            return true;
        }


        // FINISH ME
        // we will point currentNode to where root is pointing
        TreeNode currentNode = root;

        boolean finished = false;

        while (!finished)
        {
            // FINISH ME
            // compare the person names
            if (temp.getPerson().getPersonName().compareTo(currentNode.getPerson().getPersonName()) < 0)
            {
                // FINISH ME
                // see if the left pointer is null
                if (currentNode.getLeft() == null)
                {
                    // FINISH ME
                    // set the left pointer to point to where
                    // temp is pointing
                    currentNode.setLeft(temp);
                    return true;
                }
                // FINISH ME
                // change currentNode so that it points to
                // it's left pointer
                currentNode = currentNode.getLeft();
            }
			else if (temp.getPerson().getPersonName().compareTo(currentNode.getPerson().getPersonName()) > 0)
            {
                // FINISH ME
                // see if the right pointer is null
                if (currentNode.getRight() == null)
                {
                    // FINISH ME
                    // set the right pointer to point to where
                    // temp is pointing
                    currentNode.setRight(temp);
                    return true;
                }
                // FINISH ME
                // change currentNode so that it points to
                // it's right pointer
                currentNode = currentNode.getRight();
            }



			else
            {
                // it must be equal, and we cannot have duplicate keys
                // or we could update the record
                finished = true;
            }

        }


        return false;
    }


    private String output = "";


    public void inOrder(TreeNode temp)
    {
        if (temp != null)
        {
            // FINISH ME
            // print inOrder

            inOrder(temp.getLeft());

            output += temp.toString();

            inOrder(temp.getRight());

        }

    }

    public String toString()
    {
        output = "[\n\n";

        // FINISH ME
        // to be finished later
        // call inOrder and pass it the root

        inOrder(root);

        output += "]\n\n";
        // return the output String
        return output;
    }
}