package retry;

import java.util.HashMap;
import java.util.Map;

/**
 * [프로그래머스] 가장 많이 받은 선물
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 * Level 1 | 2024 KAKAO WINTER INTERNSHIP
 * 해시맵 버전
 */

public class MostGifts_260624 {
  public int solution(String[] friends, String[] gifts) {
    Map<String, Map<String, Integer>> giveCount = new HashMap<>();
    Map<String, Integer> totalGive = new HashMap<>();
    Map<String, Integer> totalReceive = new HashMap<>();

    for (String name : friends) {
      giveCount.put(name, new HashMap<>());
      totalGive.put(name, 0);
      totalReceive.put(name, 0);
    }

    // 1단계: 기록 집계
    for (String gift : gifts) {
      String[] parts = gift.split(" ");
      String giver = parts[0];
      String receiver = parts[1];

      Map<String, Integer> map = giveCount.get(giver);
      map.put(receiver, map.getOrDefault(receiver, 0) + 1);

      totalGive.put(giver, totalGive.get(giver) + 1);
      totalReceive.put(receiver, totalReceive.get(receiver) + 1);
    }

    // 2단계: 선물 지수 계산
    Map<String, Integer> giftIndex = new HashMap<>();
    for (String name : friends) {
      giftIndex.put(name, totalGive.get(name) - totalReceive.get(name));
    }

    // 3단계: 다음 달 선물 시뮬레이션
    Map<String, Integer> nextMonthReceive = new HashMap<>();
    for (String name : friends) {
      nextMonthReceive.put(name, 0);
    }

    for (int i = 0; i < friends.length; i++) {
      for (int j = i + 1; j < friends.length; j++) {
        String A = friends[i];
        String B = friends[j];

        int aToB = giveCount.get(A).getOrDefault(B, 0);
        int bToA = giveCount.get(B).getOrDefault(A, 0);

        if (aToB > bToA) {
          nextMonthReceive.put(A, nextMonthReceive.get(A) + 1);
        } else if (bToA > aToB) {
          nextMonthReceive.put(B, nextMonthReceive.get(B) + 1);
        } else {
          // 주고받은 수가 같음(0 포함) -> 선물 지수 비교
          int indexA = giftIndex.get(A);
          int indexB = giftIndex.get(B);
          if (indexA > indexB) {
            nextMonthReceive.put(A, nextMonthReceive.get(A) + 1);
          } else if (indexB > indexA) {
            nextMonthReceive.put(B, nextMonthReceive.get(B) + 1);
          }
          // 지수도 같으면 아무도 안 받음
        }
      }
    }

    // 4단계: 최댓값 찾기
    int answer = 0;
    for (int value : nextMonthReceive.values()) {
      answer = Math.max(answer, value);
    }

    return answer;
  }

  public static void main(String[] args) {
    MostGifts_260624 mg = new MostGifts_260624();
    // 테스트 케이스 1
    String[] friends1 = { "muzi", "ryan", "frodo", "neo" };
    String[] gifts1 = { "muzi frodo", "muzi frodo", "ryan muzi",
        "ryan muzi", "ryan muzi", "frodo muzi",
        "frodo ryan", "neo muzi" };
    System.out.println(mg.solution(friends1, gifts1)); // 2

    // 테스트 케이스 2
    String[] friends2 = { "joy", "brad", "alessandro", "conan", "david" };
    String[] gifts2 = { "alessandro brad", "alessandro joy",
        "alessandro conan", "david alessandro",
        "alessandro david" };
    System.out.println(mg.solution(friends2, gifts2)); // 4

    // 테스트 케이스 3
    String[] friends3 = { "a", "b", "c" };
    String[] gifts3 = { "a b", "b a", "c a", "a c", "a c", "c a" };
    System.out.println(mg.solution(friends3, gifts3)); // 0
  }
}
