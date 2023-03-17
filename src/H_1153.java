import java.util.Arrays;
import java.util.Scanner;

public class H_1153{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] values = new int [n];
        int [] dp = new int [k+1];
        for(int i=0; i<n; i++)
        {
            values[i] = sc.nextInt();
        }
        Arrays.fill(dp,999999999);
        dp[0] =0;
        for(int j=0; j<n; j++)
        {
            for(int i=k; i>=0; i--)
            {
                if(i>=values[j])
                {
                    dp[i] = Math.min(dp[i],dp[i-values[j]]+1);
                }
            }
            System.out.println();
        }
        if(dp[k]==999999999)
        {
            System.out.print(-1);
        }
        else
        {
            System.out.print(dp[k]);
        }
        System.out.println();
    }
}
