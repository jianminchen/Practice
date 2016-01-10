package tree;
import tree.PathSum.TreeNode;

public class CreateBST {
  
  //Definition for singly-linked list.
 public static ListNode rootHead;

  public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

  public TreeNode sortedArrayToBST(int[] nums) {
    
    if(nums.length == 0) return null;
    
    else {
      int start = 0;
      int end = nums.length - 1;
      return arrayToBST(nums, start, end);
    }
    
  }

  //Time O(N)
  private TreeNode arrayToBST(int[] nums, int start, int end) {
    
    if(start > end) {
      return null;
    }
    
    int mid = (start+end)/2;
    
    TreeNode root = new TreeNode(nums[mid]);
    TreeNode left = arrayToBST(nums, start, mid -1);
    TreeNode right =  arrayToBST(nums, mid +1, end);
    root.setLeft(left);
    root.setRight(right);
    return root;
  }
  
  //Bottom up O(N)
  /* Recursively construct left sub­tree from start to mid-1
  Make the mid­dle node as root and assign the left sub­tree to it.
  Recursively construct right sub­tree from mid+1 to end.
  Assign the right sub­tree to root.*/
  public TreeNode sortedListToBST(ListNode head) {
    
    if (head == null) {
      return null;
    }
    int n = getSize(head);
    rootHead = head;
    return sortedListToBST (0, n-1);
    
  }
  private TreeNode sortedListToBST(int start, int end) {

    if (start > end) return null;
    
    int mid = (start + end)/2;
    
    TreeNode left = sortedListToBST(start,mid-1);
    TreeNode root = new TreeNode(rootHead.val);
    rootHead = rootHead.next;
    TreeNode right = sortedListToBST(mid+1,end);
    
    root.setLeft(left);
    root.setRight(right);
    
    return root;

  
  }

  private int getSize(ListNode head) {
    int n =0;
    
    while (head !=null) {
      n++;
      head = head.next;
    }
    return n;
  }

  public static void main(String[] args) {

  }

}
