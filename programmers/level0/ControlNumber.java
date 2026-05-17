/**
 * [프로그래머스] 수 조작하기 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/181926
 * Level 0
 */
public class ControlNumber {
  public int solution(int n, String control) {

    int answer = n;

    for (int i = 0; i < control.length(); i++) {

      if (control.charAt(i) == 'w') {
        answer += 1;
      }

      if (control.charAt(i) == 's') {
        answer -= 1;
      }

      if (control.charAt(i) == 'd') {
        answer += 10;
      }

      if (control.charAt(i) == 'a') {
        answer -= 10;
      }
    }

    return answer;
  }

  public static void main(String[] args) {

    ControlNumber solution = new ControlNumber();

    // 테스트 1
    System.out.println(solution.solution(0, "wsdawsdassw"));
    // -1

    // 테스트 2
    System.out.println(solution.solution(10, "w"));
    // 11

    // 테스트 3
    System.out.println(solution.solution(0, "dddd"));
    // 40

    // 테스트 4
    System.out.println(solution.solution(100, "aaaa"));
    // 60

    // 테스트 5
    System.out.println(solution.solution(-5, "ssw"));
    // -6
  }
}
