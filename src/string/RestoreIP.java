package string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
  
  //Brute Force
  public static List<String> restoreIpAddresses(String s) {

    List<String> res = new ArrayList<String>();  
    if (s.length() > 12 || s.length() < 4) return res;
    for (int i = 1; i < 4; i ++) {
        String first = s.substring(0, i);
        if (! isValid(first)) continue;
        for (int j = 1; i + j < s.length() && j < 4; j ++) {
            String second = s.substring(i, i + j);
            if (! isValid(second)) continue;
            for (int k = 1; i + j + k < s.length() && k < 4; k ++) {
                String third = s.substring(i + j, i + j + k);
                String fourth = s.substring(i + j + k);
                if (isValid(third) && isValid(fourth))  {
                    res.add(first + "." + second + "." + third + "." + fourth);

            }
           }
        }
    }
    return res;
}  

 //dfs
 public static ArrayList<String> restoreIpAddressesDFS(String s) {
    ArrayList<String> res = new ArrayList<String>();  
    if (s.length()<4||s.length()>12) return res;  
    dfs(s,"",res,0);  
    return res;  
}  

private static void dfs(String s, String tmp, ArrayList<String> res, int count){  
    if (count == 3 && isValid(s)) {  
        res.add(tmp + s);  
        return;  
    }  
    for(int i=1; i<4 && i<s.length(); i++){  
        String substr = s.substring(0,i);  
        if (isValid(substr)){  
            dfs(s.substring(i), tmp + substr + '.', res, count+1);  
        }  
    }  
}
private static boolean isValid(String s) {
    if (s.length() > 1 && s.charAt(0) == '0') return false;
    return 0 <= Integer.parseInt(s) && Integer.parseInt(s) <= 255;  
} 

public static void main(String[] args) {
  System.out.println(restoreIpAddressesDFS("25525511135").toString());
}
}
