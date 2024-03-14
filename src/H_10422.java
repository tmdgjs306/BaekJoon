import java.util.Scanner;

public class H_10422 {
    static final int MOD = 1000000007; // 모듈러 연산에 사용할 값
    static long[] dp = new long[2501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 2500; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]) % MOD;
                dp[i] %= MOD;
            }
        }
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int l = sc.nextInt();
            if(l%2 ==1){
                sb.append(0).append("\n");
            }
            else{
                sb.append(dp[l/2]).append("\n");
            }
        }
        System.out.print(sb);
    }
}