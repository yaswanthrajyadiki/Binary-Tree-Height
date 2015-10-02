import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
class BinaryTreeHeight<T extends Comparable<T>> {
	Node<T> rootNode;
	int index = 0;
	int level = 0;
	int nodePointer = 0;
	Node<T> childNode;
	Node<T> traverseNode;
	Node<T> nextNode;
	ArrayList<T> levelOrderElements = new ArrayList<T>();
	public void insertElement(T element) {
		Node<T> newNode = new Node<T>();
		newNode.setElement(element);
		if (rootNode == null) {
			rootNode = newNode;
			traverseNode = newNode;
			childNode = newNode;
			nextNode = newNode;
			this.updateNodePointer();
		} else {
			if (childNode.getLeftNode() == null) {
			 	childNode.setLeftNode(newNode);
			} else if (childNode.getRightNode() == null) {
	 			childNode.setRightNode(newNode);
	 			this.updateNodePointer();
			}
			nextNode.setNextNode(newNode);
      		nextNode = newNode;
		}
	 	this.updateLevel(level);
		index++;
	}

	public void updateNodePointer() {
		Node<T> node1 = traverseNode;
		int i = 0;
		if (nodePointer == 0) {
			childNode = rootNode;
		} else {
			while (i <= nodePointer) {
				childNode = node1;
				node1 = node1.getNextNode();
				i++;
			}
		}
		nodePointer++;
	}

	public void getHeight() {
		Node<T> node = rootNode;
		int height1 = -1;
		int height2 = -1;
		while (node != null) {
			node = node.getLeftNode();
			height1++;
		}
		node = rootNode; 
		while (node != null) {
			node = node.getRightNode();
			height2++;
		}
		if ((height1+height2)/2 + 1 != 0) {
			if ((height1+height2)%2 == 0) {
			System.out.println((height1+height2)/2);
			} else {
				System.out.println((height1+height2)/2 + 1);
			}	
		} else {
			System.out.println(-1);
		}
		// if (level == 1) {
		// 	System.out.println(-1);
		// } else {
		// 	System.out.println(level - 1);
		// }
	}

	public void updateLevel(int presentLevel) {
		// System.out.println(index);
		if (index == (int)(Math.pow(2,level)) - 1) {
			level++;
		}
	}

	public static void main(String[] args) {
		BinaryTreeHeight<Integer> bt = new BinaryTreeHeight<Integer>();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			String s1 =  st.nextToken().trim();
			if (!s1.equals("#")) {
				bt.insertElement(Integer.parseInt(s1));			
			} /*else {
				bt.insertElement(null);
			}*/
		}
		bt.getHeight();
	}

}