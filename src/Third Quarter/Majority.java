import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Majority {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File("majority.txt")));

        for(int i = 0; i < 5; i++)
        {
            char[] line = in.readLine().toCharArray();

            HashMap<Character, Integer> map = new HashMap<>();

            for(int j = 0; j < line.length; j++)
            {
                if(!map.containsKey(line[j]))
                {
                    map.put(line[j], 1);
                }
                else
                {
                    map.put(line[j], map.get(line[j]) + 1);
                }
            }

            //System.out.println(map);

            boolean yoov = true;

            for(char a : map.keySet())
            {
                if(map.get(a) > (double)line.length / 2)
                {
                    System.out.println("Majority: " + a);
                    yoov = false;
                    break;
                }
            }

            if(yoov)
            {
                System.out.println("No majority");
            }
        }
    }
}
