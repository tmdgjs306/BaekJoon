import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class H_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        int sum = 0;
        for(int i=0; i<n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        if(n==2){
            System.out.println(queue.poll()+ queue.poll());
            return;
        }
        while (!queue.isEmpty()){
            int temp = queue.poll();
            int temp2 = queue.poll();
            sum+=temp+temp2;
            if(!queue.isEmpty()) {
                queue.add(temp + temp2);
            }
        }
        System.out.print(sum);
    }
}
