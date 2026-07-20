import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * [백준] 연결 요소의 개수 구하기
 * https://www.acmicpc.net/problem/11724
 * DFS | 탐색
 */
public class ConnectedComponents {
  static int N, M;
  static List<Integer>[] A; // 선언만, 아직 new 안 함(타입만 정해둠)
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 줄 단위로 읽기
    StringTokenizer st = new StringTokenizer(br.readLine()); // // "N M" 줄을 토큰 분리
    N = Integer.parseInt(st.nextToken()); // 1번째 토큰 = N
    M = Integer.parseInt(st.nextToken()); // 2번째 토큰 = M

    A = new ArrayList[N + 1]; // 여기서 진짜 크기로 배열 자체를 생성하며 초기화
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<Integer>(); // 진짜 비어있는 ArrayList 객체 하나가 만들어짐. 각 칸 마다 서로 다른, 독립적인 빈 리스트가 하나씩 들어감.
    }

    for (int i = 0; i < M; i++) { // M의 개수만큼 값 넣으며 에지 양끝 점 양방향 저장
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      A[u].add(v);
      A[v].add(u);
    }

    int count = 0;
    for (int i = 1; i <= N; i++) { // 값 넣은걸 확인하기 위해 노드 개수에 맞춰 순회
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }

    System.out.println(count);
  }

  static void dfs(int v) {
    visited[v] = true; // 먼저 방문 표시해야 재귀가 같은 노드를 무한히 다시 타지 않음
    for (int next : A[v]) {
      if (!visited[next]) { // 연결노드 중 방문하지 않았던 노드만 탐색
        dfs(next);
      }
    }
  }
}