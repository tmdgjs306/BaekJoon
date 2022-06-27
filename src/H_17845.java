import java.util.Scanner;

public class H_17845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        int []value = new int[k+1];
        int []weight= new int[k+1];
        int [][] DP = new int[k+1][n+1];

        for(int i=1; i<=k; i++)
        {
            value[i]=sc.nextInt();
            weight[i]=sc.nextInt();
        }

        for(int i=1; i<=k; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(weight[i]>j)
                {
                    DP[i][j]=DP[i-1][j];
                }
                else
                {
                    DP[i][j] = Math.max(DP[i-1][j],DP[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        System.out.println(DP[k][n]);

    }
}
