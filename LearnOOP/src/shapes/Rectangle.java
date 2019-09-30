/*Rectangle.java*/

package shapes;

import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// 長方形 //
public class Rectangle extends Shape {
	
	// 長方形的長, 闊 //
	private int width;
	private int height;
	
	// Rectangle 的 constructor //
	public Rectangle(int x, int y, int width, int height) {
		super("Rectangle", x, y);
		setWidth(width);
		setHeight(height);
	}
	
	// width 的 getter 和 setter //
	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }
	
	// height 的 getter 和 setter //
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	
	// 返回 Rectangle 的訊息的字串
	public String toString() {
		return super.toString() + 
				"width " + getWidth() + 
				" and height " + getHeight();
	}

	@Override
	// 計算 Rectangle 的面積
	public double getArea() {
		return width * height;
	}

	@Override
	// 計算 Rectangle 的周界
	public double getPerimeter() {
		return 2 * ( width + height );
	}

	@Override
	// 針對 Rectangle 的 attribute 編輯器
	public Rectangle editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int w = MyScanner.inputIntWithQuestion("input width:");
		int h = MyScanner.inputIntWithQuestion("input height:");
		return new Rectangle(x, y, w, h);
	}
	
	// 返回符合輸出格式的字串
	public String toWriteFileString() {
		return super.toWriteFileString() + getWidth() + ", " + getHeight();
	}
}
