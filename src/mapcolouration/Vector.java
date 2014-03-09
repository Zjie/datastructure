package mapcolouration;

import java.util.ArrayList;
import java.util.List;

public class Vector {
	// �ڵ���
	public int number = 0;
	// �ڵ���ھӽڵ�
	public List<Vector> neighbours = new ArrayList<Vector>();
	// �ڵ��Ƿ�Ϳ����ɫ
	public boolean isColored = false;
	// �ڵ���Ϳ����ɫ
	public Color color = null;

	// ���ݽڵ���ھӣ���ýڵ㻹�ܹ�Ϳ����ɫ
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
