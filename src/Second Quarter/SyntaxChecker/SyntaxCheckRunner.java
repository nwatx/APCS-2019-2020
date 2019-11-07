//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Stack;
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class SyntaxCheckRunner
{
	public static void main ( String[] args ) throws IOException
	{
		Stack<Character> stack;
    BufferedReader in = new BufferedReader(new FileReader("syntax.dat"));

    int cases = Integer.parseInt(in.readLine());

    for(int i = 0; i < cases; i++)
    {
      char[] line = in.readLine().toCharArray();
      stack = new Stack<Character>();
      for(int j = 0; j < line.length; j++)
      {
        if(line[j] == '[' || line[j] == '(' || line[j] == '<')
        {
          stack.push(line[j]);
        }
        else if(!stack.isEmpty())
        {
          if(stack.peek() == '[' && line[j] == ']')
          {
            stack.pop();
          }
          else if(stack.peek() == '<' && line[j] == '>')
          {
            stack.pop();
          }
          else if(stack.peek() == '(' && line[j] == ')')
          {
            stack.pop();
          }
        }

      }

      System.out.println(stack.isEmpty());
    }
	}
}
