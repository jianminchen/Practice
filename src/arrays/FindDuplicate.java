package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    FindDuplicate find = new FindDuplicate();
    List<Integer> a = new ArrayList<Integer>();
    a.add(1);
    a.add(2);
    a.add(4);
    a.add(2);
    a.add(4);
      System.out.print(find.repeatedNumber(a));
    }
  

  public int repeatedNumber(final List<Integer> a) {

    int result =0;
    int n = a.size();

   boolean[] array = new boolean[n];
   
   for( int i: a){
     if(array[i] == false) {
       array[i] = true;
     } 
     else {
       result = i;
       break;
     }
   }

    return result;
  }

}
