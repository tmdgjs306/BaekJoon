import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class H_1181 {
    static class Node implements Comparable<Node> {
        String s;

        public Node(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Node o) {
            if (s.length() == o.s.length()) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) > o.s.charAt(i)) {
                        return 1;
                    } else if (s.charAt(i) < o.s.charAt(i)) {
                        return -1;
                    }
                    if(s.charAt(i)==o.s.charAt(i))continue;
                }
            }
            return s.length()-o.s.length();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            String s = sc.next();
            if(set.contains(s)){
                continue;
            }
            else{
                set.add(s);
            }
            queue.add(new Node(s));
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll().s);
        }
    }
}
