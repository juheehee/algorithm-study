import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * [프로그래머스] 개인정보 수집 유효기간
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * Level 1 | 연습문제
 */
public class PrivacyExpiration {
  public int[] solution(String today, String[] terms, String[] privacies) {

    // 1. 오늘 날짜를 일수로 변환
    int todayDate = convertDate(today);

    // 2. 약관 종류 → 유효기간(개월)
    Map<String, Integer> termMap = new HashMap<>();

    for (String term : terms) {
      String[] parts = term.split(" ");

      String type = parts[0];
      int month = Integer.parseInt(parts[1]);

      termMap.put(type, month);
    }

    // 파기할 개인정보 번호
    List<Integer> answer = new ArrayList<>();

    // 3. 개인정보 확인
    for (int i = 0; i < privacies.length; i++) {

      String[] parts = privacies[i].split(" ");

      String date = parts[0];
      String type = parts[1];

      // 수집 날짜를 일수로 변환
      int collectedDate = convertDate(date);

      // 해당 약관의 유효기간
      int month = termMap.get(type);

      // 파기 시작 날짜
      int expireDate = collectedDate + month * 28;

      // 오늘이 파기 시작 날짜 이상이면 파기 대상
      if (todayDate >= expireDate) {
        answer.add(i + 1);
      }
    }

    // List<Integer> → int[]
    return answer.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }

  private int convertDate(String date) {

    String[] parts = date.split("\\.");

    int year = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int day = Integer.parseInt(parts[2]);

    return year * 12 * 28
        + month * 28
        + day;
  }

  public static void main(String[] args) {

    PrivacyExpiration solution = new PrivacyExpiration();

    // 테스트 케이스 1
    String today1 = "2022.05.19";

    String[] terms1 = {
        "A 6",
        "B 12",
        "C 3"
    };

    String[] privacies1 = {
        "2021.05.02 A",
        "2021.07.01 B",
        "2022.02.19 C",
        "2022.02.20 C"
    };

    int[] result1 = solution.solution(today1, terms1, privacies1);

    System.out.println(Arrays.toString(result1));
    // 예상 결과: [1, 3]

    // 테스트 케이스 2
    String today2 = "2020.01.01";

    String[] terms2 = {
        "Z 3",
        "D 5"
    };

    String[] privacies2 = {
        "2019.01.01 D",
        "2019.11.15 Z",
        "2019.08.02 D",
        "2019.07.01 D",
        "2018.12.28 Z"
    };

    int[] result2 = solution.solution(today2, terms2, privacies2);

    System.out.println(Arrays.toString(result2));
    // 예상 결과: [1, 4, 5]
  }
}
