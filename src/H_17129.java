import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_17129 {
    public static class Node{
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int newX = node.x+dx[i];
                int newY = node.y+dy[i];
                if(newX>=n || newX<0 || newY>=m || newY<0) continue;
                if(visited[newX][newY]) continue;
                if(map[newX][newY]==1) continue;
                if(map[newX][newY]>=3){
                    minDist = Math.min(node.dist+1,minDist);
                }
                else{
                    visited[newX][newY] = true;
                    queue.add(new Node(newX,newY,node.dist+1));
                }
            }
        }
    }
    static int n;
    static int m;
    static int [][]map;
    static Queue<Node> queue = new LinkedList<>();
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static boolean [][] visited;
    static int minDist = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==2){
                    visited = new boolean[n][m];
                    visited[i][j] = true;
                    queue.add(new Node(i,j,0));
                    bfs();
                }
            }
        }
        if(minDist!=Integer.MAX_VALUE) {
            System.out.println("TAK");
            System.out.print(minDist);
        }
        else{
            System.out.print("NIE");
        }
    }
}
