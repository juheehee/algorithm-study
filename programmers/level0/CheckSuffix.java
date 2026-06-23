/**
 * [프로그래머스] 접미사인지 확인하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181908
 * Level 0 | 연습문제
 */
public class CheckSuffix {
  public int solution(String my_string, String is_suffix) {

    for (int i = 0; i < my_string.length(); i++) {
      if (my_string.substring(i).equals(is_suffix)) {
        return 1;
      }
    }

    return 0;
    // 더 간단한 방법
    // return my_string.endsWith(is_suffix) ? 1 : 0;
  }

  public static void main(String[] args) {

    CheckSuffix sol = new CheckSuffix();

    // 테스트 1
    System.out.println(sol.solution("banana", "ana"));

    // 테스트 2
    System.out.println(sol.solution("banana", "nan"));

    // 테스트 3
    System.out.println(sol.solution("banana", "wxyz"));

    // 테스트 4
    System.out.println(sol.solution("banana", "abanana"));
  }
}
