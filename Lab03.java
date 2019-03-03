import java.util.*;

public class Lab03 {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();

		int[] array = new int[256];

		for (int i = 0; i < sentence.length(); i++) {
			String temp = Integer.toBinaryString((int) sentence.charAt(i));
			while (temp.length() < 7)
				temp = "0" + temp;
			array[(int) sentence.charAt(i)]++;
		}

		PriorityQueue<Tree> PQ = new PriorityQueue<Tree>();

		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {

				Tree t = new Tree();
				t.root = new Node();
				t.root.letter = (char) i;
				t.frequency = array[i];
				t.root.smallestLetter = (char) i;
				PQ.add(t);

			}
		}

		while (PQ.size() > 1) {

			Tree t1 = PQ.poll();
			Tree t2 = PQ.poll();

			Node n = new Node();

			Tree t = new Tree();
			t.root = new Node();

			t.frequency = t1.frequency + t2.frequency;

			t.root.leftChild = t1.root;
			t.root.rightChild = t2.root;

			t.root.smallestLetter = (char) Math.min(t1.root.smallestLetter, t2.root.smallestLetter);

			PQ.add(t);

		}

		Tree HuffmanTree = PQ.poll();

		for (int i = 0; i < sentence.length(); i++) {
			System.out.print(HuffmanTree.getCode(sentence.charAt(i)));
		}

	}
}

class Node {

	public char letter = '@';
	public char smallestLetter = '@';

	public Node leftChild;
	public Node rightChild;

}

class Tree implements Comparable<Tree> {
	public Node root;
	public int frequency = 0;

	public Tree() {
		root = null;
	}

	public int compareTo(Tree object) {
		if (frequency - object.frequency > 0) {
			return 1;
		} else if (frequency - object.frequency < 0) {
			return -1;
		} else {
			char a = this.root.smallestLetter;
			char b = object.root.smallestLetter;

			if (a > b) {
				return 1;
			} else if (a < b) {
				return -1;
			}
			return 0;
		}
	}

	String path = "error";

	public String getCode(char letter) {

		return this._getCode(letter, this.root, "");
	}

	private String _getCode(char letter, Node current, String path) {
		if (current == null) {
			return null;
		}
		if (current.letter == letter) {
			return path;
		}

		String leftPath = this._getCode(letter, current.leftChild, path + "0");
		if (leftPath != null) {
			return leftPath;
		}

		String rightPath = this._getCode(letter, current.rightChild, path + "1");
		return rightPath;
	}

}