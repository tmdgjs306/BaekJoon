import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_2468 {
    public static class Node{
        int x;
        int y;
        int height;
        public Node(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    static Queue<Node> queue = new LinkedList<>();
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int [][] map;
    static boolean [][] visited;
    static int n;
    public static void dfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.x][node.y] = true;
            for(int i=0; i<4; i++){
                int newX = node.x+dx[i];
                int newY = node.y+dy[i];
                if(newX>=n ||newX<0 || newY>=n || newY<0) continue;
                else if(visited[newX][newY] || map[newX][newY]<= node.height) continue;
                else{
                    visited[newX][newY] = true;
                    queue.add(new Node(newX,newY,node.height));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int tp = 0;
            while (st.hasMoreTokens()) {
                map[i][tp++] = Integer.parseInt(st.nextToken());
            }
        }

        int maxResult = 1;

        // 결과 계산 i: 물의 높이 j = x 좌표 k = y 좌표 temp: 안전구역 갯수
        for(int i=1; i<=100; i++){
            int temp = 0;
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(visited[j][k] || map[j][k]<=i) continue;
                    else{
                        queue.add(new Node(j,k,i));
                        dfs();
                        temp++;
                    }
                }
            }
            maxResult = Math.max(maxResult,temp);
            visited = new boolean[n][n];
        }
        System.out.print(maxResult);
    }
}
