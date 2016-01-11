package DP;

public class TextJustification {

  public static void main(String[] args) {
    TextJustification justify = new TextJustification();
    String input = "The quick brown fox jumps over the lazy dog.";
    int lenght = 52;
    String output = justify.justifyText(input, lenght);
    System.out.println(output);
  }

  private String justifyText(String input, int width) {

   String[] words = input.split(" ");
    
    int[][] badnessCost = new int[words.length][words.length];

    // Find the badness badnessCost to put the words i to j in one line
    for (int i = 0; i < words.length; i++) {
      for (int j = i; j <words.length; j++) {
        badnessCost[i][j] = calcualtebadness(words, i, j, width);
      }
    }

    int[] minimumCost = new int[words.length];  //stores minimum cost
    int[] result = new int[words.length];   //final result

    for (int i = words.length - 1; i >= 0; i--) {
      minimumCost[i] = badnessCost[i][words.length - 1];
      result[i] = words.length;
      for (int j = words.length - 1; j > i; j--) {
        if (badnessCost[i][j - 1] == Integer.MAX_VALUE) {
          continue;
        }
        if (minimumCost[i] > minimumCost[j] + badnessCost[i][j - 1]) {
          minimumCost[i] = minimumCost[j] + badnessCost[i][j - 1];
          result[i] = j;
        }
      }
    }
   
    int i = 0;
    int j;

   //result
    StringBuilder builder = new StringBuilder();
    do {
      j = result[i];
      for (int k = i; k < j; k++) {
        builder.append(words[k] + " ");
      }
      builder.append("\n");
      i = j;
    } while (j < words.length);

    return builder.toString();
  }

  
  private int calcualtebadness(String[] words, int start, int end, int width) {

    int total = 0;
    for (int i = start; i <=end;i++ ){
      total = total + words[i].length();
    }
    total = total + end - start +1; //for space
    if (total > width) {
      total = Integer.MAX_VALUE;
    } 
    else {
    ///System.out.println("i = " +start+ " j = " +end+" total= " +total);
      total = (int) Math.pow(width-total, 3);
    }
    return total;
  }

}
