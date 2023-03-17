import java.util.Scanner;

public class H_1636 {
    public static class snack{
        int s;
        int e;
        public snack(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        snack [] value = new snack[n];
        if(n==1) {
            System.out.println(0);
            return;
        }
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            value[i] = new snack(s,e);
        }

        int now = 0;
        int result = 0;
        snack now1 = value[0];
        snack next1 = value[1];
        if(next1.s>=now1.e){
            now = now1.e;
            sb.append(now+"\n");
        }
        else {
            now = now1.s;
            sb.append(now+"\n");
        }
        for(int i=1; i<n-1; i++) {
            snack next = value[i];
            if (now >= next.s && now <= next.e) {
                sb.append(now + "\n");
                continue;
            }
            if (Math.abs(next.e - now) <= Math.abs(next.s - now)) {
                result += (Math.abs(next.e - now));
                now = next.e;
                sb.append(now + "\n");
            } else {
                result += (Math.abs(next.s - now));
                now = next.s;
                sb.append(now + "\n");
            }
        }
        snack nows = value[n-1];
        if(Math.abs(nows.s-now)>Math.abs(nows.e-now)){
            result+=Math.abs(nows.e-now);
            now=nows.e;
            sb.append(now+"\n");
        }
        else{
            result+=Math.abs(nows.s-now);
            now=nows.s;
            sb.append(now+"\n");
        }
        System.out.println(result);
        System.out.print(sb);
    }
}
