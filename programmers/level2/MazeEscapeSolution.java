import java.util.ArrayDeque;

/**
 * [프로그래머스] 미로 탈출
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * Level 2 | 연습문제
 */

public class MazeEscapeSolution {
  private static final int[] dx = { 0, 0, -1, 1 };
  private static final int[] dy = { -1, 1, 0, 0 };

  private static class Point {
    int nx, ny; // nx = x좌표, ny = y좌표

    public Point(int nx, int ny) {
      this.nx = nx;
      this.ny = ny;
    }
  }

  private static char[][] map;
  private static int N, M;

  public int solution(String[] maps) {
    N = maps.length;
    M = maps[0].length();

    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      map[i] = maps[i].toCharArray();
    }

    Point start = null, end = null, lever = null;

    // map[i][j]는 (행, 열)순서지만 Point는 (x,y) = (열, 행) 순서라 순서 바꿔서 전달
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'S') {
          start = new Point(j, i);
        } else if (map[i][j] == 'E') {
          end = new Point(j, i);
        } else if (map[i][j] == 'L') {
          lever = new Point(j, i);
        }
      }
    }

    int startLever = bfs(start, lever); // 시작부터 레버까지
    int leverEnd = bfs(lever, end); // 레버부터 도착까지

    if (startLever == -1 || leverEnd == -1) {
      return -1;
    } else {
      return startLever + leverEnd;
    }
  }

  private static int bfs(Point start, Point end) {
    int[][] dist = new int[N][M];
    ArrayDeque<Point> queue = new ArrayDeque<>();
    dist[start.ny][start.nx] = 1; // 시작위치는 위치하는거자체가 방문했다는 뜻이라서
    queue.add(start);

    while (!queue.isEmpty()) {
      Point now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nextX = now.nx + dx[i];
        int nextY = now.ny + dy[i];

        if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
          continue;

        if (dist[nextY][nextX] > 0)
          continue;

        if (map[nextY][nextX] == 'X')
          continue;

        dist[nextY][nextX] = dist[now.ny][now.nx] + 1;

        queue.add(new Point(nextX, nextY));

        if (nextX == end.nx && nextY == end.ny) {
          return dist[end.ny][end.nx] - 1; // 1로 시작하니가 오프셋 보정
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    MazeEscapeSolution solution = new MazeEscapeSolution();

    // 예제 1: 정답 16
    String[] maps1 = {
        "SOOOL",
        "XXXXO",
        "OOOOO",
        "OXXXX",
        "OOOOE"
    };
    System.out.println("테스트 1 결과: " + solution.solution(maps1) + " (기대값: 16)");

    // 예제 2: 정답 -1 (도달 불가능)
    String[] maps2 = {
        "LOOXS",
        "OOOXX",
        "OOOOO",
        "OOOOO",
        "EOOOO"
    };
    System.out.println("테스트 2 결과: " + solution.solution(maps2) + " (기대값: -1)");
  }
}
