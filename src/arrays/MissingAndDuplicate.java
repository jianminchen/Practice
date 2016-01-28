package arrays;

import java.util.ArrayList;
import java.util.List;

/*You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
 */
public class MissingAndDuplicate {

  public static void main(String[] args) {
    MissingAndDuplicate find = new MissingAndDuplicate();
    List<Integer> a = new ArrayList<Integer>();
    a.add(1);
    a.add(2);
    a.add(2);
    a.add(4);
    a.add(5);
    List<Integer> b = find.repeatedNumber(a);

    for (int i : b) {
      System.out.print(" " + i);
    }
  }

  public ArrayList<Integer> repeatedNumber(final List<Integer> a) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    int length = a.size();

    int sum = 0;
    int count = 0;
    int duplicate = 0;
    for (int i : a) {
      duplicate += i * i;
      sum += i;
    }

    int square = (length * (length + 1) * (2 * length + 1)) / 6;
    int totalCount = (length * (length + 1)) / 2;
    int sumDiff = sum - totalCount;
    int squareDiff = duplicate - square;

    int repeated = 0;
    int missing = 0;

    int temp = squareDiff / sumDiff;

    missing = (temp - sumDiff) / 2;
    repeated = temp - missing;

    // System.out.println("Repeated = "+repeated );
    // System.out.println("missing= "+missing );

    result.add(repeated);
    result.add(missing);

    return result;
  }

}
