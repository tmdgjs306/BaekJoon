import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int sum = 0;
        int score = 0;
        for(int i=0; i<t; i++){
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                if (s.charAt(j) == 'X') {
                    score = 0;
                } else {
                    sum += (++score);
                }
            }
            score = 0;
            System.out.println(sum);
            sum = 0;
        }
    }
}
