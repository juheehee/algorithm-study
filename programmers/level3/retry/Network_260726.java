public class Network_260726 {
  // ===== 방식 1: 전역 count++ =====
  static int count = 0;

  public int solutionByCount(int[] numbers, int target) {
    count = 0; // 여러 번 호출될 걸 대비해 초기화
    dfsCount(0, 0, numbers, target);
    return count;
  }

  private void dfsCount(int index, int sum, int[] numbers, int target) {
    // 종료 조건: 숫자를 다 썼을 때 (트리의 잎)
    if (index == numbers.length) {
      if (sum == target) {
        count++;
      }
      return; // 값을 return하지 않고 그냥 빠져나옴 -> count는 밖에서 이미 늘어나 있음
    }
    // 재귀 케이스: + 가지, - 가지 둘 다 반드시 탐색
    dfsCount(index + 1, sum + numbers[index], numbers, target);
    dfsCount(index + 1, sum - numbers[index], numbers, target);
  }

  // ===== 방식 2: 리턴값 누적 =====
  public int solution(int[] numbers, int target) {
    return dfs(0, 0, numbers, target);
  }

  private int dfs(int index, int sum, int[] numbers, int target) {
    // 종료 조건: 잎에서 성공이면 1표, 실패면 0표
    if (index == numbers.length) {
      return sum == target ? 1 : 0;
    }
    // 재귀 케이스: 왼쪽(+) 서브트리 표 + 오른쪽(-) 서브트리 표
    return dfs(index + 1, sum + numbers[index], numbers, target)
        + dfs(index + 1, sum - numbers[index], numbers, target);
  }

  public static void main(String[] args) {
    Network_260726 sol = new Network_260726();
    int[] numbers1 = { 1, 1, 1, 1, 1 };
    int target1 = 3;
    System.out.println(sol.solutionByCount(numbers1, target1)); // 5
    System.out.println(sol.solution(numbers1, target1)); // 5

    int[] numbers2 = { 4, 1, 2, 1 };
    int target2 = 4;
    System.out.println(sol.solutionByCount(numbers2, target2)); // 2
    System.out.println(sol.solution(numbers2, target2)); // 2
  }
}
