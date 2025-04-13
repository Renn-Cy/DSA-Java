/* Knight's Tour: (Backtracking)
 * given a n*n chess board with the Knight placed on the first 
 * block of an empty board. Moving according to the rules of
 * Chess. The Knight must visit each square exactly once. Print
 * the order of each cell in which theu they are visited. */

public class KnightsTour
{
    static int blocksTravelled = 1;

    public static void main(String[] knighty)
    {
        int boardSize = 8;

        char board[][] = new char[boardSize][boardSize];

        for(int i=0; i<boardSize; i++)
        {
            for(int j=0; j<boardSize; j++)
            {
                board[i][j] = '-';
            }
        }

        Tour(board, 0, 0);

        PrintBoard(board);
    }

    private static void Tour(char board[][], int row, int col)
    {
        if(blocksTravelled == board.length * board.length) {return;}

        blocksTravelled++;

        PossibleMoves(board, row, col);
    }

    private static void PossibleMoves(char board[][], int row, int col)
    {
        board[row][col] = 'K';

        //up & right
        if(row-2 >= 0 && col+1 <= board.length-1 && board[row-2][col+1] == '-')
        {
            Tour(board, row-2, col+1);
        }
        else {blocksTravelled--;}

        //up & left
        if( row-2 >= 0 && col-1 >= 0 && board[row-2][col-1] == '-')
        {
            Tour(board, row-2, col-1);
        }
        else {blocksTravelled--;}

        //right & up
        if(row-1 >= 0 && col+2 >= board.length-1 && board[row-1][col+2] == '-')
        {
            Tour(board, row-1, col+2);
        }
        else {blocksTravelled--;}

        //right & down
        if(row+1 <= board[0].length-1 && col+2 >= board.length-1 && board[row+1][col+2] == '-')
        {
            Tour(board, row+1, col+2);
        }
        else {blocksTravelled--;}

        //left & up
        if(row-1 <= 0 && col-2 >= 0 && board[row-1][col-2] == '-')
        {
            Tour(board, row-1, col-2);
        }
        else {blocksTravelled--;}

        //left & down
        if(row+1 <= board[0].length-1 && col-2 >= 0 && board[row+1][col-2] == '-')
        {
            Tour(board, row+1, col-2);
        }
        else {blocksTravelled--;}

        //down & right
        if(row+2 <= board[0].length-1 && col+1 >= board.length-1 && board[row+2][col+1] == '-')
        {
            Tour(board, row+2, col+1);
        }
        else {blocksTravelled--;}

        //down & left
        if(row+2 <= board[0].length-1 && col-1 >= 0 && board[row+2][col-1] == '-')
        {
            Tour(board, row+2, col-1);
        }
        else {blocksTravelled--;}
    }

    private static void PrintBoard(char board[][])
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board.length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}