/**
 * [프로그래머스] 글자 지우기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181900
 * Level 0
 */
public class DeleteCharacters {
  public String solution(String my_string, int[] indices) {
    boolean[] deleted = new boolean[my_string.length()];

    for (int idx : indices) {
      deleted[idx] = true;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < my_string.length(); i++) {
      if (!deleted[i]) {
        sb.append(my_string.charAt(i));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    DeleteCharacters sol = new DeleteCharacters();

    String myString = "apporoograpemmemprs";
    int[] indices = { 1, 16, 6, 15, 0, 10, 11, 3 };

    System.out.println(sol.solution(myString, indices));
    // programmers
    System.out.println(sol.solution("abcde", new int[] { 1, 3 }));
    // ace
    System.out.println(sol.solution("hello", new int[] { 0 }));
    // ello
  }
}
