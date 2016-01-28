package arrays;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
  public ArrayList<ArrayList<Integer>> generate(int n) {
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

   if (n <=0) {
     return result;
   }
   
   ArrayList<Integer> previous = new ArrayList<Integer>();
   
   previous.add(1);
   result.add(previous);
   
   for (int i =2; i <= n; i++) {
     ArrayList<Integer> current = new ArrayList<Integer>();
     
     current.add(1); //first
     for (int j = 0; j < previous.size() - 1; j++) {
       current.add(previous.get(j) + previous.get(j + 1)); //middle
     }
     current.add(1);//last
      
     result.add(current);
     previous = current;
   }
   
    return result;
    
  }

}
