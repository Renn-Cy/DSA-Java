import java.util.*;

public class App
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // int a = -13 + 2 * 7 - 14;
        // int b = a++ + --a;

        // int c = -13 >> 2 * b-- + b++;
        // System.out.println(c);
        // System.out.println(c);
        // c *= ;
        // System.out.println(c);

        int[] fruits = {20,40,30,50,40,20};

        Arrays.sort(fruits);

        int noOfSteps = 0;

        if(fruits.length != 1)
        {
            for(int i = 0; i < fruits.length-1; i++)
            {
                if(fruits[i+1] == fruits[i])
                {
                    continue;
                }
                else
                {
                    noOfSteps++;
                }
            }
        }

        System.out.println(noOfSteps);
    }
}
