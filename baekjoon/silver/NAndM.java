import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * [백준] N과 M
 * https://www.acmicpc.net/problem/15649
 * 백트래킹
 */
public class NAndM {
  static boolean[] visited;
  static StringBuilder result = new StringBuilder();
  static int n, m;
  static int[] sequence;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    visited = new boolean[n + 1];
    sequence = new int[m];

    dfs(0);
    System.out.println(result);
  }

  // cnt: 채운 개수(깊이), i: 이번에 시도하는 숫자
  public static void dfs(int cnt) {
    if (cnt == m) { // 리프 노드
      for (int i = 0; i < m; i++) {
        result.append(sequence[i]); // result: 전체 출력 누적
        if (i != m - 1) // 마지막 숫자 뒤에는 공백을 안붙이려고 구별하는 조건
          result.append(' ');
      }
      result.append('\n');
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        sequence[cnt] = i; // sequence: 현재 탐색 중인 수열
        dfs(cnt + 1);
        visited[i] = false;
      }
    }
  }
}
