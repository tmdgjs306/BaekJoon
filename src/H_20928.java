import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_20928 {
    public static void main(String[] args) throws IOException {

        //입력 부분
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] point = new int[n];
        int [] speed = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            point[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            speed[i] = Integer.parseInt(st.nextToken());
        }

        //연산 부분
        int count =0;
        int nowMin = point[0];
        int nowMax = speed[0]+point[0];
        if(nowMax>=m){
            System.out.println(count);
            return;
        }
        int tempMin = -1;
        int tempMax= -1;

        for(int i=1; i<n; i++){
            int newMin = point[i]; //신규 지점
            int newMax = speed[i]+newMin; // 신규 지점에서 갈 수 있는 최대 거리
            if(newMax<=nowMax) continue;
            if(nowMax<newMin){ // 신규 지점에 더 이상 갈 수 없는 경우
                if(tempMax==-1 && tempMin==-1)break;
                //임시로 저장된 값이 있다면 해당 값을 채택하고 다시 시작한다.
                nowMin = tempMin;
                nowMax = tempMax;
                tempMin =-1;
                tempMax =-1;
                count++;
                --i;
                continue;
            }
            if(newMax>=m){ // 신규 지점에서 목적지로 바로 갈 수 있을 경우
                System.out.println(++count);
                return;
            }
            if(tempMax==-1 && tempMin==-1 && newMax>nowMax && nowMax>=tempMin){ // 신규 지점을 임시로 저장한다.
                tempMax = newMax;
                tempMin = newMin;
            }
            else if(tempMax<newMax && nowMax>=newMin){ //신규 지점이 임시로 저장된 값 보다 크면 임시 저장 값을 갱신한다.
                tempMax = newMax;
                tempMin = newMin;
            }
        }
        System.out.println(-1);
    }
}
