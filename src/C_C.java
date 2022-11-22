

import java.io.*;
import java.util.StringTokenizer;

public class C_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] values = new int[n];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                values[i] = Integer.parseInt(st.nextToken());
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n-1; i++){
                int now_sum = 0;
                for(int j = 0; j <= i; j++){
                    now_sum += values[j];
                }
                int to_sum = 0;
                int min_seg = i+1;
                int tmp=0;
                boolean is_find = false;
                boolean is_f = false;
                for(int j = i+1; j < n; j++){
                    to_sum += values[j];
                    tmp++;
                    if(to_sum > now_sum){
                        is_find =true;
                        break;
                    }
                    if(now_sum == to_sum){
                        to_sum = 0;
                        min_seg=Math.max(tmp,min_seg);
                        tmp=0;
                        is_f = true;
                    }
                }
                if(!is_find&&is_f) {
                    min = Math.min(min_seg, min);
                }
            }
            if(min==Integer.MAX_VALUE)
            {
                sb.append(n).append("\n");
            }
            else {
                sb.append(min).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}