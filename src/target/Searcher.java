package target;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.sun.org.glassfish.gmbal.Description;

/**
 * @author Shalini
 * 
 *         Description : The goal of this exercise is to create a working
 *         program in Java to search relevant documents / files for the given
 *         search term, and return results in order of relevance. Relevance is
 *         defined as number of times the exact term appears in the document.
 * 
 */
public class Searcher {

  private String filepath = null;
  private static final String defaultPath = "sample_text"; //default file path
  private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";  //used to generate random words 
  private static final int LIMIT = 2000000; //limit for performance testing
  private static Set<File> list = new HashSet<File>();

  private Searcher() {
    this.setFilepath(defaultPath);
  }

  private Searcher(String dir) {
    if (dir.isEmpty()) {
      this.setFilepath(defaultPath);
    } else {
      this.setFilepath(dir);
    }
  }

  // unit test cases
  public static void main(String[] args) throws IOException {
    Searcher search = new Searcher();
    // search.performanceTesting();

    String folderToSearch = search.getFilepath();

    File folder = new File(folderToSearch);
    search.getFiles(folder);

    //check if there is no file in the given path
    if (!list.isEmpty()) {
      //pre-process the files to store the words in a hashmap
      IndexWordSearch countWords = new IndexWordSearch(list);
      search.displayMenu(countWords);
    } else {
      System.out.println("\nNo Files to Search");
    }

  }

  //displays menu to choose the type of search to be performed
  private void displayMenu(IndexWordSearch countWords) throws IOException {

    Scanner input = new Scanner(System.in);

    System.out.println("1. Brute Force Search");
    System.out.println("2. Using RegEx Search");
    System.out.println("3. Index Based Search");
    System.out.println("4. Unit Testing");
    System.out.println("5. Exit\n");
    System.out.println("\nEnter the Option :");

    int option = Integer.parseInt(input.nextLine());
    if (option == 4) {
      System.out.println("Testing is in Progress -----\n");
      unitTesting(countWords);
      continueApp(countWords);
    } else if (option == 5) {
      System.exit(0);
    } else {
      System.out.println("\nEnter the text to Search : ");
      String inputText = input.nextLine();
      if (inputText.length() < 1) {
        System.out.println("\nNo String to search!!");
      } else {
        getSearchMethod(option, inputText, countWords);
      }
    }
  }

  //get the appropriate search method based on the user's option
  private void getSearchMethod(int option, String toSearch,
      IndexWordSearch countWords) throws IOException {

    switch (option) {
    case 1:
      System.out.println("\nBrute Force Search Results");
      bruteForce(toSearch);
      continueApp(countWords);
      break;
    case 2:
      System.out.println("\nRegEx Search Results");
      regEx(toSearch);
      continueApp(countWords);
      break;
    case 3:
      System.out.println("\n Index Based Search Results");
      countWords.search(toSearch);
      continueApp(countWords);
      break;
    default:
      System.out.println("\nInvalid option\n");
      continueApp(countWords);
    }

  }

  //unit test cases
  private void unitTesting(IndexWordSearch countWords) throws IOException {

    String[] searchList = { "The", "Forest", "", "Earth" };

    for (String toSearch : searchList) {

      if (toSearch.length() > 0) {

        System.out.println("\nSearching for the term = " + toSearch);

        System.out.println("\nIndex based Search");
        countWords.search(toSearch);

        System.out.println("\nBrute Force Search");
        bruteForce(toSearch);

        System.out.println("\nRegEx Search");
        regEx(toSearch);
      } else {
        System.out.println("\nNo String to search!!");
      }
    }

  }

  //Text search using the regex API in Java
  private void regEx(String toSearch) throws IOException {
    for (File file : list) {
      RegExSearch rSearch = new RegExSearch(file, toSearch);
      rSearch.searchWord();
    }
  }

  //Brute-force text searcher
  private void bruteForce(String toSearch) throws IOException {
    for (File file : list) {
      BruteForceSearch bSearch = new BruteForceSearch(file, toSearch);
      bSearch.searchWord();
    }
  }

  private void continueApp(IndexWordSearch countWords) throws IOException {
    System.out.println("\nDo you want to continue(Y/N) ? ");
    Scanner input = new Scanner(System.in);
    char wish = input.next().charAt(0);

    switch (wish) {
    case 'Y':
      displayMenu(countWords);
      break;
    case 'N':
      System.exit(0);
      break;
    default:
      System.out.println("Invalid option\n");
      continueApp(countWords);
    }

  }

  //helper method to get the files from the given path
  private void getFiles(File folder) {

    folder.setReadOnly();
    if (folder.exists()) {
      File[] files = folder.listFiles();
      for (int j = 0; j < files.length; j++) {
        list.add(files[j]);
        if (files[j].isDirectory())
          getFiles(files[j]);
      }
    } else {
      System.out.println("Incorrect Path!!");
    }
  }

  // helper method used to fetch a random term - for performance testing
  private static String getRandomString(int len) {

    Random rnd = new Random();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++)
      sb.append(ALPHA.charAt(rnd.nextInt(ALPHA.length())));
    return sb.toString();
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

}
