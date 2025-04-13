import java.util.*;

public class TwoDArrays {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int matrix1[][] = {{1 ,2 ,3 ,4 },
                          {5 ,6 ,7 ,8 },
                          {9 ,10,11,12},
                          {13,14,15,16}};

        int matrix[][] = new int [3][3];
        int nOfRows = matrix.length;
        int nOfCols = matrix[0].length;

        //fill the matrix by user input
        for(int i=0; i<nOfRows; i++)
        {
            for(int j=0; j<nOfCols; j++)
            {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        //print the matrix
        for(int i=0; i<nOfRows; i++)
        {
            for(int j=0; j<nOfCols; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void SearchMatrix(int matrix[][], int key)
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == key)
                {
                    System.out.println("found key at cell(" + i + "," + j + ")");
                }
            }    
        }
        System.out.println("key not found");
    }

    private static void StaircaseSearch(int matrix[][], int key) // now exiting the loop if key is found
    {
        int row = 0;
        int col = matrix[0].length-1;

        while(row < matrix.length && col >= 0)
        {
            if(key == matrix[row][col])
            {
                System.out.println("found key at cell(" + row + "," + col + ")");
            }
            else if(key < matrix[row][col])
            {
                col--;
            }
            else if(key > matrix[row][col])
            {
                row++;
            }
        }
        System.out.println("key not found");
    }

    private static void SpiralPrintMatrix(int matrix[][])
    {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol)
        {
            // top
            for(int j=startCol; j<=endCol; j++)
            {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for(int i=startRow+1; i<=endRow; i++)
            {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for(int j=endCol-1; j>=startCol; j--)
            {
                if(startRow == endRow)
                {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // left
            for(int i=endRow-1; i>=startRow+1; i--)
            {
                if(startCol == endCol)
                {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

        System.out.println();
    }

    private static int DiagonalSumBruteForce(int matrix[][])
    {
        int sum = 0;

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(i == j)   // adding up elements of the primary diagonal
                {
                    sum += matrix[i][j];
                }
                else if(i+j == matrix.length-1)   // adding up elements of the secondary diagonal
                {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static int DiagonalSumOptimized(int matrix[][])
    {
        int sum = 0;

        for(int i=0; i<matrix.length; i++)
        {
            // primary diagonal
            sum += matrix[i][i];

            // secondary diagonal
            if(i != matrix.length-i-1)
            {
                sum += matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }

    private static int MaxValueInMatrix(int matrix[][])
    {
        int maxVal = Integer.MIN_VALUE;

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                maxVal = Math.max(matrix[i][j], maxVal);
            }    
        }
        return maxVal;
    }
    
    private static void PrintMatrix(int matrix[][])
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
