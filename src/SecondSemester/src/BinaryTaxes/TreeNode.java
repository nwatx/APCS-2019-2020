package BinaryTaxes;

public class TreeNode
{
    // instance variables (attributes, properties, fields, global variables)

    private PersonRecord person;

    private TreeNode left;  // points to left node or null

    private TreeNode right;	// points to right node or null



    // init constructor
    public TreeNode(TreeNode left, PersonRecord person, TreeNode right)
    {
        // FINISH ME
        this.left = left;
        this.person = person;
        this.right = right;

    }


    public PersonRecord getPerson()
    {
        // FINISH ME
        return person;

    }

    public TreeNode getLeft()
    {
        // FINISH ME
        return left;
    }


    public TreeNode getRight()
    {
        // FINISH ME
        return right;
    }


    // ###############################################
    // ###############################################
    // ###############################################
    // setter (modifier or mutator methods)
    // that allow us to change the value of an
    // instance variable (attribute, property, ...)
    // but we do not let them change driversLicense (unique)
    // ###############################################
    // ###############################################
    // ###############################################


    public void setPersonRecord(PersonRecord person)
    {
        // FINISH ME
        this.person = person;

    }


    public void setLeft(TreeNode left)
    {
        // FINISH ME
        this.left = left;

    }


    public void setRight(TreeNode right)
    {
        // FINISH ME
        this.right=right;

    }



    // FINISH ME
    // WRITE A toString() method
    public String toString()
    {
        // FINISH ME
        // return all values of instance variables with a label
        return person.toString();
    }


}

