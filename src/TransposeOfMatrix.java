public class TransposeOfMatrix
{
    public static void main(String[] pewpew)
    {
        int[][] matrix = {{2,2,2,2},
                          {4,4,4,4},
                          {6,6,6,6},
                          {8,8,8,8}};

        Transpose(matrix);

        PrintMatrix(matrix);
    }

    static void Transpose(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = i + 1; j < matrix[0].length; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    static void PrintMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}