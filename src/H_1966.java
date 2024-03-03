import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_1966 {
    public static class Node{
        int val;
        boolean isSelect;
        public Node(int val){
            this.val= val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            Queue<Node> queue = new LinkedList<Node>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int now = Integer.parseInt(st.nextToken());
                if(i==m){
                    Node temp = new Node(now);
                    temp.isSelect = true;
                    queue.add(temp);
                }
                else{
                    queue.add(new Node(now));
                }
                maxQueue.add(now);
            }
            int idx = 1;
            while (!queue.isEmpty()){
                int nowMax = maxQueue.peek();
                Node now = queue.poll();
                if(now.val==nowMax){
                    if(now.isSelect){
                        sb.append(idx).append("\n");
                        break;
                    }
                    else{
                        maxQueue.poll();
                        idx++;
                    }
                }
                else{
                    queue.add(now);
                }
            }
        }
        System.out.print(sb);
    }
}
