public class Problem1_RotateRight
{
    public static void main(String[] args)
    {
        int[] array = {10, 11, 12, 13};

        System.out.println("Original array:");
        PrintArray(array);

        System.out.println("Original array in binary form:");
        PrintBinArray(array);

        rotateRightBy2Bits(array);

        System.out.println("Array after rotation:");
        PrintArray(array);

        System.out.println("Array after rotation in binary form:");
        PrintBinArray(array);
    }

    private static void rotateRightBy2Bits(int[] array)
    {
        int[] arrayOrignal = array;

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (array[i] >>> 2) | (arrayOrignal[(i == 0) ? array.length - 1 : i - 1] << (32 - 2));
        }
    }

    private static void PrintArray(int[] array)
    {
        for (int i = 0; i <= array.length - 1; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void PrintBinArray(int[] array)
    {
        for (int i = 0; i <= array.length - 1; i++)
        {
            System.out.print(Integer.toBinaryString(array[i]) + " ");
        }
        System.out.println();
    }
}