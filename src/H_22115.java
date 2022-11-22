import java.util.Arrays;
import java.util.Scanner;

public class H_22115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k+1];
        int [] value = new int[n];
        Arrays.fill(dp,99999999);
        for(int i=0; i<n; i++)
        {
            value[i] = sc.nextInt();
            dp[value[i]]=1;
        }
        dp[0]=0;
        Arrays.sort(value);
        for(int i=k; i>=0; i--)
        {
            for(int j=0; j<n; j++)
            {
                if(i>=value[j])
                {

                }
            }
        }
        for(int i=0; i<=k; i++)
        {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
       if(dp[k]==99999999)
       {
           System.out.println(-1);
       }
       else
           System.out.println(dp[k]);
    }
}
