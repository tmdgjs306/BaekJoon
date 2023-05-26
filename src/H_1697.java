import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] map = new int[100001];
        boolean [] visited = new boolean[100001];
        Queue <Integer> queue =  new LinkedList<>();
        map[n]= 0;
        queue.add(n);
        int count =0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now*2<= 100000 && !visited[now*2]){
                visited[now*2] = true;
                queue.add(now*2);
                //map[now*2] = Math.min(map[now*2],map[now]);
                map[now*2] = map[now];
            }
            if(now-1>=0 && !visited[now-1]) {
                visited[now-1] = true;
                queue.add(now-1);
                //map[now-1] = Math.min(map[now-1],map[now]+1);
                map[now-1] = map[now]+1;
            }
            if(now+1<=100000 && !visited[now+1]) {
                visited[now+1] = true;
                queue.add(now+1);
                //map[now+1] = Math.min(map[now+1],map[now]+1);
                map[now+1] =map[now]+1;
            }
        }
        System.out.print(map[k]);
    }
}

