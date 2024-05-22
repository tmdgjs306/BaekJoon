import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class H_11723_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens())
                num = Integer.parseInt(st.nextToken());

            switch (cmd){
                case "add":{
                    hashSet.add(num);
                    break;
                }
                case "remove":{
                    hashSet.remove(num);
                    break;
                }
                case "check":{
                    if(hashSet.contains(num)) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "toggle":{
                    if(hashSet.contains(num)){
                        hashSet.remove(num);
                    }
                    else{
                        hashSet.add(num);
                    }
                    break;
                }
                case "all":{
                    for(int j=1; j<=20; j++){
                        hashSet.add(j);
                    }
                    break;
                }
                case "empty":{
                    hashSet.clear();
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }
}
