import java.util.Arrays;

/**
 * [프로그래머스] 양궁대회
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 * Level 2 | 연습문제
 */
public class ArcheryCompetition {
  int maxDiff = 0;
  int[] answer = { -1 };

  public int[] solution(int n, int[] info) {
    maxDiff = 0;
    answer = new int[]{-1};

    int[] ryan = new int[11];

    dfs(0, n, 0, ryan, info);

    return answer;
  }

  private void dfs(int idx, int arrows, int diff, int[] ryan, int[] info) {
    if (idx == 10) {
      ryan[10] = arrows;

      if (diff > maxDiff) {
        maxDiff = diff;
        answer = ryan.clone();
      } else if (diff == maxDiff && diff > 0) {
        if (isBetter(ryan, answer)) {
          answer = ryan.clone();
        }
      }

      ryan[10] = 0;
      return;
    }

    int score = 10 - idx;
    int required = info[idx] + 1;

    if (arrows >= required) {
      ryan[idx] = required;

      dfs(
          idx + 1,
          arrows - required,
          diff + score,
          ryan,
          info);

      ryan[idx] = 0;
    }

    if (info[idx] > 0) {
      dfs(idx + 1, arrows, diff - score, ryan, info);
    } else {
      dfs(idx + 1, arrows, diff, ryan, info);
    }
  }

  private boolean isBetter(int[] a, int[] b) {
    for (int i = 10; i >= 0; i--) {
      if (a[i] > b[i]) {
        return true;
      }

      if (a[i] < b[i]) {
        return false;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ArcheryCompetition ac = new ArcheryCompetition();

    test(ac, 5, new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0 });
    test(ac, 1, new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new int[] { -1 });
    test(ac, 9, new int[] { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 }, new int[] { 1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0 });
    test(ac, 10, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 }, new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2 });
  }

  private static void test(ArcheryCompetition ac, int n, int[] info, int[] expected) {
    int[] result = ac.solution(n, info);
    boolean pass = Arrays.equals(result, expected);
    System.out.println((pass ? "PASS" : "FAIL")
        + " | n=" + n
        + " | expected=" + Arrays.toString(expected)
        + " | actual=" + Arrays.toString(result));
  }
}
