import java.util.Scanner;

public class H_1654 {
    static int [] lans;
    static int n,k;

    public static boolean check(long mid)
    {
        long sum = 0;
        for(int i=0; i<n; i++)
        {
            sum+=(lans[i]/mid);
        }
        return sum>=k;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        lans = new int[n];
        long low = 0;
        long high = 2147483647;
        for(int i=0; i<n; i++)
        {
            lans[i] = sc.nextInt();
        }
        while (low+1 < high)
        {
            long mid = (low+high)/2;
            if(check(mid)) low = mid;
            else high = mid;
        }
        System.out.println(low);
    }
}
