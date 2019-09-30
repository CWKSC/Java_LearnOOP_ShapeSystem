/*AddRectangle.java*/

package AddNewShape;

import FileControl.*;
import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class AddRectangle extends ProcessControl {

	public void part() {
		
		// 進入 Rectangle 的 attribute 編輯器, 返回經用戶輸入後的結果
		Rectangle rectangle = new Rectangle(0, 0, 0, 0).editer();
		
		// 取得儲存檔案資料的引用
		ShapeListFileData data = FileControl.getShapeListFileData();
				
		// 把 Rectangle 加到檔案資料中
		data.addShapeToTheList(rectangle);
		
		// 顯示成功訊息 //
		c.ln();
		c.println("Successfully joined [ " + rectangle + " ] into file.");
		
		// 標記有修改尚未儲存
		QuitFile.setHaveChange(true);
		
		backToUpperLayer();
	}

}
