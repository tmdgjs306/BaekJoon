import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class H_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] dp = new int[n+1];
        if(n==1){
            System.out.println(1);
            return;
        }
        Arrays.fill(dp,100);
        for(int i=1; i<=Math.sqrt(n); i++){
            dp[i*i] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=1; j<=Math.sqrt(i); j++){
                dp[i] = Math.min(dp[i],dp[i-(int)Math.pow(j,2)]+1);
            }
        }
        System.out.print(dp[n]);
    }
}
