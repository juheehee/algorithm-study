/**
 * [프로그래머스] 접두사인지 확인하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181906
 * Level 0 | 연습문제
 */
public class PrefixCheck {
  public int solution(String my_string, String is_prefix) {
    return my_string.startsWith(is_prefix) ? 1 : 0;
  }

  public static void main(String[] args) {
    PrefixCheck sol = new PrefixCheck();

    System.out.println(sol.solution("banana", "ban")); // 1
    System.out.println(sol.solution("banana", "nan")); // 0
    System.out.println(sol.solution("banana", "abcd")); // 0
    System.out.println(sol.solution("banana", "bananan")); // 0

    // 추가 테스트
    System.out.println(sol.solution("apple", "a")); // 1
    System.out.println(sol.solution("apple", "app")); // 1
    System.out.println(sol.solution("apple", "apple")); // 1
    System.out.println(sol.solution("apple", "pp")); // 0
  }
}
