package project3;

class BinaryNode<T>
{
   private T             data;
   private BinaryNode<T> leftChild;  // Reference to left child
   private BinaryNode<T> rightChild; // Reference to right child

   public BinaryNode()
   {
      this(null); // Call next constructor
   } // end default constructor

   public BinaryNode(T dataPortion)
   {
      this(dataPortion, null, null); // Call next constructor
   } // end constructor

   public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild,
                                    BinaryNode<T> newRightChild)
   {
      data = dataPortion;
      leftChild = newLeftChild;
      rightChild = newRightChild;
   } // end constructor

   /**
    * Retrieves the data portion of this node.
    * @return  The object in the data portion of the node.
    */
   public T getData()
   {
      return data;
   } // end getData

   /**
    * Sets the data portion of this node.
    * @param newData  The data object.
    */
   public void setData(T newData)
   {
      data = newData;
   } // end setData

   /**
    * Retrieves the left child of this node.
    * @return  A reference to this node's left child.
    */
   public BinaryNode<T> getLeftChild()
   {
      return leftChild;
   } // end getLeftChild

   /**
    * Sets this node’s left child to a given node.
    * @param newLeftChild  A node that will be the left child.
    */
   public void setLeftChild(BinaryNode<T> newLeftChild)
   {
      leftChild = newLeftChild;
   } // end setLeftChild

   /**
    * Detects whether this node has a left child.
    * @return  True if the node has a left child.
    */
   public boolean hasLeftChild()
   {
      return leftChild != null;
   } // end hasLeftChild

   public BinaryNode<T> getRightChild()
   {
      return rightChild;
   } // end getLeftChild

   /**
    * Sets this node’s left child to a given node.
    * @param newReftChild  A node that will be the left child.
    */
   public void setRightChild(BinaryNode<T> newRightChild)
   {
      rightChild = newRightChild;
   } // end setLeftChild

   /**
    * Detects whether this node has a left child.
    * @return  True if the node has a left child.
    */
   public boolean hasRightChild()
   {
      return rightChild != null;
   } // end hasLeftChild
   
   /**
    * Detects whether this node is a leaf.
    * @return  True if the node is a leaf.
    */
   public boolean isLeaf()
   {
      return (leftChild == null) && (rightChild == null);
   } // end isLeaf

   /**
    * Copies the subtree rooted at this node.
    * @return  The root of a copy of the subtree rooted at this node.
    */
   public BinaryNode<T> copy()
   {
      BinaryNode<T> newRoot = new BinaryNode<>(data);
      if (leftChild != null)
         newRoot.setLeftChild(leftChild.copy());
   
      if (rightChild != null)
         newRoot.setRightChild(rightChild.copy());
   
      return newRoot;
   } // end copy

   /**
    * prints (using post-order traversal) all nodes of the subtree rooted at "this" node
    */
   public void postorderTraverse_binaryNodeMethod()
   {
      postorderTraverse_binaryNodeMethod(this);
   }

   /**
    * Computes the height of the subtree rooted at "this" node.
    * @param node The node to start the traversal from.
    * @return  The height of the subtree rooted at "this" node.
    */
   private void postorderTraverse_binaryNodeMethod(BinaryNode<T> node)
   {
      if(node !=null)
      {
         postorderTraverse_binaryNodeMethod(node.getLeftChild());
         postorderTraverse_binaryNodeMethod(node.getRightChild());
         System.out.println(node.getData());
      }
   }
   
   /**
    * Computes the height of the subtree rooted at this node.
    * @return  The height of the subtree rooted at this node.
    */
    public int getHeight_binaryNodeMethod()
    {
       return getHeight_binaryNodeMethod(this); // Call private getHeight
    } // end getHeight
    
    /**
     * Computes the height of the subtree rooted at this node.
     * @param node The node to calculate the height from.
     * @return  The height of the subtree rooted at this node.
     */
    private int getHeight_binaryNodeMethod(BinaryNode<T> node)
    {
       int height = 0;
    
       if (node != null)
          height = 1 + Math.max(getHeight_binaryNodeMethod(node.getLeftChild()),
                                getHeight_binaryNodeMethod(node.getRightChild()));
       return height;
    } // end getHeight

   /**
    * Counts the nodes in the subtree rooted at "this" node.
    * @return  The number of nodes in the subtree rooted at "this" node.
    */
	public int getNumberOfNodes_binaryNodeMethod()
	{
	  int leftNumber = 0;
	  int rightNumber = 0;
	  if (leftChild != null)
	     leftNumber = leftChild.getNumberOfNodes_binaryNodeMethod();
	  if (rightChild != null)
	     rightNumber = rightChild.getNumberOfNodes_binaryNodeMethod();
	  return 1 + leftNumber + rightNumber;
	} // end getNumberOfNodes
} // end BinaryNode
