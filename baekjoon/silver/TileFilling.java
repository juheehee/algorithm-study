import java.io.*;
/**
 * [백준] 2*N 타일 채우기 
 * https://www.acmicpc.net/problem/11726
 * 동적 계획법
 */
public class TileFilling {
  static long mod = 10007;
  static int n;
  static long[] d;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());
    d = new long[1001];

    d[1] = 1;
    d[2] = 2;

    for (int i = 3; i <= n; i++) {
      d[i] = (d[i-1] + d[i-2]) % mod;
    }

    System.out.println(d[n]);
  }
}
