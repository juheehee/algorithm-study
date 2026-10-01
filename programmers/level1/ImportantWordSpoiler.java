import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [프로그래머스] 중요한 단어를 스포 방지
 * https://school.programmers.co.kr/learn/courses/30/lessons/468370
 * Level 1 | 연습문제
 */

public class ImportantWordSpoiler {
  public int solution(String message, int[][] spoiler_ranges) {
    int n = message.length();

    // 1. 각 문자가 몇 번째 스포 구간에 포함되는지 기록
    // -1이면 스포 구간이 아님
    int[] spoiler = new int[n];
    Arrays.fill(spoiler, -1);

    for (int i = 0; i < spoiler_ranges.length; i++) {
      int start = spoiler_ranges[i][0];
      int end = spoiler_ranges[i][1];

      for (int j = start; j <= end; j++) {
        spoiler[j] = i;
      }
    }

    // 스포가 아닌 일반 구간에서 등장한 단어
    Set<String> normalWords = new HashSet<>();

    // 각 스포 구간을 클릭했을 때 완전히 공개되는 단어
    List<List<String>> revealedWords = new ArrayList<>();

    for (int i = 0; i < spoiler_ranges.length; i++) {
      revealedWords.add(new ArrayList<>());
    }

    // 2. message를 단어 단위로 탐색
    int start = 0;

    while (start < n) {
      int end = start;

      while (end < n && message.charAt(end) != ' ') {
        end++;
      }

      String word = message.substring(start, end);

      boolean isSpoilerWord = false;
      int revealRange = -1;

      // 이 단어에 포함된 스포 구간 중
      // 가장 마지막에 클릭되는 구간을 찾는다.
      for (int i = start; i < end; i++) {
        if (spoiler[i] != -1) {
          isSpoilerWord = true;
          revealRange = Math.max(revealRange, spoiler[i]);
        }
      }

      if (!isSpoilerWord) {
        // 스포가 전혀 적용되지 않은 단어
        normalWords.add(word);
      } else {
        // 이 스포 구간을 클릭했을 때 단어 전체가 공개됨
        revealedWords.get(revealRange).add(word);
      }

      start = end + 1;
    }

    // 3. 스포 구간을 왼쪽 → 오른쪽 순서로 클릭
    Set<String> revealed = new HashSet<>();

    int answer = 0;

    for (List<String> words : revealedWords) {
      for (String word : words) {

        // 일반 구간에서 등장하지 않았고
        // 이전에 공개된 스포 단어와 중복되지 않으면 중요한 단어
        if (!normalWords.contains(word)
            && !revealed.contains(word)) {
          answer++;
        }

        // 중요 여부와 상관없이 공개된 단어에는 추가
        revealed.add(word);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    ImportantWordSpoiler sol = new ImportantWordSpoiler();

    String message1 = "here is muzi here is a secret message";
    int[][] spoilerRanges1 = { { 0, 3 }, { 23, 28 } };
    int result1 = sol.solution(message1, spoilerRanges1);
    System.out.println(result1);

    String message2 = "my phone number is 01012345678 and may i have your phone number";
    int[][] spoilerRanges2 = { { 5, 5 }, { 25, 28 }, { 34, 40 }, { 53, 59 } };
    int result2 = sol.solution(message2, spoilerRanges2);
    System.out.println(result2);
  }
}
