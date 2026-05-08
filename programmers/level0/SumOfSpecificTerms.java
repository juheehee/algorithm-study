/**
 * [프로그래머스] 등차수열의 특정한 항만 더하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181931
 * Level 0 | 연습문제
 */
public class SumOfSpecificTerms {
  public int solution(int a, int d, boolean[] included) {

    int result = 0;

    for (int i = 0; i < included.length; i++) {

      if (included[i]) {
        result += a + (d * i);
      }

    }

    return result;
  }

  public static void main(String[] args) {

    SumOfSpecificTerms sol = new SumOfSpecificTerms();

    // 테스트 케이스 1
    boolean[] test1 = { true, false, false, true, true };
    System.out.println(sol.solution(3, 4, test1)); // 37

    // 테스트 케이스 2
    boolean[] test2 = { false, false, false, true, false, false, false };
    System.out.println(sol.solution(7, 1, test2)); // 10

  }
}
