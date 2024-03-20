import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class H_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        int dasom = 0;
        for(int i=1; i<=n; i++){
            int vote = Integer.parseInt(br.readLine());
            if(i!=1){
                queue.add(vote);
            }
            else{
                dasom = vote;
            }
        }
        int result = 0 ;
        while (!queue.isEmpty()){
            int next = queue.poll();
            if(next<dasom){
                break;
            }
            else{
                next-=1;
                result+=1;
                dasom+=1;
                queue.add(next);
            }
        }
        System.out.print(result);
    }
}
