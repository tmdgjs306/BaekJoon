import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_24390 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st =new StringTokenizer(sc.next(),":");
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int get_time = ((m*60)+s)/10;
        if(get_time>=3)
        {
            get_time-=3;
        }
        else if (get_time==2)
        {
            System.out.print(3);
            return;
        }
        else if(get_time==1)
        {
            System.out.print(2);
            return;
        }
        int [] token = {1,3,6,60};
        int [] dp = new int[get_time+1];
        int new_getTime = get_time+3;
        int [] dp2 = new int[new_getTime+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.fill(dp2,Integer.MAX_VALUE);
        dp[0] = 1;
        dp2[0] =1 ;
        for(int i=1; i<=get_time; i++)
        {
            for(int j=0; j<4; j++)
            {
                if(i>=token[j])
                {
                    dp[i]=Math.min(dp[i],dp[i-token[j]]+1);
                }
            }
        }
        for(int i=1; i<=new_getTime; i++)
        {
            for(int j=0; j<4; j++)
            {
                if(i>=token[j])
                {
                    dp2[i]=Math.min(dp2[i],dp2[i-token[j]]+1);
                }
            }
        }
        System.out.print(Math.min(dp[get_time],dp2[new_getTime]));
    }
}
