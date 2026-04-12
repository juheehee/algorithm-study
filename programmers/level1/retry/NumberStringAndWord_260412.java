package retry;

/**
 * [프로그래머스] 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * Level 1 | 2021 카카오 채용연계형 인턴십
 */
public class NumberStringAndWord_260412 {
  public int solution(String s) {
    s = s.replace("zero", "0");
    s = s.replace("one", "1");
    s = s.replace("two", "2");
    s = s.replace("three", "3");
    s = s.replace("four", "4");
    s = s.replace("five", "5");
    s = s.replace("six", "6");
    s = s.replace("seven", "7");
    s = s.replace("eight", "8");
    s = s.replace("nine", "9");

    return Integer.parseInt(s);
  }

  public static void main(String[] args) {
    NumberStringAndWord_260412 sol = new NumberStringAndWord_260412();

    System.out.println(sol.solution("one4seveneight")); // 1478
    System.out.println(sol.solution("23four5six7")); // 234567
    System.out.println(sol.solution("2three45sixseven"));// 234567
    System.out.println(sol.solution("123")); // 123
  }
}
