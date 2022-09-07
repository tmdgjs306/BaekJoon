import java.util.Arrays;
import java.util.Scanner;

public class H_3649 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StringBuilder br =new StringBuilder();
        while(sc.hasNextInt()) {
            int T = sc.nextInt();
            int unit = 9999999 + 1;
            int n = sc.nextInt();
            int[] value = new int[n];
            boolean is_find = false;
            for (int i = 0; i < n; i++) {
                value[i] = sc.nextInt();
            }
            Arrays.sort(value);
            int first = 0;
            int last = n - 1;
            int find = unit * T;
            while (first < last) {
                if (value[first] + value[last] == find) {
                    System.out.println("yes" + " " + value[first] + " " + value[last]);
                    is_find = true;
                    break;
                } else if (value[first] + value[last] < find) {
                    first++;
                } else last--;
            }
            if(!is_find)
                System.out.println("danger");
        }
    }
}
