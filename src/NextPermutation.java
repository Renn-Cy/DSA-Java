import java.util.*; 

public class NextPermutation
{
    public static void main(String[] args)
    {
        int[] array = {1,3,4,5,2};

        NxtPermutation(array);
    }

    private static void NxtPermutation(int[] nums)
    {
        boolean isLastPerm = false;

        for(int i=0; i < nums.length-1; i++)
        {
            if(nums[i] >= nums[i+1])
            {
                isLastPerm = true;
                continue;
            }
            else
            {
                isLastPerm = false;
                break;
            }
        }

        if(isLastPerm)
        {
            Arrays.sort(nums);
            return;
        }

        int indx1 = 0;
        int indx2 = 0;

        for(int i=nums.length-2; i > 0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                indx1 = i;
                break;
            }
        }

        for(int i=nums.length-1; i > 0; i--)
        {
            if(nums[i] > nums[indx1])
            {
                indx2 = i;
                break;
            }
        }

        int temp = nums[indx1];
        nums[indx1] = nums[indx2];
        nums[indx2] = temp;

        int i = indx1 + 1;
        int j = nums.length - 1;

        while(i < j)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}