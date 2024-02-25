import java.util.Scanner;

public class H_12845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        long result =0;
        for(int i =0; i<n; i++){
            int level = sc.nextInt();
            result+=level;
            max = Math.max(level,max);
        }
        result +=(max*(n-2));
        System.out.print(result);
    }
}
