import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class H_1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <String,Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList <String> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String next = sc.next();
            if(!map.containsKey(next)){
                map.put(next,1);
            }
        }
        for(int i=0; i<m; i++){
            String next = sc.next();
            if(map.containsKey(next)){
                result++;
                list.add(next);
            }
        }
        Collections.sort(list);
        System.out.println(result);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
