/*DelectShape.java*/

package FileControl;

import cHabit.c;
import processControl.*;
import shapes.ShapeListFileData;

public class DelectShape extends ProcessControl {

	public void part() {
		
		// 取得檔案資料的引用
		ShapeListFileData shapeListFileData = FileControl.getShapeListFileData();
		
		// 列出 shapeList 列表訊息, 若果檔案中沒有任何的 shape, 返回 false
		if(shapeListFileData.listShape(true) == false){
			SystemPause();
			backToUpperLayer();
			return;
		}
		
		// 詢問, 取得用戶的輸入
		int choice = MyScanner.inputIntWithQuestionWithValueLimit(
				"Choice to delect a Shape :", 				//question
				1,										    //lowerLimit
				shapeListFileData.getElementNum() + 1);		//UpperLimit
		// 編號 shapeListFileData.getElementNum() + 1 為離開選項
		
		// 用戶選擇了離開的選項
		if(choice == shapeListFileData.getElementNum() + 1) { //Quit
			backToUpperLayer();
			return;
		}
		
		// 對應選項的陣列索引
		int index = choice - 1;
		
		// 刪除檔案資料中 對應索引的 Shape
		shapeListFileData.delectShapeAtTheList(index);
		
		// 成功訊息 //
		c.ln();
		c.println("Successfully delect the shape in the file.");
		
		// 標記有修改尚未儲存
		QuitFile.setHaveChange(true);
		
	}

}
