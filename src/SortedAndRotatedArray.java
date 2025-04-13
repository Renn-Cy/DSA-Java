public class SortedAndRotatedArray
{
    public static void main(String[] args)
    {
        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 7;
        System.out.println(Search(array, target));
    }

    // static int Search(int[] array, int target)
    // {
    //     int min = SearchMin(array);

    //     if(target >= array[min] == target <= array[array.length - 1])
    //     {
    //         return Search(array, min, array.length - 1, target);
    //     }
    //     else
    //     {
    //         return Search(array, 0, min, target);
    //     }
    // }

    // static int Search(int[] array, int strt, int end, int target)
    // {
    //     while(strt <= end)
    //     {
    //         int mid = strt + (end - 1) / 2;

    //         if(target == array[mid])
    //         {
    //             return mid;
    //         }
    //         else if(target < array[mid])
    //         {
    //             end = mid - 1;
    //         }
    //         else
    //         {
    //             strt = mid + 1;
    //         }
    //     }

    //     return -1;
    // }

    // static int SearchMin(int[] array)
    // {
    //     int strt = 0;
    //     int end = array.length - 1;

    //     while(strt < end)
    //     {
    //         int mid = strt + (end - strt) / 2;

    //         if(mid > 0 && array[mid] > array[end])
    //         {
    //             return mid;
    //         }
    //         else if(array[strt] <= array[mid] && array[mid] > array[end])
    //         {
    //             strt = mid + 1;
    //         }
    //         else
    //         {
    //             end = mid -1;
    //         }
    //     }

    //     return strt;
    // }

    static int Search(int[] array, int target)
    {
        int strtIndx = 0;
        int endIndx = array.length - 1;

        while(strtIndx <= endIndx)
        {
            int mid = strtIndx + (endIndx - strtIndx) / 2; //(startIndex+endIndex)/2

            if(mid == target)
            {
                return mid;
            }

            // left-half is sorted
            if(array[strtIndx] <= array[mid])
            {
                if(target >= array[strtIndx] && target <= array[mid])
                {
                    endIndx = mid - 1;
                }
                else
                {
                    strtIndx = mid + 1;
                }
            }
            // right-half is sorted
            else
            {
                if(target >= array[mid] && target <= array[endIndx])
                {
                    strtIndx = mid + 1;
                }
                else
                {
                    endIndx = mid - 1;
                }
            }

            // if(target <= array[strtIndx] && target > array[endIndx])
            // {
            //     endIndx = mid;
            //     mid = strtIndx + (endIndx - strtIndx) / 2;
            // }
            // else if(target > array[strtIndx] && target <= array[endIndx])
            // {
            //     strtIndx = mid;
            //     mid = strtIndx + (endIndx - strtIndx) / 2;
            // }
        }

        return -1;
    }
}