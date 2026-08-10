
/**
 * [프로그래머스] PCCE 기출문제 10번 / 데이터 분석
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121
 * Level 0 | PCCE 기출문제
 */

import java.util.*;

public class DataAnalysis {
  // 프로그래머스 제출용 (내부 클래스로 감싸서 다른 파일과 이름 충돌 방지)
  static class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

      int extIdx = 0;
      if (ext.equals("code"))
        extIdx = 0;
      else if (ext.equals("date"))
        extIdx = 1;
      else if (ext.equals("maximum"))
        extIdx = 2;
      else if (ext.equals("remain"))
        extIdx = 3;

      // 필터링
      ArrayList<int[]> list = new ArrayList<>();
      for (int i = 0; i < data.length; i++) {
        if (data[i][extIdx] < val_ext) {
          list.add(data[i]);
        }
      }

      // sort_by 인덱스
      int sortIdx = 0;
      if (sort_by.equals("code"))
        sortIdx = 0;
      else if (sort_by.equals("date"))
        sortIdx = 1;
      else if (sort_by.equals("maximum"))
        sortIdx = 2;
      else if (sort_by.equals("remain"))
        sortIdx = 3;

      // 배열로 변환
      int[][] answer = new int[list.size()][];
      for (int i = 0; i < list.size(); i++) {
        answer[i] = list.get(i);
      }

      // 정렬 - final 변수 사용!
      final int finalSortIdx = sortIdx;
      Arrays.sort(answer, (a, b) -> a[finalSortIdx] - b[finalSortIdx]);

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    // 테스트 케이스 1
    int[][] data1 = {
        { 1, 20300104, 100, 80 },
        { 2, 20300804, 847, 37 },
        { 3, 20300401, 10, 8 }
    };
    int[][] result1 = sol.solution(data1, "date", 20300501, "remain");
    System.out.println("Test 1: " + Arrays.deepToString(result1));
    // 예상: [[3, 20300401, 10, 8], [1, 20300104, 100, 80]]
  }
}