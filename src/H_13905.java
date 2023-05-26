import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_13905 {
    public static class Bridge{
        int dest;
        int value;
        public Bridge(int dest, int value){
            this.dest = dest;
            this.value = value;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Bridge>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<Bridge>();
        }

        // 간선 비용 입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[from].add(new Bridge(to,value));
            list[to].add(new Bridge(from,value));
        }

        Queue <Integer> queue = new LinkedList<>();
        queue.add(s);
        int [] values = new int[n+1];
        values[s] = 10000001;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<list[now].size(); i++){
                Bridge next = list[now].get(i);
                int val = Math.min(values[now], next.value);

                if(values[next.dest]<val){
                    queue.add(next.dest);
                    values[next.dest] = val;
                }
            }
        }
        System.out.print(values[e]);
    }
}
