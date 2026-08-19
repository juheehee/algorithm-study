package retry;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [프로그래머스] 다리를 지나는 트럭
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * Level 2 | 연습문제
 */
public class TrucksCrossingBridge {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> bridge = new LinkedList<>();
    for (int i = 0; i < bridge_length; i++) {
      bridge.offer(0);
    }

    int currentWeight = 0;
    int answer = 0;
    int idx = 0; // truck_weights에서 다음에 태울 트럭 인덱스

    while (idx < truck_weights.length) { // 모든 트럭을 큐에 태울 때까지
      answer++; // 1초 경과

      currentWeight -= bridge.poll(); // 맨 앞 트럭이 다리에서 빠짐(무게 빼기)

      if (currentWeight + truck_weights[idx] <= weight) {
        currentWeight += truck_weights[idx];
        bridge.offer(truck_weights[idx]);
        idx++;
      } else {
        bridge.offer(0); // 못 태우면 빈 칸
      }
    }

    answer += bridge_length; // 마지막 트럭이 다리를 완전히 건너는 시간 추가

    return answer;
  }

  public static void main(String[] args) {
    TrucksCrossingBridge sol = new TrucksCrossingBridge();

    // 예시 1: bridge_length=2, weight=10, truck_weights=[7,4,5,6] → 8
    System.out.println(sol.solution(2, 10, new int[] { 7, 4, 5, 6 })); // 8

    // 예시 2: bridge_length=100, weight=100, truck_weights=[10] → 101
    System.out.println(sol.solution(100, 100, new int[] { 10 })); // 101

    // 예시 3: bridge_length=100, weight=100, truck_weights=[10]*10 → 110
    System.out.println(sol.solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 })); // 110
  }
}
