package target;


 /**
 * @author Shalini
 * 
 * Parent class used by the derived search classes
 *
 */
abstract class WordSearch {

  abstract public String getFile();
  abstract public int getCount(String term);
   public void search(String fileName, int count) {
     System.out.printf("%s - %s matches.%n", fileName, count);
  }
}