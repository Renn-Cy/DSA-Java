public class NumBiggerThanSum
{
    public static void main(String[] ren)
    {
        int array[] = {4, 2, 8, 10, 1, 33, 41};

        int sum = 0;

        for(int i = 1; i <= array.length-1; i++)
        {
            sum += array[i-1];

            if (array[i] > sum)
            {
                System.out.println(array[i]);


            }
        }
    }
}
