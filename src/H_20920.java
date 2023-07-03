import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_20920 {
    public static class Word implements Comparable<Word>{
        int count;
        int length;
        String value;
        public Word(int count, int length, String value){
            this.count = count;
            this.length = length;
            this.value = value;
        }

        @Override
        public int compareTo(Word o) {
            if(this.count>o.count)
                return -1;
            else if(this.count<o.count)
                return 1;
            else{
                if(this.length>o.length)
                    return -1;
                else if(this.length<o.length)
                    return 1;
                else{
                    for(int i=0; i<this.length; i++){
                        if(this.value.charAt(i)>o.value.charAt(i))
                            return 1;
                        else if(this.value.charAt(i)<o.value.charAt(i))
                            return -1;
                    }
                }
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        HashMap<String,Word> list = new HashMap<>();
        PriorityQueue<Word> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String word = br.readLine();
            if(word.length()<c) continue;
            if(list.containsKey(word)){
                Word temp = list.get(word);
                temp.count++;
            }
            else{
                Word temp = new Word(1,word.length(),word);
                list.put(word,temp);
            }
        }
        for(Word w : list.values()){
            queue.add(w);
        }
        while (!queue.isEmpty()){
            sb.append(queue.poll().value).append("\n");
        }
        System.out.println(sb);
    }
}
