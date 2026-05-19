import java.util.*;
/**
 * [프로그래머스] 노란불 신호등
 * https://school.programmers.co.kr/learn/courses/30/lessons/468371
 * Level 1 | 2025 카카오 하반기 1차
 */

public class YellowLight {
  // 1. 각 신호등의 주기 계산
  // 2. 모든 주기의 LCM 계산 (탐색 상한선)
  // 3. t = 1부터 LCM까지 순회
  // → 모든 신호등이 노란불이면 return t
  // 4. 못 찾으면 return -1
  static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  static long lcm(long a, long b) {
    return a / gcd(a, b) * b;
  }

  public static int solution(int[][] signals) {
    // 모든 주기의 LCM 구하기
    long limit = 1;
    for (int[] s : signals) {
      int period = s[0] + s[1] + s[2];
      limit = lcm(limit, period);
    }

    // t=1부터 탐색
    for (long t = 1; t <= limit; t++) {
      boolean allYellow = true;
      for (int[] s : signals) {
        int period = s[0] + s[1] + s[2];
        long offset = (t - 1) % period;
        if (!(offset >= s[0] && offset < s[0] + s[1])) {
          allYellow = false;
          break;
        }
      }
      if (allYellow)
        return (int) t;
    }

    return -1;
  }

  public static void main(String[] args) {
    // 예제 1: 기댓값 13
    System.out.println(solution(new int[][] { { 2, 1, 2 }, { 5, 1, 1 } }));

    // 예제 2: 기댓값 11
    System.out.println(solution(new int[][] { { 2, 3, 2 }, { 3, 1, 3 }, { 2, 1, 1 } }));

    // 예제 3: 기댓값 193
    System.out.println(solution(new int[][] { { 3, 3, 3 }, { 5, 4, 2 }, { 2, 1, 2 } }));

    // 예제 4: 기댓값 -1
    System.out.println(solution(new int[][] { { 1, 1, 4 }, { 2, 1, 3 }, { 3, 1, 2 }, { 4, 1, 1 } }));
  }
}
