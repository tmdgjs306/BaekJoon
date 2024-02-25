import java.util.Scanner;

public class H_17202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int [] dp = new int[16];
        int temp = 10;
        for(int i=0; i<8; i++){
            dp[15-(i*2)] = B%temp;
            dp[(15-(i*2))-1] = A%temp;
            A /= temp;
            B /= temp;
        }
        for(int i=0; i<14; i++){
            for(int j=0; j<15-i; j++){
                dp[j] = (dp[j]+dp[j+1])%temp;
            }
        }
        System.out.print(dp[0]+""+dp[1]);
    }
}
