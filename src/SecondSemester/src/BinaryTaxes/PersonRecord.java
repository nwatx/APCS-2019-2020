package BinaryTaxes;
public class PersonRecord
{
    // instance variables (attributes, properties, fields, global variables)


    private String ssNumber;  // (must be unique)

    private String personName;

    private String dateOfBirth;

    private double taxableIncome;

    private double taxesOwed;



    // init constructor
    public PersonRecord(String ssNumber, String personName, String dateOfBirth, double taxableIncome)
    {
        // FINISH ME
        this.ssNumber = ssNumber;
        this.personName = personName;
        this.dateOfBirth = dateOfBirth;
        this.taxableIncome = taxableIncome;

        this.taxesOwed = getTaxesOwed();
    }


    public String getSSNumber()
    {
        // FINISH ME
        return this.ssNumber;
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


    public double getTaxableIncome()
    {
        // FINISH ME
        return this.taxableIncome;
    }


    public double getTaxesOwed()
    {
        // FINISH ME
        // You will pay $0.00 for your first 10,000 of taxable income
        // You will pay 10% for income > 10,000 and <= 40,000 of taxable income
        // You will pay 15% for income > 40,000 and <= 70,000 of taxable income
        // You will pay 20% for income > 70,000 and <= 100,000 of taxable income
        // You will pay 25% for income > 100,000 and <= 500,000 of taxable income
        // You will pay 28% for income > 500,000

        double totalMoney = taxableIncome;
        double yoov = 0;

        if(totalMoney > 500000)
        {
            yoov += .28*(totalMoney - 500000);
            totalMoney = 500000;
        }

        if(totalMoney > 100000)
        {
            yoov += .25*(totalMoney - 100000);
            totalMoney = 100000;
        }

        if(totalMoney > 70000)
        {
            yoov += .2*(totalMoney - 70000);
            totalMoney = 70000;
        }

        if(totalMoney > 40000)
        {
            yoov += .15*(totalMoney - 40000);
            totalMoney = 40000;
        }

        if(totalMoney > 10000)
        {
            yoov += .1*(totalMoney - 10000);
        }

        return yoov;
    }



    // ###############################################
    // ###############################################
    // ###############################################
    // setter (modifier or mutator methods)
    // that allow us to change the value of an
    // instance variable (attribute, property, field, record, ...)
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


    public void setTaxableIncome(double taxableIncome)
    {
        // FINISH ME
        this.taxableIncome = taxableIncome;
    }




    // FINISH ME
    // WRITE A toString() method
    public String toString()
    {
        // FINISH ME
        // return all values of instance variables with a label
        return " Person Name:     " + personName + "\n" +
                " SS Number:       " + ssNumber + "\n" +
                " Date of Birth:       " + dateOfBirth + "\n" +
                " Taxable income:           " + taxableIncome + "\n" +
                " Taxes Owed:            " + taxesOwed;
    }


}

