
public class BinaryTreeRecursion {
	public static void main(String[] args) {
		BinaryNode rootNode = new BinaryNode(9, new BinaryNode(45, new BinaryNode(65, null, null), new BinaryNode(29, null, null)), new BinaryNode(56, new BinaryNode(11, null, null), new BinaryNode(87, null, null)));
		BinaryNode[] arr = {new BinaryNode(12, null, null), new BinaryNode(65, null, null), new BinaryNode(23, null, null), new BinaryNode(43, null, null), new BinaryNode(176, null, null), new BinaryNode(15, null, null), new BinaryNode(99, null, null), new BinaryNode(100, null, null), null, new BinaryNode(11, null, null), new BinaryNode(90, null, null), null, null, new BinaryNode(13, null, null), new BinaryNode(14, null, null)};
		
		//Displaying the predefined Tree
		TreeFactory.displayTree(rootNode);
		
		//Testing the loadToArray and seeing if the print method lines up with the
		//predefined tree
		BinaryNode[] rootArr = new BinaryNode[1];
		rootArr = TreeFactory.loadToArray(rootNode, rootArr, 0);
		rootArr[0].print(TreeFactory.findDepth(rootArr[0]));
		
		//Testing to predefined array BT to linked tree with
		//displayTree and print.
		BinaryNode tree = TreeFactory.loadToLink(arr, 0);
		TreeFactory.displayTree(tree);
		tree.print(TreeFactory.findDepth(tree));
		
		//Testing the BST builder
		BinaryNode random = TreeFactory.BSTBuilder(null, 3, (int)TreeFactory.powerOfTwo(3));
		TreeFactory.displayTree(random);
		random.print(TreeFactory.findDepth(random));
		
		//Testing toString for all three trees (its broke)
		System.out.println(rootNode + "\n\n" + tree + "\n\n" + random);
	}
}