package level3;
/**
 * [프로그래머스] 여행경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * Level 3 | 연습문제
 */

import java.util.Arrays;

public class TravelRoute {
  boolean[] visited; // 방문 배열
  String[] answer; // 결과 담는 배열
  boolean found = false; // 경로 찾았는지 여부 확인

  public String[] solution(String[][] tickets) {
    visited = new boolean[tickets.length];
    answer = new String[tickets.length + 1]; // 도시 개수가 타켓 보다 1개 많아서
    answer[0] = "ICN"; // 첫 출발지 항상 고정되게

    // 타겟을 정렬하면 출발지, 도착지 둘 다 고려된 정렬이 되는데
    // String[]끼리 비교하는 방법 명시
    Arrays.sort(tickets, (a, b) -> {
      if (a[0].equals(b[0])) {
        return a[1].compareTo(b[1]);
      }
      return a[0].compareTo(b[0]);
    });
    dfs(tickets, "ICN", 0);

    return answer;
  }

  void dfs(String[][] tickets, String current, int depth) {
    // 종료 조건 : 다 찾았는지 확인
    if (depth == tickets.length) {
      found = true;
      return;
    }

    // 아니라면
    for (int i = 0; i < tickets.length; i++) {
      // 방문하지 않았고 현재 여행지와 출발지가 같다면
      if (!visited[i] && tickets[i][0].equals(current)) {
        visited[i] = true; // 방문표시하고
        answer[depth + 1] = tickets[i][1]; // 다음 경로 저장하고
        dfs(tickets, tickets[i][1], depth + 1); // 재귀로 반복하는데 다음 출발지로 설정

        if (found) // 경로를 찾았다면 종료
          return;

        visited[i] = false; // 모두 아니라면 방문하지 않았다
      }
    }
  }

  public static void main(String[] args) {
    TravelRoute solution = new TravelRoute();

    // 테스트 1
    String[][] tickets1 = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
    System.out.println(Arrays.toString(solution.solution(tickets1)));
    // 예상: [ICN, JFK, HND, IAD]

    // 테스트 2
    String[][] tickets2 = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
    System.out.println(Arrays.toString(solution.solution(tickets2)));
    // 예상: [ICN, ATL, ICN, SFO, ATL, SFO]
  }
}
