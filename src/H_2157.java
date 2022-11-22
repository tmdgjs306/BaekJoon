import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class H_2157 {
    public static class next
    {
        int to;
        int value;
        public next(int to, int value)
        {
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m,k;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int [][] dp =new int [n+1][m+1]; // n 도시 m 카운트

        ArrayList <next> list [] = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
        {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<k; i++)
        {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int value = sc.nextInt();
            if(from > to)
            {
                continue;
            }
            list[from].add(new next(to,value));
        }

        for(int i=1; i<=n; i++)
        {
            Arrays.fill(dp[i],-1);
        }

        dp[1][m] = 0;

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<list[i].size(); j++)
            {
                int index = list[i].get(j).to;
                int val = list[i].get(j).value;
                for (int K = 1; K <= m; K++)
                {
                    if(dp[i][K]!=-1) {
                        dp[index][K - 1] = Math.max(dp[index][K - 1], dp[i][K] + val);
                    }
                }
            }
        }

        int max = -1;
        for(int i=1; i<=m; i++)
        {
            max = Math.max(max,dp[n][i]);
        }
        System.out.print(max);

    }
}
