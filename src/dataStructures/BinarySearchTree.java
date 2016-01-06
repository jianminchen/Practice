package dataStructures;

import java.util.Stack;



public class BinarySearchTree {

  private Node root;

  private static class Node {
    private int item;
    private Node left;
    private Node right;

    private Node(int item) {
      this.item = item;
      left = null;
      right = null;
    }


  }

  public BinarySearchTree() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }



  private void insertNode(int item) {

    // If it is an empty tree, insert the value as the root
    if (root == null) {
      root = new Node(item);
      root.item = item;
    } else {
      insert(root, item);
    }
  }

  private void insert(Node currentNode, int item) {

    // right child
    if (item > currentNode.item) {
      if (currentNode.right != null) {
        insert(currentNode.right, item);
      } else {
        currentNode.right = new Node(item);
      }
    }

    // left child
    else if (item < currentNode.item) {
      if (currentNode.left != null) {
        insert(currentNode.left, item);
      } else {
        currentNode.left = new Node(item);
      }
    }

  }


  private Node delete(Node current, int value) {

    // null check
    if (current == null) {
      System.out.println("No such Element = " + value);
      return current;
    }

    // if the value is greater than root then we are trying to delete an item
    // from right tree
    else if (value > current.item) {
      current.right = delete(current.right, value);
    }

    // if the value is smaller than root then we are trying to delete an item
    // from left tree
    else if (value < current.item) {
      current.left = delete(current.left, value);
    }

    else {

      // leaf node
      if (current.left == null && current.right == null) {
        current = null;
      }

      else {

        // delete the node with two child
        if (current.right != null && current.left != null) {

          int min = findMin(current.right);
          current.item = min;
          current.right = delete(current.right, min);
        }

        // delete the node with only one child(right)
        else if (current.left == null) {
          Node newNode = current.right;
          current = null;
          return newNode;
        }

        // delete the node with only one child(right)
        else if (current.right == null) {
          Node newNode = current.left;
          current = null;
          return newNode;
        }
      }
    }

    return current;

  }

  private int findMin(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node.item;
  }


  public Node find(int num) {
    Node toFind = null;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      toFind = findNode(root, num);
    }
    return toFind;
  }

  private Node findNode(Node current, int value) {

    // null check
    if (current == null) {
      System.out.println("No such Element = " + value);
      return current;
    }


    // if the value is greater than root then we are trying to find an item
    // from right tree
    else if (value > current.item) {
      current.right = findNode(current.right, value);
    }

    // if the value is smaller than root then we are trying to find an item
    // from left tree
    else if (value < current.item) {
      current.left = findNode(current.left, value);
    }
    return current;
  }

 //Recursion
  public void preOrder(Node current) {

    if (current != null) {

      System.out.println("Node (value) = " + current.item);
      preOrder(current.left);
      preOrder(current.right);
    }

  }

  //Recursion
  public void inorder(Node current) {

    if (current != null) {
      inorder(current.left);
      System.out.println("Node (value) = " + current.item);
      inorder(current.right);
    }

  }

  //Recursion
  public void postOrder(Node current) {

    if (current != null) {
      postOrder(current.left);
      postOrder(current.right);
      System.out.println("Node (value) = " + current.item);

    }

  }
  /*
   * Create empty stack and push root node to it. 
   * Do the following when stack is not empty 
   * Pop a node from stack and print it
   * Push right child of popped node to stack 
   * Push left child of popped node to stack
   */

  public void iterativePreorder(Node root) {

    if (root == null) {
      System.out.println("Empty Tree");
    } else {
      Stack<Node> parentStack = new Stack<Node>();
      parentStack.push(root);

      while (!parentStack.isEmpty()) {

        Node current = parentStack.pop();
        System.out.println("Node (value) = " + current.item);
        if (current.right != null) {
          parentStack.push(current.right);
        }
        if (current.left != null) {
          parentStack.push(current.left);
        }
      }
    }
  }

  /*
   * 
   * Create an empty stack s and set currentNode =root. 
   * while currentNode is not NULL Do following 
   * Push currentNode 's right child and then currentNode to
   * stack. Set currentNode =currentNode .left Pop an node from stack and set it
   * as root and set it to currentNode If the popped node has a right child and
   * the right child is at top of stack, then remove the right child from stack,
   * push the current node back and set currentNode as currentNode 's right
   * child. Else print currentNode 's data and set currentNode as NULL. Repeat
   * steps 2 and 3 while stack is not empty.
   */

  public void iterativePostOrder(Node root) {

    if (root == null) {
      System.out.println("Empty Tree");
    } else {
      Stack<Node> parentStack = new Stack<Node>();
      Node lastVisited = null;

      while (root != null || !parentStack.isEmpty()) {
        
        if (root != null) {
          parentStack.push(root);
          root = root.left;
        } 
        else {
          Node peekNode = parentStack.peek();
          
          if (peekNode.right != null && lastVisited != peekNode.right) {
            root = peekNode.right;
          } 
          else {
            System.out.println("Node (value) = " + peekNode.item);
            lastVisited = parentStack.pop();
          }
        }
       
      }
    }
  }

  /*
   * Create an empty stack s and Initialize current node as root Push the
   * current node to s and set currentNode = currentNode.left until currentNode
   * is NULL If currentNode is NULL and s is not empty then Pop the top node
   * from stack and print it set currentNode = currentNode.right go to step 2 If
   * stack is empty and currentNode is also null then we are done with it
   */

  public void iterativeInOrder(Node root) {

    if (root == null) {
      System.out.println("Empty Tree");
    } else {
      Stack<Node> parentStack = new Stack<Node>();

      Node current = root;

      while (!parentStack.isEmpty() || current != null) {

        if (current != null) {
          parentStack.push(current);
          current = current.left;
        } else {
          Node tempNode = parentStack.pop();
          System.out.println("Node (value) = " + tempNode.item);
          current = tempNode.right;

        }

      }
    }
  }
  

  

  
  public int height() {

    int wid = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      wid = findheight(root);
    }
    return wid;


  }

  private int findheight(Node current) {

    if (current == null) {
      return -1;
    }

    else {
      return 1 + Math.max(findheight(current.left), findheight(current.right));
    }
  }


  public int width() {

    int max = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      for (int k = 0; k <= height(); k++) {
        int tmp = width(root, k);
        if (tmp > max)
          max = tmp;
      }
    }
    return max;
  }

  // returns the number of node on a given level
  public int width(Node p, int depth) {
    if (p == null)
      return 0;
    else if (depth == 0)
      return 1;
    else
      return width(p.left, depth - 1) + width(p.right, depth - 1);
  }



  public int diameter() {

    int dm = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      dm = diameter(root);
    }
    return dm;
  }

  private int diameter(Node p) {

    if (p == null)
      return 0;
    else {
      int lheight = findheight(p.left);
      int rheight = findheight(p.right);


      return Math.max(lheight + rheight + 1, Math.max(diameter(p.left), diameter(p.right)));
    }
  }

  public int countLeaves() {

    int leaves = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      leaves = count(root);
    }
    return leaves;

  }


  private int count(Node p) {

    if (p == null)
      return 0;
    else if (p.left == null && p.right == null)
      return 1;
    else
      return count(p.left) + count(p.right);
  }
  
/* public int findNextMax(Node root, int value) {
    
    if (root == null) {
      System.out.println("Empty Tree");
      return -1;
    }
    else {
      Node currentNode = findNode(root, value);
      return findSuccessor(currentNode);
     
    }
    
  }*/
 
/* private int findSuccessor(Node currentNode) {
   
   if (currentNode.right != null) {
     int succesorValue = findMin(currentNode.right);
     return succesorValue;
   } else {
     
     
   }
    
  return -1;
}*/

public void findLCA(int val1, int val2) {

   if (isEmpty()) {
     System.out.println("Empty tree");
   } else {
     Node lca = findLowestCommonAncestor(root, val1, val2);
     //     Node lca = findLCABST(root, val1, val2);


     if (lca == null) {
       System.out.println("Items may not be present");
     } else {
       System.out.println("LCA for " + val1 + " and " + val2 + " is = "
           + lca.item);
     }
   }
 }

 // Binary Tree LCA not BST
 private Node findLowestCommonAncestor(Node root, int value1, int value2) {

   Node leftLCA = null;
   Node rightLCA = null;

   if (root == null) {
     return null;
   }

   else {
     int value = root.item;

     if (value == value1 || value == value2) {
       return root;

     }

     else {

       leftLCA = findLowestCommonAncestor(root.left, value1, value2);
       rightLCA = findLowestCommonAncestor(root.right, value1, value2);

       if (leftLCA != null && rightLCA != null) {
         return root;
       }

       return (leftLCA != null) ? leftLCA : rightLCA;
     }
   }

 }

 public Node findLCABST(Node root, int value1, int value2) {
   while (root != null) {
     int value = root.item;

     if (value > value1 && value > value2) {
       root = root.left;
     } else if (value < value1 && value < value2) {
       root = root.right;
     } else {
       return root;
     }
   }
   return null; // only if empty tree
 }

 // 1. we can use recursion and call if the left and right subtree is bst or
 // not
 // 2. or we can find the max from left subtree and min from right subtree and
 // compare it with the root

 // Recursive : Expensive O(N^2)
 public boolean isBST(Node root) {

   // null check
   if (root == null) {
     return true;
   }

   else {
     if (isSubTreeLesser(root.left, root.item) // O(N) time
         && isSubGreater(root.left, root.item)
         && isBST(root.left)
         && isBST(root.right)) {
       return true;
     } else {
       return false;
     }
   }

 }

 private boolean isSubTreeLesser(Node root, int value) {
   if (root == null) {
     return true;
   } else {
     if (root.item <= value && isSubTreeLesser(root.left, value)
         && isSubTreeLesser(root.right, value)) {
       return true;
     } else {
       return false;
     }
   }
 }

 private boolean isSubGreater(Node root, int value) {
   if (root == null) {
     return true;
   } else {
     if (root.item >= value && isSubGreater(root.left, value)
         && isSubGreater(root.right, value)) {
       return true;
     } else {
       return false;
     }
   }
 }

 // Using Max and Min O(N)

 public boolean isBSTMaxMin(Node root) {

   // null check
   if (root == null) {
     return true;
   } else {
     return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }
 }
 
 private boolean isBSTUtil(Node root, int min, int max) {

   // null check
   if (root == null) {
     return true;
   }

   else {
     if (root.item <= max && root.item >= min
         && isBSTUtil(root.left, min, root.item) // O(1) time
         && isBSTUtil(root.right, root.item, max)) {
       return true;
     } else {
       return false;
     }
   }

 }
 
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insertNode(2);
    tree.insertNode(1);
    tree.insertNode(3);
    /*
     * tree.insert(7); tree.insert(2);
     * System.out.println(" ********** After Insertion **********");
     * tree.printTree(tree.root); tree.findLCA(4, 9); tree.findLCA(5, 9);
     * tree.findLCA(4, 2);
     * 
     * System.out.println(tree.findNode(tree.root, 2));
     * System.out.println(tree.findNode(tree.root, 112));
     * 
     * System.out.println("findLCABST " + tree.findLCABST(tree.root, 4,
     * 2).item);
     */

    tree.iterativeInOrder(tree.root);

  }

}