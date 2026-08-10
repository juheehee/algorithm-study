import java.util.Arrays;

public class example {
  public int[] solution(int[][] arr, int a, int b, int c, int d) {
    int n = arr.length; // 행 길이
    int m = arr[0].length; // 열 길이
    int[] result = new int[n]; // 행 길이만큼 결과 배열 만들기

    for (int i = 0; i < n; i++) {
      int distance = 0;
      boolean found = false;
      for (int j = 0; j < m; j++) {
        distance += arr[i][j];
        int electricCost = a + distance * c;
        int gasolineCost = b + distance * d;
        if (electricCost < gasolineCost) { // 내연차보다 전기차가 작을 때 누적합
          result[i] = j + 1;
          found = true;
          break;
        }
      }
      if (!found) {
        result[i] = -1;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    example ec = new example();
    int[][] arr = { { 110, 111, 112, 113 }, { 80, 35, 75, 20 }, { 1, 2, 3, 4 }, { 100, 100, 0, 100 },
        { 100, 100, 0, 0 } };
    int[] result = ec.solution(arr, 200000, 100000, 400, 900);
    System.out.println(Arrays.toString(result)); // [2, 4, -1, 4, -1]
  }
}
