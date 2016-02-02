package target;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shalini
 *
 */
public class IndexWordSearch {

  private final Set<WordSearch> results;

  //pre process the files to store the words as index
  public IndexWordSearch(Set<File> set) throws IOException {
    Set<WordSearch> results = new HashSet<WordSearch>();
    for (File file : set) {
      results.add(new FilePreprocess(file));
    }
    this.results = Collections.unmodifiableSet(results);

  }

  //takes constant time to fetch the term form the hashmap
  public void search(String word) {
    boolean isEmptyResults = true;
    for (WordSearch counter : results) {
      counter.search(counter.getFile(), counter.getCount(word));
      isEmptyResults = false;
    }
    if (isEmptyResults) {
      System.out.println("No results.");
    }
  }
}
