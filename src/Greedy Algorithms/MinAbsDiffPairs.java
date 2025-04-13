/* Min Absolute Difference Pairs:
 * Given two arrays A and B of equal length n. Pair each element of array
 * A to an element in array B, such that sum S of absolute differences of 
 * all the pairs is minimum.
 * 
 * approach: pair up the smallest elements of both array and so on... */

import java.util.*;

public class MinAbsDiffPairs
{
    public static void main(String[] args)
    {
        int[] A = {3, 2, 1}; //{4, 1, 8, 7};
        int[] B = {2, 1, 3}; //{2, 3, 6, 5};

        Arrays.sort(A);
        Arrays.sort(B);

        int sumOfAbsDiffs = 0;

        for (int i=0; i<A.length; i++)
        {
            sumOfAbsDiffs += Math.abs(A[i] - B[i]);
        }

        System.out.println("S = " + sumOfAbsDiffs);
    }
}
