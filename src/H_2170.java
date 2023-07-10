import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class H_2170 {
    public static class Line implements Comparable<Line>{
        int from;
        int to;
        public Line(int from, int to){
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Line o) {
            return this.from-o.from;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Line> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            queue.add(new Line(from,to));
        }
        Line temp = queue.poll();
        int start =temp.from;
        int end = temp.to;
        int length = end-start;
        while (!queue.isEmpty()){
            Line tp = queue.poll();
            if(tp.from >end){
                start = tp.from;
                end = tp.to;
                length+=end-start;
            }
            else if(tp.to>end){
                length+=tp.to-end;
                end = tp.to;
            }
        }
        System.out.print(length);
    }
}
