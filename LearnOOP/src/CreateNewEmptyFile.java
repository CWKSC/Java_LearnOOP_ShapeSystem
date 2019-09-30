/*CreateNewEmptyFile.java*/

import FileControl.FileControl;
import cHabit.c;
import processControl.*;
import shapes.ShapeListFileData;

public class CreateNewEmptyFile extends ProcessControl {
	
	public void display() {
		c.ln();
		c.print("New Empty File name:");
	}
	
	public void part() {
		String inputFileName;
		
		// 輸入檔案名稱直至合法的檔案名稱 //
		boolean isItIllFileName;
		do {
			
			// 詢問
			display();
			
			inputFileName = MyScanner.sc.nextLine();
			
			// 判斷非法的檔案名稱
			isItIllFileName = FileControl.isItIllFileName(inputFileName);
			if(isItIllFileName) {
				c.println("Illegal file name, please enter again. 非法的檔案名稱，請重新輸入。");
			}
			
		}while(isItIllFileName);
		
		// 生成空檔案 //
		//載入檔案名稱, 空的 ShapeListFileData
		FileControl.setFileName(inputFileName);
		FileControl.setShapeListFileData(new ShapeListFileData());
		
		//進入編輯, 控制檔案資料的部分
		(new FileControl()).startPart();
		
		backToUpperLayer();
	}
	
}
