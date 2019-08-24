//Isaac Hartzell
//CIS 2207 N02
//2/1/18
//Assignment 4
//This program demonstrates a binary search on a tree structure. 
import java.util.*;

public class Driver 
{
	public static void main(String arg[])
	{
		BinarySearchTree binaryTree = new BinarySearchTree();
		
		menu(binaryTree);
	}
	
	public static char getChoice()
	{
		char character = ' ';
		
		System.out.println("     Menu");
		System.out.println("    1 -- Quit");
		System.out.println("    2 -- Clear");
		System.out.println("    3 -- Insert");
		System.out.println("    4 -- Remove");
		System.out.println("    5 -- Find");
		System.out.println("    6 -- Print");
		System.out.println("    7 -- Print Range");
		System.out.println();
		
		System.out.print("Enter choice: ");

		while (character > '7' || character < '1')
		{
			try
			{
				character = (char) System.in.read();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return character;
	}
	
	public static void menu(BinarySearchTree binaryTree)
	{
		boolean isDone = false;
		String line;
		String high, low;
		
		Scanner userInput = new Scanner(System.in);
		
		while (! isDone)
		{
			switch (getChoice())
			{
			// Quit the program.
			case '1' :
				System.out.println("Bye");
				isDone = true;
				break;
			// Clear the Tree.
			case '2':
				binaryTree.clear();
				System.out.println("Cleared the tree. \n");
				break;
			// Insert string for the tree.
			case '3':
				userInput.nextLine();
				System.out.print("Enter a line to insert: ");
				line = userInput.nextLine();
				binaryTree.insert(line);
				System.out.println();
				break;
			// Remove string from entered.
			case '4':
				userInput.nextLine();
				System.out.print("Enter a line to remove: ");
				line = userInput.nextLine();
				line = binaryTree.remove(line);
				System.out.println("Removed: " + line);
				System.out.println();
				break;
			// Find a String entered into the tree in a node.
			case '5':
				userInput.nextLine();
				System.out.print("Enter a line to find: ");
				line = userInput.nextLine();
				line = binaryTree.find(line);
				System.out.println("Found: " + line);
				System.out.println();
				break;
			// Print out the tree.
			case '6':
				binaryTree.print();
				System.out.println();
				break;
			// Prints the tree from an inputted range.
			case '7':
				userInput.nextLine();
				System.out.print("Enter a low value: ");
				low = userInput.nextLine();
				System.out.print("Enter a high value: ");
				high = userInput.nextLine();
				System.out.println("Please implement the printRange method");
				binaryTree.printRange(low,high);
				System.out.println();
				break;
			}
		}
	}
}
