package level2;

/**
 * [프로그래머스] 문자열 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * Level 2 | 2020 KAKAO BLIND RECRUITMENT
 */

// (완전탐색 + 구현)
public class StringCompression {
  public int solution(String s) {
    int answer = s.length();

    // 1. size(자르는 단위) 1 ~ n/2 탐색
    for (int size = 1; size <= s.length() / 2; size++) {
      StringBuilder sb = new StringBuilder();

      String prev = s.substring(0, size);
      int count = 1;

      // 2. i += size 단위로 이동하며 substring 덩어리 비교
      for (int i = size; i < s.length(); i += size) {
        String next = s.substring(i, Math.min(i + size, s.length()));

        // 3. prev와 같으면 count 증가
        if (prev.equals(next)) {
          count++;
        } else {
          // 4. 다르면 count + prev 결과에 추가
          if (count > 1)
            sb.append(count);
          sb.append(prev);

          prev = next;
          count = 1;
        }
      }

      // 5. 마지막 prev 처리
      if (count > 1)
        sb.append(count);
      sb.append(prev);

      // 6. 최소 길이 갱신
      answer = Math.min(answer, sb.length());
    }
    return answer;
  }

  public static void main(String[] args) {
    StringCompression sol = new StringCompression();

    System.out.println(sol.solution("aabbaccc")); // 7
    System.out.println(sol.solution("ababcdcdababcdcd")); // 9
    System.out.println(sol.solution("abcabcdede")); // 8
    System.out.println(sol.solution("abcabcabcabcdededededede")); // 14
    System.out.println(sol.solution("xababcdcdababcdcd")); // 17
  }
}
