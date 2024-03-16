import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_11000 {
    public static class Node implements Comparable<Node>{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start-o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        PriorityQueue <Node> queue = new PriorityQueue<>();
        PriorityQueue <Integer> rooms = new PriorityQueue<>();

        // 값 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Node(start,end));
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            // 회의룸이 없는 경우
            if(rooms.isEmpty()){
                count++;
                // 회의가 끝날 떄 까지 방 점유
                rooms.add(node.end);
            }
            // 회의가 끝난 회의룸이 존재할 경우
            else if(rooms.peek()<=node.start){
                rooms.poll();
                // 새로운 회의 할당
                rooms.add(node.end);
            }
            // 모든 회의 룸이 회의 중인 경우
            else{
                rooms.add(node.end);
                count++;
            }
        }
        System.out.print(count);
    }
}