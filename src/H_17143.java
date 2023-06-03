import java.util.*;

public class H_17143{
    public static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;
        int id;
        public Shark(int r, int c, int s,int d, int z,int id){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.id = id;
        }
        public static void move(Shark shark, int s, int d){
            int speed = s;
            int direction =d;
            if(s==0){
                if(sharks[shark.r][shark.c]==null) {
                    sharks[shark.r][shark.c] = shark;
                    shark.d = d;
                }
                else{
                    if(shark.z > sharks[shark.r][shark.c].z){
                        sharks[shark.r][shark.c] = shark;
                        shark.d = d;
                    }
                    else{
                        return;
                    }
                }
                return;
            }
            if(direction ==1){
                int bound = 1;
                int temp = Math.abs(shark.r-bound);
                if(s>=temp){
                    shark.r = bound;
                    s-= temp;
                    d+=1;
                    move(shark,s,d);
                }
                else{
                    shark.r = shark.r - s;
                    if(sharks[shark.r][shark.c]==null) {
                        sharks[shark.r][shark.c] = shark;
                        shark.d = d;
                    }
                    else{
                        if(shark.z > sharks[shark.r][shark.c].z){
                            sharks[shark.r][shark.c] = shark;
                            shark.d = d;
                        }
                        else{
                            return;
                        }
                    }
                    return;
                }
            }
            else if(direction==2){
                int bound = x;
                int temp = Math.abs(shark.r - bound);
                if(s>=temp){
                    shark.r = bound;
                    s-= temp;
                    d-=1;
                    move(shark,s,d);
                }
                else{
                    shark.r = shark.r + s;
                    if(sharks[shark.r][shark.c]==null) {
                        sharks[shark.r][shark.c] = shark;
                        shark.d = d;
                    }
                    else{
                        if(shark.z > sharks[shark.r][shark.c].z){
                            sharks[shark.r][shark.c] = shark;
                            shark.d = d;
                        }
                        else{
                            return;
                        }
                    }
                    return;
                }
            }
            else if(direction ==3){
                int bound =y;
                int temp = Math.abs(shark.c - bound);
                if(s>=temp){
                    shark.c = bound;
                    s-=temp;
                    d+=1;
                    move(shark,s,d);
                }
                else{
                    shark.c = shark.c + s;
                    if(sharks[shark.r][shark.c]==null) {
                        sharks[shark.r][shark.c] = shark;
                        shark.d = d;
                    }
                    else{
                        if(shark.z > sharks[shark.r][shark.c].z){
                            sharks[shark.r][shark.c] = shark;
                            shark.d = d;
                        }
                        else{
                            return;
                        }
                    }
                    return;
                }
            }
            else{
                int bound =1;
                int temp = Math.abs(shark.c - bound);
                if(s>=temp){
                    shark.c = bound;
                    s-=temp;
                    d-=1;
                    move(shark,s,d);
                }
                else{
                    shark.c = shark.c - s;
                    if(sharks[shark.r][shark.c]==null) {
                        sharks[shark.r][shark.c] = shark;
                        shark.d = d;
                    }
                    else{
                        if(shark.z > sharks[shark.r][shark.c].z){
                            sharks[shark.r][shark.c] = shark;
                            shark.d = d;
                        }
                        else{
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }
    static int x;
    static int y;
    static Shark [][] sharks;
    public static void main(String[] args) {
        int id = 1;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        long count = sc.nextInt();
        sharks = new Shark[x+1][y+1];
        for(int i=0; i<count; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            Shark shark = new Shark(r,c,s,d,z,id++);
            sharks[r][c] = shark;
        }

        long sum = 0;
        for(int i=1; i<=y; i++){

            // 상어 잡기
            for(int j=1; j<=x; j++){
                if(sharks[j][i]==null)continue;
                else{
                    Shark shark =sharks[j][i];
                    sum+=shark.z;
                    sharks[j][i] = null;
                    break;
                }
            }
            //상어 이동 && 상어 잡아먹기 처리
            Queue <Shark> queue = new LinkedList<>();
            for(int j=1; j<=x; j++){
                for(int k=1; k<=y; k++){
                    if(sharks[j][k]!=null)
                        queue.add(sharks[j][k]);
                }
            }
            sharks = new Shark[x+1][y+1];
            while (!queue.isEmpty()){
                Shark now = queue.poll();
                now.move(now,now.s,now.d);
            }
        }
        System.out.print(sum);
    }
}
