import java.util.*;

public class Prog
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //String code1 = "35842";
        //String decode1 = "HOUSE";
        //String code2 = "12658";
        //String decode2 = "LEMON";

        System.out.println(Decode("HELEN"));

    }

    public static String Decode(String word)
    {
        String decodedMessage = "";

        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == 'H')
            {
                decodedMessage += '3';
            }
            else if(word.charAt(i) == 'O')
            {
                decodedMessage += '5';
            }
            else if(word.charAt(i) == 'E')
            {
                decodedMessage += '2';
            }
            else if(word.charAt(i) == 'N')
            {
                decodedMessage += '8';
            }
            else if(word.charAt(i) == 'L')
            {
                decodedMessage += '1';
            }
        }
        return decodedMessage;
    }
}