import java.util.*;
public class MergeSort
{ // Time Complexity: O(nlogn) and Space Complexity: O(n)
  // Depth First Technique
  // Divide And Conquer Technique
    public static void main(String args[])
    {
        int array[] = {6,3,9,5,2,8};
        MergeSort(array, 0, array.length-1);

        for(int i=0; i<array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        
        System.out.println();
    }

    static void MergeSort(int array[], int startIndx,int endIndx)
    {
        if(startIndx >= endIndx) {return;}

        int mid = startIndx + (endIndx - startIndx) / 2;  // (startIndx + endIndx) / 2

        MergeSort(array, startIndx, mid);
        MergeSort(array, mid+1, endIndx);

        Merge(array, startIndx, mid, endIndx);
    }

    static void Merge(int array[], int startIndx, int mid,int endIndx)
    {
        int temp[] = new int[endIndx-startIndx+1];
        int i = startIndx;  // iterator for left part
        int j = mid+1;  // iterator for right part
        int k = 0;  // iterator for temp. array

        while(i <= mid && j <= endIndx)
        {
            if(array[i] < array[j])
            {
                temp[k] = array[i];
                i++;
            }
            else
            {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        // left part
        while(i <= mid)
        {
            temp[k++] = array[i++];
        }

        // right part
        while(j <= endIndx)
        {
            temp[k++] = array[j++];
        }

        // copy temp. array to orignal array
        for(k=0, i=startIndx; k<temp.length; k++, i++)
        {
            array[i] = temp[k];
        }
    }
}