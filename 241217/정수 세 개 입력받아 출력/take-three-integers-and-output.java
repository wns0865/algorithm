import java.io.*;
import java.util.*;
public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st =new StringTokenizer(s);
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(br.readLine());
        System.out.print(a+" "+b+" "+c);
    }
}