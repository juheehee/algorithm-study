/**
 * [프로그래머스] 문자열 곱하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181940
 * Level 0 | 연습문제
 */
public class RepeatString {
  public String solution(String my_string, int k) {
        String answer = "";
        for (int i = 0; i < k; i++) {
            answer += my_string;
        }
        return answer;
    }

    public static void main(String[] args) {
        RepeatString rs = new RepeatString();
        System.out.println(rs.solution("string", 3));  // stringstringstring
        System.out.println(rs.solution("love", 10));   // lovelovelovelovelovelovelovelovelovelove
    }
}
