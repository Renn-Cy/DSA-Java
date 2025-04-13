import java.util.*;

public class SortingAlgos 
{
    public static void main(String[] args)
    {
        int array[] = {3,5,-7,8,-1,0,4,2,6};
        BubbleSort(array);
        PrintArray(array);
    }

    // largest digit is moved forward one index at a time
    private static void BubbleSort(int array[])
    {
        int swaps;

        for(int i=0; i<=array.length-2; i++)   // array.length-2 == 2nd last element of array
        {
            swaps = 0;

            for(int j=0; j<=array.length-2-i; j++)
            {
                if(array[j] >    array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    
                    swaps++;
                }
                System.out.println(swaps);
            }

            if(swaps == 0)
            {
                System.out.println("this code ran");
                return;
            }
        }
    }

    // smallest digit is moved to the first index
    private static void SelectionSort(int array[])
    {
        for(int i=0; i<=array.length-2; i++)   // array.length-2 == 2nd last element of array
        {
            int minValuePos = i;

            for(int j=i+1; j<=array.length-1; j++)
            {
                if(array[j] < array[minValuePos])   // if > operater  is used instead, array gets sorted into descending order
                {
                    minValuePos = j;
                }
            }
            
            int temp = array[minValuePos];
            array[minValuePos] = array[i];
            array[i] = temp;
        }
    }

    private static void InsertionSort(int array[])
    {
        for(int i=1; i<=array.length-1; i++)
        {
            int currValue = array[i];
            int prevPos = i-1;

            while(prevPos >= 0  &&  array[prevPos] > currValue)   // flip to < in 2nd condition to sort in decreasing order
            {
                array[prevPos+1] = array[prevPos];
                prevPos--;
            }
            array[prevPos+1] = currValue;
        }
    }

    private static void CountingSort(int array[])
    {
        int largestNum = Integer.MIN_VALUE;

        for(int i=0; i<=array.length-1; i++)
        {
            largestNum = Math.max(largestNum, i);
        }

        int frequencyArray[] = new int[largestNum+1];

        for(int i=0; i<=array.length; i++)
        {
            frequencyArray[array[i]]++;
        }

        int j = 0;

        for(int i=0; i<=frequencyArray.length-1; i++)
        {
            while(frequencyArray[i] > 0)
            {
                array[j] = i;
                j++;
                frequencyArray[i]--;
            }
        }
    }

    private static void InBuiltSorting(int array[])
    {
        Arrays.sort(array);   // O(n logn)
    }

    private static void PrintArray(int array[])
    {
        for(int i=0; i<array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
