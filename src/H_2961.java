import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_2961 {
    public static class Node{
        int a;
        int b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            queue.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Queue<Node> list = new LinkedList<>();
        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(list.isEmpty()){
                list.add(now);
                continue;
            }
            Queue<Node> temp = new LinkedList<>();
            while (!list.isEmpty()){
                Node node = list.poll();
                temp.add(node); // skip
                temp.add(new Node(node.a*now.a,node.b+now.b)); // keep
            }
            while (!temp.isEmpty()){
                list.add(temp.poll());
            }
            list.add(now); // 자기 자신
        }
        int result = Integer.MAX_VALUE;
        while (!list.isEmpty()){
            Node now = list.poll();
            result =Math.min(result,Math.abs(now.a-now.b));
        }
        System.out.print(result);
    }
}
