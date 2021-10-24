package JUnit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

import junit.framework.TestCase;
import project3.BinaryTree;

public class BinaryTreeJUnit extends TestCase
{
   BinaryTree<String> aTree;
   BinaryTree<String> bTree;
   BinaryTree<String> cTree;
   BinaryTree<String> dTree;
   BinaryTree<String> eTree;
   BinaryTree<String> fTree;
   BinaryTree<String> gTree;
   BinaryTree<String> hTree;
   
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;
   private final PrintStream originalErr = System.err;

   @Override
   protected void setUp() throws Exception
   {
      this.aTree = new BinaryTree<>();

      // Leaves:
      this.bTree = new BinaryTree<>("B");
      this.fTree = new BinaryTree<>("F");
		this.gTree = new BinaryTree<>("G");
		this.hTree = new BinaryTree<>("H");

		// Subtrees:
		this.dTree = new BinaryTree<>("D", fTree, null);
		this.eTree = new BinaryTree<>("E", gTree, hTree);
      this.cTree = new BinaryTree<>("C", dTree, eTree);
      
      aTree.setTree("A", bTree, cTree);
   }

   //Traversing the string in postorder should be correct.
   @Test
   public void testPostorderTraverse()
   {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));

      String expected = "BFDGHECA";

		aTree.postorderTraverse();
      String output = outContent.toString();
      output = output.replace("\n", "").replace("\r", "");
      assertEquals(expected, output);

      System.setOut(originalOut);
      System.setErr(originalErr);
   }
   
   //getHeight method should work.
   @Test
   public void testGetHeight()
   {
      int expected = 4;
      int height = aTree.getHeight();
      assertEquals(expected, height);
   }

   //Should be able to call the node's method for height
   //and still get the correct result.
   @Test
   public void testNodeGetHeight()
   {
      int expected = 4;
      int height = aTree.getHeight_callBinaryNodeMethod();
      assertEquals(expected, height);
   }

   //getNumberOfNodes method should work.
   @Test
   public void testGetNodes()
   {
      int expected = 8;
      int nodes = aTree.getNumberOfNodes();
      assertEquals(expected, nodes);
   }

   //Should be able to call the node's method for node count
   //and still get the correct result.
   @Test
   public void testNodeGetNodes()
   {
      int expected = 8;
      int nodes = aTree.getNumberOfNodes_callBinaryNodeMethod();
      assertEquals(expected, nodes);
   }
}