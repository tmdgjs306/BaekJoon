import java.util.Scanner;

public class H_11660 {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int DP[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                DP[i][j]=sc.nextInt();
            }
        }
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                DP[i][j]+=DP[i][j-1];
            }
        }
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                DP[i][j]+=DP[i-1][j];
            }
        }
        for(int i=0; i<m; i++)
        {
            int x1,y1;
            int x2,y2;
            x1=sc.nextInt();
            y1=sc.nextInt();
            x2=sc.nextInt();
            y2=sc.nextInt();
            int result = 0 ;
            result = DP[x2][y2] - DP [x2][y1-1] - DP[x1-1][y2] + DP[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
