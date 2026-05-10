package level2;
/**
 * [프로그래머스] 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * Level 2 | 연습문제
 */
public class Exhaustive_Fatigue {
  public int solution(int k, int[][] dungeons) {
    boolean[] visited = new boolean[dungeons.length];
    return dfs(dungeons, k, visited, 0);
  }

  int dfs(int[][] dungeons, int hp, boolean[] visited, int count) {
    int max = count;

    for (int i = 0; i < dungeons.length; i++) {
      if (!visited[i] && hp >= dungeons[i][0]) {
        visited[i] = true;
        max = Math.max(max, dfs(dungeons, hp - dungeons[i][1], visited, count + 1));
        visited[i] = false;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Exhaustive_Fatigue solution = new Exhaustive_Fatigue();

    // 테스트 1: 기본 예제
    System.out.println(solution.solution(80, new int[][] { { 80, 20 }, { 50, 40 }, { 30, 10 } })); // 3

    // 테스트 2: 피로도 부족으로 아무것도 못 가는 경우
    System.out.println(solution.solution(10, new int[][] { { 50, 40 }, { 70, 20 } })); // 0

    // 테스트 3: 던전 1개
    System.out.println(solution.solution(100, new int[][] { { 100, 100 } })); // 1

    // 테스트 4: 순서가 중요한 경우 (순서 바꾸면 2개만 가능)
    System.out.println(solution.solution(80, new int[][] { { 80, 10 }, { 50, 30 } })); // 2
  }
}