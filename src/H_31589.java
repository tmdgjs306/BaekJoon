import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class H_31589 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            maxQueue.add(temp);
            minQueue.add(temp);
        }
        boolean max = true;
        boolean min = false;
        int last = 0;
        long sum = 0;
        for(int i=0; i<k; i++){
            int temp;
            if(max){
                temp = maxQueue.poll();
                sum += Math.abs(last-temp);
                max = false;
                min = true;
                last = temp;
            }
            else if(min){
                temp = minQueue.poll();
                max = true;
                min = false;
                last = temp;
            }
        }
        System.out.print(sum);
    }
}
