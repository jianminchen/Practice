package practice;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Searcher {

  private static String filepath = null;
  private static final String defaultPath = "C://Users//sravis0//CODE//Practice//sample_text";
  private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static final int LIMIT = 2000000;

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
    search.performanceTesting();

    /*   String folderToSearch = search.filepath;

    File folder = new File(folderToSearch);
    Set<File> list = new HashSet<File>();
    search.getFiles(folder, list);

    String toSearch = "The";

    System.out.println("\nIndex based Search");

    IndexWordSearch countWords = new IndexWordSearch(list);
    countWords.search(toSearch);

    System.out.println("\nBrute Force Search");
    for (File file : list) {
      BruteForceSearch bSearch = new BruteForceSearch(file, toSearch);
      bSearch.search();
    }

    System.out.println("\nRegEx Search");
    for (File file : list) {
      RegExSearch rSearch = new RegExSearch(file, toSearch);
      rSearch.search();
    }
*/
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
  
private  void performanceTesting() throws IOException {
  
  File folder = new File(defaultPath);
  Set<File> list = new HashSet<File>();
  getFiles(folder, list);
    Random rnd = new Random();
    long startTimeBruteForce = 0;
    long endTimeBruteForce =0;
    long totalTimeBruteForce =0;

    
    long startTimeRegEx = 0;
    long endTimeRegEx =0;
    long totalTimeRegEx  =0;

    
    long startTimeHashMap = 0;
    long endTimeHashMap =0;
    long totalTimeHashMap =0;


    System.out.println("Performance Testing \n");
    for (int i =0; i<LIMIT ;i++) {
      
      int length = rnd.nextInt(10) + 1;

      String toSearch = getRandomString(length);
      
      startTimeBruteForce = System.currentTimeMillis() ;

      for (File file : list) {
        BruteForceSearch bSearch = new BruteForceSearch(file, toSearch);
        bSearch.search();
      }
      endTimeBruteForce = System.currentTimeMillis() ;
      
      totalTimeBruteForce = (endTimeBruteForce - startTimeBruteForce) + totalTimeBruteForce;
      
      startTimeRegEx = System.currentTimeMillis() ;

      for (File file : list) {
        RegExSearch rSearch = new RegExSearch(file, toSearch);
        rSearch.search();
      }
      endTimeRegEx = System.currentTimeMillis();
      
      totalTimeRegEx = (endTimeRegEx - startTimeRegEx) + totalTimeRegEx;


      IndexWordSearch countWords = new IndexWordSearch(list);
      
      startTimeHashMap = System.currentTimeMillis();
     
      countWords.search(toSearch);

      endTimeHashMap = System.currentTimeMillis();
      
      totalTimeHashMap = (endTimeHashMap - startTimeHashMap) + totalTimeHashMap;

    }
    
    System.out.println("BruteForce took " + totalTimeBruteForce + " milliseconds");
    System.out.println("RegEx took " + totalTimeRegEx + " milliseconds");
    System.out.println("HashMap took " + totalTimeHashMap + " milliseconds");
    }
    
    private static String getRandomString(int len) {
      
      Random rnd = new Random();
       StringBuilder sb = new StringBuilder(len);
       for( int i = 0; i < len; i++ ) 
          sb.append( ALPHA.charAt( rnd.nextInt(ALPHA.length()) ) );
       return sb.toString();
    }

}
