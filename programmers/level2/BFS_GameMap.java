package level2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [프로그래머스] 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * Level 2 | 연습문제
 */

public class BFS_GameMap {
  public int solution(int[][] maps) {
    int rows = maps.length;
    int cols = maps[0].length;

    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[rows][cols];

    // [행, 열, 거리] 로 큐에 넣기
    queue.offer(new int[] { 0, 0, 1 });
    visited[0][0] = true;

    // 상하좌우 기본값
    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    while (!queue.isEmpty()) {
      int[] cur = queue.poll(); // 현재 위치
      int r = cur[0];
      int c = cur[1];
      int dist = cur[2];

      for (int d = 0; d < 4; d++) {
        // 현재 값과 상하좌우 이동값 더하기
        int nr = r + dx[d];
        int nc = c + dy[d];

        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
          continue; // 맵 밖으로 나가면 건너뛰기
        if (maps[nr][nc] == 0)
          continue; // 벽이면 건너뛰기
        if (visited[nr][nc])
          continue; // 이미 방문했으면 건너뛰기

        if (nr == rows - 1 && nc == cols - 1)
          return dist + 1; // 도착점 체크

        visited[nr][nc] = true; // 현재 이동값은 방문했다
        queue.offer(new int[] { nr, nc, dist + 1 }); // 결과값 새로 만들어서 넣기(큐는 배열 자체(참조)를 넣는 거라서)
      }
    }
    return -1; // 큐가 비었다 = 갈 수 있는 곳 전부 다 가봤는데 도착점 못 찾았다
  }

  public static void main(String[] args) {
    BFS_GameMap p = new BFS_GameMap();

    int[][] maps1 = {
        { 1, 0, 1, 1, 1 },
        { 1, 0, 1, 0, 1 },
        { 1, 0, 1, 1, 1 },
        { 1, 1, 1, 0, 1 },
        { 0, 0, 0, 0, 1 }
    };
    System.out.println(p.solution(maps1)); // 기댓값: 11

    int[][] maps2 = {
        { 1, 0, 1, 1, 1 },
        { 1, 0, 1, 0, 1 },
        { 1, 0, 1, 1, 1 },
        { 1, 1, 1, 0, 0 },
        { 0, 0, 0, 0, 1 }
    };
    System.out.println(p.solution(maps2)); // 기댓값: -1
  }
}
