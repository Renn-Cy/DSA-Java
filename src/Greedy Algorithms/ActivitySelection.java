/* Activity Selection: (Greedy Approach)
 * You are given n activities with their start and end times. 
 * Select the maximum number of activities that an be performed 
 * by a single person, assuming that a person can only work on 
 * a single activity at a time. Activities are sorted according 
 * to end time.
 * 
 * approach: select the elements with the lowest end time who's start
 * time isn't lower then the last activity's end time */

import java.util.*;

public class ActivitySelection
{
    public static void main(String[] acts)
    {
        int[] start =  {5, 3, 0, 5, 1, 8};//{1, 3, 0, 5, 8, 5};
        int[] end   =  {9, 4, 6, 7, 2, 9};//{2, 4, 6, 7, 9, 9};

        //sorting
        int[][] activities = new int[start.length][3];
        for(int i = 0; i < start.length; i++)
        {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // sorted on the basis of end time
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++)
        {
            if (activities[i][1] >= lastEnd)
            {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        for(int i = 0; i < activities.length; i++)// Loop through all rows
        {
            for(int j = 0; j < activities[0].length; j++)// Loop through all elements of current row
            {
                System.out.print(activities[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("max activities = " + maxAct);
        for(int i = 0; i < ans.size(); i++)
        {
            System.out.println("act " + (ans.get(i)) + " ");
        }
    } 
}