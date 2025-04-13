import java.util.Arrays;

public class ClimbingStairs
{
    public static void main(String[] args)
    {
        int n = 5;
        int[] auxArr = new int[n+1];
        Arrays.fill(auxArr, -1);
        System.out.println(countWays(n, auxArr));
    }

    private static int countWays(int n, int[] auxArr)
    {
        if(n == 0) {return 1;}
        if(n < 0) {return 0;}

        if(auxArr[n] != -1) {return auxArr[n];}

        auxArr[n] = countWays(n-1, auxArr) + countWays(n-2, auxArr);

        return auxArr[n];
    }

    private static int countWaysTab(int n)
    {
        int[] auxArr = new int[n+1];
        auxArr[0] = 1;

        //tabulation loop  
        for(int i = 1; i <= n; i++)
        {
            if(i == 1)
            {
                auxArr[i] = auxArr[i-1] + 0;
            }
            else
            {
                auxArr[i] = auxArr[i-1] + auxArr[i-2];
            }
        }

        return auxArr[n];
    }
}