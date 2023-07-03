import java.util.Arrays;
import java.util.Scanner;

public class H_2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =5;
        int value [] = new int[n];
        int sum=0;
        for(int i=0; i<n; i++){
            value[i] = sc.nextInt();
            sum+=value[i];
        }
        System.out.println(sum/5);
        Arrays.sort(value);
        System.out.println(value[2]);
    }
}
