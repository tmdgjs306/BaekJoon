import java.util.Scanner;

public class H_2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int ii=0;
        int jj=0;
        for(int i=1; i<=9; i++)
        {
            for(int j=1; j<=9; j++)
            {
                int temp = sc.nextInt();
                if(max<temp)
                {
                    ii= i;
                    jj=j;
                    max = temp;
                }
            }
        }
        System.out.println(max);
        System.out.println(ii+" "+jj);
    }
}
