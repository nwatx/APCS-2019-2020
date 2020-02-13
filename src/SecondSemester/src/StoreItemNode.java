
public class StoreItemNode
{
    // instance variables (attributes, properties, fields, global variables)


    private int barCode;  // bar code of item (must be unique)

    private String itemName;

    private double price;

    private String pricePer;

    private StoreItemNode left;  // points to left node or null

    private StoreItemNode right;	// points to right node or null



    // init constructor
    public StoreItemNode(int barCode, String itemName, double price, String pricePer)
    {
        // FINISH ME




        this.left = null;
        this.right = null;
        this.barCode = barCode;
        this.itemName = itemName;
        this.price = price;
        this.pricePer = pricePer;
    }


    public int getBarCode()
    {
        // FINISH ME
        return this.barCode; // change me ???
    }


    public String getItemName()
    {
        // FINISH ME
        return this.itemName; // change me ???
    }


    public double getPrice()
    {
        // FINISH ME
        return this.price; // change me ???
    }


    public String getPricePer()
    {
        // FINISH ME
        return this.pricePer; // change me ???
    }


    public StoreItemNode getLeft()
    {
        // FINISH ME
        return this.left;  // change me ???
    }


    public StoreItemNode getRight()
    {
        // FINISH ME
        return this.right;  // change me ???
    }


    // ###############################################
    // ###############################################
    // ###############################################
    // setter (modifier or mutator methods)
    // that allow us to change the value of an
    // instance variable (attribute, property, ...)
    // but we do not let them change barCode (unique)
    // ###############################################
    // ###############################################
    // ###############################################


    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }


    public void setPrice(double price)
    {
        // FINISH ME
        this.price = price;
    }


    public void setPricePer(String pricePer)
    {
        // FINISH ME
        this.pricePer = pricePer;
    }


    public void setLeft(StoreItemNode item)
    {
        // FINISH ME
        this.left = item;
    }


    public void setRight(StoreItemNode item)
    {
        // FINISH ME
        this.right = item;
    }



    // FINISH ME
    // WRITE A toString() method
    public String toString()
    {
        // FINISH ME
        // return all values of instance variables with a label
        return " Item Name: " + getItemName() + "\n" +
                " Price:     " + getPrice()    + " " + getPricePer() + "\n\n";
    }


}

