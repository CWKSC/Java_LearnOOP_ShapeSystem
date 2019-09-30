/*Circle.java*/

package shapes;

import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// 圓形 //
public class Circle extends Shape{
	
	// 圓形半徑
	private int radius;
	
	// Circle 的 constructor //
	public Circle(int x, int y, int radius) {
		super("Circle", x, y);
		setRadius(radius);
	}
	
	// radius 半徑的 getter 和 setter //
	public int getRadius() { return radius; }
	public void setRadius(int radius) { this.radius = radius; }
	
	// 返回 Circle 的訊息的字串
	public String toString() {
		return super.toString() + "radius " + getRadius();
	}

	@Override
	// 計算 Circle 的面積
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	// 計算 Circle 的周界
	public double getPerimeter() {
		return 2.0 * Math.PI * radius;
	}

	@Override
	// 針對 Circle 的 attribute 編輯器
	public Circle editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int r = MyScanner.inputIntWithQuestion("input radius:");
		return new Circle(x, y, r);
	}
	
	// 返回符合輸出格式的字串
	public String toWriteFileString() {
		return super.toWriteFileString() + getRadius();
	}
	
}
