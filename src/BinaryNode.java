
public class BinaryNode{

	private BinaryNode rightChild;
	private BinaryNode leftChild;
	private int data;
	
	public BinaryNode(int data, BinaryNode right, BinaryNode left) {
		this.data = data;
		rightChild = right;
		leftChild = left;
	}
	
	//Prints out data of the BT. This doesn't work.
	public String toString(){
		String data = String.valueOf(getData());
		String rLink = "";
		String lLink = "";
		String link = "";
		if(getLeftChild() != null && getRightChild() != null){
			rLink = rLink + getRightChild().toString();
			lLink = lLink + getLeftChild().toString();
		}else if(getRightChild() != null){
			lLink = lLink + "null";
			rLink = rLink + getRightChild().toString();
		}else if(getLeftChild() != null){
			rLink = rLink + "null";
			lLink = lLink + getLeftChild().toString();
		}else{
			rLink = rLink + "null";
			lLink = lLink + "null";
		}
		
		rLink = "\n Right Link: " + rLink;
		lLink = "\n Left Link: " + lLink;
		link = rLink + lLink;
		//System.out.println("\n-L-" + link + "\n-D-" + getData());
		
		data = "\nData: " + data;
		
		System.out.println(data + link);
		return data + link;
	}
	
	//Prints out the array in an indented format
	public void print(int depth){
		
		for(int i = 0; i < depth; i++)
			System.out.print(" ");
		System.out.println(getData());
		
		if(getRightChild() != null){
			System.out.print(" ");
			getRightChild().print(depth+1);
		}
		
		if(getLeftChild() != null){
			System.out.print(" ");
			getLeftChild().print(depth+1);
		}
		
		if(getLeftChild() == null && !isLeaf()){
			for(int i = 0; i < depth+3; i++)
				System.out.print(" ");
				System.out.println("--");
		}
		
		if(getRightChild() == null && !isLeaf()){
			for(int i = 0; i < depth+3; i++)
				System.out.print(" ");
				System.out.println("--");
		}
		
	}
	
	public boolean isLeaf(){
		return (getRightChild() == null && getLeftChild() == null ? true : false);
	}
	
	public BinaryNode getRightChild(){
		return rightChild;
	}
	
	public BinaryNode getLeftChild(){
		return leftChild;
	}
	
	public int getData(){
		return data;
	}
	
	public void setRightChild(BinaryNode right){
		rightChild = right;
	}
	
	public void setLeftChild(BinaryNode left){
		leftChild = left;
	}
	
	public void setData(int data){
		this.data = data;
	}
}
