package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FiatCurrency {

  public static void main(String[] args) throws IOException {
    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
    String line;
    ArrayList<String> lines = new ArrayList<String>();
    line = bi.readLine();
    while (line != null && line.length() != 0) {
      lines.add(line);
      line = bi.readLine();
    }


    System.out.println(processLine(lines));
  }


  private static int processLine(ArrayList<String> lines) {

    int total = Integer.parseInt(lines.get(0));
    int buy = 0;
    int sell = 0;
    for (int i = 1; i < lines.size(); i++) {

      String[] temp = lines.get(i).split(" ");

      if (temp[1].equals("buy")) {
        buy = buy + Integer.parseInt(temp[0]);
      }

      if (temp[1].equals("sell")) {

        sell = sell + Integer.parseInt(temp[0]);
      }


    }


    return (total - buy + sell);
  }

}
