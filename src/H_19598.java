import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_19598 {
    public static class Node implements Comparable<Node>{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if(this.start==o.start){
                return this.end-o.end;
            }
            else{
                return this.start-o.start;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        PriorityQueue <Node> queue = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Node(start,end));
        }
        int [] rooms = new int[n];
        Arrays.fill(rooms,-1);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<n; i++){
                if(rooms[i]<=node.start){
                    rooms[i] = node.end;
                    break;
                }
            }
        }
        for (int i=0; i<n; i++){
            if(rooms[i] != -1){
                count++;
            }
        }
        System.out.print(count);
    }
}
