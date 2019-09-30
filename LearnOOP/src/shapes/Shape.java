/*Shape.java*/

package shapes;

// 圖形 //
public abstract class Shape{
	
	// 圖形名稱, x, y 座標 //
	private String shapeType;
	private int x;
	private int y;
	
	// Shape 的 constructor //
	public Shape(String shapeType, int x, int y) {
		setShapeType(shapeType);
		setX(x);
		setY(y);
	}
	
	// x 的 getter 和 setter //
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	
	// y 的 getter 和 setter //
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	
	// shapeType 的 getter 和 setter //
	public String getShapeType() { return shapeType; }
	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}
	
	// 返回 Shape 的訊息的字串
	public String toString() {
		return getShapeType() + " at (" + getX() + "," + getY() + ") has ";
	}
	
	// 有 3 個 abstract 需要子類別去繼承, 為了進行多型 //
	public abstract double getArea(); // 計算面積
	public abstract double getPerimeter(); // 計算周界
	public abstract Shape editer(); // 針對 attribute 編輯器
	
	// 返回符合輸出格式的字串
	public String toWriteFileString() {
		return getShapeType() + ", " + getX() + ", " + getY() + ", ";
	}
}
