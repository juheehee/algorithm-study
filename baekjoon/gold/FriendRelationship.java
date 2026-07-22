package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * [백준] 친구 관계 파악하기
 * https://www.acmicpc.net/problem/13023
 * DFS | 탐색
 */
public class FriendRelationship {
  static boolean visited[];
  static ArrayList<Integer>[] A;
  static boolean arrive;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    A = new ArrayList[N]; // 상자 생성
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<Integer>(); // 상자에 맞춘 빈 리스트 생성
    }

    for (int i = 0; i < M; i++) { // m개의 줄에서 반복해서 읽기 위함
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[S].add(E); // 양방향 저장
      A[E].add(S);
    }

    for (int i = 0; i < N; i++) {
      DFS(i, 1);
      if (arrive) {
        break;
      }
    }

    if (arrive) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
  }

  public static void DFS(int now, int depth) {
    if (depth == 5 || arrive) {
      arrive = true;
      return;
    }

    visited[now] = true;
    for (int i : A[now]) {
      if (!visited[i]) {
        DFS(i, depth + 1);
      }
    }
    visited[now] = false;
  }
}
