/* Fractional Knapsack:
 * Given the weights and values of N items, put these items in a 
 * knapsack of capacity W to get the maximum total value in the knapsack.
 * 
 * approach: select the elements with the lowest weight and greatest
 * value. take ratio and select based on that */

import java.util.*;

public class FractionalKnapsack
{
    public static void main(String[] args)
    {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        float[][] ratio = new float[value.length][2];

        for(int i=0; i<ratio.length; i++)
        {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/weight[i];
        }

        //sorted in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalValue = 0;

        for(int i=ratio.length-1; i>=0; i--)
        {
            int idx = (int) ratio[i][0];
            
            //include the whole item
            if(capacity >= weight[idx])
            {
                finalValue += value[idx];
                capacity -= weight[idx];
            }
            //include a fraction of the item
            else
            {
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("final value of knapsack: " + finalValue);
    }    
}
