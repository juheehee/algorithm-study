package level3.retry;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

/**
 * [프로그래머스] 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * Level 3 | 연습문제
 */
public class WordConversion_260906 {

  public int solution(String begin, String target, String[] words) {
    // 1. target이 words에 없으면 애초에 도달 불가능
    boolean targetMatch = false;
    for (String word : words) {
      if (word.equals(target)) {
        targetMatch = true;
        break;
      }
    }
    if (!targetMatch) {
      return 0;
    }

    // 2. BFS 준비
    Queue<Node> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.add(new Node(begin, 0));
    visited.add(begin);

    // 3. 큐가 빌 때까지 반복
    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.word.equals(target)) {
        return now.distance;
      }

      for (String word : words) {
        if (!visited.contains(word) && isOneCharDiff(now.word, word)) {
          visited.add(word);
          queue.add(new Node(word, now.distance + 1));
        }
      }
    }

    return 0; // 못 찾으면 (target 존재해서 여긴 사실상 안 옴)
  }
  
  // 두 단어가 정확히 한 글자만 다른지 확인
  private boolean isOneCharDiff(String a, String b) {
    int sameCount = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) {
        sameCount++;
      }
    }
    return sameCount == a.length() - 1;
  }

  static class Node {
    String word;
    int distance;

    public Node(String word, int distance) {
      this.word = word;
      this.distance = distance;
    }
  }
  
  public static void main(String[] args) {
    WordConversion_260906 solver = new WordConversion_260906();

    String begin1 = "hit";
    String target1 = "cog";
    String[] words1 = { "hot", "dot", "dog", "lot", "log", "cog" };
    System.out.println(solver.solution(begin1, target1, words1)); // 예상: 4

    String begin2 = "hit";
    String target2 = "cog";
    String[] words2 = { "hot", "dot", "dog", "lot", "log" };
    System.out.println(solver.solution(begin2, target2, words2)); // 예상: 0 (cog 없음)
  }
}