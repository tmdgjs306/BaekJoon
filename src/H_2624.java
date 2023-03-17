import java.util.ArrayList;
import java.util.Scanner;

public class H_2624 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int k = sc.nextInt();
        int [][] dp = new int [k+1][T+1];
        ArrayList<Integer> []list =new ArrayList[k+1];
        for(int i=0; i<=k; i++)
        {
            list[i] = new ArrayList<Integer>();
        }
        for(int i=1; i<=k; i++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for(int j=1; j<=m; j++)
            {
                list[i].add(n*j);
            }
        }
        dp[0][0] = 1;
        for(int i=1; i<=k; i++)
        {
            for(int j=0; j<=T; j++)
            {
                if(dp[i-1][j]!=0)
                {
                    dp[i][j]+=dp[i-1][j];
                    for(int t=0; t<list[i].size(); t++)
                    {
                        int value = list[i].get(t);
                        if(value+j>T)continue;
                        else
                            dp[i][j+value]+=dp[i-1][j];
                    }
                }
            }
        }
        System.out.print(dp[k][T]);
     }
}
