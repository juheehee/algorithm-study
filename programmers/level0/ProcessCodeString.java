/**
 * [프로그래머스] 코드 처리하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181932
 * Level 0 | 연습문제
 */
public class ProcessCodeString {
  public String solution(String code) {
    StringBuilder ret = new StringBuilder();
    int mode = 0;

    for (int i = 0; i < code.length(); i++) {
      char ch = code.charAt(i);

      if (ch == '1') {
        mode = 1 - mode; // mode 토글
      } else {
        if (mode == 0) {
          if (i % 2 == 0) {
            ret.append(ch);
          }
        } else { // mode == 1
          if (i % 2 == 1) {
            ret.append(ch);
          }
        }
      }
    }

    return ret.length() == 0 ? "EMPTY" : ret.toString();
  }

  public static void main(String[] args) {
    ProcessCodeString p = new ProcessCodeString();

    System.out.println(p.solution("abc1abc1abc")); // "acbac"
    System.out.println(p.solution("abc1abc1abc1")); // "acbac"
    System.out.println(p.solution("1111")); // "EMPTY"
    System.out.println(p.solution("a1b1c1d1")); // "ac"
  }
}
