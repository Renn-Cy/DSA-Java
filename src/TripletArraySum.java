public class TripletArraySum
{
    public static void main(String[] trippin)
    {
        int[] nums = {-1, 0, 1, 2, -1,-4};

        TripletSum(nums);
    }

    private static void TripletSum(int[] nums)
    {
        for(int i = 0; i < nums.length - 2; i++)
        {
            for(int j = i + 1; j < nums.length - 1; j++)
            {
                for(int k = j + 1; k < nums.length; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    }
                }
            }
        }
    }
}