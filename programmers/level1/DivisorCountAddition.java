/**
 * [프로그래머스] 약수의 개수와 덧셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 * Level 1 | 연습문제
 */

public class DivisorCountAddition {
  // 프로그래머스 제출용 (내부 클래스로 감싸서 다른 파일과 이름 충돌 방지)
  static class Solution {
    public int solution(int left, int right) {
      int result = 0;

      for (int i = left; i <= right; i++) {
        int count = 0;

        for (int j = 1; j <= i; j++) {
          if (i % j == 0) {
            count++;
          }
        }

        if (count % 2 == 0) {
          result += i;
        } else {
          result -= i;
        }
      }

      return result;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.solution(13, 17)); // 43
    System.out.println(sol.solution(24, 27)); // 52
  }
}