import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class H_5021 {
    static HashMap <String, Parent> map = new HashMap<>();
    public static class Parent {
        String father;
        String mother;
        public Parent(String father, String mother){
            this.father = father;
            this.mother = mother;
        }
    }
    public static Double calcNode(String name){
      if(!map.containsKey(name)){
          return 0.0;
      }
      Parent parent = map.get(name);
      if(parent.father.equals("Na") && parent.mother.equals("Na")){
          return 1.0;
      }
      else return calcNode(parent.father)/2 + calcNode(parent.mother)/2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String king = br.readLine();
        map.put(king,new Parent("Na","Na"));
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String father = st.nextToken();
            String mother = st.nextToken();
            map.put(child,new Parent(father,mother));
        }
        String newKing = "";
        double maxValue = 0.0;
        for(int i=0; i<m; i++){
            String temp = br.readLine();
            if(map.containsKey(temp)){
                double val = calcNode(temp);
                if(val>maxValue){
                    newKing = temp;
                    maxValue=val;
                }
            }
        }
        System.out.print(newKing);
    }
}
