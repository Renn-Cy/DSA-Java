import java.util.Stack;

public class Stacks
{
    public static void main(String[] piles)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverse(stack);

        while(!stack.isEmpty())
        {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    public static void pushAtBottom(Stack<Integer> stack, int data)
    {
        if(stack.isEmpty())
        {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    } // iram, 1l doodh

    public static String reverseString(String str)
    {
        Stack<Character> strStk = new Stack<>();

        int indx = 0;
        while(indx < str.length())
        {
            strStk.push(str.charAt(indx));
            indx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!strStk.isEmpty())
        {
            char curr = strStk.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void reverse(Stack<Integer> stack)
    {
        if(stack.isEmpty()) {return;}

        int top = stack.pop();

        reverse(stack);

        pushAtBottom(stack, top);
    }
}