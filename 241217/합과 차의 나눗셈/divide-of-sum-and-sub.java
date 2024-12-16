import java.io.*;
import java.util.*;
public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        float ans =(float)(a+b)/(float)(a-b);
        System.out.printf("%.2f",ans);
    }
}