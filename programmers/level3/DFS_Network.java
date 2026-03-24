package level3;

/**
 * [프로그래머스] 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * Level 3 | 깊이/너비 우선 탐색(DFS/BFS)
 */
public class DFS_Network {
  boolean[] visited;
  int[][] graph;

  public int solution(int n, int[][] computers) {
    visited = new boolean[n];
    graph = computers;
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, n);
        count++;
      }
    }
    return count;
  }

  void dfs(int node, int n) {
    visited[node] = true;
    for (int next = 0; next < n; next++) {
      if (graph[node][next] == 1 && !visited[next]) {
        dfs(next, n);
      }
    }
  }

  public static void main(String[] args) {
    DFS_Network p = new DFS_Network();

    int[][] computers1 = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
    System.out.println(p.solution(3, computers1)); // 기댓값: 2

    int[][] computers2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
    System.out.println(p.solution(3, computers2)); // 기댓값: 1

    int[][] computers3 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
    System.out.println(p.solution(3, computers3)); // 기댓값: 3
  }
}
