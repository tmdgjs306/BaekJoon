import java.util.ArrayList;
import java.util.Scanner;

public class H_18429 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList <Integer> [] list = new ArrayList[N];
        for(int i=0; i<N; i++)
        {
            list[i]=new ArrayList<>();
        }
        int [] value = new int[N];
        for(int i=0; i<N; i++)
        {
            value[i]= sc.nextInt();
            if(value[i]>=K)
            {
                list[0].add(value[i]-K);
            }
        }
        int now = K+K;
        for(int i=1; i<N; i++)
        {

        }
    }
}
