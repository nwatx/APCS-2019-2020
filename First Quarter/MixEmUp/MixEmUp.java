import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MixEmUp {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File("mixemup.dat")));
        int dataSets = Integer.parseInt(br.readLine());

        for(int i = 0; i < dataSets; i++)
        {
            String[] character = br.readLine().split(" ");
            List<String> cards = new ArrayList<String>();

            for(String a : character)
            {
                cards.add(a);
            }

            for(int j = 0; j < cards.size()-1; j++)
            {
                //System.out.println("Current cards: " + cards);
                if(cards.get(j).equals(cards.get(j + 1)))
                {
                    //System.out.println("Yeeted");
                    cards.add(cards.remove(j));
                }
            }

            for(String o : cards)
            {
                System.out.print(o + " ");
            }

            System.out.println();
        }
    }
}
