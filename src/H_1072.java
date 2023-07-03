
import java.util.Scanner;

public class H_1072 {
    static int Find(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = Find(x, y);
        int ans = -1;
        int left = 0;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Find(x + mid, y + mid) != z) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }
}