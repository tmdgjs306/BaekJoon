import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_13565 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
    static int n;
    static int m;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static Queue <Node> queue = new LinkedList<>();
    static boolean [][] visited;
    static int [][] map;
    public static void DFS(){
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) continue;
                if(visited[nextX][nextY]) continue;
                if(map[nextX][nextY]==1) continue;
                else {
                    queue.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
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
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for(int i=0; i<m; i++){
            if(map[0][i]==0){
                queue.add(new Node(0,i));
                visited[0][i] = true;
                DFS();
            }
        }
        boolean isTrue = false;
        for(int i=0; i<m; i++){
            if(visited[n-1][i]){
                isTrue = true;
                break;
            }
        }
        if(isTrue){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
