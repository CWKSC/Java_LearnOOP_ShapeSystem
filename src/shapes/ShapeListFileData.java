/*ShapeListFileData.java*/

package shapes;

import cHabit.c;

// 儲存檔案資料的類別 //
public class ShapeListFileData {
	
	// 儲存 Shape 的陣列, 和元素數目 //
	private Shape[] shapeList;
	private int elementNum = 0;
	
	// 整個 shapeList 陣列的 getter 和 setter //
	public Shape[] getShapeList() { return shapeList; }
	public void setShapeList(Shape[] input) { shapeList = input; }
	
	// 按照輸入的索引, shapeList 中其中一個元素的 getter 和 setter //
	public Shape getShapeListByIndex(int index) { return shapeList[index]; }
	public void setShapeListByIndex(Shape input, int index) {
		shapeList[index] = input;
	}
	
	// elementNum 元素數目的 getter 和 setter //
	public int getElementNum() { return elementNum; }
	public void setElementNum(int input) { elementNum = input; }
	
	// 列出 shapeList 列表訊息 //
	public boolean listShape(boolean quitChioceDisplay) {
		c.ln();
		
		// shapeList 是空陣列(null), 沒有儲存任何的 Shape
		if(elementNum == 0) {
			c.println("Haven't Any Shape at file.");
			return false;
		}
		
		// 顯示 shapeList 的列表訊息
		c.println("There are " + elementNum + " shapes:");
		for(int i = 0; i < elementNum; i++) {
			c.println("\t" + (i+1) + ". " + shapeList[i]);
		}
		
		// 根據參數決定是否顯示退出選項(最後一項)
		if(quitChioceDisplay) {
			c.println((elementNum + 1) + ". Quit");
		}
		
		c.ln();
		return true; // 代表 shapeList 並非空陣列
	}
	
	// 取得 shapeList 中的總面積 //
	public double getTotalArea() {
		double totalArea = 0;
		for(int i = 0; i < elementNum; i++) {
			totalArea += shapeList[i].getArea();
		}
		return totalArea;
	}
	
	// 取得 shapeList 中的總周界 //
	public double getTotalPerimeter() {
		double totalPerimeter = 0;
		for(int i = 0; i < elementNum; i++) {
			totalPerimeter += shapeList[i].getPerimeter();
		}
		return totalPerimeter;
	}
	
	// 擴大陣列, 元素加一
	public void expandShapeListSpace() {
		elementNum++;
		shapeList = new Shape[elementNum];
	}
	
	// 把輸入的參數加入 shapeList 陣列中
	public void addShapeToTheList(Shape input){
		Shape[] tempShapeList = shapeList;
		expandShapeListSpace();
		int indexOfLastElement = elementNum - 1;
		for(int i = 0; i < indexOfLastElement; i++) {
			shapeList[i] = tempShapeList[i];
		}
		shapeList[indexOfLastElement] = input;
	}
	
	// 縮小陣列, 元素減一
	public void reduceShapeListSpace() {
		elementNum--;
		shapeList = new Shape[elementNum];
	}
	
	// 把輸入的參數在 shapeList 陣列中刪除
	public void delectShapeAtTheList(int index){
		Shape[] tempShapeList = shapeList;
		reduceShapeListSpace();
		for(int i = 0, j = 0; i < elementNum + 1; i++) {
			if(i != index) {
				shapeList[j] = tempShapeList[i];
				j++;
			}
		}
	}
	
}
