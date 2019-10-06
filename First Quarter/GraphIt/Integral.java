import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.function.Function;

public class Integral {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("integral.dat"));
        int sets = Integer.parseInt(in.nextLine());

        //System.out.println("Got here");

        for (int i = 0; i < sets; i++) {
            int a = in.nextInt();
            double b = in.nextDouble();
            double n = in.nextDouble();
            double sum = 0;

            //System.out.println("a: " + a + " b: " + b + " n: " + n);

            for(double j = a; j < b; j = j + n)
            {
                //System.out.println("a: " + a + " b: " + b + " n: " + n);
                //System.out.println("j:" + j);
                sum += getPoint(j) * n;
                //System.out.println(sum);
            }

            System.out.println(sum);
        }

        System.out.println("End");

        in.close();
    }
    //3x^2+2x+1

    public static double getPoint(double x)
    {
        return 3 * Math.pow(x,2) + 2 * x + 1;
    }
}
