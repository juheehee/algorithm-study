import java.util.ArrayList;

public class SliceList {
  public int[] solution(int n, int[] slicer, int[] num_list) {
    ArrayList<Integer> list = new ArrayList<>();

    switch (n) {
      case 1:
        for (int i = 0; i <= slicer[1]; i++) {
          list.add(num_list[i]);
        }
        break;

      case 2:
        for (int i = slicer[0]; i < num_list.length; i++) {
          list.add(num_list[i]);
        }
        break;

      case 3:
        for (int i = slicer[0]; i <= slicer[1]; i++) {
          list.add(num_list[i]);
        }
        break;

      case 4:
        for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
          list.add(num_list[i]);
        }
        break;
    }

    int[] answer = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    SliceList sol = new SliceList();

    // 예제 1
    int[] result1 = sol.solution(
        3,
        new int[] { 1, 5, 2 },
        new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    System.out.println(java.util.Arrays.toString(result1));

    // 예제 2
    int[] result2 = sol.solution(
        4,
        new int[] { 1, 5, 2 },
        new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    System.out.println(java.util.Arrays.toString(result2));

    // n = 1
    int[] result3 = sol.solution(
        1,
        new int[] { 1, 5, 2 },
        new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    System.out.println(java.util.Arrays.toString(result3));

    // n = 2
    int[] result4 = sol.solution(
        2,
        new int[] { 1, 5, 2 },
        new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    System.out.println(java.util.Arrays.toString(result4));
  }
}
