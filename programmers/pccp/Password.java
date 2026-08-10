import java.util.HashMap;

public class Password {
  public String solution(String password, String[] hints){
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < hints.length; i++) {
      String[] cur = hints[i].split(" ");
      String variable = "";
      for (int j = 0; j < cur.length; j++) {
        if (Character.isLetter(cur[j].charAt(0))) { // split 한 결과가 알파벳일때
          variable = cur[j];
        }
      }

      if (cur[0].equals(variable)) {
        int var1 = Integer.parseInt(cur[2]) - Integer.parseInt(cur[1]);
        int var2 = Integer.parseInt(cur[2]) + Integer.parseInt(cur[1]);

        if (var1 >= 0 && var1 <= 9 && var2 >= 0 && var2 <= 9) {
          map.put(variable, Math.max(var1, var2));
        } else if (var1 >= 0 && var1 <= 9) {
          map.put(variable, var1);
        } else if (var2 >= 0 && var2 <= 9) {
          map.put(variable, var2);
        }
      }
      if (cur[1].equals(variable)) {
        int var1 = Integer.parseInt(cur[2]) - Integer.parseInt(cur[0]);
        int var2 = Integer.parseInt(cur[0]) - Integer.parseInt(cur[2]);

        if (var1 >= 0 && var1 <= 9 && var2 >= 0 && var2 <= 9) {
          map.put(variable, Math.max(var1, var2));
        } else if (var1 >= 0 && var1 <= 9) {
          map.put(variable, var1);
        } else if (var2 >= 0 && var2 <= 9) {
          map.put(variable, var2);
        }
      }
      if (cur[2].equals(variable)) {
        int var1 = Integer.parseInt(cur[0]) + Integer.parseInt(cur[1]);
        int var2 = Integer.parseInt(cur[0]) - Integer.parseInt(cur[1]);

        if (var1 >= 0 && var1 <= 9 && var2 >= 0 && var2 <= 9) {
          map.put(variable, Math.max(var1, var2));
        } else if (var1 >= 0 && var1 <= 9) {
          map.put(variable, var1);
        } else if (var2 >= 0 && var2 <= 9) {
          map.put(variable, var2);
        }
      }
    }
    
    String answer = "";
    for (int i = 0; i < password.length(); i++) {
      String key = String.valueOf(password.charAt(i));
      answer += map.get(key);
    }

    return answer;
  }

  public static void main(String[] args) {
    Password p = new Password();
    System.out.println(p.solution("x", new String[] { "x 4 5" })); // 9
    System.out.println(p.solution("banana", new String[] { "9 n 7", "b 4 7", "3 3 a" })); // 362626
  }
}
