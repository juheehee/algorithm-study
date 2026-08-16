package level2;

import java.util.PriorityQueue;

/**
 * [프로그래머스] 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * Level 2 | 연습문제
 */
public class MoreSpicy {
  public int solution(int[] scoville, int K) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int s : scoville) {
      pq.add(s);
    }

    int count = 0;
    while (pq.peek() < K) {
      if (pq.size() < 2) {
        return -1;
      }
      int first = pq.poll();
      int second = pq.poll();
      int newScoville = first + (second * 2);
      pq.add(newScoville);
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    MoreSpicy sol = new MoreSpicy();

    // 예시 1: 기대 결과 2
    int[] scoville1 = { 1, 2, 3, 9, 10, 12 };
    int K1 = 7;
    System.out.println("test1 (expected 2): " + sol.solution(scoville1, K1));

    // 예시 2: 이미 전부 K 이상 → 0회
    int[] scoville2 = { 10, 20, 30 };
    int K2 = 5;
    System.out.println("test2 (expected 0): " + sol.solution(scoville2, K2));

    // 예시 3: 섞어도 K에 도달 불가 → -1
    int[] scoville3 = { 1, 1 };
    int K3 = 1000000000;
    System.out.println("test3 (expected -1): " + sol.solution(scoville3, K3));

    // 예시 4: 원소 2개, 정확히 섞어야 K 도달
    int[] scoville4 = { 1, 2 };
    int K4 = 5;
    System.out.println("test4 (expected 1): " + sol.solution(scoville4, K4));
  }
}
