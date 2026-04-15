/**
 * [프로그래머스] 모음 제거
 * https://school.programmers.co.kr/learn/courses/30/lessons/120849
 */
public class RemoveVowels {
  public String solution(String my_string) {
    StringBuilder sb = new StringBuilder();

    for (char c : my_string.toCharArray()) {
      if (!isVowel(c)) {
        sb.append(c);
      }
    }

    return sb.toString();
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public static void main(String[] args) {
    RemoveVowels rv = new RemoveVowels();

    // 테스트 1
    String input1 = "bus";
    String result1 = rv.solution(input1);
    System.out.println(result1.equals("bs") ? "PASS" : "FAIL");

    // 테스트 2
    String input2 = "nice to meet you";
    String result2 = rv.solution(input2);
    System.out.println(result2.equals("nc t mt y") ? "PASS" : "FAIL");

    // 추가 테스트
    String input3 = "hello world";
    String result3 = rv.solution(input3);
    System.out.println(result3.equals("hll wrld") ? "PASS" : "FAIL");

    String input4 = "aeiou";
    String result4 = rv.solution(input4);
    System.out.println(result4.equals("") ? "PASS" : "FAIL");

    String input5 = "bcdfg";
    String result5 = rv.solution(input5);
    System.out.println(result5.equals("bcdfg") ? "PASS" : "FAIL");
  }
}
