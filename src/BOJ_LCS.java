import java.util.Scanner;

public class BOJ_LCS {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String first =sc.next();
        String second = sc.next();
        int x = first.length();
        int y= second.length();
        int [][] DP = new int[y+1][x+1];

        for(int i=0; i<x+1;  i++)
        {
            DP[0][i]=0;
        }
        for(int i=0; i<y+1; i++)
        {
            DP[i][0]=0;
        }
        for(int i=1; i<=x; i++)
        {
            for(int j=1; j<=y; j++)
            {
                if(first.charAt(i-1)==second.charAt(j-1))
                {
                    DP[j][i]=Math.max(DP[j-1][i-1]+1,Math.max(DP[j-1][i], DP[j][i-1]));
                }
                else
                {
                    DP[j][i]=Math.max(DP[j-1][i],DP[j][i-1]);
                }
            }
        }
        System.out.println(DP[y][x]);
    }

}
