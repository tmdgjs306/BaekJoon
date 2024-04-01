import java.io.BufferedReader;
import java.util.Scanner;

public class H_13699 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       long dp [] = new long[36];
       dp[0] = 1;
       int n = sc.nextInt();
       for(int i=1; i<=35; i++){
           long temp = 0;
           for(int j=0; j<i; j++){
               temp += dp[j] * dp[i-j-1];
           }
           dp[i] = temp;
       }
        System.out.print(dp[n]);
    }
}
