package mapcolouration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Map {
	private List<Vector> allVectors;
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("请输入区域的个数:");
		int num = input.nextInt();
		Map map = new Map(getData(num));
		map.paintVector();
	}

	public void paintVector() {
		// 循环把所有的结点都涂上颜色
		for (Vector v : allVectors) {
			paintVector(v);
		}
		if (isFinished()) {
			System.out.println("每个结点的颜色分别是：");
			for (Vector v : allVectors) {
				System.out.println(v.number + ":" + v.color);
			}
		} else {
			System.out.println("无法用4个颜色给这些区域按照题目要求进行上色");
		}
	}

	private void paintVector(Vector vector) {
		List<Color> colors = vector.getUsableColors();
		// 如果已经无法选择一个颜色给这个结点上色，说明这个方案无法满足要求，回溯上一步重新上色
		if (colors == null || colors.size() == 0) {
			return;
		}
		// 如果能给这个结点涂一种颜色，递归往下继续上色
		for (Color color : colors) {
			vector.color = color;
			vector.isColored = true;

			for (Vector v : vector.neighbours) {
				if (v.isColored) {
					continue;
				}
				paintVector(v);
			}
		}
	}

	public Map(int[][] data) {
		Vector[] vectors = new Vector[data.length];
		// 初始化所有结点
		for (int i = 0; i < vectors.length; i++) {
			vectors[i] = new Vector();
			vectors[i].number = i + 1;
		}
		// 设置结点间关系
		for (int i = 0; i < data.length; i++) {
			List<Vector> neighbours = new ArrayList<Vector>();
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] == 1) {
					neighbours.add(vectors[j]);
				}
			}
			vectors[i].neighbours = neighbours;
		}
		allVectors = Arrays.asList(vectors);
	}

	// 判断是否全部结点已经被上色
	public boolean isFinished() {
		for (Vector v : allVectors) {
			if (!v.isColored) {
				return false;
			}
			for (Vector subV : v.neighbours) {
				if (subV.color.equals(v.color)) {
					return false;
				}
			}
		}
		return true;
	}

	public static int[][] getData(int num) {
		int[][] data = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				data[i][j] = 0;
			}
		}
		System.out.println("请输入区域之间的关系");
		System.out.println("例如:1,2");
		System.out.println("表示区域1和区域2有连接，连接是无方向的");
		System.out.println("输入\"end\"来终止区域间关系数据的输入");
		boolean hasNext = true;
		while (hasNext) {
			String tmpStr = input.next();
			if (tmpStr.equals("end")) {
				hasNext = false;
			} else {
				String[] d = tmpStr.split(",");
				int x = Integer.parseInt(d[0]);
				int y = Integer.parseInt(d[1]);
				if (x > num || y > num) {
					System.out.println("输入的区域编号不能超过" + num);
					continue;
				}
				data[x - 1][y - 1] = 1;
				data[y - 1][x - 1] = 1;
			}
		}
		return data;
	}
}
