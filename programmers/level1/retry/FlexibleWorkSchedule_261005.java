package retry;

/**
 * [프로그래머스] 유연근무제
 * https://school.programmers.co.kr/learn/courses/30/lessons/388351
 * Level 1 | 구현
 */
public class FlexibleWorkSchedule_261005 {
  public int solution(int[] schedules, int[][] timelogs, int startday) {
    int answer = 0;

    for (int i = 0; i < schedules.length; i++) {
      int schedule = schedules[i];

      int deadline = (schedule / 100) * 60 + (schedule % 100) + 10;

      boolean success = true;

      for (int j = 0; j < 7; j++) {
        int day = (startday - 1 + j) % 7 + 1;

        if (day == 6 || day == 7) {
          continue;
        }

        int time = timelogs[i][j];

        int actual = (time / 100) * 60 + (time % 100);

        if (actual > deadline) {
          success = false;
          break;
        }
      }

      if (success) {
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    FlexibleWorkSchedule_261005 solution = new FlexibleWorkSchedule_261005();

    // 테스트 1: 공식 예제 1
    int[] schedules1 = { 700, 800, 1100 };
    int[][] timelogs1 = {
        { 710, 2359, 1050, 700, 650, 631, 659 },
        { 800, 801, 805, 800, 759, 810, 809 },
        { 1105, 1001, 1002, 600, 1059, 1001, 1100 }
    };

    System.out.println(solution.solution(schedules1, timelogs1, 5));
    // 기대값: 3

    // 테스트 2: 공식 예제 2
    int[] schedules2 = { 730, 855, 700, 720 };
    int[][] timelogs2 = {
        { 710, 700, 650, 735, 700, 931, 912 },
        { 908, 901, 805, 815, 800, 831, 835 },
        { 705, 701, 702, 705, 710, 710, 711 },
        { 707, 731, 859, 913, 934, 931, 905 }
    };

    System.out.println(solution.solution(schedules2, timelogs2, 1));
    // 기대값: 2

    // 테스트 3: 8:55 + 10분 = 9:05 확인
    int[] schedules3 = { 855 };
    int[][] timelogs3 = {
        { 905, 905, 905, 905, 905, 1200, 1200 }
    };

    System.out.println(solution.solution(schedules3, timelogs3, 1));
    // 기대값: 1

    // 테스트 4: 마감시간보다 1분 늦음
    int[] schedules4 = { 855 };
    int[][] timelogs4 = {
        { 906, 900, 900, 900, 900, 700, 700 }
    };

    System.out.println(solution.solution(schedules4, timelogs4, 1));
    // 기대값: 0

    // 테스트 5: 주말 지각은 상관없음
    int[] schedules5 = { 900 };
    int[][] timelogs5 = {
        { 900, 900, 900, 900, 900, 2359, 2359 }
    };

    System.out.println(solution.solution(schedules5, timelogs5, 1));
    // 기대값: 1

    // 테스트 6: 일요일부터 시작 → 요일 순환 확인
    int[] schedules6 = { 900 };
    int[][] timelogs6 = {
        { 2359, 900, 900, 900, 900, 900, 2359 }
    };

    System.out.println(solution.solution(schedules6, timelogs6, 7));
    // 일 / 월 / 화 / 수 / 목 / 금 / 토
    // 기대값: 1
  }
}
