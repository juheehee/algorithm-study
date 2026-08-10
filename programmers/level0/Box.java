public class Box {
  public static void main(String[] args) {
    Box sol = new Box();

    System.out.println(sol.solution(47, 12)); // 4개 (12+12+12+11)
    System.out.println(sol.solution(36, 12)); // 3개 (12+12+12)
    System.out.println(sol.solution(1, 12)); // 1개
    System.out.println(sol.solution(100, 7)); // 15개
  }

  public int solution(int items, int boxSize) {
    // TODO: 올림 공식 (정수로!)
    return (items + boxSize - 1) / boxSize;
  }
}
