package level2;

/**
 * [프로그래머스] 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Level 2 | 연습문제
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Process {
  public int solution(int[] priorities, int location) {
    // 1. 큐에 [인덱스, 우선순위] 쌍으로 넣기
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < priorities.length; i++) {
      queue.add(new int[]{i, priorities[i]});
    }

    // 2. 우선순위 복사본 정렬 + 포인터 설정
    int[] sorted = priorities.clone();
    Arrays.sort(sorted);
    int pointer = sorted.length - 1; // 뒤에서부터 시작

    int answer = 0; // 실행된 순서를 세는 카운터

    // 3. 큐가 빌 때까지 반복
    while (!queue.isEmpty()) {
      // 1. 큐 하나를 꺼냄.
      int[] front = queue.poll();

      // 2. 우선순위가 더 높은 프로세스가 있다면 다시 넣기(뒤로 보내기)
      if (front[1] < sorted[pointer]) {
        queue.add(front);
      } else {
        // 3. 그런 프로세스가 없다면 방금 꺼낸 프로세스 실행
        answer++;
        pointer--; // 다음 최고 우선순위로 이동

        // location 프로세스가 실행되면 순서 반환
        if (front[0] == location) {
          return answer;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Process p = new Process();

    // 예제 1: 정답 1
    System.out.println(p.solution(new int[] { 2, 1, 3, 2 }, 2));

    // 예제 2: 정답 5
    System.out.println(p.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
  }
}
