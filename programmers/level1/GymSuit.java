/**
 * [프로그래머스] 체육복
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * Level 1 | 탐욕법(Greedy)
 */
import java.util.ArrayList;
import java.util.Collections;

public class GymSuit { // 클래스명 = 파일명
  // 프로그래머스 제출용 (내부 클래스로 감싸서 다른 파일과 이름 충돌 방지)
  static class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
      ArrayList<Integer> lostList = new ArrayList<>();
      for (int l : lost) {
        lostList.add(l);
      }

      ArrayList<Integer> reserveList = new ArrayList<>();
      for (int r : reserve) {
        reserveList.add(r);
      }

      // 정렬
      Collections.sort(lostList);
      Collections.sort(reserveList);

      for (int i = 1; i <= n; i++) {
        if (lostList.contains(i) && reserveList.contains(i)) {
          lostList.remove(Integer.valueOf(i));
          reserveList.remove(Integer.valueOf(i));
        }
      }

      for (int i = 0; i < lostList.size(); i++) {
        int student = lostList.get(i);

        if (reserveList.contains(student - 1)) {
          reserveList.remove(Integer.valueOf(student - 1));
          lostList.remove(i);
          i--;
        }

        else if (reserveList.contains(student + 1)) {
          reserveList.remove(Integer.valueOf(student + 1));
          lostList.remove(i);
          i--;
        }
      }

      int answer = n - lostList.size();
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    // 테스트 케이스
    System.out.println(sol.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 })); // 5
    System.out.println(sol.solution(5, new int[] { 2, 4 }, new int[] { 3 })); // 4
    System.out.println(sol.solution(3, new int[] { 3 }, new int[] { 1 })); // 2

    // 정렬 필요한 케이스
    System.out.println(sol.solution(5, new int[] { 4, 2 }, new int[] { 3, 5 })); // 5
    System.out.println(sol.solution(5, new int[] { 1, 2 }, new int[] { 2, 3 })); // 4
  }
}