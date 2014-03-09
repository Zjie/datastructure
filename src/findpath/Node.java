package findpath;

import java.util.List;

public class Node {
	//x坐标
	private int x;
	//y坐标
	private int y;
	//从该节点，下一步能走到的节点集合
	private List<Node> nextNode;
	//父节点
	private Node fatherNode;
	//用于判断该节点是否被访问过
	private boolean isVisit = false;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public List<Node> getNextNode() {
		return nextNode;
	}
	public void setNextNode(List<Node> nextNode) {
		this.nextNode = nextNode;
	}
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	public Node getFatherNode() {
		return fatherNode;
	}
	public void setFatherNode(Node fatherNode) {
		this.fatherNode = fatherNode;
	}
	public boolean isVisit() {
		return isVisit;
	}
	public void setVisit(boolean isVisit) {
		this.isVisit = isVisit;
	}
	
}
