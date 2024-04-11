import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class H_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        while (true){
            if(n==0) break;
            queue.add(n%10);
            n/=10;
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll());
        }

    }
}
