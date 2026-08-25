package level3;

/**
 * [프로그래머스] 이중우선순위큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * Level 3 | 연습문제
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
  public int[] solution(String[] operations) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Map<Integer, Integer> count = new HashMap<>();
    int size = 0;

    for (int i = 0; i < operations.length; i++) {
      String[] op = operations[i].split(" ");
      int num = Integer.parseInt(op[1]);

      if (op[0].equals("I")) {
        minHeap.offer(num);
        maxHeap.offer(num);
        count.put(num, count.getOrDefault(num, 0) + 1); // 삽입 시 개수 기록
        size++;
      } else { // op[0].equals("D")
        if (num == 1) {
          while (!maxHeap.isEmpty() && count.get(maxHeap.peek()) == 0) {
            maxHeap.poll();
          }
          if (maxHeap.isEmpty()) {
            continue;
          } else {
            int now = maxHeap.poll();
            count.put(now, count.get(now) - 1);
            size--;
          }
        } else { // num == -1
          while (!minHeap.isEmpty() && count.get(minHeap.peek()) == 0) {
            minHeap.poll();
          }
          if (minHeap.isEmpty()) {
            continue;
          } else {
            int now = minHeap.poll();
            count.put(now, count.get(now) - 1);
            size--;
          }
        }
      }
    }

    if (size == 0) {
      return new int[] { 0, 0 };
    }

    while (count.get(maxHeap.peek()) == 0) {
      maxHeap.poll();
    }
    int maxVal = maxHeap.peek();

    while (count.get(minHeap.peek()) == 0) {
      minHeap.poll();
    }
    int minVal = minHeap.peek();

    return new int[] { maxVal, minVal };
  }

  public static void main(String[] args) {
    DoublePriorityQueue sol = new DoublePriorityQueue();

    // 입출력 예 1: 기대값 [0, 0]
    String[] operations1 = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
    int[] result1 = sol.solution(operations1);
    System.out.println("테스트 1 결과: [" + result1[0] + ", " + result1[1] + "]"
        + " (기대값: [0, 0])");

    // 입출력 예 2: 기대값 [333, -45]
    String[] operations2 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
    int[] result2 = sol.solution(operations2);
    System.out.println("테스트 2 결과: [" + result2[0] + ", " + result2[1] + "]"
        + " (기대값: [333, -45])");
  }
}
