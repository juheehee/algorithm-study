package level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [프로그래머스] 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * Level 2 | 연습문제
 */
public class LargestNumber {
  public String solution(int[] numbers) {
    String[] strNumber = new String[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      strNumber[i] = Integer.toString(numbers[i]);
    }
    Arrays.sort(strNumber, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        return (b + a).compareTo(a + b);
      }
    });

    String answer = "";
    for (String str : strNumber) {
      answer += str;
    }

    if (answer.charAt(0) == '0') {
      return "0";
    }

    return answer;
  }

  public static void main(String[] args) {
    LargestNumber sol = new LargestNumber();

    int[] numbers1 = { 6, 10, 2 };
    System.out.println(sol.solution(numbers1)); // 6210

    int[] numbers2 = { 3, 30, 34, 5, 9 };
    System.out.println(sol.solution(numbers2)); // 9534330

    int[] numbers3 = { 0, 0 };
    System.out.println(sol.solution(numbers3)); // 0
  }
}
