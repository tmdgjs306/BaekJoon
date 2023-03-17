import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] list = new int[m];
        for(int i=0; i<m; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int price = 0;
        int total = 0;
        for(int i=0; i<m; i++)
        {
            int temp = m -i;
            if(temp>n)  temp = n;
            if(total<list[i]*temp)
            {
                total = list[i]*temp;
                price = list[i];
            }
        }
        sb.append(price+" "+total);
        System.out.print(sb);
    }
}
