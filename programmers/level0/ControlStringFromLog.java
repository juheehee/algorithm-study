/**
 * [프로그래머스] 수 조작하기 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/181925
 * Level 0
 */
public class ControlStringFromLog {
  public String solution(int[] numLog) {
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < numLog.length; i++) {
      int diff = numLog[i] - numLog[i - 1];

      switch (diff) {
        case 1:
          sb.append("w");
          break;
        case -1:
          sb.append("s");
          break;
        case 10:
          sb.append("d");
          break;
        case -10:
          sb.append("a");
          break;
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    ControlStringFromLog sol = new ControlStringFromLog();

    // 테스트 케이스 1
    int[] numLog1 = { 0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1 };
    System.out.println(sol.solution(numLog1));
    // expected: wsdawsdassw

    // 테스트 케이스 2
    int[] numLog2 = { 10, 20, 10, 11, 10 };
    System.out.println(sol.solution(numLog2));
    // expected: daws

    // 테스트 케이스 3
    int[] numLog3 = { -5, -4, 6, 5, -5 };
    System.out.println(sol.solution(numLog3));
    // expected: wdsa
  }
}
