import java.util.PriorityQueue;
import java.util.Scanner;

public class H_1245 {
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        public Node(int x,int y, int value){
            this.x =x;
            this.y =y;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return o.value-this.value;
        }
    }
    static int count =0;
    static boolean[][] visited;
    static int [][]map;
    static int [] dx = {-1,0,1,1,1,0,-1,-1};
    static int [] dy = {-1,-1,-1,0,1,1,1,0};
    static int n;
    static int m;
    public static void dfs(Node node){
        Node now = node;
        for(int i=0; i<8; i++){
            int newx = now.x+dx[i];
            int newy = now.y+dy[i];
            if(newx<0 || newx >=n || newy<0 ||newy >=m) continue;
            if(visited[newx][newy]) continue;
            if(map[newx][newy]!=0 && (map[newx][newy]<=node.value)){
                visited[newx][newy] = true;
                dfs(new Node(newx,newy,map[newx][newy]));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        PriorityQueue <Node> list = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]!=0)
                    list.add(new Node(i,j,map[i][j]));
            }
        }
        while (!list.isEmpty()){
            Node temp = list.poll();
            if(visited[temp.x][temp.y]) continue;
            else{
                dfs(temp);
                visited[temp.x][temp.y] = true;
                count++;
            }
        }
        System.out.print(count);
    }
}
