import java.util.Arrays;
import java.util.Scanner;

public class H_28017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] values = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                values[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int j = 0; j < M; j++) {
            dp[0][j] = values[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    if (j == k) continue;
                    dp[i][k] = Math.min(dp[i][k], dp[i - 1][j] + values[i][k]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
       /* for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        for (int j = 0; j < M; j++) {
            min = Math.min(dp[N-1][j],min);
        }
        System.out.print(min);
    }
}
