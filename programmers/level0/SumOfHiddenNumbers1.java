/**
 * [프로그래머스] 숨어있는 숫자의 덧셈 (1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/120851
 * Level 0 | 연습문제
 */
public class SumOfHiddenNumbers1 {
  public int solution(String my_string) {
    int sum = 0;

    for (int i = 0; i < my_string.length(); i++) {
      char c = my_string.charAt(i);

      if (Character.isDigit(c)) {
        sum += c - '0';
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    SumOfHiddenNumbers1 sol = new SumOfHiddenNumbers1();

    System.out.println(sol.solution("aAb1B2cC34oOp")); // 10 (1+2+3+4)
    System.out.println(sol.solution("1a2b3c4d123")); // 16 (1+2+3+4+1+2+3)
    System.out.println(sol.solution("abcdef")); // 0
    System.out.println(sol.solution("5")); // 5
  }
}
