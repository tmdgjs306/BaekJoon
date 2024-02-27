import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_2865 {
    public static class people implements Comparable<people>{
        int number;
        double point;
        public people(int number, double point){
            this.number = number;
            this.point = point;
        }

        @Override
        public int compareTo(people o) {
            if(this.point>o.point)return -1;
            else if(this.point<o.point) return 1;
            else return 0;
        }
    }
    static int n;
    static int m;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<people> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int number = Integer.parseInt(st.nextToken());
                double point = Double.parseDouble(st.nextToken());
                queue.add(new people(number,point));
            }
        }
        boolean [] isChecked = new boolean[n+1];
        int count = 0;
        double result = 0.0;
        while (!queue.isEmpty()){
            people p = queue.poll();
            if(count>=k) break;
            if(!isChecked[p.number]){
                count++;
                result+=p.point;
                isChecked[p.number] = true;
            }
        }
        System.out.print(Math.round(result*10)/10.0);
    }
}
