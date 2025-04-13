import java.util.*;
public class Recursion
{
    public static void main(String args[])
    {
        // int n = 7;
        // int ar[] = {1,2,3,4,2,7,6};
        // String str = "rrrreeeennnnn";
        // RemoveDuplicatesFromString(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println(RaisedToPowerOptimal(2, 4));

        // String str = "abcab";
        // int n = str.length();
        // System.out.println(CountSubStrs(str, 0, n-1, n));
    }

    static void RecursiveDecOrdr(int n)
    { // print the numbers from n to 1
        if(n == 1)   // base case
        {
            System.out.println(n);
            return;
        }
        
        System.out.print(n + " ");

        RecursiveDecOrdr(n-1);
    }

    static void RecursiveIncOrdr(int n)
    { // print the numbers from i to n
        if(n == 1)   // base case
        {
            System.out.print(n + " ");
            return;
        }

        RecursiveIncOrdr(n-1);
        
        System.out.print(n + " ");
    }

    static int Factorial(int n)
    { // Space Complexity: O(n) , Time Complexity: O(n)
        if(n == 0)
        {
            return 1;
        }

        int fnm1 = Factorial(n-1);
        int fn = n * fnm1;

        return fn;
    }

    static int SumOfNaturalNums(int n)
    {
        if(n == 0)
        {
            return 0;
        }

        int snm1 = SumOfNaturalNums(n-1);
        int sum = n + snm1;
        
        return sum;
    }

    static int NthFibonacciNum(int n)
    { // Space Complexity: O(2^n) , Time Complexity: O(n)
        if(n == 0 || n == 1) {return n;}

        int fibNm1 = NthFibonacciNum(n-1);
        int fibNm2 = NthFibonacciNum(n-2);

        int nthFib = fibNm1 + fibNm2;
        
        return nthFib;
    }

    static boolean isSorted(int array[], int i)
    { // Space Complexity: O(n) , Time Complexity: O(n)
        if(i == array.length-1) {return true;}
        if(array[i] > array[i+1]) {return false;}

        return isSorted(array, i+1);
    }

    static int FirstOccurance(int array[], int key, int i/*(0)*/)
    {
        if(i == array.length) {return -1;}
        if(array[i] == key) {return i;}

        return FirstOccurance(array, key, i+1);
    }

    static int LastOccuranceMyMethod(int array[], int key, int i/*(0)*/, int lastOccur/*(-1)*/)
    {
        if(i == array.length) {return lastOccur;}
        if(array[i] == key)
        {
            lastOccur = i;
        }

        return LastOccuranceMyMethod(array, key, i+1, lastOccur);
    }

    static int LastOccurance(int array[],int key, int i)
    {
        if(i == array.length) {return -1;}

        int isFound = LastOccurance(array, key, i+1);

        if(isFound == -1 && array[i] == key) {return i;}

        return isFound;
    }

    static int RaisedToPower(int base, int exponent)
    { // Time Complexity: O(n)
        if(exponent == 0) {return 1;}

        int btpnm1 = RaisedToPower(base, exponent-1);
        int power = base * btpnm1;

        return power;
    }


    static int RaisedToPowerOptimal(int base, int exponent)
    { // Time Complexity: O(logn)
        if(exponent == 0) {return 1;}

        // x^n = x^(n/2) * x^(n/2)
        int halfPower = RaisedToPowerOptimal(base, exponent/2);
        int halfPowerSq = halfPower * halfPower;

        // odd exponent is odd
        if(exponent % 2 != 0)
        {
            halfPowerSq *= base;
        }

        return halfPowerSq;
    }

    static void RemoveDuplicatesFromString(String str, int idx/*0*/, StringBuilder newStr/*empty string*/, boolean map[]/*size: 26 */)
    {
        if(idx == str.length())
        {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);

        if(map[currChar-'a'] == true)
        {
            RemoveDuplicatesFromString(str, idx+1, newStr, map);
        }
        else
        {
            map[currChar-'a'] = true;
            RemoveDuplicatesFromString(str, idx+1, newStr.append(currChar), map);
        }
    }

    static int CountSubStrs(String str, int i, int j, int n)
    {
        if(n == 1) {return 1;}
        if(n <= 0) {return 0;}

        int res = CountSubStrs(str, i+1, j, n-1) +
                  CountSubStrs(str, i, j-1, n-1) -
                  CountSubStrs(str, i+1, j-1, n-2);
        
        if(str.charAt(i) == str.charAt(j)) 
        {
            res++;
        }
        return res;
    }
}