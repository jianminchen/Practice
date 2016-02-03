package target;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilePreprocess extends WordSearch {
  
  private final String fileName;
  private final Map<String, List<Integer>> wordOccurrenceInLines;

  public FilePreprocess(File file) throws IOException {
    this.fileName = file.getName();
    this.wordOccurrenceInLines = processFile(file);

  }

  // stores the words as index and position as list. 
  // position list makes easy if we need to search for a line(in future)
  private Map<String, List<Integer>> processFile(File file) throws IOException {

    Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
    List<Integer> position = null;
    FileInputStream fstream = new FileInputStream(file);
    BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
    String readLine = "";
    int pos = 0;
    while ((readLine = in.readLine()) != null) {
      String[] words = readLine.split("\\W");
      for (String newWord : words) {
        String word = newWord.toLowerCase();

        if (result.containsKey(word)) {
          position = result.get(word);
          position.add(pos);
        } else {
          position = new ArrayList<Integer>();
          position.add(pos);
        }
        result.put(word, position);
        pos++;
      }
    }
    return result;
  }

  public String getFile() {
    return fileName;
  }

  public int getCount(String word) {
    List<Integer> list = wordOccurrenceInLines.get(word.toLowerCase());
    return list == null ? 0 : list.size();
  }

}
