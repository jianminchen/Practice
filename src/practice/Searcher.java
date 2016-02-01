package practice;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Searcher {

  private static String filepath = null;
  private static final String defaultPath = "C://Users//sravis0//CODE//Practice//sample_text";

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

    System.out.println("Index based Search");

    IndexWordSearch countWords = new IndexWordSearch(list);
    countWords.search(toSearch);

    System.out.println("\nBrute Force Search");

    for (File file : list) {
      BruteForceSearch bSearch = new BruteForceSearch(file, toSearch);
      DisplaySearch(toSearch, bSearch);
    }
    
    System.out.println("\nRegEx Search");

    for (File file : list) {
      RegExSearch rSearch = new RegExSearch(file, toSearch);
      DisplaySearch(toSearch, rSearch);
    }

  }

  private static void DisplaySearch(String toSearch, BruteForceSearch search) {
    int count =0;
    if ( search.getCount(toSearch) > 0) {
      System.out.printf("%s - %s matches.%n", search.getFile(),
          search.getCount(toSearch));
      count++;
    }
    if (count == 0) {
      System.out.println("Empty Result Set");
    }
  }
    private static void DisplaySearch(String toSearch, RegExSearch search) {
      int count =0;

      if ( search.getCount(toSearch) > 0) {
        System.out.printf("%s - %s matches.%n", search.getFile(),
            search.getCount(toSearch));
        count++;
      }
      if (count == 0) {
        System.out.println("Empty Result Set");
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
