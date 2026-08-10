package retry;

/**
 * [프로그래머스] 체육복
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * Level 1 | 연습문제
 */
import java.util.ArrayList;
import java.util.Collections;

public class GymSuit_260106 {
  public int solution(int n, int[] lost, int[] reserve) {
    ArrayList<Integer> lostList = new ArrayList<>();

    for (int l : lost) {
      lostList.add(l);
    }

    ArrayList<Integer> reserveList = new ArrayList<>();
    for (int r : reserve) {
      reserveList.add(r);
    }

    Collections.sort(lostList);
    Collections.sort(reserveList);

    for (int i = 1; i <= n; i++) {
      if (lostList.contains(i) && reserveList.contains(i)) {
        lostList.remove(Integer.valueOf(i));
        reserveList.remove(Integer.valueOf(i));
      }
    }

    for (int student : reserveList) {
      if (lostList.contains(student - 1)) {
        lostList.remove(Integer.valueOf(student - 1));
      } else if (lostList.contains(student + 1)) {
        lostList.remove(Integer.valueOf(student + 1));
      }
    }

    return n - lostList.size();
  }

  public static void main(String[] args) {
    GymSuit_260106 sol = new GymSuit_260106();

    int n1 = 5;
    int[] lost1 = { 2, 4 };
    int[] reserve1 = { 1, 3, 5 };
    System.out.println(sol.solution(n1, lost1, reserve1)); // 5

    int n2 = 5;
    int[] lost2 = { 2, 4 };
    int[] reserve2 = { 3 };
    System.out.println(sol.solution(n2, lost2, reserve2)); // 4
  }
}
