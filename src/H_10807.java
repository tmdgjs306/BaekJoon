import java.util.Scanner;

public class H_10807 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int [] list = new int[N];
        for(int i=0; i<N; i++)
        {
            list[i]=sc.nextInt();
        }
        int M = sc.nextInt();
        int count =0;
        for(int i=0; i<N; i++)
        {
            if(list[i]==M) count++;
        }
        System.out.print(count);
    }
}
