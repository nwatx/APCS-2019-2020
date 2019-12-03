import java.util.*;
import java.io.*;

public class WellFormedExpressions
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("expression.dat"));

    int dataSets = Integer.parseInt(br.readLine());

    for(int i = 0; i < dataSets; i++)
    {
      String input = br.readLine();
      List<String> yoov = Arrays.asList(input.split("[-+*/]"));

      System.out.println(input);
      System.out.println(yoov);

      if(!yoov.contains(" ") && !yoov.contains("") && !yoov.isEmpty() && !yoov.contains("(") && !yoov.contains(")"))
      {
        System.out.println("Well Formed");
      }
      else
      {
        System.out.println("Not Well Formed");
      }

      System.out.println();
    }
  }
}
