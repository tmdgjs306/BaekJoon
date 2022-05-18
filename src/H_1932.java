import java.util.Scanner;

public class H_1932
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int [][]nums = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<=i; j++)
            {
                nums[i][j]=sc.nextInt();
            }
        }
        for(int i=n-1; i>=1; i--)
        {
            for(int j=0; j<=i-1; j++)
            {
                nums[i-1][j]+=Math.max(nums[i][j],nums[i][j+1]);
            }
        }
        System.out.println(nums[0][0]);
    }
}
