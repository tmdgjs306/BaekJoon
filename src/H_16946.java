import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_16946 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int [][]map;
    static int [][]sol;
    static int [] dx ={1,-1,0,0};
    static int [] dy ={0,0,1,-1};
    static int count =1;
    static Queue <Node> queue = new LinkedList<>();
    static boolean[][] visited;
    static void bfs(){
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0; i<4; i++){
                int newX = now.x+dx[i];
                int newY = now.y+dy[i];
                if(newX <0 || newX >=n || newY<0 || newY>=m) continue;
                if(visited[newX][newY]) continue;
                if(map[newX][newY]==1) continue;
                queue.add(new Node(newX,newY));
                count++;
                visited[newX][newY] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        sol = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1){
                    count =1;
                    for(int k=0; k<n; k++) {
                        for(int k1=0; k1<m; k1++){
                            visited[k][k1] = false;
                        }
                    }
                    visited[i][j] = true;
                    queue.add(new Node(i,j));
                    bfs();
                    sol[i][j] = count;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
    }
}
