import java.math.BigInteger;
import java.util.Scanner;

public class H_13277 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        BigInteger result = a.multiply(b);
        System.out.println(result);
    }
}
