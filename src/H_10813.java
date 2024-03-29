import java.util.Scanner;

public class H_10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] list = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = i;
        }
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int temp = list[from];
            list[from] = list[to];
            list[to] = temp;
        }

        for(int i=1; i<=n; i++){
            System.out.print(list[i]+" ");
        }
    }
}
