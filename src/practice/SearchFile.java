package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFile {

  private static String filepath = null;
  private static final String defaultPath = "C://Personal//sample_text";

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
    Scanner input = new Scanner(System.in);

    String folderToSearch = search.filepath;

    File folder = new File(folderToSearch);
    List<File> list = new ArrayList<File>();
    search.getFiles(folder, list);
//    System.out.println("list.size = " + list.size());
    if (!list.isEmpty()) {
      System.out.println("Enter the Option :");
      System.out.println("1 . Brute Force Search");
      System.out.println("2 . Using RegEx Search");
      System.out.println("3 . Effiecient Search");
      System.out.println("4 . Exit");
      int option = Integer.parseInt(input.nextLine());
      System.out.println("Enter the text to Search : ");
      String inputText = input.nextLine();
      if (inputText.length() < 1) {
        System.out.println("No String to search!!");
      } else {
        search.Searcher(option, inputText, list);
      }

    } else {
      System.out.println("No Files to Search");
    }
  }

  public void Searcher(int option, String text, List<File> list)
      throws IOException {

    switch (option) {
    case 1:
      System.out.println("Brute Force Search");
      HashMap<String, Integer> result = bruteForceSearch(text, list);
      for (String file : result.keySet()) {
        System.out.println(file + " - " + result.get(file) + " matches ");
      }
      break;
    case 2:
      System.out.println("RegEx Search");
      HashMap<String, Integer> temp = regExSearch(text, list);
      for (String file : temp.keySet()) {
        System.out.println(file + " - " + temp.get(file) + " matches ");
      }
      break;
    case 3:
      System.out.println("Search");
      break;
    case 4:
      System.exit(0);
      break;
    default:
      System.out.println("Invalid option");
    }

  }

  private void getFiles(File folder, List<File> list) {

    folder.setReadOnly();
    File[] files = folder.listFiles();
    for (int j = 0; j < files.length; j++) {
      list.add(files[j]);
      if (files[j].isDirectory())
        getFiles(files[j], list);
    }
  }

  private static HashMap<String, Integer> bruteForceSearch(
      String stringToLookFor, List<File> list) throws IOException {

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

  private static HashMap<String, Integer> regExSearch(String stringToLookFor,
      List<File> list) throws IOException {

    HashMap<String, Integer> result = new HashMap<String, Integer>();
   // Pattern patternMatcher = Pattern.compile(stringToLookFor,Pattern.CASE_INSENSITIVE);
    Pattern patternMatcher = Pattern.compile("(\\s|\\W)"+stringToLookFor+"(\\s|\\W)", Pattern.CASE_INSENSITIVE);
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

}
