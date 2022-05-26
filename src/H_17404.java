import java.util.Scanner;

public class H_17404 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int House[][] =new int[N][3];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<3; j++)
            {
                House[i][j]=sc.nextInt();
            }
        }
        int DP_one [][] = new int[N][3];
        int DP_two [][] = new int[N][3];
        int DP_three [][] = new int[N][3];

        for(int i=0; i<3; i++)
        {
            if(i==0)
            {
                DP_one[0][i]=House[0][i];
            }
            else
            {
                DP_one[0][i]=1000;
            }
        }
        for(int i=0; i<3; i++)
        {
            if(i==1)
            {
                DP_two[0][i]=House[0][i];
            }
            else
            {
                DP_two[0][i]=1000;
            }
        }
        for(int i=0; i<3; i++)
        {
            if(i==2)
            {
                DP_three[0][i]=House[0][i];
            }
            else
            {
                DP_three[0][i]=1000;
            }
        }
        for(int i=1; i<N-1; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(j==0) {
                    DP_one[i][j] = Math.min(DP_one[i - 1][j + 1], DP_one[i - 1][j + 2]) + House[i][j];
                    DP_two[i][j] = Math.min(DP_two[i - 1][j + 1], DP_two[i - 1][j + 2]) + House[i][j];
                    DP_three[i][j] = Math.min(DP_three[i - 1][j + 1], DP_three[i - 1][j + 2]) + House[i][j];
                }
                else if(j==1) {
                    DP_one[i][j] = Math.min(DP_one[i - 1][j + 1], DP_one[i - 1][j - 1]) + House[i][j];
                    DP_two[i][j] = Math.min(DP_two[i - 1][j + 1], DP_two[i - 1][j - 1]) + House[i][j];
                    DP_three[i][j] = Math.min(DP_three[i - 1][j + 1], DP_three[i - 1][j - 1]) + House[i][j];
                }
                else if(j==2) {
                    DP_one[i][j] = Math.min(DP_one[i - 1][j - 1], DP_one[i - 1][j - 2]) + House[i][j];
                    DP_two[i][j] = Math.min(DP_two[i - 1][j - 1], DP_two[i - 1][j - 2]) + House[i][j];
                    DP_three[i][j] = Math.min(DP_three[i - 1][j - 1], DP_three[i - 1][j - 2]) + House[i][j];
                }
            }
        }
        for(int i=0; i<3; i++)
        {
            if(i==1) {
                DP_one[N-1][i] = Math.min(DP_one[N - 2][i + 1], DP_one[N - 2][i - 1]) + House[N-1][i];
            }
            else if(i==2) {
                DP_one[N-1][i] = Math.min(DP_one[N - 2][i - 1], DP_one[N - 2][i - 2]) + House[N-1][i];
            }
        }
        for(int i=0; i<3; i++)
        {
           if(i==0)
           {
               DP_two[N-1][i] = Math.min(DP_two[N- 2][i + 1], DP_two[N - 2][i + 2]) + House[N-1][i];
           }
           else if (i==2)
           {
               DP_two[N-1][i] = Math.min(DP_two[N- 2][i - 1], DP_two[N - 2][i - 2]) + House[N-1][i];
           }
        }
        for(int i=0; i<3; i++)
        {
            if(i==0)
            {
                DP_three[N-1][i] = Math.min(DP_three[N - 2][i + 1], DP_three[N - 2][i + 2]) + House[N-1][i];
            }
            else if(i==1)
            {
                DP_three[N-1][i] = Math.min(DP_three[N - 2][i + 1], DP_three[N - 2][i - 1]) + House[N-1][i];
            }
        }
        int max_one=Math.min(DP_one[N-1][1],DP_one[N-1][2]);
        int max_two=Math.min(DP_two[N-1][0],DP_two[N-1][2]);
        int max_three=Math.min(DP_three[N-1][0],DP_three[N-1][1]);
        System.out.println(Math.min(max_one,Math.min(max_two,max_three)));

    }
}
