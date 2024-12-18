import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {0, 1}; // 오른쪽, 아래
    static int dy[] = {1, 0};
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, ans;
    static int[][] arr;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N 값 먼저 초기화
        arr = new int[N][N];
        isVisited = new boolean[N][N]; // N 이후에 초기화

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String num[] = s.split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }

        start(0, 0); // BFS 탐색 시작
        System.out.println(ans);
    }

    static void start(int a, int b) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(a, b));

        while (!q.isEmpty()) {
            Pos tmp = q.poll();
            int num = arr[tmp.x][tmp.y];

            for (int d = 0; d < 2; d++) {
                int tx = tmp.x + dx[d] * num;
                int ty = tmp.y + dy[d] * num;

                if (!check(tx, ty)) continue; // 범위 체크
                if (tx == N - 1 && ty == N - 1) { // 도착 지점
                    ans++;
                } else if (!isVisited[tx][ty]) { // 방문하지 않은 경우
                    isVisited[tx][ty] = true;
                    q.add(new Pos(tx, ty));
                }
            }
        }
    }

    static boolean check(int a, int b) {
        return a >= 0 && a < N && b >= 0 && b < N; // 범위 확인
    }
}
