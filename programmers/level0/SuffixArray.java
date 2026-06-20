import java.util.Arrays;
/**
 * [프로그래머스] 접미사 배열
 * https://school.programmers.co.kr/learn/courses/30/lessons/181909
 * Level 0 | 연습문제
 */
public class SuffixArray {
  public String[] solution(String my_string) {
    String[] answer = new String[my_string.length()];

    for (int i = 0; i < my_string.length(); i++) {
      answer[i] = my_string.substring(i);
    }

    Arrays.sort(answer);

    return answer;
  }

  public static void main(String[] args) {

    SuffixArray sol = new SuffixArray();

    String my_string1 = "banana";
    System.out.println(Arrays.toString(sol.solution(my_string1)));

    String my_string2 = "programmers";
    System.out.println(Arrays.toString(sol.solution(my_string2)));
  }
}
