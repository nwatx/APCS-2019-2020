import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Square {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File("square.dat")));

        int dataSets = Integer.parseInt(br.readLine());

        for(int i = 0; i < dataSets; i++)
        {
            char[] line = br.readLine().toCharArray();
            char[][] square = new char[line.length][line.length];

            for(int j = 0; j < line.length; j++)
            {
                square[0][j] = line[j];
                square[j][0] = line[j];
                square[line.length-1][line.length - 1 - j] = line[j];
                square[line.length - 1 - j][line.length-1] = line[j];
            }

            for(int j = 0; j < line.length; j++)
            {
                System.out.println(Arrays.toString(square[j]));
            }
        }

        br.close();
    }
}
