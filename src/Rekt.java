import java.util.*;

public class Rekt
{
    public static void main(String[] args)
    {
        FlipHalvPyrmdPattern(4);
    }

    private static boolean ArrayReccurValues(int array[])
    {
        for(int i=0; i<=array.length-2; i++)   // array.length-2 == 2nd last element of array
        {
            for(int j=i+1; j<=array.length-1; j++)   // array.length-1 == last element of array
            {
                if(array[i]==array[j])
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static void PrintArray(int array[])
    {
        for(int i=0; i<array.length; i++)
        {
            System.out.println(array[i]);
        }
    }

    private static void LinearSearch(int array[], int key)
    {
        for(int i=0; i<array.length; i++)
        {
            if(array[i] == key)
            {
                System.out.println("Element found at indek: " + i);
                return;
            }
        }
        System.out.println("Element not found");
        return;
    }

    private static int BinarySearch(int array[], int key)
    {
        int start = 0;
        int end = array.length-1;
        int midPoint;

        while(start <= end)
        {
            midPoint = (start + end)/2;

            if(array[midPoint] == key)
            {
                return midPoint;
            }
            else if(array[midPoint] < key)
            {
                start = midPoint+1;
            }
            else if(array[midPoint] > key)
            {
                end = midPoint-1;
            }
        }
        return -1;
    }

    private static void ReverseArray(int array[])
    {
        int first = 0;
        int last = array.length-1;

        while(first < last)
        {
            int temp = array[last];
            array[last] = array[first];
            array[first] = temp;

            first++;
            last--;
        }
    }

    // private static void ReverseArray(String array[])
    // {
    //     String tempArray[] = new String[array.length];
    //     int n = array.length;
    //     for(int i=0; i<n; i++)
    //     {
    //         tempArray[i] = array[n-i+1];
    //     }
    //     array = tempArray;
    // }

    private static void AllPossPairInArray(int array[])
    {
        for(int i=0; i<array.length; i++)
        {
            for(int j=i+1; j<array.length; j++)
            {
                System.out.println("(" + array[i] + "," + array[j] + ")");
            }
        }
    }

    private static void AllSubArrays(int array[])
    {
        for(int i=0; i<array.length; i++)
        {
            for(int j=i; j<array.length; j++)
            {
                for(int k=i; k<=j; k++)
                {
                    System.out.print(array[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void MaxSumOfSubArraysBruteForce(int array[])
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++)
        {
            for(int j=i; j<array.length; j++)
            {
                currSum = 0;

                for(int k=i; k<=j; k++)
                {
                    currSum += array[k];
                }

                System.out.println(currSum);

                if(maxSum < currSum)
                {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum: " + maxSum);
    }

    private static void MaxSumOfSubArraysPrefixSum(int array[])
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefixArray[] = new int[array.length];
        
        prefixArray[0] = array[0];

        // create prefix array
        for(int i=1; i<prefixArray.length; i++)
        {
            prefixArray[i] = prefixArray[i-1] + array[i];
        }

        for(int i=0; i<array.length; i++)
        {
            for(int j=i; j<array.length; j++)
            {
                currSum = i == 0 ? prefixArray[j] : prefixArray[j] - prefixArray[i-1];

                if(maxSum < currSum)
                {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum: " + maxSum);
    }

    private static void MaxSumOfSubArraysKadanesAlgo(int array[])
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // check if all the values in array are positive
        boolean isPositive = false;

        for(int i=0; i<array.length; i++)
        {
            if(0<array[i])
            {
                isPositive = true;
                break;
            }
            else
            {
                maxSum = Math.max(maxSum, array[i]);
            }
        }

        if(!isPositive)
        {
            System.out.println("Max sum: " + maxSum);
            return;
        }

        // Kadane's Algorithm
        for(int i=0; i<array.length; i++)
        {
            currSum +=array[i];

            if(currSum < 0)
            {
                currSum = 0;
            }

            maxSum = Math.max(currSum, maxSum);

        }
        System.out.println("Max sum: " + maxSum);
    }

    private static int SearchLargestNum(int array[])
    {
        int largestNum = Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++)
        {
            if(array[i] > largestNum)
            {
                largestNum = array[i];
            }
        }
        return largestNum;
    }

    private static void HollowRectPattern(int noOfRows, int noOfColms)
    {
        for(int i = 1; i<=noOfRows; i++)
        {
            for(int j = 1; j<=noOfColms; j++)
            {
                if(i == 1 || i == noOfRows || j == 1 || j == noOfColms)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void FlipHalvPyrmdPattern(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n-i; j++ )
            {
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++)
            {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    private static void InvNumRightTriPattern(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n-i+1; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void FloydsTriPattern(int n)
    {
        int num = 1;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print(num + "  ");
                num++;
            }
            System.out.println();
        }
    }

    private static void ButterflyPattern(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print("* ");
            }
            for(int j=1; j<=2*(n-i); j++)
            {
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n-i+1; j++)
            {
                System.out.print("* ");
            }
            for(int j=1; j<=2*(i-1); j++)
            {
                System.out.print("  ");
            }
            for(int j=1; j<=n-i+1; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }  
    }

    private static void SolidRhombusPattern(int n, int m)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n-i; j++)
            {
                System.out.print("  ");
            }
            for(int j=1; j<=m; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static int DecimalToBinary(int decNum)
    {
        int pow = 0;
        int binNum = 0;

        while(decNum > 0)
        {
            int remainder = decNum % 2;
            binNum += (remainder * (int) Math.pow(10, pow));

            pow++;
            decNum /= 2;
        }

        return binNum;
    }

    private static int BinaryToDecimal(int binNum)
    {
        int pow = 0;
        int decNum = 0;

        while(binNum > 0)
        {
            int lastDigit = binNum % 10;
            decNum += (lastDigit * (int) Math.pow(2, pow));
            
            pow++;
            binNum /= 10;
        }

        return decNum;
    }
}
