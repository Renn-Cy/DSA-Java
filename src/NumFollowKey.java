import java.util.*;

// Most Frequent Number Following Key
public class NumFollowKey
{
    public static void main(String[] keys)
    {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(4);nums.add(5);nums.add(2);
        nums.add(4);nums.add(4);nums.add(8);
        nums.add(4);nums.add(8);nums.add(2);
        nums.add(4);nums.add(8);nums.add(7);
        int key = 4;

        System.out.println(MostFreqNumAftKey(nums, key));
    }

    private static int MostFreqNumAftKey(ArrayList<Integer> nums, int key)
    {
        ArrayList<Integer> targets = new ArrayList<>();

        for(int i = 0; i <= nums.size()-2; i++)
        {
            if(nums.get(i) == key)
            {
                targets.add(nums.get(i+1));
            }
        }

        return TargetOccurrecMost(targets);
    }

    private static int TargetOccurrecMost(ArrayList<Integer> targets)
    {
        // ArrayList<ArrayList<Integer>> count = new ArrayList<>();
        ArrayList<Integer> occur = new ArrayList<>();
        ArrayList<Integer> elmnts = new ArrayList<>();
        // count.add(occur);
        // count.add(elmnts);
        int maxOccurrence = 0;
        int mostOccurredElmnt = 0;

        //filling the Count ArrayList
        for(int i = 0; i < targets.size(); i++)
        {
            //checks if a target has already occured
            if(!inList(elmnts, targets.get(i)))
            {
                elmnts.add(targets.get(i));
                occur.add(0);
            }
            
            //adds occurrence of the target to the list 
            for(int j = 0; j < elmnts.size(); j++)
            {
                if(targets.get(i) == elmnts.get(j))
                {
                    occur.set(j, occur.get(j)+1);
                }
            }
        }

        //finding the most occurred element
        for(int i = 0; i < elmnts.size(); i++)
        {
            if(occur.get(i) > maxOccurrence)
            {
                maxOccurrence = occur.get(i);
                mostOccurredElmnt = elmnts.get(i);
            }
        }

        return mostOccurredElmnt;
    }

    private static boolean inList(ArrayList<Integer> elmnts, int target)
    {
        for(int i = 0; i < elmnts.size(); i++)
        {
            if(elmnts.get(i) == target) {return true;}
        }

        return false;
    }
}