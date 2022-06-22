import java.util.Scanner;

public class H_2560{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int d=sc.nextInt();
        int N=sc.nextInt();
        int []DP = new int[N+1];
        DP[0]=1;
        for(int i=1; i<=N; i++)
        {
            if(i<a)
            {
                DP[i]=(DP[i-1]+1000)%1000;
            }
            else if(i<b)
            {
                DP[i]=(DP[i-1] + DP[i-a]+1000)%1000;
            }
            else
            {
                DP[i]=(DP[i-1]+DP[i-a]-DP[i-b]+1000)%1000;
            }

        }
        if(N-d>=0)
        {
            DP[N]=(DP[N]-DP[N-d]+1000)%1000;
        }
        System.out.println(DP[N]%1000);
    }
}
