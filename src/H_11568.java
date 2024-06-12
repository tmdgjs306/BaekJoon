import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_11568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(1);
            return;
        }
        int [] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i],-1);
        }
        /**
         * DP ARRAY
         * x: 현재 위치
         * y: 선택한 원소의 최대값 Index
         * */
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                if(dp[i-1][j]!=-1){
                    int value =  arr[j];
                    if(arr[i]>value){
                        dp[i][i] = Math.max(dp[i-1][j]+1,dp[i][i]); // Keep
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j]); //Skip
                    } else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j]); //Skip
                    }
                }
            }
        }
        int result = 0;
        for(int i=0; i<=n; i++){
            result = Math.max(result, dp[n][i]);
        }
        System.out.print(result);
    }
}
