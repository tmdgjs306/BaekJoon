import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_17208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // m => 남은 치즈버거 | k = 남은 감자튀김
        int [][] dp = new int[m+1][k+1];
        for(int i=0; i<=m; i++){
            Arrays.fill(dp[i],-1);
        }
        dp[m][k] =0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x > m || y > k) continue;
            for(int j =0; j<=m; j++){
                for(int t=0; t<=k; t++){
                    if(dp[j][t]!=-1 && j-x>=0 && t-y>=0){
                        dp[j-x][t-y] = Math.max(dp[j-x][t-y],dp[j][t]+1);
                    }
                }
            }
        }
        int maxOrder = 0;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=k; j++){
                maxOrder = Math.max(dp[i][j],maxOrder);
            }
        }
        System.out.print(maxOrder);
    }
}
