import java.io.*;
import java.util.*;
public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String arr[]=s.split("-");
        System.out.print(arr[0]+"-"+arr[2]+"-"+arr[1]);
    }
}