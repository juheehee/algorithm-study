
import java.util.Arrays;

/**
 * [프로그래머스] 덧칠하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 * Level 1 | 연습문제
 */
public class WallPainting {

    public int solution(int n, int m, int[] section) {
        int count = 0;
        int paintedEnd = 0;

        for (int current : section) {
            if (current > paintedEnd) {
                count++;
                paintedEnd = current + m - 1;
            }
        }

        return count;
    }

    public static void test(
            int n,
            int m,
            int[] section,
            int expected) {

        // 객체 생성 후 solution 호출
        WallPainting wallPainting = new WallPainting();
        int actual = wallPainting.solution(n, m, section);

        System.out.println(
                "n=" + n +
                ", m=" + m +
                ", section=" + Arrays.toString(section));

        System.out.println(
                "Expected: " + expected +
                ", Actual: " + actual);

        if (expected == actual) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println("--------------------");
    }

    public static void main(String[] args) {

        // 프로그래머스 예제
        test(8, 4, new int[]{2, 3, 6}, 2);
        test(5, 4, new int[]{1, 3}, 1);
        test(4, 1, new int[]{1, 2, 3, 4}, 4);

        // 추가 테스트
        test(10, 3, new int[]{1, 2, 3}, 1);
        test(10, 3, new int[]{1, 4, 7, 10}, 4);
        test(10, 5, new int[]{2, 4, 5}, 1);
        test(10, 2, new int[]{1, 3, 5}, 3);
        test(100000, 100000, new int[]{1, 100000}, 1);
    }
}
