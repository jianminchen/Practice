package linkedList;

import java.util.HashMap;
import java.util.Map;

public class CloneWithRandomPointer {

  
  private static class RandomListNode {
        int label;
        RandomListNode next, random;
        
        RandomListNode(int x)  { 
      this.label = x; 
      }
  }
    

  private static RandomListNode clone(RandomListNode head) {
    // Initialize two references, one with original
    // list's head.
    RandomListNode origCurr = head;
    RandomListNode cloneCurr = null;

    // Hash map which contains node to node mapping of
    // original and clone linked list.
    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    // Traverse the original list and make a copy of that
    // in the clone linked list.
    while (origCurr != null)
    {
        cloneCurr = new RandomListNode(origCurr.label);
        map.put(origCurr, cloneCurr);
        origCurr = origCurr.next;
    }

    // Adjusting the original list reference again.
    origCurr = head;

    // Traversal of original list again to adjust the next
    // and random references of clone list using hash map.
    while (origCurr != null)
    {
        cloneCurr = map.get(origCurr);
        cloneCurr.next = map.get(origCurr.next);
        cloneCurr.random = map.get(origCurr.random);
        origCurr = origCurr.next;
    }

    //return the head reference of the clone list.
    return map.get(head);
}
}
