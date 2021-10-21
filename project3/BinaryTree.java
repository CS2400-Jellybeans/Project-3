package project3;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

	private void initializeTree(T rootData, BinaryTree<T> leftTree,
	                                        BinaryTree<T> rightTree)
	{
      // < FIRST DRAFT - See Segments 25.4 - 25.7 for improvements. >
      root = new BinaryNode<T>(rootData);
      
      if (leftTree != null)
         root.setLeftChild(leftTree.root);
      
      if (rightTree != null)
         root.setRightChild(rightTree.root);
	} // end initializeTree

   public void postorderTraverse()
   {
      postorderTraverse(root);
   }
   private void postorderTraverse(BinaryNode<T> node)
   {
      if(node !=null)
      {
         postorderTraverse(node.getLeftChild());
         postorderTraverse(node.getRightChild());
         System.out.println(node.getData());
      }
   }

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   }

   public void postorderTraverse_callBinaryNodeMethod()
   {
      root.postorderTraverse_binaryNodeMethod();
   }

   public int getHeight_callBinaryNodeMethod()
   {
      return root.getHeight_binaryNodeMethod();
   }

/* Implementations of setRootData, getRootData, getHeight, getNumberOfNodes,
   isEmpty, clear, and the methods specified in TreeIteratorInterface are here.
   . . . */

} // end BinaryTree
