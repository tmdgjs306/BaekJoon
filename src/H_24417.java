import java.util.Scanner;

public class H_24417 {
    static int fib1=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int [n+1];
        dp[1] =1;
        dp[2] =1;
        dp[3] =1;
        dp[4] =3;
        dp[5] =5;
        for(int i=6; i<=n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
            dp[i]%=1000000007;
        }
        System.out.println(dp[n]+" "+(n-2));
    }
}
