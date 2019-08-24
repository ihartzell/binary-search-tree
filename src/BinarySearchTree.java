
public class BinarySearchTree 
{
	// I'm making the root being the starting node, and a
	// nodeCount is an integer that contains the size of the tree.
	private Node root;
	private int nodeCount;
	
	// The constructor assigns the root node to null initially.
	// The count of nodes at this point will be 0.
	public BinarySearchTree()
	{
		root = null;
		nodeCount = 0;
	}
	// This method clears the tree.
	// and the count of nodes is again 0.
	public void clear()
	{
		root = null;
		nodeCount = 0;
	}
	//Recursive function that inserts a value into the tree.
	public Node insertHelp(Node subRoot, String nodeWereWorkingOn)
	{
		// base case
		if (subRoot == null)
			return new Node(nodeWereWorkingOn,null,null);
		
		// general case
		// This statement is equivalent to comparing two integers one being < the other.
		if (subRoot.getElement().compareTo(nodeWereWorkingOn) > 0)
			subRoot.setLeftChild(insertHelp(subRoot.getLeftChild(),nodeWereWorkingOn));
		else
			subRoot.setRightChild(insertHelp(subRoot.getRightChild(),nodeWereWorkingOn));
		
		return subRoot;
	}
	// Inserts a value into the tree.
	public void insert(String nodeWereWorkingOn)
	{
		root = insertHelp(root, nodeWereWorkingOn);
		nodeCount++;
	}
	//This is a recursive routine that finds a node based on a value given
	private String findHelp(Node subRoot, String nodeWereWorkingOn)
	{
		// base case
		if (subRoot == null)
			return null;
		if (subRoot.getElement().compareTo(nodeWereWorkingOn) == 0)
			return subRoot.getElement();
		
		// general case
		if (subRoot.getElement().compareTo(nodeWereWorkingOn) > 0)
			return findHelp(subRoot.getLeftChild(),nodeWereWorkingOn);
		else
			return findHelp(subRoot.getRightChild(),nodeWereWorkingOn);
	}
	//This function finds a value in the tree
	public String find(String nodeWereWorkingOn)
	{
		return findHelp(root, nodeWereWorkingOn);
	}
	// This is a recursive function that gets the left most node in the right subTree.
	private Node getMin(Node subRoot)
	{
		// Base Case
		if (subRoot.getLeftChild() == null)
			return subRoot;
		// General Case
		else
			return getMin(subRoot.getLeftChild());
	}
	//Recursive function that deletes the left most node in the right subTree
	private Node deleteMin(Node subRoot)
	{
		// base case
		if (subRoot.getLeftChild() == null) // Found min
			return subRoot.getRightChild();
		// general case
		else
			{
			subRoot.setLeftChild(deleteMin(subRoot.getLeftChild()));
			return subRoot;
			}
	}
	// This is a recursive function that deletes a node based on a value given.
	private Node removeHelp(Node subRoot, String nodeWereWorkingOn)
	{
		// base case
		if (subRoot == null)
			return null;
		else if (subRoot.getElement().compareTo(nodeWereWorkingOn) == 0)
		{
			if (subRoot.getLeftChild() == null)	// only a right child
				subRoot = subRoot.getRightChild();
			else if (subRoot.getRightChild() == null)  // only a left child
				subRoot = subRoot.getLeftChild();
			else
			{
				Node temp = getMin(subRoot.getRightChild());
				subRoot.setElement(temp.getElement());
				subRoot.setRightChild(deleteMin(subRoot.getRightChild()));
			}
		}
		// general case
		else if (subRoot.getElement().compareTo(nodeWereWorkingOn) > 0)
			subRoot.setLeftChild(removeHelp(subRoot.getLeftChild(),nodeWereWorkingOn));
		else if (subRoot.getElement().compareTo(nodeWereWorkingOn) <= 0)
			subRoot.setRightChild(removeHelp(subRoot.getRightChild(),nodeWereWorkingOn));
		
		return subRoot;
	}
	// Removes a value from the tree.
	public String remove(String nodeWereWorkingOn)
	{
		String temp = findHelp(root,nodeWereWorkingOn);
		
		if (temp != null)
		{
			root = removeHelp(root,nodeWereWorkingOn);
			nodeCount--;
		}
		
		return temp;
	}
	// This is a recursive routine that prints the tree.
	private void printHelp(Node subRoot, int level)
	{
		// base case
		if (subRoot == null)
			return;
		
		printHelp(subRoot.getLeftChild(), level + 1);
		
		// for every level in the tree or depth space the nodes so it looks like a tree structure.
		for (int i = 0; i < level; i++)
			System.out.print("  ");
		
		// Print out the element or node we're interested in.
		System.out.println(subRoot.getElement());
		
		printHelp(subRoot.getRightChild(), level + 1);
	}
	// Prints out the tree
	public void print()
	{
		printHelp(root,0);
	}
	
	private void printRangeHelp(Node subRoot, String low, String high)
	{   
		// Base case
		if(subRoot == null)
		{
			return;
		}
		
		// If the subRoot node being compared to the low string node > 0 then go left getting the left child.
		if (subRoot.getElement().compareTo(low) > 0)
		{	
			printRangeHelp(subRoot.getLeftChild(),low,high);
		}
		
		// If the subRoot node or String that I care about that is inputted falls in range of the low and high value
		// then I print that String.
		if(subRoot.getElement().compareTo(low) > 0 && subRoot.getElement().compareTo(high) < 0)
		{
			System.out.println(subRoot.getElement());
		}
		// If the subRoot node being compared to the high string node < 0 then go right getting the right child.
		if (subRoot.getElement().compareTo(high) < 0)
		{
			printRangeHelp(subRoot.getRightChild(),low,high);
		}
	}
	
	// Prints the range.
	public void printRange(String low, String high)
	{
		printRangeHelp(root, low, high);
	}
	
}
