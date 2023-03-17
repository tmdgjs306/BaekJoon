import java.util.Scanner;

public class H_27210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] value = new int[n+1];
        for(int i=1; i<=n; i++){
            value[i] = sc.nextInt();
        }
        int [][] dp = new int[n+1][2];
        int max1 = 0;
        int max2 = 0;
        dp[0][1] = 0;
        dp[0][0] = 0;
        for(int i=1; i<=n; i++){
            if(value[i]==1){
                dp[i][0] =dp[i-1][0]+1;
                dp[i][1] =dp[i-1][1]-1;
                if(dp[i][1]<=0) dp[i][1] = 0;
                max1 = Math.max(max1,dp[i][0]);
            }
            else{
                dp[i][0] = dp[i-1][0]-1;
                dp[i][1] =dp[i-1][1]+1;
                if(dp[i][0]<=0) dp[i][0] = 0;
                max2 = Math.max(max2,dp[i][1]);
            }
        }
        System.out.print(Math.max(max1,max2));
    }
}
