import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_18113 {
    static int n;
    static int k;
    static int m;
    static int [] list;
    public static boolean check(int size)
    {
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            int bob = list[i];
            sum+=(bob/size);
        }
        if(sum>=m)
        {
            return true;
        }
        else
            return false;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        for(int i=0; i<n; i++)
        {
            int temp = Integer.parseInt(br.readLine());
            if(temp>=2*k)
                temp-=2*k;
            else if(temp>=k)
                temp-=k;
            else
                temp=-1;
            list[i] = temp;
        }
        int left = 0;
        int right = 1000000000;
        while(left+1<right)
        {
            int mid = (left+right)/2;
            if(check(mid)) left = mid;
            else right = mid;
        }
        if(left ==0)
            System.out.print(-1);
        else
            System.out.print(left);
    }
}
