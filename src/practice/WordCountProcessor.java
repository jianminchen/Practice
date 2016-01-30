package practice;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordCountProcessor {
  
  private final Set<WordSearch> results;

  public WordCountProcessor(Set<File> set) throws IOException {
      Set<WordSearch> results = new HashSet<WordSearch>();
      for (File file : set) {
          results.add(new FileSearch(file));
      }
      this.results = Collections.unmodifiableSet(results);
  }

  public void search(String word) {
      boolean isEmptyResults = true;
      for (WordSearch counter : results) {
          System.out.printf("%s - %s matches.%n",
                              counter.getFile(), counter.getCount(word));
          isEmptyResults = false;
      }
      if (isEmptyResults) {
          System.out.println("No results.");
      }
  }
}
