/**
 * [프로그래머스] 조건 문자열
 * https://school.programmers.co.kr/learn/courses/30/lessons/181934
 * Level 0 | 연습문제
 */
public class ConditionString {
  public int solution(String ineq, String eq, int n, int m) {

    if (ineq.equals(">") && eq.equals("=")) {
      return n >= m ? 1 : 0;
    } else if (ineq.equals("<") && eq.equals("=")) {
      return n <= m ? 1 : 0;
    } else if (ineq.equals(">") && eq.equals("!")) {
      return n > m ? 1 : 0;
    } else { // "<" && "!"
      return n < m ? 1 : 0;
    }
  }

  public static void main(String[] args) {
    ConditionString sol = new ConditionString();

    System.out.println(sol.solution(">", "=", 20, 50)); // 0 (20 >= 50 false)
    System.out.println(sol.solution("<", "!", 10, 20)); // 1 (10 < 20 true)
    System.out.println(sol.solution(">", "!", 5, 5)); // 0 (5 > 5 false)
    System.out.println(sol.solution("<", "=", 3, 3)); // 1 (3 <= 3 true)
  }
}
