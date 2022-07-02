import java.util.Scanner;

public class H_11404 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]map = new int[n+1][n+1];
        int inf=100000001;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(i==j)
                    map[i][j]=0;
                else
                    map[i][j]=inf;
            }
        }
        for(int i=0; i<m; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int value =sc.nextInt();
            map[x][y]=Math.min(map[x][y],value);
        }
        for(int r=1; r<=n; r++)
        {
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    map[i][j]=Math.min(map[i][j],map[i][r]+map[r][j]);
                }
            }
        }
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(map[i][j]==inf)
                {
                    map[i][j]=0;
                }
                    System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
