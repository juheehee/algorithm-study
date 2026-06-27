/**
 * [프로그래머스] 문자열 뒤집기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181905
 * Level 0 | 연습문제
 */
public class ReverseStringSection {
  public String solution(String my_string, int s, int e) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s; i++) {
      sb.append(my_string.charAt(i));
    }

    for (int i = e; i >= s; i--) {
      sb.append(my_string.charAt(i));
    }

    for (int i = e + 1; i < my_string.length(); i++) {
      sb.append(my_string.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    ReverseStringSection sol = new ReverseStringSection();

    System.out.println(sol.solution("Progra21Sremm3", 6, 12));
    // ProgrammerS123

    System.out.println(sol.solution("Stanley1yelnatS", 4, 10));
    // Stanley1yelnatS

    System.out.println(sol.solution("abcdefg", 2, 5));
    // abfedcg

    System.out.println(sol.solution("hello", 0, 4));
    // olleh

    System.out.println(sol.solution("hello", 1, 3));
    // hlleo

    System.out.println(sol.solution("a", 0, 0));
    // a

    System.out.println(sol.solution("abcdef", 0, 0));
    // abcdef

    System.out.println(sol.solution("abcdef", 5, 5));
    // abcdef
  }
}
