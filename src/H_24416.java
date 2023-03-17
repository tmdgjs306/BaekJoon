import java.util.Scanner;

public class H_24416 {
    static long count_rec= 0;
    public static int fib(int n)
    {
        if(n==1 || n==2)
            return 1;
        else
        {
            count_rec++;
            return (fib(n-1)+fib(n-2));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int[n+1];
        int count_dp = 0;
        if(n==1 || n==2)
        {
            System.out.println(1+" "+1);
        }
        else
        {
            dp[1]=1;
            dp[2]=1;
            for(int i=3; i<=n; i++)
            {
                dp[i] = dp[n-1]+dp[n-2];
                count_dp++;
            }
        }
        fib(n);
        System.out.print(count_rec+1+" "+count_dp);
    }
}
