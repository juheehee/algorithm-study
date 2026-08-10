public class Cinema {
  public static void main(String[] args) {
    Cinema sol = new Cinema();

    // (성인, 회원, VIP)
    System.out.println(sol.solution(20, true, false)); // true (성인+회원)
    System.out.println(sol.solution(20, false, false)); // false (성인이지만 비회원)
    System.out.println(sol.solution(15, false, true)); // true (미성년이지만 VIP)
    System.out.println(sol.solution(15, true, false)); // false (미성년+비VIP)
    System.out.println(sol.solution(25, true, true)); // true (모두 만족)
  }

  public boolean solution(int age, boolean isMember, boolean isVIP) {
    // TODO: (나이 >= 19 AND 회원) OR VIP
    if ((age >= 19 && isMember) || (isVIP)) {
      return true;
    }

    return false;
  }
}
