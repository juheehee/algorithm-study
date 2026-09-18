import java.util.Arrays;

/**
 * [프로그래머스] H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * Level 2 | 연습문제
 */
public class HIndex {
  public int solution(int[] citations) {
    Arrays.sort(citations);

    int n = citations.length;

    for (int i = 0; i < n; i++) {
      int h = n - i;

      if (citations[i] >= h) {
        return h;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] test1 = { 3, 0, 6, 1, 5 };
    
    HIndex hIndex = new HIndex();

    System.out.println(hIndex.solution(test1));
  }
}
