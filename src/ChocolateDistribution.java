/* Given an array of N integers where each value represents 
 * the number of chocolates in a packet. Each packet can have a 
 * variable number of chocolates. There are m students, the task 
 * is to distribute chocolate packets such that: 

- Each student gets one packet.
- The difference between the number of chocolates in the packet 
  with maximum chocolates and the packet with minimum chocolates 
  given to the students is minimum. */

import java.util.*;

public class ChocolateDistribution
{
    public static void main(String args[])
    {
        int chocolates[] = {54,3,7,34,6,4,6,24,3};
        int noOfStudents = 4;

        System.out.println("min difference is: " + DistributeChocolates(chocolates, noOfStudents));
    }

    static int DistributeChocolates(int array[], int noOfKids)
    {
        if(array.length < noOfKids) {return -1;}

        Arrays.sort(array);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < (array.length - noOfKids); i++)
        {
            minDiff = Math.min(minDiff, array[i+noOfKids-1] - array[i]);
        }

        return minDiff;
    }
}