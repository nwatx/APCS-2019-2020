import java.util.*;
import java.io.*;

public class Palinlist
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("palin.dat"));

    int dataSets = Integer.parseInt(br.readLine());

    for(int i = 0; i < dataSets; i++)
    {
      String[] out = br.readLine().split(" ");

      ArrayList<String> ar = new ArrayList<String>();
      ArrayList<String> b = new ArrayList<String>();

      for(int j = 0; j < out.length; j++)
      {
        ar.add(out[j]);
        b.add(out[out.length-1-j]);
      }

      if(ar.equals(b))
      {
        System.out.println("This is a palinlist");
      }
      else
      {
        System.out.println("Not a palinlist");
      }
    }
  }
}
