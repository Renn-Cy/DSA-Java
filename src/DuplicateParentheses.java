import java.util.*;

public class DuplicateParentheses   
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        String txt = scanner.nextLine();

        System.out.println(DuplicatePresent(txt));
    }

    public static boolean DuplicatePresent(String str)
    {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++)
        {   
            char chr = str.charAt(i);

            if(chr == ')')
            {
                int count = 0;

                while(stack.pop() != '(')
                {
                    count++;
                }

                if(count == 0) {return true;}
            }
            else
            {
                stack.push(chr);
            }
        }

        return false;
    }
}
