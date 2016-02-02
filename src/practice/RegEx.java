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
    String patternStr =  "3";

    Pattern patternMatcher = Pattern.compile("\\b"+Pattern.quote(patternStr)+"\\b", Pattern.CASE_INSENSITIVE);

    List<String> strList = new ArrayList<String>();
    strList.add("3? Message");
    strList.add("This is 3 Message ");
    strList.add("Hi 33.");
    strList.add("Hi [3]");
    strList.add("Hi 3!!!");


    for(String str : strList) {
        Matcher matcher = patternMatcher.matcher(str);
        System.out.println(">> "+matcher.find());
    }
  }
  

}
