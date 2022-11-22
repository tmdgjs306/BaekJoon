import java.util.Arrays;
import java.util.Scanner;

public class C_Increse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int t=0; t<T; t++)
        {
            int n = sc.nextInt();
            int [] array = new int[n];
            for(int i=0; i<n; i++)
            {
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            boolean is_f = false;
            for(int i=0; i<n-1; i++)
            {
                if(!(array[i]<array[i+1]))
                {
                    is_f=true;
                    break;
                }
            }
            if(is_f)
            {
                sb.append("NO").append("\n");
            }
            else
            {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}
