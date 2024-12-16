import java.io.*;
import java.util.*;
public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st =new StringTokenizer(s);
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        System.out.print(n+" "+m+" "+(n+m));
    }
}