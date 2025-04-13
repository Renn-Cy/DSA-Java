/* Find the number of ways to reach from (0,0) to
 * (n-1, m-1) in a n*m Grid. 
 * Legal moves: right, down */

public class GridWays
{
    public static void main(String args[])
    {
        int n = 3;
        int m = 3;
        
        System.out.println(gridWays(0, 0, n, m));
    }

    private static int gridWays(int i, int j, int n, int m)
    {
        //condition for last cell
        if(i == n-1 && j == m-1) {return 1;}

        //boundary cross condition
        else if(i == n || j == n) {return 0;}

        //down
        int w1 = gridWays(i+1, j, n, m);
        
        //right
        int w2 = gridWays(i, j+1, n, m);

        return w1 + w2;
    }
}
