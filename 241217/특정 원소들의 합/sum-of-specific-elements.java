import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][]= new int[4][4];
        for(int i=0; i<4;i++){
            String s = br.readLine();
            String num[] = s.split(" ");
            for(int j=0;j<4;j++){
                arr[i][j]=Integer.parseInt(num[j]);
            }
        }
        int sum=0;
        for(int i=0; i<4;i++){
            for(int j=0;j<=i;j++){
                 sum+=arr[i][j];        
          }
        }
        System.out.println(sum);
    }
}