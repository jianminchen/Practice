package target;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shalini
 *
 */
public class BruteForceSearch extends WordSearch {

  private final String fileName;
  private final String text;

  private Map<String, Integer> result = new HashMap<String, Integer>();
  private File file;

  public BruteForceSearch(File file, String text) throws IOException {
    this.fileName = file.getName();
    this.text = text;
    this.file = file;

  }

  // Bruteforce way - checks if the search term occurs in the given file
  private Map<String, Integer> searchHelper() throws IOException {

    Map<String, Integer> tempResult = new HashMap<String, Integer>();

    FileInputStream fstream = new FileInputStream(file);
    BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
    String readLine = "";
    int count = 0;
    while ((readLine = in.readLine()) != null) {
      String[] words = readLine.split("\\W");
      for (String word : words) {
        if (word.equalsIgnoreCase(text)) {
          count++;
        }
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

  public void serachWord() {
    try {
      this.result = searchHelper();
      super.search(getFile(), getCount(text));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
