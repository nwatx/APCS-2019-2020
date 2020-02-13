import java.io.*;   // for file input


public class Punch
{
    // no instance variables are needed


    public static void main(String[] args) throws IOException
    {

        // print out your first and last name


        // reads in the othello.dat file and puts it
        // in a Scanner object
        BufferedReader br = new BufferedReader(new FileReader(new File("punch.dat")));

        char[][] matrix = new char[8][8];
        // create your matrix
        // now read in the matrix that represents the punched card
        for(int i = 0; i < 8; i++)
        {
            matrix[i] = br.readLine().replaceAll(" ", "").toCharArray();
        }

        String output = "";

        for(int i = 0; i < 8; i++)
        {
            char sum = 0;

            for(int j = 0; j < 8; j++)
            {
                if(matrix[j][i] == '1')
                {
                    sum += Math.pow(2,j);
                }
            }

            output += sum;
        }

        System.out.println(output);

        br.close();

    } // end of main method

} // end of class
