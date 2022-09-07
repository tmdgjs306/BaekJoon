import java.util.Scanner;

public class H_B {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long N = sc.nextInt();
        long max = Long.MAX_VALUE;
        long result = 0;
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();
        for(int i=0; i<N; i++)
        {
            int T = sc.nextInt();
            long temp_result = 0;
            long now = a;
            long now2 =b;
            for(int t=0; t<T; t++)
            {
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();
                temp_result+=Math.abs(temp1-now)+Math.abs(temp2-now2);
                now=temp1;
                now2=temp2;
            }
            temp_result+=Math.abs(now-c)+Math.abs(now2-d);
            if(temp_result<max)
            {
                max =temp_result;
                result=i+1;
            }
        }
        System.out.print(result);
    }
}
