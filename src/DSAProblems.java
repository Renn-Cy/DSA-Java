import java.util.*;

public class DSAProblems
{
    public static void main(String[] args)
    {
        // int n = 3;
        // char board[][] = new char[n][n];

        // for(int i=0; i<n; i++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         board[i][j] = '-';
        //     }
        // }

        // NQueens(board, 0);

        int array[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(StoreWater2PointerApproach(array));
    }

    private static int TrappingRainDSA(int heightMap[])
    {
        int n = heightMap.length;

        // calc. left max boundaries (array)
        int leftMax[] = new int[n]; // auxillary array
        leftMax[0] = heightMap[0];
        
        for(int i=1; i<n; i++)
        {
            leftMax[i] = Math.max(heightMap[i],leftMax[i-1]);
        }

        // calc. right max boundaries (array)
        int rightMax[] = new int[n]; // auxillary array
        rightMax[n-1] = heightMap[n-1];

        for(int i=n-2; i>=0; i--)
        {
            rightMax[i] = Math.max(heightMap[i],rightMax[i+1]);
        }
        
        // loop
        int trappedWater = 0;
        int waterLevel;

        for(int i=0; i<n; i++)
        {
            // waterLevel = min(leftMax, rightMax)
            waterLevel = Math.min(leftMax[i], rightMax[i]);

            // trappedWater = waterLevel - height[i]
            trappedWater += waterLevel - heightMap[i];
        }
        return trappedWater;
    }

    private static int BuySellStocks(int stockPrices[])
    {
        int costP = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<stockPrices.length; i++)
        {
            if(costP < stockPrices[i])
            {
                int profit = stockPrices[i] - costP;
                maxProfit = Math.max(maxProfit, profit);
            }
            else
            {
                costP = stockPrices[i];
            }
        }
        return maxProfit;
    }

    /* Tiling Problem: (Basic Recursion)
     * Given a "2 x n" floor and tiles of size "2 x 1", count 
     * the number of ways to tile the given floor unsing the 
     * "2 x 1" tiles. (A tile can be placed horizontally or 
     * vertically) */
    private static int TileEm(int length)
    {
        if(length == 0 || length == 1) {return 1;}

        // Tiling Vertically
        int fnm1 = TileEm(length-1);

        // Tiling Horizontally
        int fnm2 = TileEm(length-2);

        // Total No. of Ways
        int totalNoOfWays = fnm1 + fnm2;

        return totalNoOfWays;
    }

    /* Friends Pairing Problem:
     * Given n friends, each one can remain single or can be paired 
     * up with some other friend. Each friend can be paired only 
     * once. Find out the total number of ways in which frineds can
     * remain single or can be paired up. */
    private static int PairEmUp(int numOfFriends)
    {
        if(numOfFriends == 1 || numOfFriends == 2) {return numOfFriends;}

        // single
        int fnm1 = PairEmUp(numOfFriends-1);

        // paired up
        int fnm2 = PairEmUp(numOfFriends-2);
        int pairWays = (numOfFriends-1) * fnm2;

        // total ways
        int totalCombinations = fnm1 + pairWays;

        return totalCombinations;
    }

    /* Binary String Problem:
     * Print all possible binary strings of size n without 
     * consecutive ones. */
    private static void BinaryNoAdjacent1s(String binStr, int size, int lastBit)
    {
        if(size == 0)
        {
            System.out.println(binStr);
            return;
        }

        BinaryNoAdjacent1s(binStr+"0", size-1, 0);

        if(lastBit == 0)
        {
            BinaryNoAdjacent1s(binStr+"1", size-1, 1);
        }
    }

    /* N-Queens: (Backtracking)
     * Place n Queens on an n*n chessboard such that no 2 queens
     * can attack each other. */
    private static void NQueens(char board[][], int row)
    {
        if(row == board.length)
        {
            PrintBoard(board);
            return;
        }

        for(int j=0; j<board.length; j++)
        {
            board[row][j] = 'Q';
            NQueens(board, row+1);
            board[row][j] = '-';
        }
    }
    static void PrintBoard(char board[][])
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board.length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    //Time Complexity: O(n)
    private static int StoreWater2PointerApproach(int heightMap[])
    {
        int maxWater = 0;
        int leftPointer = 0;
        int rightPointer = heightMap.length-1;

        while(leftPointer < rightPointer)
        {
            int height = Math.min(heightMap[leftPointer], heightMap[rightPointer]);
            int width = rightPointer - leftPointer;
            int currWater = height * width;

            maxWater = Math.max(maxWater, currWater);

            if(heightMap[leftPointer] < heightMap[rightPointer])
            {
                leftPointer++;
            }
            else
            {
                rightPointer--;
            }
        }

        return maxWater;
    }

    private static boolean PairSumExists2PointerApproach(int array[], int key)
    {
        int leftPointer = 0;
        int rightPointer = array.length-1;

        while(leftPointer != rightPointer)
        {
            if(array[leftPointer] + array[rightPointer] == key)
            {
                return true;
            }
            else if(array[leftPointer] + array[rightPointer] < key)
            {
                leftPointer++;
            }
            else
            {
                rightPointer--;
            }
        }

        return false;
    }
}