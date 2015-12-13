package practice;

/*
 * A sequence of numbers is called a zig-zag sequence if the differences between successive numbers
 * strictly alternate between positive and negative. The first difference (if one exists) may be
 * either positive or negative. A sequence with fewer than two elements is trivially a zig-zag
 * sequence.
 * 
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are
 * alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag
 * sequences, the first because its first two differences are positive and the second because its
 * last difference is zero.
 * 
 * Given a sequence of integers, sequence, return the length of the longest subsequence of sequence
 * that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements
 * (possibly zero) from the original sequence, leaving the remaining elements in their original
 * order.
 */

/**
 * @author Shalini
 *
 */
public class ZigZag {

  public static void main(String[] args) {

    int[] seqArray = {1, 7, 4, 9, 2, 5};
    int res = longestZigZag(seqArray);
    System.out.println(res);
  }

  public static int longestZigZag(int[] seqArray) {
    int n = seqArray.length;
    int[][] zigzag = new int[n][2];
    // zigzag [i][0] = zigzag subsequence with positive difference
    // zigzag [i][1] = zigzag subsequence with negative difference

    if (n == 1) {
      return 1;
    } else {

      int best = 1;

      for (int i = 0; i < n; i++) {
        zigzag[i][0] = 1;
        zigzag[i][1] = 1;

        for (int j = 0; j <= i - 1; j++) {

          if (seqArray[i] - seqArray[j] > 0) // positive difference
          {
            zigzag[i][0] = Math.max(zigzag[j][1] + 1, zigzag[i][0]);
          } else if (seqArray[i] - seqArray[j] < 0) // negative difference
          {
            zigzag[i][1] = Math.max(zigzag[j][0] + 1, zigzag[i][1]);

          }

          best = Math.max(best, Math.max(zigzag[i][0], zigzag[i][1]));
        }
      }
      return best;

    }
  }

}
