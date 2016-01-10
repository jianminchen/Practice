package tree;

import tree.PathSum.TreeNode;

public class BuildTree {


  public TreeNode buildTree1(int[] inorder, int[] postorder) {

    int inStart = 0;
    int inEnd = inorder.length - 1;
    int posStart = 0;
    int posEnd = postorder.length - 1;

    return buildTree1(inorder, postorder, inStart, inEnd, posStart, posEnd);
  }

  private TreeNode buildTree1(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart,
      int posEnd) {

    if (inStart > inEnd || posStart > posEnd)
      return null;


    int rootValue = postorder[posEnd];
    TreeNode root = new TreeNode(rootValue);

    int leftTreeLength = 0;

    for (int i = 0; i < inorder.length; i++) {

      if (inorder[i] == rootValue) {
        leftTreeLength = i;
        break;
      }
    }


    TreeNode left = buildTree1(inorder, postorder, inStart, leftTreeLength - 1, posStart,
        posStart + leftTreeLength - (inStart + 1));
    TreeNode right = buildTree1(inorder, postorder, leftTreeLength + 1, inEnd,
        posStart + leftTreeLength - inStart, posEnd - 1);

    root.setRight(right);
    root.setRight(left);

    return root;
  }

  public TreeNode buildTree2(int[] preorder, int[] inorder) {

    int inStart = 0;
    int inEnd = inorder.length - 1;
    int preStart = 0;
    int preEnd = preorder.length - 1;

    return buildTree2(inorder, preorder, inStart, inEnd, preStart, preEnd);
  }

  private TreeNode buildTree2(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart,
      int preEnd) {

    if (inStart > inEnd || preStart > preEnd)  return null;


    int rootValue = preorder[preStart];
    TreeNode root = new TreeNode(rootValue);

    int leftTreeLength = 0;

    for (int i = 0; i < inorder.length; i++) {

      if (inorder[i] == rootValue) {
        leftTreeLength = i;
        break;
      }
    }


    TreeNode left = buildTree2(inorder, preorder, inStart, leftTreeLength - 1, preStart + 1,
        preStart + (leftTreeLength - inStart));
    TreeNode right = buildTree2(inorder, preorder, leftTreeLength + 1, inEnd,
        preStart + (leftTreeLength - inStart) + 1, preEnd);

    root.setRight(right);
    root.setRight(left);

    return root;
  }
}
