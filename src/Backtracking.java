public class Backtracking
{
    public static void main(String args[])
    {
        String str = "abc";
        Permutation(str, "");
    }

    private static void PrintArray(int array[])
    {
        for(int i=0; i<array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void ChangeArray(int array[]/*empty array*/, int i/*0*/, int val/*1*/)
    {
        if(i == array.length) {PrintArray(array);return;}

        array[i] = val;
        ChangeArray(array, i+1, val+1);
        array[i] = array[i] - 2;
    }

    static void FindAllSubsets(String str, String ans/*""*/, int i/*0*/)
    {
        if(i == str.length())
        {
            if(ans.length() == 0)
            {
                System.out.println("NULL");
            }
            else
            {
                System.out.println(ans);
            }
            return;
        }

        //yes choice
        FindAllSubsets(str, ans+str.charAt(i), i+1);
        //no choice
        FindAllSubsets(str, ans, i+1);
    }

    static void Permutation(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++)
        {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);

            Permutation(newStr, ans+currChar);
        }
    }
}