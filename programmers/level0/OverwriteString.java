/**
 * [프로그래머스] 문자열 겹쳐쓰기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181943
 * Level 0 | 연습문제
 */
public class OverwriteString {

  public String solution(String my_string, String overwrite_string, int s) {
    String front = my_string.substring(0, s);
    String back = my_string.substring(s + overwrite_string.length());

    return front + overwrite_string + back;
  }

  public static void main(String[] args) {
    OverwriteString sol = new OverwriteString();

    String result1 = sol.solution("abcdef", "zzz", 2);
    System.out.println(result1); // abzzzf

    String result2 = sol.solution("helloWorld", "Java", 5);
    System.out.println(result2); // helloJavad

    String result3 = sol.solution("aaaaaa", "bbb", 3);
    System.out.println(result3); // aaabbb
  }
}
