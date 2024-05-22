import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_1487 {
    public static class People{
        int price;
        int deliveryCost;
        public People(int price, int deliveryCost){
            this.price = price;
            this.deliveryCost = deliveryCost;
        }
    }
    static People[] arr;
    public static int getSum(int mid){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            People p = arr[i];
            if(mid>p.price)continue;
            if(p.deliveryCost>mid)continue;
            sum += Math.min(p.price,mid)-p.deliveryCost;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new People[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int deliveryCost = Integer.parseInt(st.nextToken());
            People p = new People(price,deliveryCost);
            arr[i] = p;
        }
        int max = -1;
        int index = 0;
        for(int i=1; i<=1000000; i++){
            int sum = getSum(i);
            if(sum>max){
                index = i;
                max = sum;
            }
        }
        if(max!=0)
            System.out.print(index);
        else
            System.out.println(0);
    }
}
