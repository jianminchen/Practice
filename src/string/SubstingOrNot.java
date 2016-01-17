package string;

public class SubstingOrNot {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  // iterative
  boolean isSubSequence(String string1, String string2)

  {

    char[] str1 = string1.toCharArray();
    char[] str2 = string2.toCharArray();

    int m = str1.length;
    int n = str2.length;
    int j = 0;

    // Traverse str2 and str1, and compare current character

    // of str2 with first unmatched char of str1, if matched

    // then move ahead in str1

    for (int i = 0; i < n && j < m; i++)

      if (str1[j] == str2[i])

        j++;



    // If all characters of str1 were found in str2

    return (j == m);

  }

  boolean isSubSequenceRecurion(char str1[], char str2[], int m, int n)

  {

    // Base Cases

    if (m == 0)
      return true;

    if (n == 0)
      return false;



    // If last characters of two strings are matching

    if (str1[m - 1] == str2[n - 1])

      return isSubSequenceRecurion(str1, str2, m - 1, n - 1);



    // If last characters are not matching

    return isSubSequenceRecurion(str1, str2, m, n - 1);

  }

}
