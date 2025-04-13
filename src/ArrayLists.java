import java.util.*;

public class ArrayLists
{
    public static void main(String args[])
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();

        outerList.add(list1);
        outerList.add(list2);

        list1.add(16);
        list1.add(64);
        list1.add(4);
        list1.add(32);
        list1.add(8);

        list2.add(2);
        list2.add(4);
        list2.add(8);
        list2.add(16);
        list2.add(32);

        Collections.sort(list1);
        Collections.sort(list2, Collections.reverseOrder());

        for(int i = 0; i < list2.size(); i++)
        {
            list2.set(i, list2.get(i) * 2);
        }

        
        System.out.println(outerList);   
    }
}