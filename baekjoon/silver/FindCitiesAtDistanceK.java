import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

/**
 * [백준] 특정 거리의 도시 찾기
 * https://www.acmicpc.net/problem/18352
 * BFS | 그래프
 */

public class FindCitiesAtDistanceK {
  static int visited[];
  static ArrayList<Integer>[] A;
  static int N, M, K, X;
  static List<Integer> answer;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    M = scan.nextInt();
    K = scan.nextInt();
    X = scan.nextInt();

    A = new ArrayList[N + 1];
    answer = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < M; i++) {
      int S = scan.nextInt();
      int E = scan.nextInt();
      A[S].add(E);
    }
    // visited 배열 초기화 (-1로 채워 방문 안 한 상태 표시)
    visited = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      visited[i] = -1;
    }

    // BFS로 X에서 출발해 각 노드까지 거리 계산
    BFS(X);
    for (int i = 0; i <= N; i++) {
      if (visited[i] == K) {
        answer.add(i);
      }
    }

    if (answer.isEmpty()) {
      System.out.println("-1");
    } else {
      Collections.sort(answer);
      for (int temp : answer) {
        System.out.println(temp);
      }
    }
  }

  private static void BFS(int Node) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(Node);
    visited[Node]++;
    while (!queue.isEmpty()) {
      int now_Node = queue.poll();
      for (int i : A[now_Node]) {
        if (visited[i] == -1) {
          // 이전 노드 거리 + 1로 누적
          visited[i] = visited[now_Node] + 1;
          queue.add(i);
        }
      }
    }
  }
}
