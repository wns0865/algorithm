import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N]; // 경로의 수를 저장할 DP 배열

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        // DP 초기화
        dp[0][0] = 1;

        // DP 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) continue; // 더 이상 이동 불가한 지점
                int step = arr[i][j];

                // 오른쪽 이동
                if (j + step < N) {
                    dp[i][j + step] += dp[i][j];
                }

                // 아래로 이동
                if (i + step < N) {
                    dp[i + step][j] += dp[i][j];
                }
            }
        }

        // 결과 출력 (오른쪽 아래 최종 값)
        System.out.println(dp[N - 1][N - 1]);
    }
}
