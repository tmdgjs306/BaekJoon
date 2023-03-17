import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_17391 {
    public static class Node {
        int x;
        int y;
        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int [][] map;
    static int [][] value;
    static boolean [][] visited;
    static Queue <Node> queue = new LinkedList();
    public static void bfs() {
        while (!queue.isEmpty()){
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int val = map[nowX][nowY];
            for(int i=1; i<=val; i++){
                if(nowY+i>=M) continue;
                if(visited[nowX][nowY+i]) continue;
                value[nowX][nowY+i] = value[nowX][nowY]+1;
                queue.add(new Node(nowX,nowY+i));
                visited[nowX][nowY+i] = true;
            }
            for(int i=1; i<=val; i++){
                if(nowX+i>=N) continue;
                if(visited[nowX+i][nowY]) continue;
                value[nowX+i][nowY] = value[nowX][nowY]+1;
                queue.add(new Node(nowX+i,nowY));
                visited[nowX+i][nowY] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        value = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<N; i++) {
            Arrays.fill(value[i],Integer.MAX_VALUE);
        }
        value[0][0] = 0;
        Node node = new Node(0,0);
        queue.add(node);
        bfs();
        System.out.print(value[N-1][M-1]);
    }
}
