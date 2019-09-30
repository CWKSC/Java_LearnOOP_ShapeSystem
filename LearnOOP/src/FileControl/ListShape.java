/*ListShape.java*/

package FileControl;

import cHabit.c;
import processControl.ProcessControl;
import shapes.ShapeListFileData;

public class ListShape extends ProcessControl {
	
	public void part() {
		
		// 獲取檔案資料
		ShapeListFileData data = FileControl.getShapeListFileData();
		
		// 列出檔案資料 //
		data.listShape(false);
		c.printf("The total area is %.2f, and\n", data.getTotalArea());
		c.printf("thw total perimeter "
				+ "is %.2f\n", data.getTotalPerimeter());
		
		// 暫停進程, 返回上一層
		SystemPause();
		backToUpperLayer();
		
	}

}
