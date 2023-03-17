import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class H_1774 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static class Path implements Comparable<Path>{
        int from;
        int to;
        double dist;
        public Path(int from, int to, double dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
        @Override
        public int compareTo(Path o) {
            if(this.dist>o.dist) {
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    static int [] parent;
    public static int find(int a){
        if(parent[a] ==a) return a;
        else return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b){
        int Pa = find(a);
        int Pb = find(b);
        if(Pa!=Pb) parent[Pb] = Pa;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        ArrayList <Node> nodes = new ArrayList<>();
        nodes.add(new Node(0,0));
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node node = new Node(x,y);
            nodes.add(node);
        }
        PriorityQueue <Path> list = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            Node now = nodes.get(i);
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                else{
                    Node next = nodes.get(j);
                    double val =Math.sqrt((Math.pow(now.x-next.x,2)+Math.pow(now.y-next.y,2)));
                    list.add(new Path(i,j,val));
                }
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from,to);
        }
        double result = 0;
        while (!list.isEmpty()){
            Path next = list.poll();
            int from = next.from;
            int to = next.to;
            if(find(from) == find(to)) continue;
            else {
                result+=next.dist;
                union(from,to);
            }
        }
        System.out.printf("%.2f\n", result);
    }
}
