package LocationAwareness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LocationAwareness {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("aware.in"));
        int sets = Integer.parseInt(br.readLine());

        double[][][] unscaled = new double[200][200][3];

        for(int i = 0; i < 200; i++)
        {
            for(int j = 0; j < 200; j++)
            {
                unscaled[i][j][0] = 1000/Math.pow(distance(i, j, 100, 200),2);
                unscaled[i][j][1] = 1000/Math.pow(distance(i,j,0,0),2);
                unscaled[i][j][2] = 1000/Math.pow(distance(i,j,200,0),2);
            }
        }

        for(int i = 0; i < 200; i++)
        {
            for(int j = 0; j < 200; j++)
            {
                if(i == 121 && j == 135)
                {
                    System.out.println(Arrays.toString(unscaled[i][j]));
                }

            }
            //System.out.println();
        }

        for(int i = 0; i < sets; i++)
        {
            String[] in = br.readLine().split(" ");
            double[] numbers = new double[3];

            for(int j = 0; j < 3; j++)
            {
                numbers[j] = Double.parseDouble(in[j]);
            }

            System.out.println(Arrays.toString(returnPosition(unscaled, numbers[0], numbers[1], numbers[2])));
        }
    }

    public static double distance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    public static int[] returnPosition(double[][][] unscaled, double a, double b, double c)
    {
        for(int i = 0; i < 200; i++)
        {
            for(int j = 0; j < 200; j++)
            {
                double ratio1 = unscaled[i][j][0]/a;
                double ratio2 = unscaled[i][j][1]/b;
                double ratio3 = unscaled[i][j][2]/c;

                if(approxEqual(ratio1, ratio2) && approxEqual(ratio2, ratio3))
                {
                    int[] output = new int[2];
                    output[0] = i-100;
                    output[1] = j-100;
                    return output;
                }
            }
        }

        return null;
    }

    public static boolean approxEqual(double a, double b)
    {
        return (b > a-0.00001 && b < a+0.00001);
    }
}