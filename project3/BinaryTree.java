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

	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);

      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);

      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // end if

      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();

      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // end initializeTree

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   }

   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData
   
   public boolean isEmpty()
   {
      return root == null;
   }

   public void clear()
   {
      root = null;
   }
   
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode
   
   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode

   /**
    * Calls postorderTraverse(BinaryNode{@literal <}T{@literal >} node)
    * Prints (using post-order traversal) all nodes in the "whole" tree
    */
   public void postorderTraverse()
   {
      postorderTraverse(root);
   }
   
   /**
    * Prints (using post-order traversal) all nodes in the subtree rooted at this node
    */
   private void postorderTraverse(BinaryNode<T> node)
   {
      if(node !=null)
      {
         postorderTraverse(node.getLeftChild());
         postorderTraverse(node.getRightChild());
         System.out.println(node.getData());
      }
   }

   /** 
    * Prints (using post-order traversal) all nodes in the "whole" tree
    */
   public void postorderTraverse_callBinaryNodeMethod()
   {
      root.postorderTraverse_binaryNodeMethod();
   }

   /**
    * calls getHeight(BinaryNode{@literal <}T{@literal >} node)
    * @return  The height of the "whole" tree
    */
   public int getHeight()
   {
	   return getHeight(root);
   } // end getHeight
   
   /**
    * Computes the height of the subtree rooted at this node.
    * @return  The height of the subtree rooted at this node.
    */
   private int getHeight(BinaryNode<T> node)
   {
      int height = 0;
      if (node != null)
         height = 1 + Math.max(getHeight(node.getLeftChild()),
                               getHeight(node.getRightChild()));
      return height;
   } // end getHeight

   /** 
    * Computes the height of this tree.
    * @return  The height of this tree.
    */
   public int getHeight_callBinaryNodeMethod()
   {
      return root.getHeight_binaryNodeMethod();
   }

   /** -------------------------------------------------------------------- */
   /** Task 3: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getNumberOfNodes()
    *          2. private int getNumberOfNodes(BinaryNode<T> node)*/
   
   /** calls getNumberOfNodes({@literal <}T{@literal >} node) 
   @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes()
   {
      return 0;
   } // end getNumberOfNodes
   
   /** A Recursive Method in the BinaryTree Class   
    * Counts the nodes in the subtree rooted at this node.
   @return  The number of nodes in the subtree rooted at this node. */
   private int getNumberOfNodes(BinaryNode<T> node)
   {
      return 0;
   } // end getNumberOfNodes
   
   /**
    * Counts the nodes in the "whole" tree
    * @return  The number of nodes in the "whole" tree.
    */
   public int getNumberOfNodes_callBinaryNodeMethod()
   {
	   int numberOfNodes = 0;
	   if (root != null)
		   numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
	   return numberOfNodes;
   } // end getNumberOfNodes_callBinaryNodeMethod

} // end BinaryTree
