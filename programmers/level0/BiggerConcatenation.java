/**
 * [프로그래머스] 더 크게 합치기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181939#
 * Level 0 | 연습문제
 */
public class BiggerConcatenation {
  public int solution(int a, int b) {
    String ab = "" + a + b;
    String ba = "" + b + a;

    return ab.compareTo(ba) >= 0
        ? Integer.parseInt(ab)
        : Integer.parseInt(ba);
  }

  public static void main(String[] args) {
    BiggerConcatenation sol = new BiggerConcatenation();

    System.out.println(sol.solution(9, 91)); // 991
    System.out.println(sol.solution(89, 8)); // 898

    // 추가 테스트
    System.out.println(sol.solution(12, 3)); // 123
    System.out.println(sol.solution(3, 12)); // 312
    System.out.println(sol.solution(0, 0)); // 0
    System.out.println(sol.solution(100, 10)); // 10100 vs 10010 → 10100
  }
}
