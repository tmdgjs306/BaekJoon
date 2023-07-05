import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_1956 {
    static int [] parent;
    public static int find(int a){
        if(parent[a]==a){
            return a;
        }
        else return parent[a]=find(parent[a]);
    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        parent[pa] = pb;
    }
    public static class Node implements Comparable<Node>{
        int from;
        int to;
        int value;
        public Node(int from, int to, int value){
            this.from = from;
            this.to =to;
            this.value=value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }
    static PriorityQueue<Node> queue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v+1];
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            queue.add(new Node(from,to,val));
        }
        int result = 0;
        Queue <Node>temp = new LinkedList<Node>();
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++)
                parent[i] = i;

        }
    }
}
