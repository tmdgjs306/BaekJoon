import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_14716 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int [] dx = {1,-1,0,0,1,-1,-1,1};
    static int [] dy = {0,0,1,-1,1,-1,1,-1};
    static int n;
    static int m;
    static int [][] map;
    static boolean [][] visited;
    static Queue<Node> queue = new LinkedList<>();

    public static void bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<8; i++){
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];
                if(newX>=n || newX<0 || newY>=m || newY<0) continue;
                if(visited[newX][newY] || map[newX][newY]==0) continue;
                visited[newX][newY] = true;
                queue.add(new Node(newX,newY));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    queue.add(new Node(i,j));
                    bfs();
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
