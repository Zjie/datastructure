package mapcolouration;

import java.util.ArrayList;
import java.util.List;

public class Vector {
	// 节点编号
	public int number = 0;
	// 节点的邻居节点
	public List<Vector> neighbours = new ArrayList<Vector>();
	// 节点是否被涂上颜色
	public boolean isColored = false;
	// 节点所涂的颜色
	public Color color = null;

	// 根据节点的邻居，获得节点还能够涂的颜色
	public List<Color> getUsableColors() {
		List<Color> colors = Color.getAllColors();
		for (Vector v : neighbours) {
			if (v.isColored) {
				colors.remove(v.color);
			}
		}
		return colors;
	}

	@Override
	public String toString() {
		return number + "";
	}
}
