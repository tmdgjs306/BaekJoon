import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class H_14677 {
    public static class Node{
        int l; // 왼쪽 약 위치
        int r; // 오른쪽 약 위치
        int now; // 현재 먹을 약[B, L, D]
        int result; // 지금 까지 먹은 약
        public Node(int l, int r, int now, int result){
            this.l = l;
            this.r = r;
            this.now = now;
            this.result = result;
        }
    }
    public static int bfs(int l, int r)
    {
        int value = 0;
        visited[l][r] = true;
        if (map[l] == 0) {
            queue.add(new Node(l+1, r, B, 1));
            visited[l+1][r] = true;
        }
        if (map[r] == 0) {
            queue.add(new Node(l, r-1, B, 1));
            visited[l][r - 1] = true;
        }
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Node node = queue.poll();
                if (node.l > node.r)continue;
                if (map[node.l] == (node.now + 1) % 3 && !visited[node.l+1][node.r]) {
                    queue.add(new Node(node.l+1, node.r, (node.now+1) % 3, node.result+1));
                    visited[node.l + 1][node.r] = true;
                }
                if (map[node.r] == (node.now + 1) % 3 && !visited[node.l][node.r-1]) {
                    queue.add(new Node(node.l, node.r-1, (node.now + 1) % 3, node.result + 1));
                    visited[node.l][node.r-1] = true;
                }
            }
            value++;
        }
        return value;
    }
    static int n;
    static Queue<Node> queue = new LinkedList<>();
    static int maxValue;
    static int map[];
    static boolean [][] visited;
    static final int B = 0;
    static final int L = 1;
    static final int D = 2;

    //코드 작성 편리를 위해 [B = 0 L = 1 D = 2] 으로 변경하여 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String medicine = br.readLine();
        n *=3;
        map = new int[n];
        visited = new boolean[n+1][n+1];
        for(int i=0; i<n; i++){
            char temp = medicine.charAt(i);
            if(temp =='B') map[i] = B;
            else if(temp =='L') map[i] =L;
            else map[i] = D;
        }
        maxValue = bfs(0,n-1);
        System.out.print(maxValue);
    }
}

