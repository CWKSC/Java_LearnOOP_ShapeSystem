/*Square*/

package shapes;
import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// 正方形 //
public class Square extends Shape {
	
	// 正方形的邊長
	private int length;
	
	// Rectangle 的 constructor //
	public Square(int x, int y, int side) {
		super("Square", x, y);
		setLength(side);
	}
	
	// length 的 getter 和 setter //
	public int getLength() { return length; }
	public void setLength(int length) { this.length = length; }
	
	// 返回 Square 的訊息的字串
	public String toString() {
		return super.toString() + "length " + getLength();
	}

	@Override
	// 計算 Square 的面積
	public double getArea() {
		return Math.pow(length, 2);
	}

	@Override
	// 計算 Square 的周界
	public double getPerimeter() {
		return 4.0 * length;
	}

	@Override
	// 針對 Square 的 attribute 編輯器
	public Square editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int s = MyScanner.inputIntWithQuestion("input side:");
		return new Square(x, y, s);
	}
	
	// 返回符合輸出格式的字串
	public String toWriteFileString() {
		return super.toWriteFileString() + getLength();
	}
}
