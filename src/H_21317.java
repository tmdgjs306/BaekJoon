import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_21317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] smallJump = new int[n+1];
        int [] bigJump = new int [n+1];
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            smallJump[i] = Integer.parseInt(st.nextToken());
            bigJump[i] = Integer.parseInt(st.nextToken());
        }
        int superJump = Integer.parseInt(br.readLine());

        int [] dp = new int[n+1];
        int [] dp2 = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.fill(dp2,Integer.MAX_VALUE);

        dp[1] =0;
        for(int i=1; i<n; i++){
            if(dp[i]!=Integer.MAX_VALUE){
                if(i+1<=n){
                    dp[i+1] = Math.min(dp[i+1],dp[i]+smallJump[i]);
                }
                if(i+2<=n){
                    dp[i+2] = Math.min(dp[i+2],dp[i]+bigJump[i]);
                }
                if(i+3<=n){
                    dp2[i+3] = Math.min(dp[i+3],dp[i]+superJump);
                }
            }
            if(dp2[i]!=Integer.MAX_VALUE) {
                if (i + 1 <= n) {
                    dp2[i + 1] = Math.min(dp2[i + 1], dp2[i] + smallJump[i]);
                }
                if (i + 2 <= n) {
                    dp2[i + 2] = Math.min(dp2[i + 2], dp2[i] + bigJump[i]);
                }
            }
        }
        System.out.print(Math.min(dp[n],dp2[n]));
    }
}
