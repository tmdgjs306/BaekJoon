import java.util.Scanner;

public class H_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
        {
            int temp = sc.nextInt();
            if(temp<X)
            {
                sb.append(temp+" ");
            }
        }
        System.out.println(sb);
    }
}
