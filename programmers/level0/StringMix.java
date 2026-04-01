/**
 * [프로그래머스] 문자열 섞기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181942
 * Level 0 | 연습문제
 */
public class StringMix {
  public String solution(String str1, String str2) {
    String answer = "";
    for (int i = 0; i < str1.length(); i++) {
      answer = answer + str1.charAt(i) + str2.charAt(i);
    }
    return answer;
  }

  // 테스트 코드
  public static void main(String[] args) {
    StringMix sol = new StringMix();
    System.out.println(sol.solution("aaaaa", "bbbbb")); // "ababababab"
    System.out.println(sol.solution("abcd", "efgh")); // "aebfcgdh"
  }
}
