/**
 * [프로그래머스] 카드뭉치
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 * Level 1 | 연습문제
 */
public class CardDeck {
  public static String solution(
      String[] cards1,
      String[] cards2,
      String[] goal) {

    int index1 = 0;
    int index2 = 0;

    for (String word : goal) {

      if (index1 < cards1.length
          && cards1[index1].equals(word)) {

        index1++;

      } else if (index2 < cards2.length
          && cards2[index2].equals(word)) {

        index2++;

      } else {

        return "No";
      }
    }

    return "Yes";
  }

  public static void main(String[] args) {

    // Test 1
    String[] cards1 = { "i", "drink", "water" };
    String[] cards2 = { "want", "to" };
    String[] goal = { "i", "want", "to", "drink", "water" };

    System.out.println(solution(cards1, cards2, goal));
    // Expected: Yes

    // Test 2
    String[] cards3 = { "i", "water", "drink" };
    String[] cards4 = { "want", "to" };
    String[] goal2 = { "i", "want", "to", "drink", "water" };

    System.out.println(solution(cards3, cards4, goal2));
    // Expected: No

    // Test 3
    String[] cards5 = { "a", "b", "c" };
    String[] cards6 = { "d", "e" };
    String[] goal3 = { "a", "b", "d", "e", "c" };

    System.out.println(solution(cards5, cards6, goal3));
    // Expected: Yes

    // Test 4
    String[] cards7 = { "a", "b", "c" };
    String[] cards8 = { "d", "e" };
    String[] goal4 = { "a", "c", "d" };

    System.out.println(solution(cards7, cards8, goal4));
    // Expected: No
  }
}
