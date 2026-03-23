package level2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [프로그래머스] 다리를 지나는 트럭
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * Level 2 | 스택/큐
 */
public class Queue_BridgeTruck {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> bridge = new ArrayDeque<>();
    // 다리 길이만큼 0으로 채우기
    for (int i = 0; i < bridge_length; i++)
      bridge.offer(0);

    int idx = 0;
    int currentWeight = 0;
    int time = 0;

    // 대기 트럭이 남아있거나 다리 위에 트럭이 있는 동안
    while (idx < truck_weights.length || currentWeight > 0) {
      int removed = bridge.poll(); // 현재 다리 맨 앞 칸 제거 (트럭이 건너감)
      currentWeight -= removed; // 현재 무게에서 빼기

      // 대기 트럭이 있고 다음 트럭이 올라올 수 있으면
      if (idx < truck_weights.length && currentWeight + truck_weights[idx] <= weight) {
        bridge.offer(truck_weights[idx]); // 다리에 현재 트럭 무게 추가
        currentWeight += truck_weights[idx]; // 현재 무게에 다리에 올라간 현재 트럭 무게 추가
        idx++;
      } else { // 두 조건이 모두 아니라면 즉, 못 올라오면
        bridge.offer(0); // 다리에 0 추가
      }
      time++; // 다리 지나는 시간 추가
    }
    return time;
  }

  public static void main(String[] args) {
    Queue_BridgeTruck p = new Queue_BridgeTruck();

    System.out.println(p.solution(2, 10, new int[] { 7, 4, 5, 6 }));
    // 기댓값: 8

    System.out.println(p.solution(100, 100, new int[] { 10 }));
    // 기댓값: 101

    System.out.println(p.solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }));
    // 기댓값: 110
  }
}
