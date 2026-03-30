/**
 * [PCCP 모의고사 1회 - 2번] 체육대회
 * Level 2 | DFS + 백트래킹
 */
public class DFS_SportsMeeting {
  boolean[] used;
  int max = 0;

  public int solution(int[][] ability) {
    used = new boolean[ability.length];
    max = 0;
    dfs(0, ability, 0);
    return max;
  }

  void dfs(int subject, int[][] ability, int sum) {
    if (subject == ability[0].length) {
      max = Math.max(max, sum);
      return;
    }
    for (int student = 0; student < ability.length; student++) {
      if (!used[student]) {
        used[student] = true;
        dfs(subject + 1, ability, sum + ability[student][subject]);
        used[student] = false;
      }
    }
  }

  public static void main(String[] args) {
    DFS_SportsMeeting p = new DFS_SportsMeeting();

    System.out.println(p.solution(new int[][] {
        { 40, 10, 10 }, { 20, 5, 0 }, { 30, 30, 30 }, { 70, 0, 70 }, { 100, 100, 100 }
    })); // 기댓값: 210

    System.out.println(p.solution(new int[][] {
        { 20, 30 }, { 30, 20 }, { 20, 30 }
    })); // 기댓값: 60
  }
}
