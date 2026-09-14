package retry;

/**
 * [프로그래머스] 두 정수 사이의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/12912
 * Level 1 | 연습문제
 */

public class SumBetweenTwoIntegers_260914 {
  public static long solution(int a, int b) {
    return ((long) a + b) * (Math.abs((long) a - b) + 1) / 2;
  }

  public static void main(String[] args) {
    System.out.println(solution(3, 5)); // 12
    System.out.println(solution(3, 3)); // 3
    System.out.println(solution(5, 3)); // 12
    System.out.println(solution(-3, 3)); // 0
    System.out.println(solution(-5, -3)); // -12
  }
}
