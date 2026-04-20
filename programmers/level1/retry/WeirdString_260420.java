package retry;
/**
 * [프로그래머스] 이상한 문자 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 * Level 1 | 문자열 변환
 */
public class WeirdString_260420 {
  public String solution(String s) {
    String answer = "";
    int idx = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == ' ') {
        answer += ' ';
        idx = 0;
      } else {
        if (idx % 2 == 0) {
          answer += Character.toUpperCase(c);
        } else {
          answer += Character.toLowerCase(c);
        }
        idx++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    WeirdString_260420 sol = new WeirdString_260420();

    // 테스트 케이스
    System.out.println("=== solution ===");
    System.out.println(sol.solution("try hello world")); // "TrY HeLlO WoRlD"
    System.out.println(sol.solution("a b c")); // "A B C"
    System.out.println(sol.solution("a  b")); // "A B" (공백 1개만!)
    System.out.println(sol.solution("a   b")); // "A B" (공백 1개만!)
  }
}
