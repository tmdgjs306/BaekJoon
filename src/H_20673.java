import java.util.Scanner;
public class H_20673 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        String colorCode = getColorCode(p, q);
        System.out.print(colorCode);
    }
    public static String getColorCode(int newCases, int newHospitalizations) {

        if (newHospitalizations > 30) {
            return "Red"; // High-risk city
        } else if (newCases > 50 || newHospitalizations > 10) {
            return "Yellow"; // Medium-risk city
        } else {
            return "White"; // Low-risk city
        }
    }
}
