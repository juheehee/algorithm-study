/**
 * [프로그래머스] 둘만의 암호
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 * Level 1 | 연습문제
 */
public class SecretCodeBetweenUs {
  public static String solution(String s, String skip, int index) {
    StringBuilder answer = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      int count = 0;

      while (count < index) {
        current++;

        if (current > 'z') {
          current = 'a';
        }

        if (skip.indexOf(current) != -1) {
          continue;
        }

        count++;
      }

      answer.append(current);
    }

    return answer.toString();
  }

  public static void main(String[] args) {
    test("aukks", "wbqd", 5, "happy");
    test("zzzzz", "a", 1, "bbbbb");
    test("aaaaa", "b", 1, "ccccc");
    test("abcde", "xyz", 1, "bcdef");
    test("zzzzz", "abc", 3, "eeeee");
  }

  private static void test(
      String s, String skip, int index, String expected) {

    String actual = solution(s, skip, index);

    if (expected.equals(actual)) {
      System.out.println("PASS: " + actual);
    } else {
      System.out.println("FAIL: expected="
          + expected + ", actual=" + actual);
    }
  }
}
