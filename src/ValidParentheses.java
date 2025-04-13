import java.util.*;

public class ValidParentheses
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        
        System.out.println(IsValid(txt));
    }

    private static boolean IsValid(String str)
    {
        if(str.charAt(0) == '(' || str.charAt(0) == '[' || str.charAt(0) == '{')
        {return false;}

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++)
        {
            char chr = str.charAt(i);

            if(chr == '(' || chr == '[' || chr == '{')
            {
                stack.push(chr);
            }

            if(chr == ')')
            {
                if(stack.peek() == '(')
                {
                    stack.pop();
                }

            }
            else if(chr == ']')
            {
                if(stack.peek() == '[')
                {
                    stack.pop();
                }

            }
            else if(chr == '}')
            {
                if(stack.peek() == '{')
                {
                    stack.pop();
                }

            }
        }

        if(stack.isEmpty()) {return true;}

        return false;
    }
}