import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_16288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> [] lines = new LinkedList[k];
        for(int i=0; i<k; i++){
            lines[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int now = Integer.parseInt(st.nextToken());
            boolean isCheck = false;
            for(int j=0; j<k; j++){
                if(lines[j].isEmpty()){
                    lines[j].add(now);
                    isCheck = true;
                    break;
                }
                if(lines[j].peek()<now){
                    lines[j].poll();
                    lines[j].add(now);
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck){
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }
}
