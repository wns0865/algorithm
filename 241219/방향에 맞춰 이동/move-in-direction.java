import java.util.*;
import java.io.*;
public class Main {
    static int dx[]={0,-1,1,0};
    static int dy[]={-1,0,0,1};
    public static void main(String[] args)throws IOException {
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       int n =Integer.parseInt(br.readLine());
       int x=0,y=0;
       for(int i=0;i<n;i++){
        String s = br.readLine();
        StringTokenizer st =new StringTokenizer(s);
        char c=st.nextToken().charAt(0);
        int num=Integer.parseInt(st.nextToken());
        switch(c){
            case 'W': 
                x+=dx[0];
                y+=dy[0]*num;
                break;
            case 'S': 
                x+=dx[1]*num;
                y+=dy[1];
                break;
            case 'N': 
                x+=dx[2]*num;
                y+=dy[2];
                break;
            case 'E': 
                x+=dx[3];
                y+=dy[3]*num;
                break;

        }

       } System.out.print(y+" "+x);
       
    }
}