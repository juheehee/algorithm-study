package level3;
/**
 * [프로그래머스] 여행경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * Level 3 | 연습문제
 */

import java.util.Arrays;

public class TravelRoute {
  boolean[] visited;
  String[] answer;
  boolean found = false;

  public String[] solution(String[][] tickets) {
    visited = new boolean[tickets.length];
    answer = new String[tickets.length + 1];
    answer[0] = "ICN";

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
    if (depth == tickets.length) {
      found = true;
      return;
    }

    for (int i = 0; i < tickets.length; i++) {
      if (!visited[i] && tickets[i][0].equals(current)) {
        visited[i] = true;
        answer[depth + 1] = tickets[i][1];
        dfs(tickets, tickets[i][1], depth + 1);

        if (found)
          return;

        visited[i] = false;
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
