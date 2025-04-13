import java.util.*;

public class Strings 
{
    public static void main(String args[])
    {
        String charset = "bbbyyyyeeeee!!!!!";
        System.out.println(Compression(charset));
    }
    
    private static Boolean IsPalindrome(String str)
    {
        int leftIndex = 0;
        int rightIndex = str.length()-1;

        while(leftIndex < rightIndex)
        {
            if(str.charAt(leftIndex) != str.charAt(rightIndex))
            {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    private static float DirectionToDisplacement(String dirSet)
    {
        int xPos = 0;
        int yPos = 0;

        for(int i=0; i<=dirSet.length()-1; i++)
        {
            char dir = dirSet.charAt(i);

            if(dir == 'N' || dir == 'n')
            {
                yPos++;
            }
            else if(dir == 'S' || dir == 's')
            {
                yPos--;
            }
            else if(dir == 'E' || dir == 'e')
            {
                xPos++;
            }
            else if(dir == 'W' || dir == 'w')
            {
                xPos--;
            }
            else
            {
                return -1;
            }
        }

        float displacement = (float
        ) Math.sqrt(xPos*xPos + yPos*yPos);

        return displacement;
    }

    private static String FirstCharUpper(String str)
    {
        StringBuilder strBldr = new StringBuilder("");

        char chr = Character.toUpperCase(str.charAt(0));
        strBldr.append(chr);

        for(int i=1; i<str.length(); i++)
        {
            if(str.charAt(i) == ' ' && i < str.length()-1)
            {
                strBldr.append (str.charAt(i));
                i++;
                strBldr.append(Character.toUpperCase(str.charAt(i)));
            }
            else
            {
                strBldr.append(str.charAt(i));
            }
        }
        return strBldr.toString();
    }

    private static String Compression(String str)
    {
        StringBuilder strBldr = new StringBuilder("");
        int countReps = 0;

        for(int i=0; i<str.length(); i++)
        {
            countReps = 1;

            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1))
            {
                countReps++;
                i++;
            }
            strBldr.append(str.charAt(i));

            if(countReps > 1)
            {
                strBldr.append(countReps);
            }
        }
        return strBldr.toString();
    }
}
