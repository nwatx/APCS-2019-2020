

import java.util.*;


public class MyBaseAdder
{

    // main method (execution of the program starts here)
    public static void main(String args[])
    {
        System.out.println();

        // FINISH ME
        // put your first name and last name instead of xxxxxx xxxxxxx
        System.out.println("Written by Neo Wang");

        System.out.println();
        System.out.println();
        System.out.println("Base Adder with Integer Numbers");
        System.out.println("==========================================");
        System.out.println();
        System.out.println();
        System.out.println("Example:  ");
        System.out.println("Step 1: Add the one's column (just like in base 10)  ");
        System.out.println("Carry");
        System.out.println("    1");
        System.out.println(" +  24 base 5");
        System.out.println("    43 base 5");
        System.out.println("   ---");
        System.out.println("     2    4+3=7   7%5=2 (the remainder)   7/5=1 (the carry for 1 group of 5)");
        System.out.println();
        System.out.println("Step 2: Add the five's column (just like in base 10)  ");
        System.out.println("Carry");
        System.out.println("   11");
        System.out.println(" +  24 base 5");
        System.out.println("    43 base 5");
        System.out.println("   ---");
        System.out.println("    22    1+2+4=7   7%5=2 (the remainder)   7/5=1 (the carry for 1 group of 25)");
        System.out.println();
        System.out.println("Step 3: Add the twenty-five's column (just like in base 10)  ");
        System.out.println("Carry");
        System.out.println("   11");
        System.out.println(" +  24 base 5");
        System.out.println("    43 base 5");
        System.out.println("   ---");
        System.out.println("   122 base 5   1+0+0=1   ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        boolean finished = false;


        // FINISH ME
        // create a Scanner object that will read from the keyboard
        Scanner scan = new Scanner(System.in);


        while (  !finished  )
        {

            System.out.println();


            try
            {

                int base = 0;

                do
                {
                    try
                    {
                        System.out.println("Enter 0 to quit ");
                        System.out.print("Enter a base. (Example: 5) : ");
                        base = 0;

                        // FINISH ME
                        // read in the next line of input from the scanner object called scan
                        // and store the base into variable base
                        base = scan.nextInt();

                        scan.nextLine(); // flush the buffer
                    }
                    catch(Exception e)
                    {
                        System.out.println();
                        System.out.println();
                        System.out.println("You did not enter a number.");
                        System.out.println();
                        System.out.println();
                        scan.nextLine(); // flush the buffer
                        base = 1;

                    }
                }
                while (base == 1);


                // FINISH ME
                // check and see if base is equal to 0
                if ( base <= 0 || base > 16)
                {
                    System.out.println();
                    System.out.println();
                    System.out.print("Goodbye");
                    System.out.println();
                    System.out.println();
                    break;
                }


                // FINISH ME
                // read in the next line of input from the scanner object called scan
                // and store the number into variable number1
                System.out.print("Enter your first number to add. (Example: 24) : ");
                String number = scan.nextLine();


                // FINISH ME
                // create a new NumberString object and pass it number and base
                NumberString number1 = new NumberString(number,base);
                System.out.println();



                // FINISH ME
                // read in the next line of input from the scanner object called scan
                // and store the number into variable number2
                System.out.print("Enter your second number to add. (Example: 43) : ");
                number = scan.nextLine();



                // FINISH ME
                // create a new NumberString object and pass it number and base
                NumberString number2 = new NumberString(number,base);
                System.out.println();


                System.out.println();


                // FINISH ME
                // find the largest length of the two Strings (number1 and number2)
                int largestLength = Math.max(number1.length(), number2.length());


                System.out.println("Largest length:"+largestLength);


                // FINISH ME
                // call number1's padNum method and pass it largestLength
                number1.padNum(largestLength);
                System.out.println("number1 padded:"+number1);


                // FINISH ME
                // call number2's padNum method and pass it largestLength
                number2.padNum(largestLength);
                System.out.println("number2 padded:"+number2);


                // FINISH ME
                // call number1's add method and pass it number2
                NumberString result = number1.add(number2);


                NumberString dashes = new NumberString("",0);
                dashes.padWith("-", largestLength+1);


                number1.removeLeadingZeroes();
                number2.removeLeadingZeroes();
                result.removeLeadingZeroes();

                number1.padWith(" ",largestLength);
                number2.padWith(" ",largestLength);
                result.padWith(" ",largestLength+1);


                System.out.println();
                System.out.println("==============================================================");
                System.out.println("The sum of");
                System.out.println("           " + number1 + "  in base " + number1.getBase());
                System.out.println("         + " + number2 + "  in base " + number1.getBase());
                System.out.println("          " + dashes);
                System.out.println("          " + result +  "  in base " + result.getBase());
                System.out.println("==============================================================");
                System.out.println();
                System.out.println();


            }
            catch (Exception e)
            {
                System.out.println();
                System.out.println();
                System.out.print("Error in input or calculation.  Please try again. "+e.toString());
                System.out.println();
                System.out.println();
                continue;
            }

            System.out.println();

        }


        System.out.println();



    }
}

class NumberString
{
    String number;
    int base;

    public NumberString(String number, int base)
    {
        // FINISH ME
        // initialize the instance variables (attributes, fields, properties)
        // with the incoming values

        this.number = number;
        this.base = base;
    }

    public int length()
    {
        // FINISH ME
        // return the length of number
        return number.length();
    }

    public int getBase()
    {
        // FINISH ME
        // return the base
        return base;
    }

    public int getDigit(int index)
    {
        // FINISH ME
        // return the digit in the index position as an int
        // remember since the number is stored as a String, we have character values
        // which must be converted to the proper int value
        if (number.charAt(index) >= 'a')
            return number.charAt(index)-87;


        // handle a capital letter 'A' should return 10, 'B' should return 11, etc.
        if (number.charAt(index) >= 'A')
            return number.charAt(index) - 55;


        // handle a digit '0' should return 0, '1' should return 1, etc.
        return number.charAt(index) - 48;
    }


    public void addDigitToFront(String digit)
    {
        // FINISH ME
        // add the digit to the left of number
        number = digit + number;
    }


    public void addDigitToEnd(String digit)
    {
        // FINISH ME
        // add the digit to the right of number
        number = number + digit;
    }


    // FINISH ME
    // this method should pad String number
    // with zeroes on the left
    // for example, suppose that number is "75
    // the call padNum(1); should make the String "75"
    // the call padNum(2); should make the String "75"
    // the call padNum(3); should make the String "075"
    // the call padNum(4); should make the String "0075"
    public void padNum(int length)
    {
        String result = ""+number;

        for(int i = 0; i < length - result.length(); i++)
        {
            result = "0" + result;
        }

        number = result;
    }


    // FINISH ME
    // if the number is "00705"
    // the call removeLeadingZeroes(); should make the String "705"
    public void removeLeadingZeroes()
    {
        if (number.length()==1)
            return;

        // FINISH ME
        // Hint: loop through the String checking the first char each time
        //       if it is equal to '0' then use number = number.substring(1); else break
        //       There is no remove method in the String class

        for(int i = 0; i < number.length(); i++)
        {
            if(number.charAt(i) == '0')
            {
                number = number.substring(1);
            }
            else
            {
                break;
            }
        }

    }

    public void padWith(String s, int length)
    {
        String result = ""+number;

        length = length - result.length();

        for (int i=1; i<=length; i++)
        {
            result = s + result;
        }

        number = result;
    }


    // this method adds this number plus other and returns a NumberString
    // the bases must be the same
    public NumberString add(NumberString other)
    {
        if (base != other.base)
            return new NumberString("0",10);


        int carry = 0; // this will hold the carry for 1 column

        NumberString newNumber = new NumberString("",base);


        for (int i=number.length()-1; i>=0; i--)
        {
            int x = getDigit(i);
            int y = other.getDigit(i);

            // this adds the digits in the i column
            int sum = x + y + carry;


            // get the digit for the column
            int newDigit = sum % base;


            if (newDigit >= 10)
            {
                switch(newDigit)
                {
                    case 10: newNumber.addDigitToFront("A"); break;
                    case 11: newNumber.addDigitToFront("B"); break;
                    case 12: newNumber.addDigitToFront("C"); break;
                    case 13: newNumber.addDigitToFront("D"); break;
                    case 14: newNumber.addDigitToFront("E"); break;
                    case 15: newNumber.addDigitToFront("F"); break;
                }

            }
            else
            {
                newNumber.addDigitToFront(""+newDigit);
            }


            // get the carry for the column
            carry = sum / base;

        }

        if (carry != 0)
        {
            newNumber.addDigitToFront(""+carry);
        }

        return newNumber;
    }


    public String toString()
    {
        return number;
    }

}




