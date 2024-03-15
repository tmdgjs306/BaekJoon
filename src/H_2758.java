import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_2758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // i = 현재 숫자 | j = 현재 선택한 숫자 갯수
        long [][] dp = new long[2001][11];

        for(int i=1; i<=2000; i++){
            dp[i][1] = 1;
            for(int j=1; j<10; j++){
                if(dp[i][j]!=0){
                    for(int k = i*2; k<=2000; k++){
                        dp[k][j+1] += dp[i][j];
                    }
                }
            }
        }

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long sum = 0;
            for(int j=1; j<=m; j++){
                sum += dp[j][n];
            }
            System.out.println(sum);
        }
    }
}
