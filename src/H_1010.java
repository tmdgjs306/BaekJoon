import java.util.Scanner;

public class H_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int T=0; T<t; T++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][] dp = new int[n][m];
            for(int i=0; i<m; i++){
                dp[0][i] = 1;
            }
            for(int i=1; i<n; i++){
                for(int j=i; j<m; j++){
                    for(int k=j; k<m; k++){
                        dp[i][j]+=dp[i-1][k];
                    }
                }
            }
            long result =0;
            for(int i=0; i<m; i++){
                result+=dp[n-1][i];
            }
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
}
