import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_1757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][][] dp = new int[n+2][m+2][2];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        dp[0][0][0]=0;
        int [] list = new int[n+2];
        for(int i=1; i<=n; i++)
        {
            int temp = Integer.parseInt(br.readLine());
            list[i] = temp;
        }
        for(int i=0; i<=n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                for (int k = 1; k >=0; k--)
                {
                    if (dp[i][j][k] != -1)
                    {
                        if (k == 1)
                        {
                            if (j >= 1)
                                dp[i + 1][j - 1][k] = Math.max(dp[i + 1][j - 1][k], dp[i][j][k]);
                            else
                                dp[i][0][0] = Math.max(dp[i][0][0], dp[i][j][k]);
                        }
                        else
                        {
                            if (j < m)
                            {
                                dp[i + 1][j + 1][k] = Math.max(dp[i + 1][j + 1][k], dp[i][j][k] + list[i]); //run
                                //skip
                                if (j == 0) {
                                    dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k]); //skip
                                } else {
                                    dp[i + 1][j - 1][1] = Math.max(dp[i + 1][j - 1][1], dp[i][j][k]);
                                }
                            } else {
                                dp[i + 1][j - 1][1] = Math.max(dp[i + 1][j - 1][1], dp[i][j][k]);
                            }
                        }
                    }
                }
            }
        }
        System.out.print(Math.max(dp[n+1][0][1],dp[n+1][0][0]));
    }
}
