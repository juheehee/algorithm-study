/**
 * [프로그래머스] 주사위 게임2
 * https://school.programmers.co.kr/learn/courses/30/lessons/181930
 * Level 0 | 코딩 기초 트레이닝
 */
public class DiceGame {
  public static int solution(int a, int b, int c) {
    if (a != b && b != c && a != c) {
      return a + b + c;
    } else if (a == b && b == c) {
      return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
    } else {
      return (a + b + c) * (a * a + b * b + c * c);
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(2, 6, 1) == 9 ? "PASS" : "FAIL"); // 9
    System.out.println(solution(5, 3, 3) == 473 ? "PASS" : "FAIL"); // 473
    System.out.println(solution(4, 4, 4) == 110592 ? "PASS" : "FAIL"); // 110592
  }
}
