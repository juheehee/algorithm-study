package level3;

/**
 * [프로그래머스] 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * Level 3 | 동적계획법(DP)
 */
public class DP_Triangle {
  public int solution(int[][] triangle) {
    int n = triangle.length;
    int[][] dp = new int[n][n];
    dp[0][0] = triangle[0][0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          dp[i][0] = dp[i - 1][0] + triangle[i][0];
        } else if (j == i) {
          dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
        }
      }
    }

    int max = 0;
    for (int j = 0; j < n; j++) {
      max = Math.max(max, dp[n - 1][j]);
    }
    return max;
  }

  public static void main(String[] args) {
    DP_Triangle p = new DP_Triangle();

    int[][] t1 = {
        { 7 },
        { 3, 8 },
        { 8, 1, 0 },
        { 2, 7, 4, 4 },
        { 4, 5, 2, 6, 5 }
    };
    System.out.println(p.solution(t1)); // 기댓값: 30

    int[][] t2 = {
        { 1 },
        { 2, 3 },
        { 4, 5, 6 }
    };
    System.out.println(p.solution(t2)); // 기댓값: 10

    int[][] t3 = {
        { 5 },
        { 1, 9 },
        { 2, 3, 4 }
    };
    System.out.println(p.solution(t3)); // 기댓값: 18
  }
}
