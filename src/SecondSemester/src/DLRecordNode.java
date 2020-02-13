
public class DLRecordNode
{
    // instance variables (attributes, properties, fields, global variables)


    private String driversLicense;  // bar code of item (must be unique)

    private String personName;

    private String dateOfBirth;

    private String eyeColor;

    private int points;

    private DLRecordNode left;  // points to left node or null

    private DLRecordNode right;	// points to right node or null



    // init constructor
    public DLRecordNode(String driversLicense, String personName, String dateOfBirth, String eyeColor, int points)
    {
        // FINISH ME


        this.left = null;
        this.right = null;

        this.driversLicense = driversLicense;
        this.personName = personName;
        this.dateOfBirth = dateOfBirth;
        this.eyeColor = eyeColor;
        this.points = points;
    }


    public String getDriversLicense()
    {
        // FINISH ME
        return driversLicense;
    }


    public String getPersonName()
    {
        // FINISH ME
        return this.personName;
    }


    public String getDateOfBirth()
    {
        // FINISH ME
        return this.dateOfBirth;

    }


    public String getEyeColor()
    {
        // FINISH ME
        return this.eyeColor;
    }


    public double getPoints()
    {
        // FINISH ME
        return this.points;
    }




    public DLRecordNode getLeft()
    {
        // FINISH ME
        return this.left;
    }


    public DLRecordNode getRight()
    {
        // FINISH ME
        return this.right;
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


    public void setPersonName(String personName)
    {
        // FINISH ME
        this.personName = personName;
    }


    public void setDateOfBirth(String dateOfBirth)
    {
        // FINISH ME
        this.dateOfBirth = dateOfBirth;
    }


    public void setEyeColor(String eyeColor)
    {
        // FINISH ME
        this.eyeColor = eyeColor;
    }


    public void setPoints(int points)
    {
        // FINISH ME
        this.points = points;
    }


    public void setLeft(DLRecordNode item)
    {
        // FINISH ME
        this.left = item;
    }


    public void setRight(DLRecordNode item)
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
        // use method calls to get your data elements
        return " Person Name:     " + this.personName + "\n" +
            " Drivers License: " + driversLicense + "\n" +
            " Eye Color:       " + eyeColor + "\n" +
            " Points:          " + points + "\n\n";
    }


}

