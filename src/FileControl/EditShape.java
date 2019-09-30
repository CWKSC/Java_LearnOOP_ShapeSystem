/*EditShape.java*/

package FileControl;

import cHabit.c;
import processControl.*;
import shapes.*;

public class EditShape extends ProcessControl{

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
				"Choice a Shape to edit the attributes:", //Question
				1,										  //lowerLimit
				shapeListFileData.getElementNum() + 1);	  //UpperLimit
		// 編號 shapeListFileData.getElementNum() + 1 為離開選項
		
		// 用戶選擇了離開的選項
		if(choice == shapeListFileData.getElementNum() + 1) { //Quit
			backToUpperLayer();
			return;
		}
		
		// 對應選項的陣列索引
		int index = choice - 1;
		
		// 取得對應索引的 Shape
		Shape shape = shapeListFileData.getShapeListByIndex(index); //get
		
		// 使用對應的編輯器讓用戶修改 attribute
		shape = shape.editer();
		
		// 把修改後的 Shape 放入 shapeListFileData 檔案資料
		shapeListFileData.setShapeListByIndex(shape, index); //set
		
		// 成功訊息 //
		c.ln();
		c.println("Successfully change [ " + shape + " ] into file.");
		
		// 標記有修改尚未儲存
		QuitFile.setHaveChange(true);
		
	}
	
}
