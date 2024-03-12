import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_17265 {

    public static class Node{
        int x;
        int y;
        int op;
        int val;

        public Node(int x,int y, int op, int val){
            this.x = x;
            this.y = y;
            this.op = op;
            this.val = val;
        }
    }
    static int n;
    static int [][] map;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int [] dx = {0,1};
    static int [] dy = {1,0};
    public static int calc(int a, int b, int op){
        if(op == 43){
            return a+b;
        }
        else if(op == 45){
            return a-b;
        }
        else{
            return a*b;
        }

    }

    static Queue<Node> queue = new LinkedList<>();
    public static void bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x==n-1 && node.y==n-1){
                max = Math.max(node.val,max);
                min = Math.min(node.val,min);
            }
            for(int i=0; i<2; i++){
                int newX = node.x+dx[i];
                int newY = node.y+dy[i];
                if(newX>=n || newX<0 || newY>=n || newY<0) continue;
                if(map[newX][newY]>=6){
                    queue.add(new Node(newX,newY,map[newX][newY],node.val));
                }
                else{
                    queue.add(new Node(newX,newY,0,calc(node.val,map[newX][newY],node.op)));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 43 = +, 45 = -, 42 = *
        map = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();
                if (s.equals("+") || s.equals("-") || s.equals("*")) {
                    map[i][j] = s.charAt(0);
                } else
                    map[i][j] = Integer.parseInt(s);
            }
        }
        queue.add(new Node(0,0,0,map[0][0]));
        bfs();
        System.out.print(max+" "+min);
    }
}
