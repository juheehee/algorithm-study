/**
 * [프로그래머스] 자릿수 더하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120906
 * Level 0 | 연습문제
 */
public class DigitSum {
  public int solution(int n) {
    String str = String.valueOf(n); // 문자열로 만들기
    int sum = 0;

    for (int i = 0; i < str.length(); i++) {
      sum += str.charAt(i) - '0'; // 문자를 숫자로 변환
    }

    return sum;
  }

  public static void main(String[] args) {
    DigitSum solution = new DigitSum();

    System.out.println(solution.solution(1234)); // 10
    System.out.println(solution.solution(930211)); // 16
    System.out.println(solution.solution(0)); // 0
    System.out.println(solution.solution(1000000)); // 1
  }
}
