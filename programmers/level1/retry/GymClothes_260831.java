package retry;
/**
 * [프로그래머스] 체육복
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * Level 1 | 탐욕법(Greedy)
 */
import java.util.Arrays;

public class GymClothes_260831 {
  public int solution(int n, int[] lost, int[] reserve) {
    boolean[] hasClothes = new boolean[n + 1];
    Arrays.fill(hasClothes, true);
    for (int i = 0; i < lost.length; i++) {
      hasClothes[lost[i]] = false;
    }

    boolean[] hasExtra = new boolean[n + 1];
    for (int i = 0; i < reserve.length; i++) {
      hasExtra[reserve[i]] = true;
    }

    for (int i = 0; i < lost.length; i++) {
      if (hasExtra[lost[i]] == true) {
        hasClothes[lost[i]] = true;
        hasExtra[lost[i]] = false;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (hasClothes[i] == false) {
        if (i - 1 >= 1 && hasExtra[i - 1] == true) {
          hasClothes[i] = true;
          hasExtra[i - 1] = false;
        } else if (i + 1 <= n && hasExtra[i + 1] == true) {
          hasClothes[i] = true;
          hasExtra[i + 1] = false;
        } else {
          continue;
        }
      }
    }

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (hasClothes[i] == true) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    GymClothes_260831 sol = new GymClothes_260831();

    // 예시 1: n=5, lost=[2,4], reserve=[1,3,5] -> 5
    int r1 = sol.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 });
    System.out.println("Test 1: " + r1 + " (expected 5) -> " + (r1 == 5 ? "PASS" : "FAIL"));

    // 예시 2: n=5, lost=[2,4], reserve=[3] -> 4
    int r2 = sol.solution(5, new int[] { 2, 4 }, new int[] { 3 });
    System.out.println("Test 2: " + r2 + " (expected 4) -> " + (r2 == 4 ? "PASS" : "FAIL"));

    // 예시 3: n=3, lost=[3], reserve=[1] -> 2
    int r3 = sol.solution(3, new int[] { 3 }, new int[] { 1 });
    System.out.println("Test 3: " + r3 + " (expected 2) -> " + (r3 == 2 ? "PASS" : "FAIL"));
  }
}
