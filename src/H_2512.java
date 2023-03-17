import java.util.Scanner;

public class H_2512 {
    static int [] list;
    static int m;
    public static boolean check(int money)
    {
        int sum= 0;
        for(int i=0; i<list.length; i++)
        {
            if(money>=list[i])
                sum+=list[i];
            else
                sum+=money;
        }
        if(sum>m) return false;
        else return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new int[n];
        int temp =0;
        int max = 0;
        for(int i=0; i<n; i++)
        {
            list[i] = sc.nextInt();
            temp+=list[i];
            max = Math.max(max,list[i]);
        }
        m = sc.nextInt();
        if(m>=temp)
        {
            System.out.print(max);
            return;
        }
        int left = 0;
        int right =m;
        while(left+1<right)
        {
            int mid = (left+right)/2;
            if(check(mid))left=mid;
            else right = mid;
        }
        System.out.print(left);
    }
}
