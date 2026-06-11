import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [프로그래머스] 중요한 단어를 스포 방지
 * https://school.programmers.co.kr/learn/courses/30/lessons/468370
 * Level 1 | 2025 카카오 하반기 1차
 */
public class ImportantWordSpoilerPrevention {
  public int solution(String message, int[][] spoiler_ranges) {
    int answer = 0;

    // 1. message 파싱 → {word, start, end} 리스트
    List<int[]> wordInfo = new ArrayList<>(); // [start, end]
    List<String> words = new ArrayList<>();
    int i = 0;
    while (i < message.length()) {
      if (message.charAt(i) == ' ') {
        i++;
        continue;
      }
      int j = i;
      while (j < message.length() && message.charAt(j) != ' ')
        j++;
      words.add(message.substring(i, j));
      wordInfo.add(new int[] { i, j - 1 });
      i = j;
    }

    // 2. 각 단어가 스포 구간에 걸치는지 체크
    boolean[] isSpoiler = new boolean[words.size()];
    for (int w = 0; w < words.size(); w++) {
      int ws = wordInfo.get(w)[0], we = wordInfo.get(w)[1];
      for (int[] range : spoiler_ranges) {
        if (we >= range[0] && ws <= range[1]) {
          isSpoiler[w] = true;
          break;
        }
      }
    }

    // 3. 비-스포 구간 단어 HashSet 만들기
    Set<String> nonSpoilerSet = new HashSet<>();
    for (int w = 0; w < words.size(); w++) {
      if (!isSpoiler[w])
        nonSpoilerSet.add(words.get(w));
    }

    // 4. 스포 구간 단어 순서대로 순회하면서 중요 단어 카운트
    Set<String> seen = new HashSet<>();
    for (int w = 0; w < words.size(); w++) {
      if (!isSpoiler[w])
        continue;
      String word = words.get(w);
      if (!nonSpoilerSet.contains(word) && !seen.contains(word)) {
        answer++;
      }
      seen.add(word);
    }

    return answer;
  }

  public static void main(String[] args) {
    ImportantWordSpoilerPrevention s = new ImportantWordSpoilerPrevention();
    System.out.println(s.solution("here is muzi here is a secret message", new int[][] { { 0, 3 }, { 23, 28 } })); // 1
    System.out.println(s.solution("my phone number is 01012345678 and may i have your phone number",
        new int[][] { { 5, 5 }, { 25, 28 }, { 34, 40 }, { 53, 59 } })); // 4
  }
}
