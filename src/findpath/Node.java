package findpath;

import java.util.List;

public class Node {
	//x����
	private int x;
	//y����
	private int y;
	//�Ӹýڵ㣬��һ�����ߵ��Ľڵ㼯��
	private List<Node> nextNode;
	//���ڵ�
	private Node fatherNode;
	//�����жϸýڵ��Ƿ񱻷��ʹ�
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
