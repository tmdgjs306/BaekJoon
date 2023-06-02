import java.util.*;

public class H_17081 {
    /*
        아이템 상자 정보
        A : 방어구
        W : 무기
        O : 장신구

        맵 정보
        . : 빈칸
        # : 벽
        & : 보스 x 몬스터
        ^ : 가시함정
        B : 아이템 상자

        몬스터 정보
        x 좌표 y 좌표, 이름, 공격력, 방어력, 체력, 경험치

        장신구 정보
        HR : 전투 승리시 잃은 체력 3 회복
        RE : 주인공 사망 시 소멸, 주인공 첫 위치로 복귀 전투 중인 몬스터 역시 회복
        CO : 모든 전투에서 주인공의 첫 공격이 두배로 적용
        EX : 얻는 경험치가 1.2배가 된다.
        DX : 가시함정 데미지 1로 고정, CO 효과 1.5배
        HU : 보스 전투시 체력 회복, 보스의 첫 공격 0 데미지
        CU : 능력 x

    */

    // 장신구 플래그
    static boolean returnFlag = false;
    static boolean HR = false;
    static boolean RE = false;
    static boolean CO = false;
    static boolean EX = false;
    static boolean DX = false;
    static boolean HU = false;
    static boolean CU = false;
    static int accCount = 0;
    static int startX;
    static int startY;
    static boolean playerLive = true;
    static boolean clearGame = false;
    public static class Item{
        int x;
        int y;
        char type;
        String acc;
        int value;
        public Item(int x, int y, char type, String acc){
            this.x = x;
            this.y = y;
            this.type = type;
            this.acc= acc;
        }
        public Item(int x, int y, char type, int value){
            this.x = x;
            this.y = y;
            this.type = type;
            this.value= value;
        }
    }
    public static class Monster{
        int x;
        int y;
        String name;
        int w;
        int a;
        int h;
        int ex;
        public Monster(int x, int y, String name, int w, int a, int h, int ex){
            this.x = x;
            this.y = y;
            this.name = name;
            this.w = w;
            this.a = a;
            this.h = h;
            this.ex = ex;
        }
    }
    public static class Player{
        int x;
        int y;
        int w;
        int a;
        int curHp;
        int maxHp;
        int ex;
        int lv;
        public Player(){

        }
        public Player(int x, int y, int w, int a, int maxHp, int ex){
            this.x = x;
            this.y = y;
            this.w = 0;
            this.a = 0;
            this.maxHp = maxHp;
            this.curHp = maxHp;
            this.ex = ex;
            this.lv = 1;
        }
    }
    // 게임 이벤트 구현
    static String murder= "";
    public static void damageByTrapEvent(Player hero){
        int TrapDmg = 5;
        if(DX)
            hero.curHp -= 1;
        else
            hero.curHp-=TrapDmg;
        if(hero.curHp <=0) {
            deathEvent(hero);
            if(!returnFlag)
            {
                murder = "SPIKE TRAP";
            }
        }
    }
    public static void deathEvent(Player hero){
        if(RE){
            hero.x =startX;
            hero.y =startY;
            hero.curHp = hero.maxHp;
            RE = false;
            accCount--;
            returnFlag = true;
            return;
        }
        if(!RE){
            playerLive = false;
            clearGame = false;
            return;
        }
    }
    public static boolean battleToBossEvent(Player hero, Monster boss){
        if(HU)
            hero.curHp = hero.maxHp;
        int bossHp = boss.h;
        boolean first = true;
        int playerDmg = Math.max(1, (hero.w+hero.lv*2)-boss.a);
        int bossDmg = Math.max(1,boss.w-(hero.a+hero.lv*2));
        while(true){
            if(first){
                if(CO){
                    int firstAttDmg;
                    if(DX)
                        firstAttDmg = Math.max(((hero.w+hero.lv*2)*3)-boss.a,1);
                    else
                        firstAttDmg = Math.max(((hero.w+hero.lv*2)*2)-boss.a,1);
                    bossHp-=firstAttDmg;
                    if (bossHp<=0)
                        return true;
                    if(HU)
                        hero.curHp-=0;
                    else
                        hero.curHp-=bossDmg;
                    if(hero.curHp<=0)
                        return false;
                    first = false;
                }
                else {
                    bossHp -= playerDmg;
                    if(bossHp<=0)
                        return true;
                    if(HU)
                        hero.curHp-=0;
                    else
                        hero.curHp -= bossDmg;
                    if(hero.curHp<=0)
                        return false;
                    first = false;
                }
            }
            else {
                bossHp -=playerDmg;
                if(bossHp<=0)
                    return true;
                hero.curHp -= bossDmg;
                if(hero.curHp<=0)
                    return false;
            }
        }
    }
    public static boolean battleToMonsterEvent(Player hero, Monster monster){
        int monsterHp = monster.h;
        boolean first = true;
        int playerDmg = Math.max(1, (hero.w+hero.lv*2)-monster.a);
        int monsterDmg = Math.max(1,monster.w-(hero.a+hero.lv*2));
        while(true){
            if(first){
                if(CO){
                    int firstAttDmg;
                    if(DX)
                        firstAttDmg = Math.max(((hero.w+hero.lv*2)*3)-monster.a,1);
                    else
                        firstAttDmg = Math.max(((hero.w+hero.lv*2)*2)-monster.a,1);
                    monsterHp-=firstAttDmg;
                    if (monsterHp<=0)
                        return true;
                    hero.curHp-=monsterDmg;
                    if(hero.curHp<=0)
                        return false;
                    first = false;
                }
                else {
                    monsterHp -=playerDmg;
                    if(monsterHp<=0)
                        return true;
                    hero.curHp -= monsterDmg;
                    if(hero.curHp<=0)
                        return false;
                    first = false;
                }
            }
            else {
                monsterHp -=playerDmg;
                if(monsterHp<=0)
                    return true;
                hero.curHp -= monsterDmg;
                if(hero.curHp<=0)
                    return false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int pass = 0;
        Player hero = new Player();
        int enemyCount = 0;
        int itemCount = 0;
        char [][] map = new char[n+1][m+1];
        for(int i=1; i<=n; i++){
            String s = sc.next();
            for(int j=1; j<=m; j++){
                map[i][j] = s.charAt(j-1);
                switch (map[i][j]){
                    case '&':
                        enemyCount++;
                        break;
                    case 'B':
                        itemCount++;
                        break;
                    case '@':
                        hero = new Player(i,j,2,2,20,0);
                        break;
                    case 'M':
                        enemyCount++;
                        break;
                }
            }
        }
        startX = hero.x;
        startY = hero.y;
        String command = sc.next();
        Dictionary<Integer,Monster> Monsters = new Hashtable<>();
        Dictionary<Integer,Item> Items = new Hashtable<>();
        for(int i=0; i<enemyCount; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String name = sc.next();
            int w = sc.nextInt();
            int a = sc.nextInt();
            int h = sc.nextInt();
            int ex = sc.nextInt();
            Monster monster = new Monster(x,y,name,w,a,h,ex);
            Monsters.put((x*10)+y,monster);
        }
        for(int i=0; i<itemCount; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            char type =sc.next().charAt(0);
            if(type =='O'){
                String acc = sc.next();
                Item item = new Item(x,y,type,acc);
                Items.put((x*10)+y,item);
            }
            else{
                int value = sc.nextInt();
                Item item = new Item(x,y,type,value);
                Items.put((x*10)+y,item);
            }
        }

        map[startX][startY]= '.';
        for(int i=0; i<command.length(); i++){
            char cmd = command.charAt(i);
            if(!playerLive || clearGame) break;
            int newy = hero.x;
            int newx = hero.y;
            switch (cmd){
                case 'R':
                    newx = hero.x;
                    newy = hero.y+1;
                    break;
                case 'L':
                    newx = hero.x;
                    newy = hero.y-1;
                    break;
                case 'U':
                    newx = hero.x-1;
                    newy = hero.y;
                    break;
                case 'D':
                    newx = hero.x+1;
                    newy = hero.y;
                    break;
            }
            if(newy<= 0 || newy >m || newx <=0 || newx >n){
                if(map[hero.x][hero.y] == '^') {
                    damageByTrapEvent(hero);
                }
                pass++;
                continue;
            }
            if(map[newx][newy]=='#'){
                if(map[hero.x][hero.y] == '^') {
                    damageByTrapEvent(hero);
                }
                pass++;
                continue;
            }
            if(map[newx][newy]=='^'){
                damageByTrapEvent(hero);
            }
            if(map[newx][newy]=='&'){
                Monster monster = Monsters.get((newx*10)+newy);
                if(battleToMonsterEvent(hero,monster)){
                    if(HR){
                        hero.curHp += 3;
                        if(hero.curHp>= hero.maxHp)
                            hero.curHp = hero.maxHp;
                    }
                    int needExp = hero.lv*5;
                    int getExp = monster.ex;
                    if(EX)
                        hero.ex += 1.2*getExp;
                    else
                        hero.ex += getExp;
                    if(hero.ex>=needExp){
                        hero.ex = 0;
                        hero.maxHp+=5;
                        hero.curHp = hero.maxHp;
                        hero.lv+=1;
                    }
                    map[newx][newy] = '.';
                }
                else{
                    deathEvent(hero);
                    if(!returnFlag){
                        murder = monster.name;
                    }
                }
            }
            if(map[newx][newy]=='M'){
                Monster monster = Monsters.get((newx*10)+newy);
                if(battleToBossEvent(hero,monster)){
                    clearGame = true;
                    if(HR){
                        hero.curHp += 3;
                        if(hero.curHp>= hero.maxHp)
                            hero.curHp = hero.maxHp;
                    }
                    int needExp = hero.lv*5;
                    int getExp = monster.ex;
                    if(EX)
                        hero.ex += 1.2*getExp;
                    else
                        hero.ex += getExp;
                    if(hero.ex>=needExp){
                        hero.ex = 0;
                        hero.maxHp+=5;
                        hero.curHp = hero.maxHp;
                        hero.lv+=1;
                    }
                    map[newx][newy] = '.';
                }
                else{
                    deathEvent(hero);
                    if(!returnFlag){
                        murder = monster.name;
                    }
                }
            }
            if(map[newx][newy]=='B'){
                Item item = Items.get((newx)*10 + newy);
                if(item.type=='O'){
                    if(item.acc.equals("EX")){
                        if(!EX && accCount!=4){
                            EX=true;
                            accCount++;
                        }
                    }
                    if(item.acc.equals("HR")){
                        if(!HR  && accCount!=4 ){
                            HR = true;
                            accCount++;
                        }
                    }
                    if(item.acc.equals("RE")){
                        if(!RE  && accCount!=4 ){
                            RE = true;
                            accCount++;
                        }
                    }
                    if(item.acc.equals("CO")){
                        if(!CO  && accCount!=4 ){
                            CO = true;
                            accCount++;
                        }
                    }
                    if(item.acc.equals("DX")){
                        if(!DX  && accCount!=4 ){
                            DX = true;
                            accCount++;
                        }
                    }
                    if(item.acc.equals("HU")){
                        if(!HU  && accCount!=4 ){
                            HU = true;
                            accCount++;
                        }
                    }
                    if(item.acc.equals("CU")){
                        if(!CU  && accCount!=4 ){
                            CU = true;
                            accCount++;
                        }
                    }
                }
                else{
                    if(item.type=='W'){
                        hero.w = item.value;
                    }
                    if(item.type=='A') {
                        hero.a = item.value;
                    }
                }
                map[newx][newy] = '.';
            }
            if(returnFlag){
                pass+=1;
                returnFlag = false;
                continue;
            }
            hero.x = newx;
            hero.y = newy;
            pass+=1;
        }
        
        if(playerLive)
            map[hero.x][hero.y] = '@';
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        if(hero.curHp<0) hero.curHp = 0;
        System.out.println("Passed Turns : "+pass);
        System.out.println("LV : "+hero.lv);
        System.out.println("HP : "+hero.curHp+"/"+hero.maxHp);
        System.out.println("ATT : "+(hero.lv*2)+"+"+hero.w);
        System.out.println("DEF : "+(hero.lv*2)+"+"+hero.a);
        System.out.println("EXP : "+hero.ex+"/"+(hero.lv*5));
        if(clearGame){
            System.out.println("YOU WIN!");
        }
        else if(!playerLive){
            System.out.println("YOU HAVE BEEN KILLED BY "+murder+"..");
        }
        else{
            System.out.println("Press any key to continue.");
        }
    }
}
