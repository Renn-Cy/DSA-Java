import java.util.*;

public class BitManipulation
{
    public static void main(String args[])
    {
        // System.out.println(ClearLastIBits(15, 2));
        System.out.println(NoOfSetBits(2048));
    }

    private static void OddOrEven(int bin)
    {
        if((bin & 1) == 1)
        {
            System.out.println("Odd Number");
        }
        else
        {
            System.out.println("Even Number");
        }
    }

    private static int GetIthBit(int bin, int bitPos)
    {
        bin = bin >> bitPos;

        if((bin & 1) == 1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    private static int SetIthBit(int bin, int bitPos)
    {
        int bitMask = 1 << bitPos;

        return bin | bitMask;
    }

    private static int ClearIthBit(int bin, int bitPos)
    {
        int bitMask = 1 << bitPos;

        return bin ^ bitMask;
    }

    private static int UpdateIthBit(int bin, int bitPos, int updatedValue)
    {
        bin = ClearIthBit(bin, bitPos);
        int bitMask = updatedValue << bitPos;

        return bin | bitMask;
    }

    private static void ClearLastIBitsMySol(int bin, int noOfBits)
    {
        for(int i=0; i<=noOfBits; i++)
        {
            ClearIthBit(bin, i);
        }
    }

    private static int ClearLastIBits(int bin, int noOfBits)
    {
        int bitMask = (~0)<<noOfBits;
        return bin & bitMask;
    }

    private static void ClearRangeOfBits(int bin, int startInd, int endInd)
    {
        for(int i=startInd; i<=endInd; i++)
        {
            ClearIthBit(bin, i);
        }
    }

    private static char CharacterCaseChange(char alphabet)
    {
        if((int) alphabet >= 65 && (int) alphabet <= 90)
        {
            return (char)(alphabet | ' ');
        }
        else if((int) alphabet >= 97 && (int) alphabet <= 122)
        {
            return (char)(alphabet ^ ' ');
        }
        else
        {
            return '!';
        }
    }

    private static boolean isPowerOf2(int n)
    {
        return (n & (n-1)) == 0;
    }

    private static int NoOfSetBits(int n)
    {
        int count = 0;

        while(n > 0)
        {
            if((n & 1) != 0)
            {
                count++;
            }

            n = n >> 1;
        }

        return count;
    }
}