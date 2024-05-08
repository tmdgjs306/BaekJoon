import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class H_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        for(int i=0; i<n; i++){
            String temp = br.readLine();
            if(set.contains(temp))continue;
            else{
                set.add(temp);
            }
        }

        if(game.equals("Y")){
            System.out.print(set.size());
        }
        else if(game.equals("F")){
            System.out.print(set.size()/2);
        }
        else {
            System.out.print(set.size()/3);
        }
    }
}
