package PartsOfSpeech;

import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*; // so that you don't have to do System.

public class PartsOfSpeech
{
	// no instance variables are needed


	public static void main(String[] args) throws IOException
	{

		// print out your first and last name

    System.out.println("Neo Wang");
		// reads in the partofspeech.dat file and puts it
		// in a Scanner object
		Scanner input = new Scanner(new File("PartsOfSpeech.dat"));
		// read in articles and store in a data structure

    String[] articles = input.nextLine().split(" ");
    String[] helping = input.nextLine().split(" ");

		System.out.println("Articles: " + Arrays.toString(articles));
		System.out.println("Helping: " + Arrays.toString(helping));

		// read in helping verbs and store in a data structure

		// read in the rest of the helping verbs
		// and store in the data structure


		int numDataSets = input.nextInt();
		input.nextLine(); // move to the next line in the data file

		// loop through each data set
		for(int i = 0; i < numDataSets; i++)
		{
			String word = input.next();
			System.out.println("Word: " + word);
      int numSets = input.nextInt();
      input.nextLine();

      for(int j = 0; j < numSets; j++)
      {
        int indexOf = 0;
        String[] sentence = input.nextLine().split(" ");
				System.out.println("Sentence: " + Arrays.toString(sentence));

        for(int z = 0; z < sentence.length; z++)
        {
					sentence[z] = sentence[z].replaceAll("\\p{Punct}", "");
          if(sentence[z].equals(word))
          {
            indexOf = z;
            break;
          }
        }

				indexOf--;

        boolean verb = true;
				//System.out.println("iO: " + indexOf);

        for(int z = 0; z < articles.length; z++)
        {
					System.out.println("Articles[" + z + "] : " + articles[z]);
					//System.out.println("Sentence[" + indexOf + "] " + sentence[indexOf]);
					//System.out.println("article[" + z + "]" + " " + z);
					String lowerSentence = sentence[indexOf].toLowerCase();
					articles[z] = articles[z].toLowerCase();
          /* if(articles[z].equals(sentence[indexOf]) || articles[z].equals(sentence[indexOf].toLowerCase()))
          {
            System.out.println("NOUN");
            verb = false;
            break;
          } */


					if(articles[z].equals(lowerSentence))
					{
						//System.out.println("NOUN");
						verb = false;
						break;
					}
        }
        if(verb)
        {
          System.out.println("VERB");
        }
				else
				{
					System.out.println("NOUN");
				}
      }
		}

		input.close();

	} // end of main method

} // end of class
