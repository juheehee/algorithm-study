import java.util.HashSet;
import java.util.Set;

/**
 * [프로그래머스] N으로 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 * Level 3 | 동적계획법(DP)
 */
public class DP_NExpression {
  public int solution(int N, int number) {
    // dp[i] = N을 i번 사용해서 만들 수 있는 숫자들의 집합
    Set<Integer>[] dp = new HashSet[9];

    int concat = 0;
    for (int i = 1; i <= 8; i++) {
      dp[i] = new HashSet<>();

      // N을 i번 이어붙인 수 추가 (5, 55, 555...)
      concat = concat * 10 + N;
      dp[i].add(concat);

      // (j번 사용 결과) op (i-j번 사용 결과) 모든 조합
      for (int j = 1; j < i; j++) {
        for (int left : dp[j]) {
          for (int right : dp[i - j]) {
            dp[i].add(left + right);
            dp[i].add(left - right);
            dp[i].add(left * right);
            if (right != 0)
              dp[i].add(left / right);
          }
        }
      }

      // i번 사용해서 number 만들 수 있으면 i가 최솟값
      if (dp[i].contains(number))
        return i;
    }
    return -1; // 8번 이하로 만들 수 없음
  }

  public static void main(String[] args) {
    DP_NExpression p = new DP_NExpression();

    System.out.println(p.solution(5, 12)); // 기댓값: 4
    System.out.println(p.solution(2, 11)); // 기댓값: 3
    System.out.println(p.solution(5, 5)); // 기댓값: 1
  }
}
