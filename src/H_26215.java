import java.util.*;

public class H_26215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int [] dp = new int[value+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int [] coin = new int [4];
        coin[0] = 1;
        coin[1] = 2;
        coin[2] = 5;
        coin[3] = 7;
        dp[0]=0;
        for(int i =1; i<=value; i++)
        {
            for(int j=0; j<4; j++)
            {
                if(i>=coin[j])
                {
                    dp[i]= Math.min(dp[i],dp[i-coin[j]]+1);
                }
            }
        }
        System.out.println(dp[value]);
    }
}
