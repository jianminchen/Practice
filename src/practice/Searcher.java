package practice;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Searcher {

  private static String filepath = null;
  private static final String defaultPath = "D://Prepations//Practice//sample_text";

  private Searcher() {
    this.filepath = defaultPath;
  }

  private Searcher(String dir) {
    if (dir.isEmpty()) {
      this.filepath = defaultPath;
    } else {
      this.filepath = dir;
    }
  }

  public static void main(String[] args) throws IOException {
    Searcher search = new Searcher();

    String folderToSearch = search.filepath;

    File folder = new File(folderToSearch);
    Set<File> list = new HashSet<File>();
    search.getFiles(folder, list);

    String toSearch = "The";

  //  WordCountProcessor countWords = new WordCountProcessor(list);
   // countWords.search(toSearch.toLowerCase());
    
    for (File file : list) {
     BruteForceSearch bSerch = new BruteForceSearch(file);
     bSerch.search(toSearch);
    }
  }

  private void getFiles(File folder, Set<File> list) {

    folder.setReadOnly();
    File[] files = folder.listFiles();
    for (int j = 0; j < files.length; j++) {
      list.add(files[j]);
      if (files[j].isDirectory())
        getFiles(files[j], list);
    }
  }

}
