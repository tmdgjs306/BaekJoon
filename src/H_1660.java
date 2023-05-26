import java.util.Scanner;

public class H_1660 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n =  sc.nextInt();
        int [] dp = new int[n+1];
        dp[0] = 1;
        int j = 1;
        int pre =2;
        for(int i=1; i<=n; i++){
            j += pre++;
            dp[i]=dp[i-1]+j;
            System.out.println("j: "+j);
        }
        for(int i=0; i<=n; i++){
            System.out.print(dp[i]+" ");
        }
    }
}
