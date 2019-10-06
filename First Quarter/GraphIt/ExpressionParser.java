
import java.util.*;


public class ExpressionParser
{

    char fnSQRT = '!';

    // these variables are for parsing infix expressions
    // char []  opStack;  // array 1..100
    Stack <Character> opStack;

    int      opTop;    // top of op stack

    // this list holds all of the numbers found in the infix expression
    // A=1, B=2, C=3, etc.   a lower case letter represents x
    // note that the zero position is not used
    //double [] numList;       // list of values
    //int       numCount;      // holds the number of numbers in the list
    //char []   numVarList;    // holds tokens
    //char []   numVarListxyz; // holds actual variable name if it is a variable


    ArrayList <Double> numList;          // list of values
    int       numCount;                  // holds the number of numbers in the list
    ArrayList <Character> numVarList;    // holds tokens
    ArrayList <Character> numVarListxyz; // holds actual variable name if it is a variable

    ArrayList <String> functionList;
    ArrayList <Character> operatorList;

    Results results;


    // default constructor
    public ExpressionParser()
    {
        createLists();
    }


    // init constructor	with input infix expression variable s
    public ExpressionParser(String s)
    {
        createLists();

        System.out.println("=====================================");
        System.out.println();
        results = parseInfixExpression(s);
        if (!results.getIsOk())
        {
            System.out.println("Invalid expression.  Parsing error.");
            return;
        }
        System.out.println(s + "  infix = " + results.getNS());
        results = evaluatePostFixExpression(results.getNS());
        if (!results.getIsOk())
        {
            System.out.println("Invalid expression.  Parsing error.");
            return;
        }
        System.out.println(s + "  output = " + results.getN());

    }



// this assumes that all blanks have been removed
// startPos should indicate the beginning left parenthesis (
// returns a negative # if there is an error, else returns stopPos
//procedure matchParenthesis(s : String; startPos : integer; var stopPos : integer; var perror : integer);

    public Results matchParenthesis(String s, int startPos)
    {
        int pTop;
        int k;
        boolean done;
        int pError;
        int stopPos;

        Results results = new Results();

        pError = startPos;  // position of error
        pTop = 0;
        k = startPos;
        stopPos = startPos;
        if (s.charAt(k)!='(')
        {
            results.setError(-1);
            results.setIsOk(false);
            return results;
        }

        done = false;
        k = k + 1;
        while (!done && (k < s.length()))
        {
            if (s.charAt(k) == '(')
                pTop = pTop + 1;


            if (s.charAt(k) == ')')
                pTop = pTop - 1;

            if (pTop == -1)
            {
                done = true;
                if (k+1 < s.length())
                    pError = -1;
                else
                    pError = k;
                stopPos = k;
            }
            else
            {
                k = k + 1;
            }
        } // of while

        results.setError(0);
        results.setIsOk(true);

        if (pError==-1)
        {
            results.setError(-1);
            results.setIsOk(false);
            return results;
        }
        if (pTop==-1)
        {
            return results; // all is well
        }

        results.setError(-1);
        results.setIsOk(false);
        return results;
    }  // end of public Results matchParenthesis(String s, int startPos)



    public boolean isOperator(char op)
    {
        if (operatorList.contains(op))
            return true;

        return false;
    } // end of public boolean isOperator(char op)


    // tokens must be capital letters
    public boolean isToken(char ch)
    {
        if ( (ch >= 'A') && (ch <= 'Z') )
            return true;
        else
            return false;
    } // end of public boolean isToken(char ch)



    // variables must be lower case letters
    public boolean isVariable(char ch)
    {
        if ( (ch >= 'a') && (ch <= 'z') )
            return true;
        else
            return false;
    } // end of public boolean isVariable(char ch)



    // is it a 3 letter function
    public boolean isFunction3(String s, int theStart)
    {
        String ts;

        if (theStart+3 >= s.length())
            return false;

        ts = s.substring(theStart,theStart+3);
        ts = ts.toUpperCase();

        if (functionList.contains(ts))
            return true;

        return false;
    } // end of public boolean isFunction3(String s, int theStart)



    // is it a 4 letter function
    public boolean isFunction4(String s, int theStart)
    {
        String ts;

        if (theStart+4 >= s.length())
            return false;

        ts = s.substring(theStart,theStart+4);
        ts = ts.toUpperCase();

        if (functionList.contains(ts))
            return true;

        return false;
    } // end of public boolean isFunction4(String s, int theStart)




    // is it a number
    public boolean isNumeric(char ch)
    {
        if ( (ch >= '0') && (ch <= '9') )
            return true;
        else if ( (ch == '+') || (ch == '-') )
            return true;
        else
            return false;
    } // end of public boolean isNumeric(char ch)


    // is it a digit
    public boolean isDigit(char ch)
    {
        if ( (ch >= '0') && (ch <= '9') )
            return true;
        else
            return false;
    } // end of public boolean isDigit(char ch)


    // get the sign + or -
    public String getSign(char ch)
    {
        if (ch == '+')
            return "+";
        else if (ch == '-')
            return "-";
        else
            return "+";
    } // end of public String getSign(char ch)



    public int infixPriority(char op)
    {
        if (op == '+')
            return 1;
        if (op == '-')
            return 1;

        if (op == '*')
            return 2;
        if (op == '/')
            return 2;
        if (op == '%')
            return 2;

        if (op == '^')
            return 4;

        if (op == fnSQRT)
            return 5;

        return 0;
    } // end of public int infixPriority(char op)



    public int inStackPriority(char op)
    {
        if (op == '(')
            return 0;

        // + or -
        if (op == '+')
            return 1;
        if (op == '-')
            return 1;

        // * or / or %
        if (op == '*')
            return 2;
        if (op == '/')
            return 2;
        if (op == '%')
            return 2;

        // exponent
        if (op == '^')
            return 4;

        // sqrt
        if (op == fnSQRT)
            return 5;

        return 0;
    } // end of public int inStackPriority(char op)


    public char peekOpStack()
    {
        if (opTop >= 0)
        {
            return opStack.peek();
        }
        else
        {
            return '?';
        }
    } // end of public char peekOpStack()



    public boolean isEmptyOpStack()
    {
        return opStack.isEmpty();
    } // end of public boolean isEmptyOpStack()



    public String emptyOpStack(String ns)
    {
        char tempOp;
        while (!opStack.isEmpty())
        {
            tempOp = opStack.pop();
            ns = ns + tempOp;
        }
        opTop = -1;
        return ns;
    } // end of public String emptyOpStack(String ns)



    public String handleRightParenthesis(String ns)
    {
        boolean done = false;
        char tempOp;

        while ( (!opStack.isEmpty()) && !done)
        {
            tempOp = opStack.pop();
            opTop = opTop - 1;
            if ( tempOp == '(' )
                done = true;
            else
                ns = ns + tempOp;
        }

        return ns;
    } // end of public String handleRightParenthesis(String ns)



    // returns ns (adds on to the post fix expression)
    public String handleOperator(char op, String ns)
    {
        boolean done = false;
        char tempOp;
        char inStackOp = '?';

        // at the end add to the opStack
        while (!done)
        {
            if (opStack.isEmpty())
            {
                inStackOp = '?';
            }
            else
            {
                inStackOp = opStack.peek();
            }

            if ((infixPriority(op) > inStackPriority(inStackOp)) )
            {
                // push operator
                opTop = opTop + 1;
                opStack.push(op);
                done = true;
            }
            else if (!opStack.isEmpty())
            {
                // pop stack and add to ns
                if (opTop >= 0)
                {
                    tempOp = opStack.pop();
                    opTop = opTop - 1;
                    ns = ns + tempOp;
                }
                else
                {
                    done = true;
                    ns = "";  // error in input
                }
            }
            else
            {
                done = true;
                ns = "";
            }
        }
        return ns;
    } // end of public String handleOperator(char op, String ns)



    // we will need to return sn, k, ierror and n
    public Results getNumber(String s, int j, String sn, int k, double n)
    {
        int ierror = 0;
        boolean isPos = true;
        boolean done = false;
        char ch;

        Results results = new Results();


        k = j;
        sn = "";  // string that holds the number
        while (!done)
        {
            if (k >= s.length())
            {
                done = true;
            }
            else
            {
                ch = s.charAt(k);
                if (ch == '+')
                {
                    if (k == j)
                        k = k + 1;
                    else
                        done = true;
                }
                else if (ch == '-')
                {
                    if (k == j)
                    {
                        isPos = false;
                        sn = sn + ch;
                        k = k + 1;
                    }
                    else
                    {
                        done = true;
                    }
                }
                else if (ch == '.')
                {
                    sn = sn + ch;
                    k = k + 1;
                }
                else if (isDigit(ch))
                {
                    sn = sn + ch;
                    k = k + 1;
                }
                else
                {
                    done = true;
                }
            }
        }
        //system.val(sn,n,ierror);
        try
        {
            n = Double.parseDouble(sn);
        }
        catch (Exception e)
        {
            n = 0;
        }
        results.setSN(sn);
        results.setK(k);
        results.setN(n);
        return results;
    } // end of public Results getNumber(String s, int j, String sn, int k, double n)




    // parses infix string s and outputs postfix string ns
// procedure parseInfixExpression(s : String; var ns : String; var isOk : boolean);
    public Results parseInfixExpression(String s)
    {
        int j = 0; //     : integer; // loop variable
        char ch = ' '; //    : char;    // temp variable to hold a char from infix string s
        String sn = ""; //    : String;  // string representation of number that was found
        int k=0; //     : integer; // index in s
        double n=0; //     : real;    // the number found in infix string s
        int ierror=0; // : integer;  // error code returned, i.e. was it really a number?
        char prevCh = '?'; //  : char;
        String fnName = ""; //  : String;
        int stopPos=0; //  : integer;
        int pError=0; //   : integer;  // parenthesis error

        String  ns = "";
        boolean isOk = true;

        // these are global
        //opStack : array[1..100] of char;
        //opTop   : integer;

        s = s.trim(); // get rid of any pre or post spaces
        if (s.equals(""))
            isOk = false;
        else
            isOk = true;

        resetLists();

        opTop = -1;
        numCount = 0;

        while (j < s.length())
        {
            ch = s.charAt(j);

            if (ch == ' ')
            {
                j = j + 1;
                continue;
            }

            prevCh = '+';
            if (j > 0)
            {
                prevCh = s.charAt(j-1);
            }

            if (ch == ';')
            {
                j = j + 1;
                // not really needed
            }
            else if (  (isOperator(ch) && !isOperator(prevCh))
                    && (isOperator(ch) && (prevCh != '('))
            )
            {
                ns = handleOperator(ch,ns);
                j = j + 1;
            }
            else if (ch == '(')
            {
                opTop = opTop + 1;
                opStack.push(ch);
                j = j + 1;
            }
            else if (ch == ')')
            {
                ns = handleRightParenthesis(ns);
                j = j + 1;
            }
            else if (isNumeric(ch))
            {
                //getNumber(s,j,sn,k,n,ierror);
                Results results = getNumber(s,j,sn,k,n);
                k = results.getK();
                sn = results.getSN();
                n = results.getN();
                j = k;
                numCount = numCount + 1;
                numList.add(n); //    [numCount] = n;
                numVarList.add((char)(numCount+64));
                numVarListxyz.add( (char)(numCount+64) );

                ns = ns + (char)(numCount+64);
            }
            else if (isFunction3(s,j))
            {
                fnName = s.substring(j,j+3); // for function name
                fnName = fnName.toUpperCase();
                numCount = numCount + 1;
                numList.add(0.0); // dummy value to be filled in later
                numVarList.add((char)(numCount+96));
                numVarListxyz.add((char)(numCount+96));
                ns = ns + (char)(numCount+96);
                j = j + 3;
                // fix me
            }
            else if (isFunction4(s,j))
            {
                fnName = s.substring(j,j+4); //  system.Copy(s,j,4);  // for function name
                fnName = fnName.toUpperCase();
                matchParenthesis(s,j+4); // fix me ,stopPos,perror);
                // fix me
                // system.Insert(')',s,stopPos);
                if (fnName.equals("SQRT"))
                {
                    // system.Delete(s,j,4);
                    // system.Insert('(1!',s,j);
                }
            }
            else if (isVariable(ch))
            {
                //system.Copy(s,j,3); ??????  for function
                numCount = numCount + 1;
                numList.add(0.0); // dummy value to be filled in later
                numVarList.add((char)(numCount+96)); // token to be used
                numVarListxyz.add(ch); // store the actual variable name
                ns = ns + (char)(numCount+96);
                j = j + 1;
            }
            else
            {
                isOk = false;
            }
        }

        ns = emptyOpStack(ns);

        Results results = new Results();
        results.setError(ierror);
        results.setIsOk(isOk);
        results.setNS(ns);

        // results.s
        return results;
    } // end of public Results parseInfixExpression(String s)



    // puts the value for x into the numList
// make sure that the numList exists
//procedure fillInVariableValue(theVariable : char; theValue : real);
    public void fillInVariableValue(char theVariable, double theValue)
    {
        for (int j=0; j<numVarListxyz.size(); j++)
        {
            if (theVariable == numVarListxyz.get(j))
            {
                numList.set(j,theValue);
                break;
            }
        }
    }


    // function lookUpTokenValue(ch : char) : real;
    public double lookUpTokenValue(char ch)
    {
        int i=0;

        while (i < numVarList.size())
        {
            if (numVarList.get(i) == ch)
            {
                return numList.get(i);
            }
            i++;
        }
        return 0;
    }


    //procedure doTheOperation(leftOperand : real; op : char; rightOperand : real; var theResult : real; var isOk : boolean);
    public Results doTheOperation(double leftOperand, char op, double rightOperand)
    {
        boolean isOk = true;
        double theResult = 0;

        if (op == '+')
        {
            try
            {
                theResult = leftOperand + rightOperand;
            }
            catch (Exception errorAdd)
            {
                theResult = 0;
            }
        }
        else if (op == '-')
        {
            try
            {
                theResult = leftOperand - rightOperand;
            }
            catch (Exception errorSubtraction)
            {
                theResult = 0;
            }

        }
        else if (op == '*')
        {
            try
            {
                theResult = leftOperand * rightOperand;
            }
            catch (Exception errorMultiply)
            {
                theResult = 0;
            }
        }
        else if (op == '/')
        {
            try
            {
                theResult = leftOperand / rightOperand;
            }
            catch (Exception errorDivide)
            {
                theResult = 0;
            }
        }
        else if (op == '%')
        {
            try
            {
                // in c you will need to type cast to an int
                theResult = leftOperand % rightOperand;
            }
            catch (Exception errorMod)
            {
                theResult = 0;
            }
        }
        else if (op == '^')
        {
            try
            {
                theResult = Math.pow(leftOperand,rightOperand);
            }
            catch (Exception errorPow)
            {
                theResult = 0;
            }
        }
        else if (op == fnSQRT)
        {
            try
            {
                theResult = Math.sqrt(leftOperand);
            }
            catch (Exception errorPow)
            {
                theResult = 0;
            }
        }
        else
        {
            isOk = false;
            theResult = 0;
        }

        Results results = new Results();
        results.setIsOk(isOk);
        results.setN(theResult);

        return results;

    }



    // procedure replaceVariableWithValueInNumList(theVariable : char; theValue : real);
    public void replaceVariableWithValueInNumList(char theVariable, double theValue)
    {
        for (int j=0; j<numList.size(); j++)
        {
            if ((numVarList.get(j) >= 'a') && (numVarList.get(j) <= 'z'))
            {
                if (numVarListxyz.get(j) == theVariable)
                    numList.set(j, theValue);
            }
        }
    }


    // evaluate the postfix expression postfixExpression   (ABC*+  =  A + B * C)
    public Results evaluatePostFixExpression(String postfixExpression)
    {
        double n = 0;
        boolean isOk = true;

        int j = 0;
        char ch = ' ';
        Stack <Double> answerStack = new Stack <Double>(); //  : array[1..100] of real;
        int answerTop = 0;
        double rightOperand=0;
        double leftOperand=0;
        double theResult=0;

        Results results = new Results();

        while (isOk && (j < postfixExpression.length()))
        {

            ch = postfixExpression.charAt(j);

            if (isOperator(ch))
            {
                if (answerTop < 2)
                {
                    isOk = false;
                }
                else
                {
                    try
                    {
                        rightOperand = answerStack.pop();
                        answerTop = answerTop - 1;
                        leftOperand = answerStack.pop();
                        answerTop = answerTop - 1;

                        results = doTheOperation(leftOperand,ch,rightOperand);
                        theResult = results.getN();
                        isOk = results.getIsOk();

                        answerTop = answerTop + 1;
                        answerStack.push(theResult);
                        n = theResult;
                    }
                    catch(Exception e)
                    {
                        isOk = false;
                        n = 0;
                    } // of catch
                } // of else
            } // if (isOperator(ch))
            else if (isToken(ch) || isVariable(ch))
            {
                try
                {
                    answerTop = answerTop + 1;
                    answerStack.push(lookUpTokenValue(ch));
                    n = answerStack.peek();  // it might just have  y = 5 (no operators)
                }
                catch (Exception e)
                {
                    isOk = false;
                    n = 0;
                }
            } // else if (isToken(ch) || isVariable(ch))

            j = j + 1;

        }


        results.setIsOk(isOk);
        if (isOk)
        {
            results.setError(0);
        }
        else
        {
            results.setError(-1);
        }

        if (!answerStack.isEmpty())
        {
            if (answerStack.size()==1)
                results.setN(answerStack.pop());
        }

        return results;
    } //end of public Results evaluatePostFixExpression(String postfixExpression)


    public void resetLists()
    {
        opStack.clear();
        opTop = -1;
        numCount = 0;
        numList.clear(); //    [numCount] = n;
        numVarList.clear();
        numVarListxyz.clear();
    } // end of public void resetLists()


    public void createLists()
    {
        functionList = new ArrayList<String>();
        functionList.add("SIN");
        functionList.add("COS");
        functionList.add("TAN");
        // etc.


        operatorList = new ArrayList<Character>();
        operatorList.add('+');
        operatorList.add('-');
        operatorList.add('*');
        operatorList.add('/');
        operatorList.add('%');
        operatorList.add('^');
        operatorList.add(fnSQRT);
        // etc.


        opStack = new Stack<Character>();
        opTop = -1;

        numList = new ArrayList<Double>();
        numCount = 0;

        numVarList = new ArrayList<Character>();    // holds tokens
        numVarListxyz = new ArrayList<Character>(); // holds actual variable name if it is a variable

    } // end of public void createLists()






    // test methods
    public static void main(String [] args)
    {
        ExpressionParser parser = new ExpressionParser();


        System.out.println("=====================================");
        System.out.println();
        String s = "((a)+(b*c))";
        Results results = parser.matchParenthesis(s,0);
        System.out.println(s + "  match result = " + results.getIsOk());


        System.out.println("=====================================");
        System.out.println();
        s = "5+3*2";
        results = parser.parseInfixExpression(s);
        System.out.println(s + "  infix = " + results.getNS());
        results = parser.evaluatePostFixExpression(results.getNS());
        System.out.println(s + "  output = " + results.getN());


        System.out.println("=====================================");
        System.out.println();
        s = "5+3*x";
        results = parser.parseInfixExpression(s);
        System.out.println(s + "  infix = " + results.getNS());
        parser.replaceVariableWithValueInNumList('x',5);
        System.out.println("x = " + 5);
        results = parser.evaluatePostFixExpression(results.getNS());
        System.out.println(s + "  output = " + results.getN());


        System.out.println("=====================================");
        System.out.println();
        s = "5+3*x+2";
        results = parser.parseInfixExpression(s);
        System.out.println(s + "  infix = " + results.getNS());
        parser.replaceVariableWithValueInNumList('x',5);
        System.out.println("x = " + 5);
        results = parser.evaluatePostFixExpression(results.getNS());
        System.out.println(s + "  output = " + results.getN());

        System.out.println("=====================================");
        System.out.println();
        s = "5+3^x+2";
        System.out.println("s = " + s);
        results = parser.parseInfixExpression(s);
        System.out.println(s + "  infix = " + results.getNS());
        parser.replaceVariableWithValueInNumList('x',3);
        System.out.println("x = " + 3);
        results = parser.evaluatePostFixExpression(results.getNS());
        System.out.println(s + "  output = " + results.getN());

        s = "5+3^3+2";
        parser = new ExpressionParser(s);

    } // end of public static void main(String [] args)






}  // end of class


class Results
{
    String  sn;
    String  ns; // new string
    int     k;
    int     error;
    boolean isOk;
    double  n;
    int     stopPos;

    public Results()
    {
        sn = "";
        ns = "";
        k = 0;
        error = 0;
        isOk = true;
        n = 0;
        stopPos = 0;
    }

    public String getSN()
    {
        return sn;
    }

    public void setSN(String sn)
    {
        this.sn = sn;
    }

    public String getNS()
    {
        return ns;
    }

    public void setNS(String ns)
    {
        this.ns = ns;
    }

    public int getError()
    {
        return error;
    }

    public void setError(int error)
    {
        this.error = error;
    }

    public boolean getIsOk()
    {
        return isOk;
    }

    public void setIsOk(boolean isOk)
    {
        this.isOk = isOk;
    }

    public double getN()
    {
        return n;
    }

    public void setN(double n)
    {
        this.n = n;
    }

    public int getK()
    {
        return k;
    }

    public void setK(int k)
    {
        this.k = k;
    }

} // end of inner class Results
