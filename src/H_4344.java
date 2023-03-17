import java.util.Scanner;

public class H_4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++)
        {
            int m = sc.nextInt();
            int [] list = new int[m];
            int sum = 0;
            double rate = 0.0;
            int avg = 0;
            for(int j=0; j<m; j++)
            {
                list[j] = sc.nextInt();
                sum+=list[j];
            }
            avg = sum/m;
            double count = 0;
            for(int j=0; j<m; j++)
            {
                if(list[j]>avg)
                    count++;
            }
            rate = (count/(double) m)*100;
            System.out.println(String.format("%,.3f",rate)+"%");
        }
    }
}
