import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * [백준] 효율적으로 해킹하기
 * https://www.acmicpc.net/problem/1325
 * BFS | 그래프
 */
public class EfficientHacking {
  static int N, M;
  static boolean visited[];
  static int answer[];
  static ArrayList<Integer> A[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new ArrayList[N + 1];
    answer = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[S].add(E); // S가 E를 신뢰 (그대로 저장, 방향 안 뒤집음)
    }

    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      BFS(i); // 모든 노드를 각각 출발점으로 BFS 실행
    }

    int maxVal = 0;
    for (int i = 1; i <= N; i++) {
      maxVal = Math.max(maxVal, answer[i]);
    }

    for (int i = 1; i <= N; i++) {
      if (answer[i] == maxVal) {
        System.out.print(i + " ");
      }
    }
  }

  // BFS(start)에서 새로 방문한 노드 i는 "start가 i를 (전이적으로) 신뢰한다"는 뜻
  // 즉 i가 해킹당하면 start도 뚫림 -> i 입장에서 "나를 신뢰하는 노드 수"를 누적
  public static void BFS(int index) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(index);
    visited[index] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int i : A[now]) {
        if (visited[i] == false) {
          visited[i] = true;
          answer[i]++;
          queue.add(i);
        }
      }
    }
  }
}
