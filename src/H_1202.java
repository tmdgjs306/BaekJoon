import java.util.*;

public class H_1202 {
    static class gem implements Comparable<gem> {
        int value;
        int weight;

        public gem(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(gem o) {
            return  this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<gem> gems = new ArrayList<>();
        ArrayList<Integer> bag = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            gem g = new gem(weight, value);
            gems.add(g);
        }
        for (int i = 0; i < K; i++) {
            int temp = sc.nextInt();
            bag.add(temp);
        }
        Collections.sort(gems);
        Collections.sort(bag);
        long sum = 0;
        gem gem1;
        int temp;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && gems.get(j).weight <= bag.get(i)) {
                queue.offer(gems.get(j++).value);
            }

            if (!queue.isEmpty()) {
                sum += queue.poll();
            }
        }
        System.out.println(sum);
    }
}