import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [백준] DFS와 BFS 프로그램
 * https://www.acmicpc.net/problem/1260
 * DFS, BFS | 탐색
 */

public class DfsBfsProgram {
  static int N,M,V; // n,m,v 초기화
  static boolean visited[];
  static ArrayList<Integer>[] A;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리드로 줄 읽고, 토크나이저로 토큰 구분해 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    visited = new boolean[N+1];
    A = new ArrayList[N+1]; // n+1인 이유는 노드 번호가 1부터 시작해서 인덱스 순서 사용하려면 + 1해야함.
    for (int i = 1; i <= N; i++) { // 노드 개수에 따라 인접 리스트 초기화하기
      A[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < M; i++) { // m번 읽어야 하는 반복 횟수 카운터에 따라 인접 리스트의 빈 배열에 인접 노드 값 넣어줌
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[S].add(E);
      A[E].add(S);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(A[i]); // 인접리스트의 값들을 작은 순으로 정렬(초기화 루프와 같게 설정)
    }

    sb = new StringBuilder();
    DFS(V);
    System.out.println(sb.toString());

    visited = new boolean[N+1];
    sb = new StringBuilder();
    BFS(V);
    System.out.println(sb.toString());
  }

  // dfs 함수 - 인접 노드 순회하며 미방문이면 방문 표시 + 기록 후 재귀 호출
  public static void DFS(int node) {
    sb.append(node + " ");
    visited[node] = true;
    for (int i : A[node]) {
      if (!visited[i]) {
        DFS(i);
      }
    }
  }

  // bfs 함수 - 큐 빌 때까지 꺼내서 기록하고 인접 노드 중 미방문이면 방문 표시하고 큐에 넣기
  public static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      sb.append(now + " ");
      for (int i : A[now]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
}
