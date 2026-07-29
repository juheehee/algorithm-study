import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
/**
 * [백준] 이친수 구하기
 * https://www.acmicpc.net/problem/2193
 * 동적 계획법
 */
public class DinaryNumber {
  static int n;
  static long[][] d; // d[i][0]: i자리 중 0으로 긑나는 이친수 개수, d[i][1]: 1로 끝나는 개수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());
    d = new long[n+1][2]; // 인덱스 1~n 사용 위해 n+1, 마지막 자리 0/1 두 상태라 열은 2 고정

    // base case: 한 자리 이친수는 "1"만 가능 (0으로 시작 불가)
    d[1][1] = 1;
    d[1][0] = 0;

    for (int i = 2; i <= n; i++) {
      d[i][0] = d[i-1][1] + d[i-1][0]; // 0 뒤엔 0/1 둘 다 올 수 있음 -> 이전 두 경우 다 더함
      d[i][1] = d[i-1][0]; // 1 뒤엔 0만 올 수 있음 (11 되면 규칙 위반) -> 이전이 0으로 끝난 경우만
    }

    // n자리 이친수는 0으로 끝나거나 1로 끝나거나 둘 중 하나이므로 합산
    System.out.println(d[n][0] + d[n][1]);
  }
}
