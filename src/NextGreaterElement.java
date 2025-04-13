import java.util.*;

public class NextGreaterElement
{
    public static void main(String[] ren)
    {
        int array[] = {6,8,0,1,3};
        Stack<Integer> stack = new Stack<>();
        int nxtGratr[] = new int[array.length];

        for(int i = array.length - 1; i >= 0; i--)
        {
            // 1 while
            while(!stack.isEmpty() && array[stack.peek()] <= array[i])
            {
                stack.pop();
            }

            // 2 if-else
            if(stack.isEmpty())
            {
                nxtGratr[i] = -1;
            }
            else
            {
                nxtGratr[i] = array[stack.peek()];
            }

            // 3 push in stack
            stack.push(i);
        }

        for(int i = 0; i < nxtGratr.length; i++)
        {
            System.out.print(nxtGratr[i] + " ");
        }
        System.out.println();
    }

    //private static int NextGreaterElement(int[] nums)
    {

    }
}