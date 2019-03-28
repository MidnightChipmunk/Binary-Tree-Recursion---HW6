
public class TreeFactory {

	public static long powerOfTwo(int pow){
		long power;	
		
		if(pow-1 < 0){
			return 1;
		}
		
		power = 2 * powerOfTwo(pow-1);
		
		return power;
	}
	
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
	
	public static BinaryNode[] loadToArray(BinaryNode root, BinaryNode[] binArr, int index){
		BinaryNode[] binaryArray = binArr;
		
		if(binaryArray[0] == null){
			binaryArray = new BinaryNode[(int) powerOfTwo(findDepth(root))*2-1];
		}
		
		//right  = 2*index+2
		//left = 2*index+1
		
		if(root.getRightChild() != null){
			binaryArray[index*2+2] = root.getRightChild();
			loadToArray(root.getRightChild(), binaryArray, index*2+2);
		}
		
		if(root.getLeftChild() != null){
			binaryArray[index*2+1] = root.getLeftChild();
			loadToArray(root.getLeftChild(), binaryArray, index*2+1);
		}
		
		return binaryArray;
	}
	
	public static BinaryNode loadToLink(BinaryNode[] binArr, int ind){
		int index = ind;
		BinaryNode[] binaryArray = binArr;
		BinaryNode root = null;
		
		if(index*2+2 > binaryArray.length || index*2+1 > binaryArray.length-1){
			return root;
		}
		root = new BinaryNode(binaryArray[index].getData(), binaryArray[index*2+2], binaryArray[index*2+1]);
		loadToLink(binaryArray, index*2+2);
		loadToLink(binaryArray, index*2+1);
		return root;
		
	}
	
	public static void displayTree(BinaryNode root){
		int depth = findDepth(root);
		long length = powerOfTwo(depth);
		BinaryNode[] tree = loadToArray(root, new BinaryNode[0], 0);
		for(int i = 1; i <= depth+1; i++){
			for(int j = 0; j < length; j++){
				int counter = 0;
				if(length/powerOfTwo(i) == j || length/powerOfTwo(i)+((length/2)/i)*counter == j){
					counter++;
					System.out.println(tree[j].getData());
				}else{
					System.out.println(" ");
				}
			}
		}
	}
}
