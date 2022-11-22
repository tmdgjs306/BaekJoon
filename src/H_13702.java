import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_13702 {
    static int n,m;
    static long [] list;
    public static boolean is_true(long size)
    {
        long temp = 0;
        for(int i=0; i<n; i++)
        {
            temp+= list[i] / size;
        }
        if(temp>=m)
        {
            return true;
        }
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new long[n];
        long high = 0;
        for(int i=0; i<n; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
            high = Math.max(list[i],high);
        }
        long left = 1;
        long right = high;
        long max = 0;

        while(left<= right)
        {
            long mid = (left+right)/2;
            if(is_true(mid))
            {
                left = mid+1;
                max = Math.max(max,mid);
            }
            else
            {
                right = mid-1;
            }
        }
        System.out.print(max);
    }
}
