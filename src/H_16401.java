import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_16401 {
    static int m,n;
    static int [] list;
    public static boolean is_find(int size)
    {
        int temp=0;
        for(int i=0; i<n; i++)
        {
           temp+=(list[i])/size;
        }
        if(temp>=m) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        list = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right =1000000000;
        int max_size = -1;
        while(left+1 < right)
        {
            int mid=(left+right)/2;
            if(is_find(mid))
            {
                max_size = Math.max(max_size,mid);
                left=mid;
            }
            else
            {
                right=mid;
            }
        }
        if(max_size!=-1)
        {
            System.out.println(max_size);
        }
        else
        {
            System.out.println(0);
        }
    }
}
