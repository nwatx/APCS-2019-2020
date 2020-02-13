import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WideTriangle {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File("wile.txt")));

        int sets = Integer.parseInt(br.readLine());
        int[][] triangle = new int[100][100];

        for(int i = 0; i < sets; i++)
        {
            String[] input = br.readLine().split(" ");
            triangle[0][0] = Integer.parseInt(input[0]);
            triangle[1][0] = Integer.parseInt(input[1]);
            triangle[1][1] = Integer.parseInt(input[2]);

            int setsTwo = Integer.parseInt(br.readLine());
            for(int j = 0; j < setsTwo; j++)
            {
                String[] coordinate = br.readLine().split(" ");
                System.out.println(Arrays.toString(coordinate) + " " + pascal(triangle,Integer.parseInt(coordinate[0])-1,Integer.parseInt(coordinate[1])-1));
            }

            /* for(int a  = 0 ; a < 15; a++)
            {
                for(int b = 0; b < 15; b++)
                {
                    System.out.print(pascal(triangle,a,b) + " ");
                }
                System.out.println();
            } */
        }

        System.out.println("Lab by Neo");
    }

    public static int pascal(int[][] triangle, int i, int j) {
        if(i == 0 && j == 0)
        {
            return triangle[0][0];
        }
        else if(i < 0 || j  < 0)
        {
            return 0;
        }
        else if (j == 0) {
            return triangle[1][0];
        } else if (j == i) {
            return triangle[1][1];
        } else {
            return pascal(triangle,i - 1, j) + pascal(triangle,i - 1, j-1) + pascal(triangle,i-2,j-1);
        }
    }


}
