package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

  public static void main(String[] args) {
    String patternStr =  "Hello";

    Pattern patternMatcher = Pattern.compile("(\\s|\\W)?"+patternStr+"(\\s|\\W)", Pattern.CASE_INSENSITIVE);

    List<String> strList = new ArrayList<String>();
    strList.add("hello? Message");
    strList.add("This is Hello Message ");
    strList.add("Hi Hellos.");
    strList.add("Hi [Hello]");
    strList.add("Hi Hello!!!");


    for(String str : strList) {
        Matcher matcher = patternMatcher.matcher(str);
        System.out.println(">> "+matcher.find());
    }
  }
  

}
