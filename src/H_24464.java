import java.util.Scanner;

public class H_24464 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [][] dp = new long[n+1][5+1]; // i = 날짜 j= 1,2,3,4 선택한 식당 5=> 스킵
        for(int j=1; j<=5; j++)
        {
            dp[1][j] = 1;
        }
        if(n==1) {
            System.out.println(5);
            return;
        }
        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<=5; j++)
            {
                if(j==5)
                {
                    for(int k=1; k<=4; k++) {
                        dp[i][k] += dp[i - 1][j];
                        dp[i][k]%=1000000007;
                    }
                }
                else
                {
                    for(int k =1; k<=5; k++)
                    {
                        if(j==4)
                        {
                            if(k==3 || k==4) continue;
                            dp[i][k]+=dp[i-1][j];
                            dp[i][k]%=1000000007;
                            continue;
                        }
                        else if(j==k || j+1==k || j-1 ==k) continue;
                        dp[i][k]+=dp[i-1][j];
                        dp[i][k]%=1000000007;
                    }
                }
            }
        }
        long result = 0;
        for(int j=1; j<=5; j++)
        {
            result+=dp[n][j];
        }
        System.out.print(result%1000000007);
    }
}
