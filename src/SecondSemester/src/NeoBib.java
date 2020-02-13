import java.util.ArrayList;
import java.util.Scanner;

public class NeoBib {
    static Scanner keyboard;
    static boolean keepGoing = true;

    public static void main(String[] args)
    {
         ArrayList<String> authors =  new ArrayList<>();
         keyboard = new Scanner(System.in);

         if(ynDialogue("Create citation?"))
         {
             while(keepGoing)
             {
                 String articleTitle = stringDialogue("Enter article title ");
                 String author = "";
                 do {
                      author = stringDialogue("Enter authors (one per line of no more authors type DONE");
                      if(!author.equals("") || author.toLowerCase().equals("done"))
                      {
                          authors.add(author);
                      }
                 } while(!author.toLowerCase().equals("done"));

                 String publisher = stringDialogue("Enter publisher/sponsor ");
                 String url = stringDialogue("Paste url ");
                 String date = stringDialogue("Date published: MMDDYYYY");

                 System.out.println(format(articleTitle, authors, publisher, url, date));
             }
         }
         else
         {
             System.out.println("Application Terminated");
         }
    }

    static boolean ynDialogue(String message)
    {
        System.out.print(message + " (y/n) ");
        if(keyboard == null)
        {
            return false;
        }

        return keyboard.nextLine().trim().toLowerCase().equals("y");
    }

    static String stringDialogue(String message)
    {
        System.out.print(message + " (type) ");
        if(keyboard == null)
        {
            return "";
        }

        return keyboard.nextLine().trim();
    }

    static String authorCitation(ArrayList<String> authors)
    {
        String output = "";

        for(String author : authors)
        {
            if(!author.equals("") || author == null)
            {
                try {
                    String[] name = author.split(" ", 2);
                    output += name[1] + ", " + name[0] + " ";
                } catch (Exception e)
                {
                    //System.out.println("Not enough authors entered");
                }
            }
        }

        return output.trim() + ". ";
    }

    static String formatTitle(String title)
    {
        return "\"" + title + ".\" ";
    }

    static String formatDate(String MMDDYYYY)
    {
        String output = "";
        String month = MMDDYYYY.substring(0,2);

        try {


            switch (month) {
                case "01":
                    output += "Jan. ";
                    break;
                case "02":
                    output += "Feb. ";
                    break;
                case "03":
                    output += "Mar. ";
                    break;
                case "04":
                    output += "Apr. ";
                    break;
                case "05":
                    output += "May. ";
                    break;
                case "06":
                    output += "Jun. ";
                    break;
                case "07":
                    output += "Jul. ";
                    break;
                case "08":
                    output += "Aug. ";
                    break;
                case "09":
                    output += "Sep. ";
                    break;
                case "10":
                    output += "Oct. ";
                    break;
                case "11":
                    output += "Nov. ";
                    break;
                case "12":
                    output += "Dec. ";
                    break;
            }

            if(MMDDYYYY.charAt(0) == '0')
            {
                MMDDYYYY = MMDDYYYY.replace("0","");
                return output + MMDDYYYY.substring(2, 4) + " " + MMDDYYYY.substring(4);
            }
            else
            {
                return output + MMDDYYYY.substring(2, 3) + " " + MMDDYYYY.substring(3);
            }

        }
        catch(Exception e)
        {
            System.out.println("ERROR: Date not found");
        }

        return "";
    }

    static String format(String title, ArrayList<String> authors, String publisher, String url, String date)
    {
        return authorCitation(authors) + formatTitle(title) + publisher + ", " + formatDate(date) + ", " + url;
    }

}
