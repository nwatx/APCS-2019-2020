

import java.util.*;


public class MyBitStuff
{

    // this method makes the expression 12&4 become 12 & 4
    // so that we can put it into a Scanner object
    // and split it, as well as doing the same for
    // the other bit operators
    public static String fixExpression(String expression)
    {
        if (expression.indexOf("&") > 0)
        {
            expression = expression.replaceAll("&"," & ");
        }

        if (expression.indexOf("|") > 0)
        {
            expression = expression.replaceAll("\\|"," \\| ");
        }
        if (expression.indexOf("^") > 0)
        {
            expression = expression.replaceAll("\\^"," \\^ ");
        }

        if (expression.indexOf("<<") < 0 && expression.indexOf("<") > 0)
        {
            expression = expression.replaceAll("<","<<");
        }

        if (expression.indexOf(">>") < 0 && expression.indexOf(">") > 0)
        {
            expression = expression.replaceAll(">",">>");
        }

        if (expression.indexOf(">>") > 0)
        {
            expression = expression.replaceAll(">>"," >> ");
        }

        if (expression.indexOf("<<") > 0)
        {
            expression = expression.replaceAll("<<"," << ");
        }

        if (expression.indexOf("~")>=0)
        {
            expression = expression.replaceAll("\\~", "\\~ ");
        }


        return expression;
    }


    // FINISH ME
    // this method should create a String that has the number
    // with spaces on the left and then return it
    // for example, the call padNum(12,1); should return the String "12"
    // for example, the call padNum(12,2); should return the String "12"
    // for example, the call padNum(12,3); should return the String " 12"
    // for example, the call padNum(12,4); should return the String "  12"
    // for example, the call padNum(12,5); should return the String "   12"
    public static String padNum(int num, int length)
    {
        String result = ""+num;

        // put your code here

        for(int i = 0; i < length - result.length(); i++)
        {
            result = " " + result;
        }

        return result;
    }


    // FINISH ME
    // this method should create a String that has the binary number
    // with zeroes on the left and then return it
    // for example, the call padNum("1011",1); should return the String "1011"
    // for example, the call padNum("1011",2); should return the String "1011"
    // for example, the call padNum("1011",3); should return the String "1011"
    // for example, the call padNum("1011",4); should return the String "1011"
    // for example, the call padNum("1011",5); should return the String "01011"
    // for example, the call padNum("1011",6); should return the String "001011"
    // for example, the call padNum("1011",7); should return the String "0001011"
    // for example, the call padNum("1011",8); should return the String "00001011"
    public static String padBinaryStringWithZeroes(String num, int length)
    {
        String result = ""+num;

        // put your code here

        for(int i = 0; i < length - result.length(); i++)
        {
            result = "0" + result;
        }

        return result;
    }


    // main method (execution of the program starts here)
    public static void main(String args[])
    {
        System.out.println();

        // FINISH ME
        // put your first name and last name instead of xxxxxx xxxxxxx
        System.out.println("Written by Neo Wang");

        System.out.println();
        System.out.println();
        System.out.println("Bit Stuff with Integer Numbers");
        System.out.println("==========================================");
        System.out.println();
        System.out.println();
        System.out.println("Operators:  &   Bitwise And                 Example: 12 & 9  ");
        System.out.println("Operators:  |   Bitwise Or                  Example: 12 | 9  ");
        System.out.println("Operators:  ^   Bitwise Exclusive Or        Example: 12 ^ 9  ");
        System.out.println();
        System.out.println("Bitwise operators can be used with all integer types, including long.");
        System.out.println("long, int, short, char, byte, but NOT with double, float, boolean, etc.");
        System.out.println();
        System.out.println();
        System.out.println("Operators:  <<  Left Bit Shift              Example: 12 << 1  (keeps sign)");
        System.out.println("Operators:  >>  Right Bit Shift             Example: 12 >> 1  (keeps sign)");
        System.out.println("Operators:  >>> Right Unsigned Bit Shift    Example: 12 >>> 1 (positive)  ");
        System.out.println();
        System.out.println("Bit shift operators can be used with all integer types, including long.");
        System.out.println("long, int, short, char, byte, but NOT with double, float, boolean, etc.");
        System.out.println();
        System.out.println();
        System.out.println("Operators:  ~   One's Complement           Example: ~12  ");
        System.out.println();
        System.out.println("The ~ operator can be used with all integer types, including long.");
        System.out.println("long, int, short, char, byte, but NOT with double, float, boolean, etc.");
        System.out.println();
        System.out.println();
        System.out.println("http://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html");
        System.out.println();
        System.out.println("Try positive and negative numbers.");
        System.out.println("Try Integer.MAX_VALUE " + String.format("%,d",Integer.MAX_VALUE) + "  and INTEGER.MIN_VALUE "  + String.format("%,d",Integer.MIN_VALUE));
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
                System.out.println("Enter Q or q to quit or ");
                System.out.print("enter a bitwise expression. (Example: 12 & 1) : ");

                // FINISH ME
                // read in the next line of input from the scanner object called scan
                String bitExpression = scan.nextLine();


                // FINISH ME
                // fix the bitExpression so that it will have a space before and after the operator
                // call the appropriate method from above
                bitExpression = fixExpression(bitExpression);


                // debug code
                // this should put spaces around the operators and operands
                // so that we can parse the bitExpression
                // System.out.print("bitExpression="+bitExpression);

                System.out.println();


                // FINISH ME
                // check and see if bitExpression is equal to a "" or "Q" or "q"
                if ( bitExpression.equals("") || bitExpression.equals("Q") || bitExpression.equals("q") )
                {
                    System.out.println();
                    System.out.println();
                    System.out.print("Goodbye");
                    System.out.println();
                    System.out.println();
                    break;
                }


                // FINISH ME
                // create a new Scanner object and pass it bitExpression
                Scanner scanExpression = new Scanner(bitExpression);



                // define variables to hold input values
                int x = 0;
                int y = 0;
                String bitOperator = "";


                if (bitExpression.substring(0,1).equals("~")) // scanExpression should be in the form ~ x
                {
                    // debug code to see if we are in the right spot
                    // System.out.print("reading in the bitOperator and x for ~");


                    // FINISH ME
                    // get the next element from the Scanner object called scanExpression
                    // which should be the ~  (so you want it back as a String)
                    bitOperator = scanExpression.next();


                    // FINISH ME
                    // get the next element from the Scanner object called scanExpression,
                    // but ask the Scanner object to return the value as an integer
                    // this should be the number after the ~
                    x = Integer.parseInt(scanExpression.next());
                }
                else
                {
                    // debug code to see if we are in the right spot
                    // System.out.print("reading in x bitOperator y for bit shifts and bitwise.");

                    // FINISH ME
                    // get the next element from the Scanner object called scanExpression,
                    // but ask the Scanner object to return the value as an integer
                    x = scanExpression.nextInt();

                    // FINISH ME
                    // get the next element from the Scanner object called scanExpression
                    // it should return a String
                    bitOperator = scanExpression.next();


                    // FINISH ME
                    // get the next element from the Scanner object called scanExpression,
                    // but ask the Scanner object to return the value as an integer
                    y = scanExpression.nextInt();
                }



                int result = 0;

                // FINISH ME
                // convert x into a binary string (use Integer.???)
                String xInBinary = Integer.toBinaryString(x) + "";


                String xPadded = padNum(x,xInBinary.length());


                // FINISH ME
                // convert y into a binary string (use Integer.????)
                String yInBinary = Integer.toBinaryString(y) + "";


                String yPadded = padNum(y, yInBinary.length());

                String resultInBinary = "";


                // variables to handle one's complement
                boolean isComplementOperator = false;
                int result1 = 0;
                int result2 = 0;
                String resultInBinary1 = "";
                String resultInBinary2 = "";


                if (bitOperator.equals("&"))
                {
                    // FINISH ME
                    // find the bitwise result of x and y
                    result = x & y;

                    // FINISH ME
                    // convert result into a binary string
                    resultInBinary = Integer.toBinaryString(result);

                    resultInBinary = padBinaryStringWithZeroes(resultInBinary,32);
                }
                else if (bitOperator.equals("|"))
                {
                    // FINISH ME
                    // find the bitwise result of x or y
                    result = x | y;


                    // FINISH ME
                    // convert result into a binary string
                    resultInBinary = Integer.toBinaryString(result);

                    resultInBinary = padBinaryStringWithZeroes(resultInBinary,32);
                }
                else if (bitOperator.equals("^"))
                {
                    // FINISH ME
                    // find the bitwise result of x exclusive or y
                    result = x ^ y;


                    // FINISH ME
                    // convert result into a binary string
                    resultInBinary = Integer.toBinaryString(result) + "";

                    resultInBinary = padBinaryStringWithZeroes(resultInBinary,32);
                }
                else if (bitOperator.equals("<<"))
                {
                    // FINISH ME
                    // find the bitshift result of x and y
                    result = x << y;


                    // FINISH ME
                    // convert result into a binary string
                    resultInBinary = Integer.toBinaryString(result) + "";

                    resultInBinary = padBinaryStringWithZeroes(resultInBinary,32);
                }
                // FINISH ME
                // check and see if bitOperator is equal to ">>"
                else if (bitOperator.equals(">>"))
                {
                    // FINISH ME
                    // find the bitshift result of x and y
                    result = x >> y;


                    // FINISH ME
                    // convert result into a binary string
                    resultInBinary = Integer.toBinaryString(result) + "";

                    resultInBinary = padBinaryStringWithZeroes(resultInBinary,32);
                }
                // FINISH ME
                // check and see if bitOperator is equal to ">>>"
                else if (bitOperator.equals(">>>"))
                {
                    // FINISH ME
                    // find the bitshift result of x and y
                    result = x >>> y;


                    // FINISH ME
                    // convert result into a binary string
                    resultInBinary = Integer.toBinaryString(result) + "";

                    resultInBinary = padBinaryStringWithZeroes(resultInBinary,32);
                }

                else if (bitOperator.equals("~"))
                {
                    isComplementOperator = true;

                    // FINISH ME
                    // find the one's complement of x
                    result1 = ~x;      // one's complement


                    // FINISH ME
                    // find the two's complement of x
                    result2 = ~y;  // two's complement


                    // FINISH ME
                    // convert result1 into a binary string
                    resultInBinary1 = result1 + "";

                    resultInBinary1 = padBinaryStringWithZeroes(resultInBinary1,32);


                    // FINISH ME
                    // convert result2 into a binary string
                    resultInBinary2 = result2 + "";

                    resultInBinary2 = padBinaryStringWithZeroes(resultInBinary2,32);
                }
                else
                {
                    System.out.println();
                    System.out.println();
                    System.out.print("Error in expression.  Please try again. ");
                    System.out.println();
                    System.out.println();
                    continue;
                }


                if (isComplementOperator)
                {
                    System.out.println();
                    System.out.println("==============================================================");
                    System.out.println("" + bitOperator + x + "  =  " + String.format("%,d",result1));
                    System.out.println();

                    System.out.println(padBinaryStringWithZeroes(xInBinary,32) + "  x=" + String.format("%,4d",x) + " operator=" + bitOperator);
                    System.out.println(resultInBinary1 + " ones complement   ~x=" + String.format("%,4d",~x));
                    System.out.println(resultInBinary2 + " twos complement ~x+1=" + String.format("%,4d",~x+1));

                    System.out.println("==============================================================");
                    System.out.println();
                    System.out.println();
                }
                else
                {
                    System.out.println();
                    System.out.println("=======================================");
                    System.out.println(x   + " " + bitOperator + " " + y   + "  =  " + String.format("%,d",result));
                    System.out.println();

                    System.out.println(padBinaryStringWithZeroes(xInBinary,32) + " " + String.format("%,4d",x) + " " + bitOperator);
                    System.out.println(padBinaryStringWithZeroes(yInBinary,32) + " " + String.format("%,4d",y) );
                    System.out.println(resultInBinary);

                    System.out.println("=======================================");
                    System.out.println();
                    System.out.println();
                }

            }
            catch (Exception e)
            {
                System.out.println();
                System.out.println();
                //System.out.print("Error in expression.  Please try again. "+e.toString());
                e.printStackTrace();
                System.out.println();
                System.out.println();
                continue;
            }

            System.out.println();

        }


        System.out.println();

        // try other stuff and see if it works
        // boolean b = 12;
        // System.out.println(b & 1);
        // System.out.println(String.format("%,d",Integer.MAX_VALUE));


    }
}