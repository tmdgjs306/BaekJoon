import java.util.Scanner;

public class H_4299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int diff = sc.nextInt();

        int teamA = (sum + diff) / 2;
        int teamB = (sum - diff) / 2;

        if ((sum + diff) % 2 == 0 && (sum - diff) % 2 == 0 && teamA >= 0 && teamB >= 0) {
            System.out.println(Math.max(teamA, teamB) + " " + Math.min(teamA, teamB));
        } else {
            System.out.println("-1");
        }
    }
}
