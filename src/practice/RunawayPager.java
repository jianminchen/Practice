package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class RunawayPager {

  public static void main(String[] args) throws IOException {
    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
    String line;
    ArrayList<String> lines = new ArrayList<String>();
    line = bi.readLine();
    while (line != null && line.length() != 0) {
      lines.add(line);
      line = bi.readLine();
    }

    for (String l : lines) {

      System.out.println(processLine(l));
    }
  }

  private static String processLine(String l) {


    int length = l.length();


    int count = 1;
    String temp = "";
    for (int i = 0; i < length; i++) {
      if ((i != length - 1) && (l.charAt(i) == l.charAt(i + 1))) {
        count++;
      } else {
        if (count == 1) {
          temp += l.charAt(i) + "";
        } else{
          temp += l.charAt(i) + "" + count;
          count = 1;
        }



      }



    }

    return temp;
  }

}
