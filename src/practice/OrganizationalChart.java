package practice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationalChart {

  private static HashMap<String, ArrayList<String>> bossDict = null;
  private static HashMap<String, ArrayList<String>> empDict = null;
  private static PrintWriter out = null;

  private static class Employee {

    private String name;
    private String boss;
    private String role;
    private String year;

    private Employee(String emp) {

      String[] empInfo = emp.split(",");

      this.name = empInfo[0];
      this.boss = empInfo[1];
      this.role = empInfo[2];
      this.year = empInfo[3];

    }

  }

  public static void main(String[] args) throws IOException {

    try {
      BufferedReader reader = new BufferedReader(new FileReader(
          "input.in"));
      out = new PrintWriter(new FileWriter("output.out"));

      int n = Integer.parseInt(reader.readLine());
     // System.out.println(n);

      for (int i = 0; i < n; i++) {
        String tempLine = reader.readLine();
        bossDict = new HashMap<String, ArrayList<String>>();
        empDict = new HashMap<String, ArrayList<String>>();

        out.println("Case #" + (i + 1));
        String[] cases = tempLine.split("--");
        for (String temp : cases) {
          ArrayList<String>  empList = new ArrayList<String>();
          Employee em = new Employee(temp);
          empList.add(em.role);
          empList.add(em.year);
          empDict.put(em.name, empList);

          if (bossDict.get(em.boss) == null) {
            bossDict.put(em.boss, new ArrayList<String>());
          }

          bossDict.get(em.boss).add(em.name);

        }
        writetoFile("NULL", 0);
        // System.out.println(case_output);
      }
      out.close();
      reader.close();
      System.out.println("Check the output file!!");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static void writetoFile(String boss, int level) {

    if (bossDict.containsKey(boss)) {

     // System.out.println(boss + " " + level);

      for (String value : bossDict.get(boss)) {

        /*
         * case_output += levelToDash(level) + value + " (" +
         * empDict.get(value).get(0) + ") " + empDict.get(value).get(1) + "\n";
         */
        out.println(levelToDash(level) + value + " ("
            + empDict.get(value).get(0) + ") " + empDict.get(value).get(1));

        writetoFile(value, level + 1);
      }

    }

  }

  private static String levelToDash(int level) {

    String dash = "";

    while (level > 0) {
      dash = dash + "-";
      level--;
    }

    return dash;

  }

}
