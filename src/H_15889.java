import java.util.Scanner;

public class H_15889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] list = new int[N];
        int [] power = new int[N-1];
        for(int i=0; i<N; i++){
            list[i] = sc.nextInt();
        }

        for(int i=0; i<N-1; i++){
            power[i] = sc.nextInt();
        }

        String fail = "엄마 나 전역 늦어질 것 같아";
        String success = "권병장님, 중대장님이 찾으십니다";
        if(N==1){
            System.out.println(success);
            return;
        }
        boolean isTrue = false;
        int now = 0;
        while (true){
            int pw = list[now] + power[now];
            int next = 0;
            int nextValue = 0;
            if(pw>=list[N-1]){
                isTrue=true;
                break;
            }
            for(int i = now+1; i<N-1; i++){
                if(i>=N-1) continue;
                if(list[i]<=pw){
                    int nt = list[i] + power[i];
                    if(nextValue<nt){
                        nextValue = nt;
                        next = i;
                    }
                }
            }
            if(next == 0){
                isTrue=false;
                break;
            }
            now = next;

        }
        if(isTrue)
            System.out.println(success);
        else
            System.out.println(fail);
    }
}
