package level2.retry;

import java.util.Arrays;
/**
 * [프로그래머스] 주식가격
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * Level 2 | 연습문제
 */

public class StockPrice_260405 {
  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) { // i 다음 인덱스부터 돌아가도록
        if (prices[i] > prices[j]) { // 가격이 떨어지는 순간
          answer[i] = j - i; // 가격 떨어진 시점 - 기준 시점
          break;
        }
      }

      if (answer[i] == 0) { // 가격이 떨어지지 않았다면
        answer[i] = prices.length - 1 - i; // 마지막 인덱스 - 기준 시점
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    StockPrice_260405 sol = new StockPrice_260405();

    // 테스트 1: 기본 예제
    int[] prices1 = { 1, 2, 3, 2, 3 };
    int[] result1 = sol.solution(prices1);
    System.out.println("Test 1: " + Arrays.toString(result1));
    // 예상: [4, 3, 1, 1, 0]

    // 테스트 2: 계속 상승
    int[] prices2 = { 1, 2, 3, 4, 5 };
    int[] result2 = sol.solution(prices2);
    System.out.println("Test 2: " + Arrays.toString(result2));
    // 예상: [4, 3, 2, 1, 0]

    // 테스트 3: 계속 하락
    int[] prices3 = { 5, 4, 3, 2, 1 };
    int[] result3 = sol.solution(prices3);
    System.out.println("Test 3: " + Arrays.toString(result3));
    // 예상: [1, 1, 1, 1, 0]

    // 테스트 4: 같은 가격
    int[] prices4 = { 3, 3, 3, 3 };
    int[] result4 = sol.solution(prices4);
    System.out.println("Test 4: " + Arrays.toString(result4));
    // 예상: [3, 2, 1, 0]

    // 테스트 5: 최소 길이
    int[] prices5 = { 5 };
    int[] result5 = sol.solution(prices5);
    System.out.println("Test 5: " + Arrays.toString(result5));
    // 예상: [0]
  }
}
