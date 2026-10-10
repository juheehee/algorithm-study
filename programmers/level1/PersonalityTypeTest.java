import java.util.HashMap;
import java.util.Map;
/**
 * [프로그래머스] 성격 유형 검사하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * Level 1 | 연습문제
 */
public class PersonalityTypeTest {
  public static String solution(String[] survey, int[] choices) {

    // 각 성격 유형별 점수 저장
    Map<Character, Integer> score = new HashMap<>();

    // 모든 질문 확인
    for (int i = 0; i < survey.length; i++) {

      char disagree = survey[i].charAt(0); // 비동의 유형
      char agree = survey[i].charAt(1); // 동의 유형

      int choice = choices[i];

      // 비동의 -> 첫 번째 유형에 점수
      if (choice < 4) {
        score.put(
            disagree,
            score.getOrDefault(disagree, 0) + (4 - choice));
      } else if (choice > 4) { // 동의 -> 두 번째 유형에 점수
        score.put(
            agree,
            score.getOrDefault(agree, 0) + (choice - 4));
      }
    }

    // 각 지표별 결과 결정
    char[][] types = {
        { 'R', 'T' },
        { 'C', 'F' },
        { 'J', 'M' },
        { 'A', 'N' }
    };

    StringBuilder answer = new StringBuilder();

    for (char[] type : types) {

      int firstScore = score.getOrDefault(type[0], 0);
      int secondScore = score.getOrDefault(type[1], 0);

      // 점수가 같으면 사전순으로 빠른 첫 번째 유형 선택
      if (firstScore >= secondScore) {
        answer.append(type[0]);
      } else {
        answer.append(type[1]);
      }
    }

    return answer.toString();
  }

  public static void main(String[] args) {
    String[] survey1 = { "AN", "CF", "MJ", "RT", "NA" };
    int[] choices1 = { 5, 3, 2, 7, 5 };

    String result1 = solution(survey1, choices1);

    System.out.println("테스트 1");
    System.out.println("결과   : " + result1);
    System.out.println("기댓값 : TCMA");
    System.out.println("통과 여부 : " + result1.equals("TCMA"));

    System.out.println();

    String[] survey2 = { "TR", "RT", "TR" };
    int[] choices2 = { 7, 1, 3 };

    String result2 = solution(survey2, choices2);

    System.out.println("테스트 2");
    System.out.println("결과   : " + result2);
    System.out.println("기댓값 : RCJA");
    System.out.println("통과 여부 : " + result2.equals("RCJA"));
  }
}
