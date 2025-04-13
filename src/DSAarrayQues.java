public class DSAarrayQues 
{
    public static void main(String args[])
    {
        int nums[] = {4,5,6,7,0,1,2,3};

        int target = 0;

        System.out.println(Search(nums, target));
    }

    static int  Search(int array[], int target)
    {
        int min = SearchMinValue(array);
        if(array[min]<=target &&  target <=array[array.length-1])
        {
            return Search(array, min , array.length-1, target);
        }
        else
        {
            return Search(array, 0, min, target);
        }
    }

    static int Search(int array[], int left , int right , int target)
    {
        int l = left ;
        int r = right ;
        while(l<=r)
        {
            int mid = l+(r-l)/2 ;
            if(array[mid] == target)
            {
                return mid ;
            }
            else if (array[mid]>target)
            {
                r=mid - 1 ;

            }
            else
            {
                l= mid + 1 ;
            }
        }return -1 ;

    }

    static int SearchMinValue(int[] nums)
    {
        int left = 0 ;
        int right = nums.length - 1 ;

        while(left<right)
        {
            int mid = left  + (right - left)/2;

            if(mid>0 && nums[mid-1]>nums[mid])
            {
                return mid ; 
            }
            else if (nums[left]<=nums[mid]&& nums[mid]>nums[right])
            {
                left = mid + 1 ;
            }
            else
            {
                right = mid -  1;
            }
        }
        return left ; 
    }
}
