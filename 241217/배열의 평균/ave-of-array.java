import java.io.*;
/*
1. 자연수 2행 4열
2. 가로, 세로, 전체 평균
3. 소수 첫째자리까지만
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][]= new int[2][4];
        int total =0;
        for(int i=0;i<2;i++){
            String s = br.readLine();
            String num[]=s.split(" ");
            int rsum=0;
            for(int j=0;j<4;j++){
                arr[i][j]=Integer.parseInt(num[j]);
                rsum+=arr[i][j];
            }
            total+=rsum;
            System.out.printf("%.1f ",rsum/4.0);
        }
        System.out.println();
        for(int i=0;i<4;i++){
            int csum=0;
            for(int j=0;j<2;j++){
                csum+=arr[j][i];
            }
            System.out.printf("%.1f ",csum/2.0);
        }
        System.out.printf("\n%.1f ",total/8.0);
    }
}