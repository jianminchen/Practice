package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFile {

  private static String filepath = null;
  private static final String defaultPath = "D://Prepations//Practice//sample_text";
  private static HashMap<String, ArrayList<HashMap<String, HashMap<Integer, ArrayList<Integer>>>>> fmap =
      new HashMap<String, ArrayList<HashMap<String, HashMap<Integer, ArrayList<Integer>>>>>();
  private static List<File> list = null;
  private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final int LIMIT = 2000000;


  // <word,<filename, <count, position[]>>>

  private SearchFile() {
    this.filepath = defaultPath;
  }

  private SearchFile(String dir) {
    if (dir.isEmpty()) {
      this.filepath = defaultPath;
    } else {
      this.filepath = dir;
    }
  }

  public static void main(String[] args) throws IOException {

    SearchFile search = new SearchFile();

    String folderToSearch = search.filepath;

    File folder = new File(folderToSearch);
    list = new ArrayList<File>();
    search.getFiles(folder);
    search.processFile();
    // System.out.println("list.size = " + list.size());
    search.displayMenu();
  }

  private static void displayMenu() throws IOException {

    Scanner input = new Scanner(System.in);

    if (!list.isEmpty()) {
      System.out.println("Enter the Option :");
      System.out.println("1. Brute Force Search");
      System.out.println("2. Using RegEx Search");
      System.out.println("3. Effiecient Search");
      System.out.println("4. Performace Testing");
      System.out.println("5. Exit\n");
      int option = Integer.parseInt(input.nextLine());
      System.out.println("\nEnter the text to Search : ");
      String inputText = input.nextLine();
      if (inputText.length() < 1) {
        System.out.println("\nNo String to search!!");
      } else {
        searcher(option, inputText);
      }

    } else {
      System.out.println("\nNo Files to Search");
    }
  }

  public static void searcher(int option, String text) throws IOException {

    switch (option) {
      case 1:
        HashMap<String, Integer> result = bruteForceSearch(text);
          if (!result.isEmpty()) {
            System.out.println("\nBrute Force Search Result for the given term " + text + " = >\n");
            for (String file : result.keySet()) {
              System.out.println(file + " - " + result.get(file) + " matches ");
            }
          } else {
            System.out.println("\nEmpty Result Set \n");
          }
        continueApp();
        break;
      case 2:
        HashMap<String, Integer> temp = regExSearch(text);
        if (!temp.isEmpty()) {
          System.out.println("\nRegEx Search Results for the given term " + text + " = >\n");
          for (String file : temp.keySet()) {
            System.out.println(file + " - " + temp.get(file) + " matches ");
          }
        } else {
          System.out.println("\nEmpty Result Set \n");
        }
        continueApp();
        break;
      case 3:
        System.out.println("Search");
        hashMapSearch(text);
        continueApp();
        break;
      case 4:
        System.out.println("Tesiting is in Progress -----");
        performanceTesting();
        continueApp();
        break;
      case 5:
        System.exit(0);
        break;
      default:
        System.out.println("\nInvalid option\n");
        continueApp();
    }

  }

  private static void continueApp() throws IOException {
    System.out.println("\nDo you want to continue(Y/N) ? ");
    Scanner input = new Scanner(System.in);
    char wish = input.next().charAt(0);

    switch (wish) {
      case 'Y':
        displayMenu();
        break;
      case 'N':
        System.exit(0);
        break;
      default:
        System.out.println("Invalid option\n");
        continueApp();
    }

  }

  private void getFiles(File folder) {

    folder.setReadOnly();
    File[] files = folder.listFiles();
    for (int j = 0; j < files.length; j++) {
      list.add(files[j]);
      if (files[j].isDirectory())
        getFiles(files[j]);
    }
  }

  private static HashMap<String, Integer> bruteForceSearch(String stringToLookFor)
      throws IOException {

    HashMap<String, Integer> result = new HashMap<String, Integer>();
    for (File file : list) {
      String fileName = file.getName();
      // System.out.println(fileName);
      FileInputStream fstream = new FileInputStream(file);
      BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
      String readLine = "";
      int count = 0;
      while ((readLine = in.readLine()) != null) {
        String[] words = readLine.split("\\W");
        for (String text : words) {
          if (text.equalsIgnoreCase(stringToLookFor)) {
            count++;
          }
        }
      }
      if (count != 0) {
        result.put(fileName, count);
      }

      in.close();
    }

    return result;

  }

  private static HashMap<String, Integer> regExSearch(String stringToLookFor) throws IOException {

    HashMap<String, Integer> result = new HashMap<String, Integer>();
    Pattern patternMatcher =
        Pattern.compile("(\\s|\\W)?" + stringToLookFor + "(\\s|\\W)", Pattern.CASE_INSENSITIVE);
    for (File file : list) {
      String fileName = file.getName();
      // System.out.println(fileName);
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
        result.put(fileName, count);
      }

      in.close();
    }

    return result;

  }

  // <word,<filename, <count, position[]>>> something like this

  private void processFile() throws IOException {

    int fcount = 0;
    for (File file : list) {
      String fileName = file.getName();
      // System.out.println(fileName);
      FileInputStream fstream = new FileInputStream(file);
      BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
      String readLine = "";
      int pos = 0;
      while ((readLine = in.readLine()) != null) {
        ArrayList<HashMap<String, HashMap<Integer, ArrayList<Integer>>>> fList;
        String[] words = readLine.split("\\W");

        for (String newWord : words) {

          String word = newWord.toLowerCase();
          ArrayList<Integer> position = null;
          HashMap<Integer, ArrayList<Integer>> value = null;
          HashMap<String, HashMap<Integer, ArrayList<Integer>>> fnameWithCount = null;

          if (fmap.containsKey(word)) {
            fList = fmap.get(word);

            for (int i = 0; i < fList.size(); i++) {
              if (fList.get(i).containsKey(fileName)) {
                fnameWithCount = getMap(fList, fileName);
              }
            }

            int newCount = 1;
            if (fnameWithCount != null) {
              value = fnameWithCount.get(fileName);
              for (int prevcount : value.keySet()) {
                newCount = prevcount + 1;
                value.put(newCount, value.remove(prevcount));
              }
              value.get(newCount).add(pos);
            } else {
              position = new ArrayList<Integer>(); // position array
              position.add(pos);

              value = new HashMap<Integer, ArrayList<Integer>>();
              value.put(1, position);

              fnameWithCount = new HashMap<String, HashMap<Integer, ArrayList<Integer>>>();
              fnameWithCount.put(fileName, value);

              fList.add(fnameWithCount);
              fmap.put(word, fList);
            }


          } else {
            position = new ArrayList<Integer>(); // position array
            position.add(pos);

            value = new HashMap<Integer, ArrayList<Integer>>();
            value.put(1, position);

            fnameWithCount = new HashMap<String, HashMap<Integer, ArrayList<Integer>>>();
            fnameWithCount.put(fileName, value);

            fList = new ArrayList<HashMap<String, HashMap<Integer, ArrayList<Integer>>>>();
            fList.add(fnameWithCount);

            fmap.put(word, fList);

          }

          pos++;
        }
      }
      fcount++;
    }

  }

  private HashMap<String, HashMap<Integer, ArrayList<Integer>>> getMap(
      ArrayList<HashMap<String, HashMap<Integer, ArrayList<Integer>>>> fList, String fileName) {


    for (int i = 0; i < fList.size(); i++) {
      if (fList.get(i).containsKey(fileName)) {
        return fList.get(i);

      }
    }

    return null;
  }

  public static void hashMapSearch(String stringToLookFor) throws IOException {

    if (fmap.containsKey(stringToLookFor.toLowerCase())) {
  /*    for (int i = 0; i < fmap.get(stringToLookFor.toLowerCase()).size(); i++) {
        String name = (String) fmap.get(stringToLookFor.toLowerCase()).get(i).keySet().toArray()[0];
        int count = (Integer) fmap.get(stringToLookFor.toLowerCase()).get(i).get(name).keySet()
            .toArray()[0];
        System.out.println(name + " - " + count + " matches ");
        
      }

    } else {
      System.out.println("\nEmpty Result Set \n");
      */
      return;
    }

  }
  
  
  private static void performanceTesting() throws IOException {
    
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

      String text = getRandomString(length);
      
      startTimeBruteForce = System.currentTimeMillis() ;

      bruteForceSearch(text);

      endTimeBruteForce = System.currentTimeMillis() ;
      
      totalTimeBruteForce = (endTimeBruteForce - startTimeBruteForce) + totalTimeBruteForce;
      
      startTimeRegEx = System.currentTimeMillis() ;

      regExSearch(text);

      endTimeRegEx = System.currentTimeMillis();
      
      totalTimeRegEx = (endTimeRegEx - startTimeRegEx) + totalTimeRegEx;

      
      startTimeHashMap = System.currentTimeMillis();

      hashMapSearch(text);

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
