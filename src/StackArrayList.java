import java.util.*;

public class StackArrayList
{
    public static void main(String[] piles)
    {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty())
        {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    static class Stack
    {
        static ArrayList<Integer> list = new ArrayList<>();
        
        public static boolean isEmpty()
        {
            return list.size() == 0;
        }

        public static void push(int data)
        {
            list.add(data);
        }

        public static int pop()
        {
            if(isEmpty()) {return -1;}

            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public static int peek()
        {
            if(isEmpty()) {return -1;}
 
            return list.get(list.size()-1);
        }
    }
}