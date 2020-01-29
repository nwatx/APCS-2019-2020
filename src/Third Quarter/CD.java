import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CD {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File("CD.txt")));

        int trials = Integer.parseInt(br.readLine());

        for(int i = 0; i < trials; i++)
        {
            String time = br.readLine();
            String[] thing1 = time.split(":");
            int totalTime = 60*Integer.parseInt(thing1[0]) + Integer.parseInt(thing1[1]);

            String[] line = br.readLine().split("  *");
            int[] lineInt = new int[line.length];
            for(int z = 0; z < line.length; z++)
            {
                String[] thing = line[z].split(":");
                lineInt[z] = 60*Integer.parseInt(thing[0]) + Integer.parseInt(thing[1]);
            }
            Arrays.sort(lineInt);

            ArrayList<Integer> timesAdded = new ArrayList<>();

           // System.out.println(totalTime);

            for(int z = 0; z < lineInt.length - 1; z++)
            {
                if(timesAdded.contains(lineInt[z]))
                {
                    continue;
                }
                if(totalTime < 0)
                {
                    break;
                }
                else if(totalTime - lineInt[z] < 0)
                {
                    break;
                }
                else
                {
                    totalTime -= lineInt[z];
                    timesAdded.add(lineInt[z]);
                }
            }

            int sum = 0;

            for(int a : timesAdded)
            {
                sum+=a;
            }

            System.out.println("Total Time (s) " + sum);


            System.out.println(timesAdded);
            //System.out.println(Arrays.toString(lineInt));

            br.readLine();
            //System.out.println(Arrays.toString(line));
        }

        br.close();
        System.out.println("Lab by Neo");
    }
}
