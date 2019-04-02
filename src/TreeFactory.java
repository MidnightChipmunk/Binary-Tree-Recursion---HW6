
public class TreeFactory {

	//Takes a number and returns 2^pow
	public static long powerOfTwo(int pow){
		long power;	
		
		if(pow-1 < 0){
			return 1;
		}
		
		power = 2 * powerOfTwo(pow-1);
		
		return power;
	}
	
	//Takes a root and traverses down it's longest path and returns the depth (root is at 0)
	public static int findDepth(BinaryNode root){
		int rDepth = 1;
		int lDepth = 1;
		if(root == null){
			return -1;
		}
		
		if(root.getRightChild() != null){
			rDepth = 1 + findDepth(root.getRightChild());
		}else{
			rDepth -= 1;
		}
		
		if(root.getLeftChild() != null){
			lDepth = 1 + findDepth(root.getLeftChild());
		}else{
			lDepth -= 1;
		}
		
		return rDepth >= lDepth ? rDepth : lDepth;
	}
	
	//Runs through the BT recursivley checking to see if there is a right or left child,
	//if there is load it to the given array. Returns the new array.
	public static BinaryNode[] loadToArray(BinaryNode root, BinaryNode[] binArr, int index){
		BinaryNode[] binaryArray = binArr;
		
		if(binaryArray[0] == null){
			binaryArray = new BinaryNode[(int) powerOfTwo(findDepth(root))*2-1];
		}
		
		binaryArray[index] = root;
		
		if(root.getLeftChild() != null){
			binaryArray[index*2+2] = root.getLeftChild();
			loadToArray(root.getLeftChild(), binaryArray, index*2+2);
		}
		
		if(root.getRightChild() != null){
			binaryArray[index*2+1] = root.getRightChild();
			loadToArray(root.getRightChild(), binaryArray, index*2+1);
		}
		
		return binaryArray;
	}
	
	//Takes an array and creates a BT from it
	public static BinaryNode loadToLink(BinaryNode[] binArr, int ind){
		int index = ind;
		int rightIndex = (index*2)+2;
		int leftIndex = (index*2)+1;
		BinaryNode[] binaryArray = binArr;
		BinaryNode root = new BinaryNode(binaryArray[index].getData(), null, null);

		if(rightIndex >= binaryArray.length){
			return root;
		}
		
		if(binaryArray[rightIndex] != null && binaryArray[leftIndex] != null){
			root.setRightChild(loadToLink(binaryArray, rightIndex));
			root.setLeftChild(loadToLink(binaryArray, leftIndex));
		}else{
			if(binaryArray[rightIndex] != null){
				root.setRightChild(loadToLink(binaryArray, rightIndex));
			}else{
				root.setRightChild(null);
			}
			
			if(binaryArray[leftIndex] != null){
				root.setLeftChild(loadToLink(binaryArray, leftIndex));
			}else{
				root.setLeftChild(null);
			}
		}
		return root;
		
	}
	
	//Displays a tree using the array of the BT
	public static void displayTree(BinaryNode root){
		int depth = findDepth(root);
		BinaryNode[] tree = loadToArray(root, new BinaryNode[1], 0);
		int cursor = 0;
		int power = 0;
		int index = 0;
		while(cursor <= depth){
			int spaces = (int)(tree.length - powerOfTwo(power)-power);
			for(int i = 0; i < spaces; i++){
				System.out.print(" ");
			}
			
			for(int i = 0; i < powerOfTwo(power); i++){
				if(tree[index] != null){
					System.out.print(" " + tree[index].getData());
				}else{
					System.out.print(" -");
				}
				index++;
			}
			
			power++;
			cursor++;
			System.out.println("\n");
		}
	}
	
	//Builds a BST with a certain depth given a root node and a starting index
	public static BinaryNode BSTBuilder(BinaryNode node, int depth, int top){
		BinaryNode root = node;
		
		if(depth == 0){
			return root;
		}
		
		if(root == null){
			root = new BinaryNode((int)powerOfTwo(depth), null, null);
		}
		
		root.setRightChild(new BinaryNode((top-(int)powerOfTwo(depth)/2), null ,null));
		root.setLeftChild(new BinaryNode(top+(int)powerOfTwo(depth)/2, null ,null));
		
		BSTBuilder(root.getRightChild(), depth-1, top-(int)powerOfTwo(depth)/2);
		BSTBuilder(root.getLeftChild(), depth-1, top+(int)powerOfTwo(depth)/2);
		
		return root;
	}
}
