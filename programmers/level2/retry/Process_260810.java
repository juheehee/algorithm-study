package level2.retry;

import java.util.*;

/**
 * [프로그래머스] 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Level 2 | 연습문제
 */
public class Process_260810 {
  public int solution(int[] priorities, int location) {
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < priorities.length; i++) {
      queue.offer(new int[] { priorities[i], i });
    }

    int count = 0;

    while (true) {
      int[] cur = queue.poll();

      if (!queue.isEmpty()) {
        int[] max = Collections.max(queue, (a, b) -> a[0] - b[0]);
        if (max[0] > cur[0]) {
          queue.offer(cur);
          continue;
        }

        count++;
        if (cur[1] == location) {
          return count;
        }
      }
    }
  }

  public static void main(String[] args) {
    Process_260810 sol = new Process_260810();

    int[] p1 = { 2, 1, 3, 2 };
    System.out.println(sol.solution(p1, 2)); // 예상: 1

    int[] p2 = { 1, 1, 9, 1, 1, 1 };
    System.out.println(sol.solution(p2, 0)); // 예상: 5
  }
}
