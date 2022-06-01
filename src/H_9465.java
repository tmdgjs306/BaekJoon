import java.util.Scanner;

public class H_9465 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0; i<T; i++)
        {
            int N=sc.nextInt();
            int st[][]=new int[2][N+1];
            for(int j=0; j<2; j++)
            {
                for(int t=1; t<=N; t++)
                {
                    st[j][t]=sc.nextInt();
                }
            }
            int [][]dp=new int[2][N+1];
            dp[0][1] = st[0][1];
            dp[1][1] = st[1][1];

                for (int j = 2; j <= N; j++) {
                    dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + st[0][j];
                    dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + st[1][j];
                }


            System.out.println(Math.max(dp[0][N],dp[1][N]));
        }
    }
}
