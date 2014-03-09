package binarytree;

public class Node {
	public Node father;
	public Node left;
	public int data;
	public Node right;

	@Override
	public boolean equals(Object o) {
		Node other = (Node) o;
		if (other.isLeaf() && this.isLeaf()) {
			return other.data == this.data;
		} else if (other.isLeaf() && !this.isLeaf()) {
			return false;
		} else if (!other.isLeaf() && this.isLeaf()) {
			return false;
		} else {
			if (this.left != null && other.left == null) {
				return false;
			} else if (this.left == null && other.left != null) {
				return false;
			} else if (this.right == null && other.right != null) {
				return false;
			} else if (this.right != null && other.right == null) {
				return false;
			} else if (this.left == null && other.left == null) {
				return this.data == other.data
						&& this.right.equals(other.right);
			} else if (this.right == null && other.right == null) {
				return this.data == other.data
						&& this.left.equals(other.left);
			} else {
				return this.data == other.data
						&& this.left.equals(other.left)
						&& this.right.equals(other.right);
			}
		}

	}

	@Override
	public String toString() {
		return data + "";
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}
}
