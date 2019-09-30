/*EquivalentTriangle.java*/

package shapes;

import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// 正三角形 //
public class EquivalentTriangle extends Shape {
	
	// 正三角形邊長
	private int length;
	
	// EquivalentTriangle 的 constructor //
	public EquivalentTriangle(int x, int y, int side) {
		super("EquivalentTriangle", x, y);
		setLength(side);
	}
	
	// length 的 getter 和 setter
	public int getLength() { return length; }
	public void setLength(int length) { this.length = length; }
	
	// 返回 EquivalentTriangle 的訊息的字串
	public String toString() {
		return super.toString() + "length " + getLength();
	}

	@Override
	// 計算 EquivalentTriangle 的面積
	public double getArea() {
		return (Math.sqrt(3.0) / 4.0) * Math.pow(length, 2);
	}

	@Override
	// 計算 EquivalentTriangle 的周界
	public double getPerimeter() {
		return 3.0 * length;
	}

	@Override
	// 針對 EquivalentTriangle 的 attribute 編輯器
	public EquivalentTriangle editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int s = MyScanner.inputIntWithQuestion("input side:");
		return new EquivalentTriangle(x, y, s);
	}

	// 返回符合輸出格式的字串
	public String toWriteFileString() {
		return super.toWriteFileString() + getLength();
	}
}
