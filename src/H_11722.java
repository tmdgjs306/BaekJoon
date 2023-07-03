import java.util.Arrays;
import java.util.Scanner;

public class H_11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] dp = new int[n+1][1002];
        int [] values = new int[n+1];
        for(int i=1; i<=n; i++){
            values[i] = sc.nextInt();
        }
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][1001]=0;
        for(int i=1; i<=n; i++){
            int now = values[i];
            for(int j=1; j<=1001; j++){
                if(dp[i-1][j]==-1)continue;
                if(j<=now) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j]); //skip
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j]); //skip
                    dp[i][now] = Math.max(dp[i-1][j]+1,dp[i][now]); //keep
                }
            }
        }
        int max =0;
        for(int i=1; i<=1001; i++){
            if(dp[n][i]>max){
                max = dp[n][i];
            }
        }
        System.out.print(max);
    }
}
