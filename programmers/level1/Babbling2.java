import java.util.Arrays;
/**
 * [프로그래머스] 옹알이(2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * Level 1 | 연습문제
 */
public class Babbling2 {
  private static final String[] WORDS = { "aya", "ye", "woo", "ma" };

  public int solution(String[] babbling) {
    int answer = 0;

    for (String word : babbling) {
      if (canSpeak(word)) {
        answer++;
      }
    }

    return answer;
  }

  private boolean canSpeak(String word) {
    int index = 0;
    String prev = "";

    while (index < word.length()) {
      boolean found = false;

      for (String sound : WORDS) {
        if (!sound.equals(prev) && word.startsWith(sound, index)) {
          index += sound.length();
          prev = sound;
          found = true;
          break;
        }
      }

      if (!found) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Babbling2 sol = new Babbling2();

    // 문제 예제
    String[] test1 = { "aya", "yee", "u", "maa" };
    String[] test2 = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };

    // 추가 테스트
    String[] test3 = { "aya" };
    String[] test4 = { "ayaye" };
    String[] test5 = { "yeye" };
    String[] test6 = { "woowoo" };
    String[] test7 = { "mama" };
    String[] test8 = { "ayawooma" };
    String[] test9 = { "woowo" };
    String[] test10 = { "ayawoomaye" };

    runTest(sol, 1, test1, 1);
    runTest(sol, 2, test2, 2);
    runTest(sol, 3, test3, 1);
    runTest(sol, 4, test4, 1);
    runTest(sol, 5, test5, 0);
    runTest(sol, 6, test6, 0);
    runTest(sol, 7, test7, 0);
    runTest(sol, 8, test8, 1);
    runTest(sol, 9, test9, 0);
    runTest(sol, 10, test10, 1);
  }

  private static void runTest(
      Babbling2 sol,
      int testNumber,
      String[] input,
      int expected) {
    int result = sol.solution(input);

    System.out.println(
        "Test " + testNumber +
            " | input = " + Arrays.toString(input) +
            " | expected = " + expected +
            " | result = " + result +
            " | " + (result == expected ? "PASS" : "FAIL"));
  }
}
