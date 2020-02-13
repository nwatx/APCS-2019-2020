

// this is the main program
public class BinaryTree
{

    // default constructor, not really needed
    public BinaryTree()
    {

    }

    public static void main(String[] args)
    {
        // FINISH ME
        // put your first and last name on it
        System.out.println("BinaryTree by Neo Wang");
        System.out.println();
        System.out.println();

        BinarySearchTree tree = new BinarySearchTree();



        // DON'T CHANGE THE NUMBERS below


        // add a root node
        Student student = new Student("Tom","500",112.786);
        tree.add(student);

        // add some nodes to the left subtree
        student = new Student("Sue","250",110.689);
        tree.add(student);
        student = new Student("Bill","100",108.589);
        tree.add(student);
        student = new Student("Al","300",109.289);
        tree.add(student);

        // add some nodes to the right subtree
        student = new Student("Bob","750",112.789);
        tree.add(student);
        student = new Student("Jim","600",112.789);
        tree.add(student);
        student = new Student("Ben","800",113.789);
        tree.add(student);


        tree.printTreeInOrder();
        tree.printLargestGPA();
        tree.printSmallestGPA();
        tree.printTheSumOfGPA();
        tree.printTheAverageGPA();
        tree.printNumberOfGPAsGreaterOrEqual(70);
        tree.printNumberOfLeaves();






    }
}  // end of class BinaryTree (main program )



// ********************************************
// ********************************************
// ********************************************
// interface StudentInterface
// ********************************************
// ********************************************
// ********************************************

interface StudentInterface
{
    // NOTE 1: The keywords public and abstract
    //         are NOT required, as all methods
    //         listed in the interface are
    //         public abstract by default.
    // NOTE 2: You do NOT put constructors or
    //         instance variables in an
    //         interface.  An interface contains
    //         only public abstract methods and
    //         public static final constants.


    public abstract String getName();

    public abstract String getId();

    public abstract double getGpa();


}

// ********************************************
// ********************************************
// ********************************************
// class Student
// implements StudentInterface, Comparable
// ********************************************
// ********************************************
// ********************************************

class Student implements StudentInterface, Comparable
{
    private String name;
    private String id;
    private double gpa;


    // FINISH ME
    // assign the incoming values to the appropriate
    // instance variables above
    public Student(String name, String id, double gpa)
    {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }


    // FINISH ME
    // implement all of the public abstract methods
    // that are listed in the StudentInterface

    public String getName()
    {
        return this.name;
    }

    public String getId()
    {
        return this.id;
    }

    public double getGpa()
    {
        return this.gpa;
    }


    // FINISH ME
    // write the one and only method in the
    // Comparable interface
    public int compareTo(Object theOtherStudent)
    {
        Student other = (Student)(theOtherStudent);

        // NOTE: you can refer to this student's id with:
        //       id
        //       this.id
        //       this.getId()

        // NOTE: you can refer to the other student's id with:
        //       other.id
        //       other.getId()


        // FINISH ME
        // if this student's id is less than
        //     the other student's id,
        //     then return ?

        return this.id.compareTo(other.id);


        // FINISH ME
        // if this student's id is greater than
        //     the other student's id,
        //     then return ?


        // FINISH ME
        // the id's must be the same, so return ?



    } // end of public int compareTo(Object theOtherStudent)
}



// ********************************************
// ********************************************
// ********************************************
// class Node
// represents one Node in the binary tree
// ********************************************
// ********************************************
// ********************************************

class Node
{
    private Student student;
    private Node left;
    private Node right;

    // default constructor, not really needed
    public Node()
    {
        this.student = null;
        left = null;
        right = null;
    }

    // init constructor
    public Node(Student student)
    {
        this.student = student;
        left = null;
        right = null;
    }

    // FINISH ME
    public Student getStudent()
    {
        return this.student;
    }

    // FINISH ME
    public Node getLeft()
    {
        return left;
    }

    // FINISH ME
    public Node getRight()
    {
        return right;
    }

    // FINISH ME
    public void setLeft(Node node)
    {
		this.left = node;
    }

    // FINISH ME
    public void setRight(Node node)
    {
		this.right = node;
    }

}  // end of class Node


// ********************************************
// ********************************************
// ********************************************
// interface TreeInterface
// ********************************************
// ********************************************
// ********************************************

// FINISH ME
// you will need to implement these methods in
// the BinarySearchTree class
interface TreeInterface
{
    public abstract void inOrder(Node tree);

    public abstract void preOrder(Node tree);

    public abstract void postOrder(Node tree);

    public abstract void reverseOrder(Node tree);

    public abstract double getLargestGPA(Node tree);

    public abstract double getSmallestGPA(Node tree);

    public abstract double getSumOfGPA(Node tree);

    public abstract double getAverageOfGPA(Node tree);

    public abstract int getNumberOfGPAsGreaterOrEqual(Node tree, double n);

    public abstract int getNumberOfLeaves(Node tree);

}


// ********************************************
// ********************************************
// ********************************************
// class BinarySearchTree
// implements TreeInterface
// ********************************************
// ********************************************
// ********************************************

class BinarySearchTree implements TreeInterface
{
    private Node root; // the one and only entry point to your tree
    private int  size;


    // default constructor
    public BinarySearchTree()
    {
        root = null;
    }


    // add a Student object to the tree
    public void add(Student student)
    {
        if (root == null)
        {
            size++;
            root = new Node(student);
            return;
        }

        Node tree = root; // point to top node of the tree

        while (tree != null)
        {
            // is our id smaller
            if (student.getId().compareTo(tree.getStudent().getId()) < 0)
            {
                if (tree.getLeft() == null)
                {
                    // attach it!
                    Node node = new Node(student);
                    tree.setLeft(node);
                    size++;
                    return; // we are done
                }
                else
                {
                    tree = tree.getLeft();
                }
            }
            // is our id bigger
            else if (student.getId().compareTo(tree.getStudent().getId()) > 0)
            {
                if (tree.getRight() == null)
                {
                    // attach it!
                    Node node = new Node(student);
                    tree.setRight(node);
                    size++;
                    return; // we are done
                }
                else
                {
                    tree = tree.getRight();
                }
            }

            else // it must be equal
            {
                return; // no duplicates allowed
            }

        }

    } // end of add routine


    // FINISH ME
    public int size()
    {
        return size;
    }


    // FINISH ME
    // write (implement) all of the methods in the TreeInterface
    // print the tree in order
    // (some have been done for you)
    public void inOrder(Node tree)
    {
        if (tree == null)
            return;

        inOrder(tree.getLeft());

        System.out.print(tree.getStudent().getName()+ " " + tree.getStudent().getGpa() + " ");

        inOrder(tree.getRight());
    }

    @Override
    public void preOrder(Node tree) {

        if(tree == null)
        {
            return;
        }

        System.out.print(tree.getStudent().getName() + " ");

        preOrder(tree.getLeft());
        preOrder(tree.getRight());
    }

    @Override
    public void postOrder(Node tree) {
        if(tree == null)
        {
            return;
        }

        preOrder(tree.getLeft());
        preOrder(tree.getRight());
        System.out.print(tree.getStudent().getName() + " ");
    }

    @Override
    public void reverseOrder(Node tree) {
        if (tree == null)
            return;

        inOrder(tree.getRight());

        System.out.print(tree.getStudent().getName()+ " ");

        inOrder(tree.getLeft());
    }


    public double getLargestGPA(Node tree)
    {
        if (tree == null)
            return Double.MIN_VALUE;

        double largestGPA = tree.getStudent().getGpa();

        // now see if the left tree has something higher
        double largestGPALeft = getLargestGPA(tree.getLeft());
        if (largestGPALeft > largestGPA)
            largestGPA = largestGPALeft;

        double largestGPARight = getLargestGPA(tree.getRight());
        if (largestGPARight > largestGPA)
            largestGPA = largestGPARight;

        return largestGPA;
    }

    @Override
    public double getSmallestGPA(Node tree) {
        if(tree == null)  return 0;
        if(tree.getLeft() == null)
        {
            return tree.getStudent().getGpa();
        }
        return getSmallestGPA(tree.getLeft());
    }


    public double getSumOfGPA(Node tree)
    {
        if (tree == null)
            return 0;

        return tree.getStudent().getGpa()
                + getSumOfGPA(tree.getLeft())
                + getSumOfGPA(tree.getRight());

    }

    @Override
    public double getAverageOfGPA(Node tree) {
        return (getSumOfGPA(tree)/size);
    }

    @Override
    public int getNumberOfGPAsGreaterOrEqual(Node tree, double n) {
       if(tree == null) return 0;
        if(tree.getStudent().getGpa() > n)
        {
            return 1 + getNumberOfGPAsGreaterOrEqual(tree.getRight(),n) + getNumberOfGPAsGreaterOrEqual(tree.getLeft(),n);
        }
        return 0;
    }

    @Override
    public int getNumberOfLeaves(Node tree) {
        if(tree == null) return 0;
        if(tree.getLeft() != null || tree.getRight() != null)
        {
            return getNumberOfLeaves(tree.getLeft()) + getNumberOfLeaves(tree.getRight());
        }
        else
        {
            return 1+ getNumberOfLeaves(tree.getRight()) + getNumberOfLeaves(tree.getLeft());
        }
    }


    // ================================================
    // ================================================
    // THE METHODS BELOW ARE ALL OF THE CALL STATEMENTS
    // DO NOT CHANGE THESE
    // ================================================
    // ================================================


    // call method to print the tree in order
    public void printTreeInOrder()
    {
        System.out.println("The tree in order");
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.println();
    }

    // call method to print the tree in pre-order
    public void printTreeInPreOrder()
    {
        System.out.println("The tree in pre-order");
        preOrder(root);
        System.out.println();
        System.out.println();
    }

    // call method to print the tree in post-order
    public void printTreeInPostOrder()
    {
        System.out.println("The tree in post order");
        postOrder(root);
        System.out.println();
        System.out.println();
    }

    // call method to print the tree in reverse order
    public void printTreeInReverseOrder()
    {
        System.out.println("The tree in reverse order");
        reverseOrder(root);
        System.out.println();
        System.out.println();
    }


    // call method to print the largest GPA
    public void printLargestGPA()
    {
        System.out.println("The largest GPA in the tree is ");
        System.out.println(getLargestGPA(root));
        System.out.println();
        System.out.println();
    }


    // call method to print the smallest GPA
    public void printSmallestGPA()
    {
        System.out.println("The smallest GPA in the tree is ");
        System.out.println(getSmallestGPA(root));
        System.out.println();
        System.out.println();
    }



    // call method to print the sum of the GPAs
    public void printTheSumOfGPA()
    {
        System.out.println("The sum of the GPAs in the tree is ");
        System.out.println(getSumOfGPA(root));
        System.out.println();
        System.out.println();
    }



    // call method to print the average of the GPAs
    public void printTheAverageGPA()
    {
        System.out.println("The average of the GPAs in the tree is ");
        System.out.println(getAverageOfGPA(root));
        System.out.println();
        System.out.println();
    }


    // call method to print the number of gpa's greater than n
    public void printNumberOfGPAsGreaterOrEqual(double n)
    {
        System.out.println("The number of the GPAs in the tree >= "+n);
        System.out.println(getNumberOfGPAsGreaterOrEqual(root,n));
        System.out.println();
        System.out.println();
    }


    // call method to print the number of leaves in the tree
    public void printNumberOfLeaves()
    {
        System.out.println("The number of leaves in the tree ");
        System.out.println(getNumberOfLeaves(root));
        System.out.println();
        System.out.println();
    }

} // end of class BinarySearchTree
