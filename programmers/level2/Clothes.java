import java.util.HashMap;
import java.util.Map;
/**
 * [프로그래머스] 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * Level 2 | 연습문제
 */
public class Clothes {
  public int solution(String[][] clothes) {
    Map<String, Integer> countByType = new HashMap<>();

    for (String[] cloth : clothes) {
      String type = cloth[1];
      countByType.put(type, countByType.getOrDefault(type, 0) + 1);
    }

    int answer = 1; // 곱셈 누적이라 1로 초기화
    for (int count : countByType.values()) {
      answer *= (count + 1);
    }

    return answer - 1; // 아무것도 안 입는 경우 제거
  }

  public static void main(String[] args) {
    Clothes c = new Clothes();
    String[][] test1 = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
        { "green_turban", "headgear" } };
    System.out.println(c.solution(test1)); // 5

    String[][] test2 = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };
    System.out.println(c.solution(test2)); // 3
  }
}
