import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_1920 {
    static long [] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        list = new long [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
        {
            int value = Integer.parseInt(st1.nextToken());
            int first = 0;
            int last = n-1;
            boolean find = false;
            int mid;
            while(first+1<last)
            {
                mid = (first+last)/2;
                if(list[mid]==value)
                {
                    find = true;
                    break;
                }
                else if(list[mid]<value)
                {
                    first = mid;
                }
                else
                {
                    last = mid;
                }
            }
            if(list[first]==value|| list[last]==value)
            {
                find = true;
            }
            if(find)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
