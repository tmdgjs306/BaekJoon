import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_17953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 날짜
        int m = Integer.parseInt(st.nextToken()); // 디저트 종류
        int [][] dp = new int[m][n];
        int [][] values = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        for(int i=0; i<m; i++){
            dp[i][0] = values[i][0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<m; k++){
                    if(j==k)
                        dp[k][i] = Math.max(dp[k][i],dp[j][i-1]+(values[k][i]/2));
                    else
                        dp[k][i] = Math.max(dp[k][i],dp[j][i-1]+(values[k][i]));
                }
            }
        }

        /*for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        int max = Integer.MIN_VALUE;
        for(int j=0; j<m; j++){
            max = Math.max(max,dp[j][n-1]);
        }
        System.out.print(max);
    }
}
