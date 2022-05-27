
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class H_2467 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start=0;
        int end=N-1;
        int max=Integer.MAX_VALUE;
        int temp;
        int acid=0;
        int alkali=0;
        while(start<end)
        {
            temp=arr[start]+arr[end];
            if(Math.abs(temp)<max)
            {
                max=Math.abs(temp);
                acid=arr[end];
                alkali=arr[start];
            }
            if(temp>0)
                end--;
            else
                start++;
        }
        System.out.println(alkali + " " + acid);
    }

}
