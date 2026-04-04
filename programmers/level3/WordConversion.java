package level3;

/**
 * [프로그래머스] 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * Level 3 | 연습문제
 */
import java.util.LinkedList;
import java.util.Queue;

public class WordConversion {
  public int solution(String begin, String target, String[] words) {
    Queue<String[]> queue = new LinkedList<>(); // 큐 선언
    queue.offer(new String[] { begin, "0" }); // 큐 초기화 [단어, 횟수]
    boolean[] visited = new boolean[words.length]; // 방문 확인 배열

    // bfs 루프(최소)
    while (!queue.isEmpty()) { // 큐가 비어있지 않을동안
      String[] polled = queue.poll();
      String cur = polled[0]; // 꺼낸 큐의 단어부분 저장
      int count = Integer.parseInt(polled[1]); // 꺼낸 큐의 횟수 부분이 문자열이라 변환해 저장

      for (int i = 0; i < words.length; i++) { // words 순회
        int diff = 0; // 한 글자 차이 판별 변수
        for (int j = 0; j < words[i].length(); j++) { // 단어의 해당 인덱스의 한 글자씩 판별
          // 현재 단어의 한 글자와 words의 한 글자가 다를 때
          if (cur.charAt(j) != words[i].charAt(j)) {
            diff++;
          }
        }
        // 한 글자 차이이면서 방문하지 않았다면
        if (diff == 1 && !visited[i]) {
          visited[i] = true; // 방문했다로 바꾸고
          if (words[i].equals(target)) // 만약 target에 도달했다면
            return count + 1; // 몇 단계를 거쳤는지 출력
          queue.offer(new String[] { words[i], String.valueOf(count + 1) }); // 큐에 추가, 숫자 → 문자열 (넣을 때)
        }
      }
    }
    return 0; // target으로 변환 불가능한 경우
  }

  public static void main(String[] args) {
    WordConversion wc = new WordConversion();

    // 예제 1: 정답 4
    System.out.println(wc.solution("hit", "cog",
        new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));

    // 예제 2: target이 words에 없음, 정답 0
    System.out.println(wc.solution("hit", "cog",
        new String[] { "hot", "dot", "dog", "lot", "log" }));
  }
}
