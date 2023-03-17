import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class H_23843 {
    static int [] power;
    static int N;
    static int M;
    static int index = 0;
    public static boolean charge(int now){
        boolean isEmpty = true;
        for(int i=0; i<M; i++){
            if(power[i]==0){
                power[i] = now;
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
    public static void timer(){
        for(int i=0; i<M; i++){
            if(power[i]>0){
                power[i]--;
            }
        }
        index++;
    }
    public static boolean isZero(){
        for(int i=0; i<M; i++){
            if(power[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        PriorityQueue <Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<N; i++){
            queue.add(sc.nextInt());
        }
        power = new int[M];
        while (!queue.isEmpty()){
            int now = queue.poll();
            while (charge(now)){
                timer();
            }
        }
        while (!isZero()){
            timer();
        }
        System.out.print(index);
    }
}
