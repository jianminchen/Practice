package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements WordSearch {

  private final String fileName;
  private final String text;

  private Map<String, Integer> result = new HashMap<String, Integer>();
  private File file;

  public RegExSearch(File file, String text) throws IOException {
    this.fileName = file.getName();
    this.text = text;
    this.file = file;

  }

  private Map<String, Integer> searchHelper()
      throws IOException {

    Map<String, Integer> tempResult = new HashMap<String, Integer>();
    Pattern patternMatcher =
        Pattern.compile("(\\s|\\W)?" + text + "(\\s|\\W)", Pattern.CASE_INSENSITIVE);
    
    FileInputStream fstream = new FileInputStream(file);
    BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
    String readLine = "";
    int count = 0;
    while ((readLine = in.readLine()) != null) {
      Matcher regexMatcher = patternMatcher.matcher(readLine);
      while (regexMatcher.find()) {
        count++;
      }
    }

    if (count != 0) {
      tempResult.put(text.toLowerCase(), count);
    }

    in.close();

    return tempResult;
  }

  public String getFile() {
    return fileName;
  }

  public int getCount(String word) {
    if (result.containsKey(word.toLowerCase())) {
      return result.get(word.toLowerCase());
    }
    return 0;
  }
  
  public void search() {
    try {
     this.result  = searchHelper();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if ( getCount(text) > 0) {
      getCount(text);
      /*System.out.printf("%s - %s matches.%n", getFile(),
          getCount(text));*/
      return;
    }
  }
  
}
