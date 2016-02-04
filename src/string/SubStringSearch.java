package string;

public class SubStringSearch {

  public static void main(String[] args) {
    SubStringSearch str = new SubStringSearch();
    int index = str.strStr("aaaabbbbbccccccccc", "bc");
    System.out.println(index);
  }

  // naive approach O(MN)
  public int strStr(final String haystack, final String needle) {

    int m = haystack.length();
    int n = needle.length();

    if (n == 0) {
      return -1;
    } else if (n > m) {
      return -1;
    } else if (n == m) {
      if (haystack.equals(needle)) {
        return 0;
      } else {
        return -1;
      }
    } else {
      for (int i = 0, j = 0; i < m && j < n; i++) {
        if (haystack.charAt(i) == needle.charAt(j)) {
          j++;
        } else {
          i = i - j;
          j = 0;
        }


        if (j == n) {
          return i - n + 1; // return index
        }
      }
      return -1;
    }
  }

}
