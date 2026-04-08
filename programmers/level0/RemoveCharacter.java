/**
 * [프로그래머스] 특정 문자 제거하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120826
 * Level 0 | 연습문제
 */
public class RemoveCharacter {
  public String solution(String my_string, String letter) {
    return my_string.replace(letter, "");
  }

  public static void main(String[] args) {
    RemoveCharacter s = new RemoveCharacter();

    System.out.println(s.solution("abcdef", "f").equals("abcde") ? "PASS" : "FAIL");
    System.out.println(s.solution("BCBdbe", "B").equals("Cdbe") ? "PASS" : "FAIL");
    System.out.println(s.solution("aaa", "a").equals("") ? "PASS" : "FAIL");
    System.out.println("결과: [" + s.solution("aaa", "a") + "]");
    System.out.println(s.solution("abc", "z").equals("abc") ? "PASS" : "FAIL");
  }
}
