public class RepeatNMissingNumArray
{
    public static void main(String[] ren)
    {
        int[] nums = {3,1,2,5,3};

        int[] array = RepNMissNums(nums);

        System.out.println(array[0]);
        System.out.println(array[1]);
    }

    private static int[] RepNMissNums(final int[] A)
    {
        int[] ans = {0, Integer.MIN_VALUE};

        //finding n
        for(int i=0; i < A.length; i++)
        {
            ans[1] = Math.max(ans[1], A[i]);
        }

        if(ans[1] != A.length)
        {
            ans[1] = A.length;
        }
        else
        {
            ans[1] = 0;
        }

        for(int i=0; i < A.length-1; i++)
        {
            for(int j=i+1; j < A.length; j++)
            {
                if(ans[0] == 0)
                {
                    //finding the repeating number
                    if(A[j] == A[i])
                    {
                        ans[0] = A[j];
                    }
                }

                //finding the missing number
                if(ans[1] == A.length)
                {
                    continue;
                }
                else
                {
                    if(i+1 != A[j] && ans[1] >= 0)
                    {
                        ans[1]++;
                    }
                    else
                    {
                        ans[1] = A[j];
                    }

                    if(ans[1] == A.length && ans[1] >= 0)
                    {
                        ans[1] = -A[j];
                    }
                }
            }
        }

        if(ans[1] < 0)
        {
            ans[1] = ans[1] * -1;
        }

        return ans;
    }
} 