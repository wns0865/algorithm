import java.io.*;
import java.util.*;

public class Main {
    static int dx[]={0,1};
    static int dy[]={1,0};
    static class pos{
        int x,y;
        public pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int N,ans;
    static int[][]arr;
    static boolean isVisited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isVisited=new boolean[N][N];
        N = Integer.parseInt(br.readLine());
        arr=new int[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            String num[]=s.split(" ");
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(num[j]);
            }
        }
        start(0,0);
        System.out.println(ans);
    }
    static void start(int a, int b){
        Queue<pos> q= new ArrayDeque<>();
        q.add(new pos(a,b));
        // isVisited[a][b]=true;
        while(!q.isEmpty()){
            pos tmp = q.poll();
            int num=arr[tmp.x][tmp.y];
            for(int d=0;d<2;d++){
                int tx=tmp.x+dx[d]*num;
                int ty=tmp.y+dy[d]*num;
                if(!check(tx,ty)) continue;
                // if(isVisited[tx][ty])continue;
                if(tx==N-1&&ty==N-1) {
                    ans++;
                    break;
                    }
                else{
                    q.add(new pos(tx,ty));
                }
            }
        }
    }
    static boolean check(int a, int b){
        if(a<0||a>=N||b<0||b>=N) return false;
        return true;

    }
}
