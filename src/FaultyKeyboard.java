import java.util.*;

class FaultyKeyboard
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        s.toUpperCase();
        
        System.out.println(finalString(s));
    }
    
    public static String finalString(String s) 
    {
        String temp = "";
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'i')
            {
                temp = ReverseString(temp);
            }
            else
            {
                temp += s.charAt(i);
            }
        }
        
        return temp;
    }
        
    public static String ReverseString(String str)
    {
        String revStr = "";

        for(int i = str.length()-1; i >= 0; i--)
        {
            revStr += str.charAt(i);
        }
        
        return revStr;
    }
}