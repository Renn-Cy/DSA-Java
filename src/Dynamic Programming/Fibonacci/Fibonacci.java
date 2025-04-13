import java.util.Arrays;

public class Fibonacci
{
    public static void main(String[] args)
    {
        int n = 5;
        int[] auxArr = new int[n+1];
        System.out.println(NthFibNum(n, auxArr));
    }

    private static int NthFibNum(int n, int[] auxArr)
    {
        if(n == 0 || n == 1) {return n;}
        if(auxArr[n] != 0) {return auxArr[n];}

        auxArr[n] = NthFibNum(n-1, auxArr) + NthFibNum(n-2, auxArr);

        return auxArr[n];
    }

    private static int NthFibNumTab(int n)
    {
        int[] auxArr = new int[n+1];
        auxArr[0] = 0;
        auxArr[1] = 1;

        //tabulation loop
        for(int i = 2; i <= n; i++)
        {
            auxArr[i] = auxArr[i-1] + auxArr[i-2];
        }

        return auxArr[n];
    }
}