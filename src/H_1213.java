import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String question = br.readLine();
        int [] count = new int[26];
        for(int i=0; i< question.length(); i++){
            int word = question.charAt(i)-65;
            count[word]++;
        }
        boolean isTotalOdd = true;
        if(question.length()%2==0){
            isTotalOdd = false;
        }

        int odd = 0;
        for(int i=0; i<26; i++){
            if(count[i]%2 !=0){
                odd+=1;
            }
        }
        if(odd>=2){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        if(!isTotalOdd && odd!=0){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        char [] temp = new char[question.length()];
        int index = 0;
        int idx = 0;
        int oddIdx = 0;
        while (true){
            if(count[index]>=2){
                temp[idx] = (char)(index+65);
                temp[question.length()-idx-1] =(char)(index+65);
                count[index]-=2;
                idx++;
            }
            else{
                index+=1;
            }
            if(idx==question.length()/2)break;
        }
        for(int i=0; i<26; i++){
            if(count[i]==1){
                oddIdx=i;
                break;
            }
        }
        if(isTotalOdd){
            temp[question.length()/2] =(char)(oddIdx+65);
        }
        for(int i=0; i<temp.length; i++){
            System.out.print(temp[i]);
        }
    }
}
