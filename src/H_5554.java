import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class H_5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] list = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        int pre = list[n-1];
        if (n == 1)
        {
            System.out.println(0);
            return;
        }
        for(int i=n-2; i>=0; i--)
        {
            int temp = list[i];
            int minus = 0;
            if(temp>=pre)
            {
                sum+=(temp-pre)+1;
                minus = (temp-pre)+1;
            }
            pre = temp-minus;
        }
        System.out.print(sum);
    }
}
