import java.util.Arrays;
import java.util.Scanner;

public class H_24435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            String b = sc.next();
            String a = sc.next();
            int [] bob = new int[n];
            int [] alice = new int[n];
            for(int i=0; i<n; i++){
                bob[i] =b.charAt(i)-'0';
                alice[i] =a.charAt(i)-'0';
            }
            int bobMin =0;
            for(int i=0; i<n; i++){
                bobMin +=bob[i] * Math.pow(10,n-i-1);
            }
            int temp =0;
            for(int i=0; i<n; i++){
                temp +=bob[i] * Math.pow(10,i);
            }
            bobMin = Math.min(bobMin,temp);
            boolean isTrue = true;
            Arrays.sort(alice);
            int index = 0;
            String bobS =Integer.toString(bobMin);
            int resultTrue = 0;
            while (true){
                if(index==n) {
                    isTrue = false;
                    break;
                }
                int bobNum = bobS.charAt(index)-'0';
                if(bobNum<alice[index]){
                    isTrue=false;
                    break;
                }
                if(bobNum>alice[index]){
                    isTrue=true;
                    break;
                }
                index++;
            }
            if(isTrue){
                int tindex = n-1;
                int result = 0;
                boolean [] isSelect = new boolean[n];
                int id=0;
                while (true) {
                    if(id==n) break;
                    int first = bobS.charAt(id)-'0';
                    for (int i = n - 1; i >= 0; i--) {
                        if (isSelect[i]) continue;
                        if (first < alice[i]) continue;
                        else {
                            isSelect[i] = true;
                            result += alice[i] * Math.pow(10, tindex);
                            break;
                        }
                    }
                    tindex--;
                    id++;
                }
                sb.append(result).append("\n");
                continue;
            }
            else{
                int result=0;
                int tp = n-2;
                for(int i=n-1; i>=1; i--){
                    result+=(int)(alice[i]*Math.pow(10,tp--));
                }
                sb.append(result).append("\n");
            }
        }
        System.out.print(sb);
    }
}
