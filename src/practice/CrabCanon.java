package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CrabCanon {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);    String line;
    ArrayList<String> lines = new ArrayList<String>();
    line = input.nextLine();
    while (line != null && line.length() != 0) {
      lines.add(line);
      line = input.nextLine();
    }


    for (int i = 0 ; i <lines.size(); i = i+2) {

      System.out.println(processLine(lines.get(i),lines.get(i+1)));
    }
  }

  private static String processLine(String string, String string2) {

    String result = null;
    StringBuilder stringBuilder = new StringBuilder(string2);
    
    if(string.equals(stringBuilder.reverse().toString())){
      result = "yes";
    }
    else {
      result ="no";
    }
    
    
    
    return result;
  }
}
