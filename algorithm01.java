
import java.util.*;
public class Snake {
	static int n;
	static int k;
	static int[][] snk;
	static int[][] apple;
	static int[] td;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		apple = new int[n+1][n+1];
		for(int i=0;i<k;i++) {
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			apple[p1][p2] = 2; // 사과
		}
		snk = new int[n+1][n+1];
		int l = sc.nextInt();
		td = new int[10001]; // td초 후의 방향에 대한 정보.
		for(int i=0;i<l;i++) {
			int td1 = sc.nextInt();
			String t2 = sc.next();
			if(t2.equals("L")) {
				td[td1] = 1;				
			}else if(t2.equals("D")) {
				td[td1] = 2;
			}
		}
		ans = 0;
		
		func(1,1,0,1,1);
	}
	
	// 이 함수에 대한 정의가 매우 중요함.
	// 방향에 따른 도착한 곳에서의 상태. 즉, 방향에 따라 위치가 바뀔 것이고, 시간도 +1이 되고 길이도 그에 따라 변경.
	// 어차피 허용되지 않는 상황이어도 원하는 time 값은 이럴 때의 time값임.
	static void func(int ix, int jy, int time, int direct, int leng) {
		int x = ix;
		int y = jy;
		int len = leng;
		int t = time+1;
		
		//도착한 곳에서의 진행.
		// 방향에 따른 위치 변경(이후 방향에 대한 고려는 밑에 따로 함)
		if(direct==0){//위
			x = ix-1;
			y = jy;
		}else if(direct==1){//오
			x = ix;
			y = jy+1;			
		}else if(direct==2){//아
			x = ix+1;
			y = jy;			
		}else if(direct==3){//왼
			x = ix;
			y = jy-1;			
		}
		
		//벽에 부딪힘(도착한 곳들이..)
		if(x==0 || y==0 || x>n || y>n){
			ans = t;
			System.out.println(ans);
			return;
		}
		
		// 도착한 곳엔 사과가 있니
		if(apple[x][y]==2){
			len += 1;
            apple[x][y] = 0;
		}
		//자기몸에 부딪힘         t-len<snk[x][y]
		if(snk[x][y]>0 && t-snk[x][y]<len+1){
			ans = t;
			System.out.println(ans);
			return;
		}
		
		
	}
}
