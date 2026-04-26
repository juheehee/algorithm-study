/**
 * [프로그래머스] 대문자와 소문자
 * https://school.programmers.co.kr/learn/courses/30/lessons/120893
 * Level 0 | 연습문제
 */
public class SwapCaseString {
  public String solution(String my_string) {
    StringBuilder result = new StringBuilder();

    for (char ch : my_string.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        result.append(Character.toLowerCase(ch));
      } else {
        result.append(Character.toUpperCase(ch));
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    SwapCaseString obj = new SwapCaseString();

    String test1 = "cccCCC";
    String test2 = "abCdEfghIJ";

    System.out.println(obj.solution(test1)); // 기대값: CCCccc
    System.out.println(obj.solution(test2)); // 기대값: ABcDeFGHij
  }

}
