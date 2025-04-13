public class SortedAndRotatedArrayRecur
{
    public static void main(String[] args)
    {
        int arr[] = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 0;
        System.out.println(Search(arr, target, 0, arr.length-1));
    }

    private static int Search(int arr[], int target, int startIndx, int endIndx)
    {
        if(startIndx > endIndx) {return -1;}

        int mid = startIndx + (endIndx - startIndx)/2; //(startIndex+endIndex)/2
        
        if(arr[mid] == target)
        {
            return mid;
        }

        if(arr[startIndx] <= arr[mid])
        {
            //mid on line 1
            if(arr[startIndx] <= target && target <= arr[endIndx])
            {
                //left
                return Search(arr, target, startIndx, mid-1);
            }
            else
            {
                //right
                return Search(arr, target, mid+1, endIndx);
            }
        }
        else
        {
            //mid on line 2
            if(arr[mid] <= target && target <= arr[endIndx])
            {
                //right
                return Search(arr, target, mid+1, endIndx);
            }
            else
            {
                //left
                return Search(arr, target, startIndx, mid-1);
            }
        }
    }
}