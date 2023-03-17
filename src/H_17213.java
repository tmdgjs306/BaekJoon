import java.util.Scanner;

public class H_17213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [][] dp = new int[N+1][M+1];
        for(int i=1; i<=(M-(N-1)); i++) {
            dp[1][i] = 1;
        }
        if(N==1)
        {
            System.out.println(1);
            return;
        }
        for(int i=2; i<=N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j] != 0) {
                    for (int t = 1; t <= (M - (N - i)); t++) {
                        if (j + t > M) continue;
                        dp[i][j + t] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.print(dp[N][M]);
    }
}
