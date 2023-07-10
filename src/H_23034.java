import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_23034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][]dp = new int [n+1][201];
        boolean [] skip = new boolean[n+1];
        for(int i=0; i<m; i++){
            int temp = Integer.parseInt(br.readLine());
            skip[temp] = true;
        }
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[2][1] =1;
        if(skip[2]){
            System.out.println(-1);
            return;
        }
        for(int i=2; i<=n; i++){
            for(int j=1; j<=200; j++){
                if(dp[i][j]!=Integer.MAX_VALUE){
                    if(i+j+1<=n && !skip[i+j+1]){
                        dp[i+j+1][j+1] =Math.min(dp[i+j+1][j+1],dp[i][j]+1);
                    }
                    if(i+j<=n &&!skip[i+j]){
                        dp[i+j][j] = Math.min(dp[i+j][j],dp[i][j]+1);
                    }
                    if(i+j-1<=n && j-1>=1 && !skip[i+j-1]){
                        dp[i+j-1][j-1] = Math.min(dp[i+j-1][j-1],dp[i][j]+1);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=200; i++){
            min = Math.min(min,dp[n][i]);
        }
        if(min==Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(min);
    }
}
