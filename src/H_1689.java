import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_1689 {
    public static class Line implements Comparable<Line>{
        int start;
        int end;
        int value;
        int idx;
        public Line(int start, int end,int value,int idx){
            this.start = start;
            this.end = end;
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Line o) {
            return this.start-o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue <Line> queue = new PriorityQueue<>();
        PriorityQueue <Line >queue1 = new PriorityQueue<>();
        int id=0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Line l1 = new Line(start,end,0,++id);
            queue.add(l1);
            queue1.add(l1);
        }
        int max = 0;
        while (!queue.isEmpty()){
            Line now  = queue.poll();
            int findLine = 0;
            Queue<Line> temp = new LinkedList<>();
            while(!queue1.isEmpty()){
                Line nt = queue1.poll();
                temp.add(nt);
                if(now.idx==nt.idx) continue;
                if(nt.start>now.end)break;
                else{
                    findLine+=1;
                }
            }
        }
        System.out.println(max);
    }
}
