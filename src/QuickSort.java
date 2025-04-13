public class QuickSort
{
    public static void main(String args[])
    {
        int array[] = {6,3,9,5,2,8};
        QuickSort(array, 0, array.length-1);

        for(int i=0; i<array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        
        System.out.println();
    }   
    
    static void QuickSort(int array[], int startIndx, int endIndx)
    {
        if(startIndx >= endIndx) {return;}

        // last element
        int pIndx = Partition(array, startIndx, endIndx);

        QuickSort(array, startIndx, pIndx-1);
        QuickSort(array, pIndx+1, endIndx);

    }

    static int Partition(int array[], int startIndx, int endIndx)
    {
        int pivot = array[endIndx];
        int i = startIndx-1;  // to make place for elements smaller than pivot

        for(int j=startIndx; j<endIndx; j++)
        {
            if(array[j] <= pivot)
            {
                i++;
                // swap
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        array[endIndx] = array[i];  // pivot = array[i]
        array[i] = temp;
        
        return i;
    }
}