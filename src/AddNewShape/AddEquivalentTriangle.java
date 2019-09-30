/*AddEquivalentTriangle.java*/

package AddNewShape;

import FileControl.*;
import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class AddEquivalentTriangle extends ProcessControl {

	public void part() {
		
		// 進入 EquivalentTriangle 的 attribute 編輯器, 返回經用戶輸入後的結果
		EquivalentTriangle equivalentTriangle = new EquivalentTriangle(0, 0, 0).editer();
		
		// 取得儲存檔案資料的引用
		ShapeListFileData data = FileControl.getShapeListFileData();
				
		// 把 EquivalentTriangle 加到檔案資料中
		data.addShapeToTheList(equivalentTriangle);
		
		// 顯示成功訊息 //
		c.ln();
		c.println("Successfully joined [ " + equivalentTriangle + " ] into file.");
		
		// 標記有修改尚未儲存
		QuitFile.setHaveChange(true);
		
		backToUpperLayer();
	}

}
