
public class Node 
{
	// Since private, the only way to gain access is through the public methods.
	// If these were not private I could simply get them by making a Node variable say root,
	// Then saying root.leftChild.
	// Also, if I was to make these static I wouldn't have to make an object before calling for the variable or methods.
	// That's what static does, it makes is so an object doesn't have to be created to call the method.
	// The leftChild and rightChild are the nodes to the left and right of the root node.
	private String element;
	private Node leftChild;
	private Node rightChild;
	
	//Constructors for my data field variables.
	public Node()
	{
		element = "";
		// The left and rightChild of the root node start as null.
		leftChild = rightChild = null;
	}
	public Node(String nodeWereWorkingOn)
	{
		element = nodeWereWorkingOn;
		leftChild = rightChild = null;
	}
	public Node(String nodeWereWorkingOn, Node leftChild, Node rightChild)
	{
		element = nodeWereWorkingOn;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	//getters and setters.
	public String getElement() 
	{
		return element;
	}
	public void setElement(String element) 
	{
		this.element = element;
	}
	public Node getLeftChild() 
	{
		return leftChild;
	}
	public void setLeftChild(Node leftChild) 
	{
		this.leftChild = leftChild;
	}
	public Node getRightChild() 
	{
		return rightChild;
	}
	public void setRightChild(Node rightChild) 
	{
		this.rightChild = rightChild;
	}
	
	// The leaf is the node without children.
	public boolean isLeaf()
	{
		boolean leaf = true;
		
		// if the leftChild or the rightChild nodes contain something I set the leaf to false and return the leaf.
		if(leftChild != null || rightChild != null)
			leaf = false;
		
		return leaf;
	}
	
}
