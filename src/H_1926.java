import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_1926 {
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
    static int [][] map;
    static int [] dx ={1,-1,0,0};
    static int [] dy ={0,0,1,-1};
    static Queue<Node> queue = new LinkedList<>();
    static boolean [][] visited;
    public static int DFS(int count){
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(nextX<=0 || nextX>n || nextY<=0 || nextY>m) continue;
                if(map[nextX][nextY]!=1)continue;
                if(visited[nextX][nextY]) continue;
                else{
                    queue.add(new Node(nextX,nextY));
                    visited[nextX][nextY] = true;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        int count =0;
        int max = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==1&& !visited[i][j]){
                    visited[i][j]=true;
                    queue.add(new Node(i,j));
                    max = Math.max(max,DFS(1));
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
