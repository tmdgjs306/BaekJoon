import java.util.Scanner;

public class H_2096 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int numbers[][] = new int[N][3];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<3; j++)
            {
                numbers[i][j]=sc.nextInt();
            }
        }
        int max1=numbers[0][0];
        for(int i=1; i<N-1; i++)
        {
            max1=1;
        }
    }
}
