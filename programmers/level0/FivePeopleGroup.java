import java.util.List;
import java.util.ArrayList;;
/**
 * [프로그래머스] 5명씩
 * https://school.programmers.co.kr/learn/courses/30/lessons/181886
 * Level 0 | 연습문제
 */
public class FivePeopleGroup {
  public String[] solution(String[] names) {
    List<String> answer = new ArrayList<>();

    for (int i = 0; i < names.length; i += 5) {
      answer.add(names[i]);
    }

    return answer.toArray(new String[0]);
  }

  public static void main(String[] args) {
    FivePeopleGroup sol = new FivePeopleGroup();

    String[] names1 = {
        "nami", "ahri", "jayce", "garen",
        "ivern", "vex", "jinx"
    };
    System.out.println(java.util.Arrays.toString(sol.solution(names1)));
    // [nami, vex]

    String[] names2 = {
        "a", "b", "c", "d", "e"
    };
    System.out.println(java.util.Arrays.toString(sol.solution(names2)));
    // [a]

    String[] names3 = {
        "a", "b", "c", "d", "e",
        "f", "g", "h", "i", "j"
    };
    System.out.println(java.util.Arrays.toString(sol.solution(names3)));
    // [a, f]

    String[] names4 = {
        "a", "b", "c", "d", "e",
        "f", "g", "h", "i", "j",
        "k", "l"
    };
    System.out.println(java.util.Arrays.toString(sol.solution(names4)));
    // [a, f, k]
  }
}
