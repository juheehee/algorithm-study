package level3.retry;

import java.util.*;
/**
 * [프로그래머스] 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * Level 3 | 깊이/너비 우선 탐색(BFS)
 */
public class Network_260719 {
  boolean[] visited;
  int[][] graph;

  public int solution(int n, int[][] computers) {
    visited = new boolean[n];
    graph = computers; // 참조 대입(읽기만 하므로 복사 불필요)
    int network = 0;

    for (int i = 0; i < graph.length; i++) {
      if (visited[i] == false) {
        network++; // 새로운 네트워크 발견
        bfs(i); // i와 연결된 모든 노드를 방문 처리
      }
    }

    return network;
  }

  void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int j = 0; j < graph.length; j++) {
        // 연결되어 있고 아직 방문 안 한 노드만 큐에 추가 (AND 조건 필수)
        if (graph[cur][j] == 1 && !visited[j]) {
          visited[j] = true;
          queue.add(j);
        }
      }
    }
  }

  public static void main(String[] args) {
    Network_260719 p = new Network_260719();

    int[][] computers1 = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
    System.out.println(p.solution(3, computers1)); // 기댓값: 2

    int[][] computers2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
    System.out.println(p.solution(3, computers2)); // 기댓값: 1

    int[][] computers3 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
    System.out.println(p.solution(3, computers3)); // 기댓값: 3
  }
}
