/**
 * [프로그래머스] 등굣길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * Level 3 | 동적계획법(DP)
 */
public class DP_School {
  public int solution(int m, int n, int[][] puddles) {
    // dp[i][j] = (0,0)에서 (i,j)까지 올 수 있는 최단경로 수
    int[][] dp = new int[n][m];
    dp[0][0] = 1; // 시작점

    // 물 잠긴 곳 -1로 표시 (p[0]=x좌표=열, p[1]=y좌표=행)
    for (int[] p : puddles)
      dp[p[1] - 1][p[0] - 1] = -1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (dp[i][j] == -1)
          continue; // 물 잠긴 곳 건너뛰기
        if (i == 0 && j == 0)
          continue; // 시작점은 이미 1

        int up = (i > 0) ? dp[i - 1][j] : 0; // 위에서 오는 경우
        int left = (j > 0) ? dp[i][j - 1] : 0; // 왼쪽에서 오는 경우

        if (up == -1)
          up = 0; // 물 잠긴 곳에서 오면 0으로
        if (left == -1)
          left = 0;

        dp[i][j] = (up + left) % 1000000007;
      }
    }
    return dp[n - 1][m - 1];
  }

  public static void main(String[] args) {
    DP_School p = new DP_School();

    System.out.println(p.solution(4, 3, new int[][] { { 2, 2 } }));
    // 기댓값: 4

    System.out.println(p.solution(3, 3, new int[][] { { 1, 2 }, { 2, 1 } }));
    // 기댓값: 0

    System.out.println(p.solution(1, 1, new int[][] {}));
    // 기댓값: 1
  }
}
