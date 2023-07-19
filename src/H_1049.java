import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int minOne = Integer.MAX_VALUE;
        int minSix = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            minSix = Math.min(minSix,six);
            minOne = Math.min(minOne,one);
        }
        int temp = n;
        int result =0;
        if(minOne*6<minSix){
            System.out.println(minOne*n);
            return;
        }
        while (true){
            if(temp>=6){
                temp -=6;
                result+=minSix;
            }
            else{
                if(minOne*temp> minSix){
                    result+=minSix;
                    break;
                } else {
                    result += minOne * temp;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
