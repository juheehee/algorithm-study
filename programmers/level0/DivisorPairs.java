/**
 * [프로그래머스] 순서쌍의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/120836
 * Level 0 | 연습문제
 */

public class DivisorPairs {
  public int solution(int n) {
    int count = 0;

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    DivisorPairs sol = new DivisorPairs();

    System.out.println(sol.solution(6)); // 4
    System.out.println(sol.solution(20)); // 6
    System.out.println(sol.solution(1)); // 1
  }
}
