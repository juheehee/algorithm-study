import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * [백준] N-Queen
 * https://www.acmicpc.net/problem/9663
 * 백트래킹
 */
public class NQueen {
  static int n;
  static boolean[] col;
  static boolean[] diag1; // i - j 방향 (↘), 인덱스: i - j + (n-1)
  static boolean[] diag2; // i + j 방향 (↗), 인덱스: i + j
  static int count = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());

    col = new boolean[n];
    diag1 = new boolean[2 * n - 1];
    diag2 = new boolean[2 * n - 1];

    dfs(0);

    System.out.println(count);
  }

  static void dfs(int row) {
    if (row == n) {
      count++;
      return;
    }

    for (int c = 0; c < n; c++) {
      int d1 = row - c + (n - 1);
      int d2 = row + c;

      if (col[c] || diag1[d1] || diag2[d2]) {
        continue; // 이미 공격받는 자리라 스킵
      }

      // 선택
      col[c] = true;
      diag1[d1] = true;
      diag2[d2] = true;

      dfs(row + 1);

      // 되돌리기
      col[c] = false;
      diag1[d1] = false;
      diag2[d2] = false;
    }
  }
}
