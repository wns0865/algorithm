import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       double a=Double.parseDouble(br.readLine());
       double sum=a+1.5;
       System.out.printf("%.2f",sum);
    }
}