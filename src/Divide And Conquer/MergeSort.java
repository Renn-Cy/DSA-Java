package Divide And Conquer;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] array = {6,3,9,5,2,8};
        
        MergeSort(array, 0, array.length-1);

        for(int i=0; i<array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        
        System.out.println();
    }

    private static void MergeSort(int[] array, int strtIndx, int endIndx)
    {
        if(array.length == 1) {return;}

        //right half
        MergeSort(array, (strtIndx + (endIndx - strtIndx)) / 2, endIndx);
        //left half
        MergeSort(array, strtIndx, ((strtIndx + (endIndx - strtIndx)) / 2) - 1);

        int[] temp = new int[strtIndx + endIndx];

        FillTempArray(temp);
        
        return;
    }
        
    private static void FillTempArray(int[] temp)
    {
        
    }
}
