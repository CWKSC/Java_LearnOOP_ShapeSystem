/*DelectExistFile.java*/

import java.io.File;

import FileControl.FileControl;
import cHabit.c;
import processControl.*;

public class DelectExistFile extends ProcessControl {

	// 與 LoadExistFile 的部分很類似
	// 刪除存在的檔案 //
	public void part() {
		
		// 取得當前目錄下可載入的檔案陣列
		File[] DataFiles = FileControl.loadFileList("delect");
		
		// 當前目錄下沒有可載入的檔案 //
		if(DataFiles == null) {
			c.println("No exist file can be delect.");
			backToUpperLayer();
			SystemPause();
			return;
		}
		
		// 詢問, 取得用戶的輸入
		int fileChoice = MyScanner.inputIntWithQuestionWithValueLimit(
				"Input your choose: ", //question
				1,					   //lowerLimit
				DataFiles.length + 1); //UpperLimit
		// 編號 DataFiles.length + 1 為離開選項
		
		// 用戶選擇了離開的選項
		if(fileChoice == DataFiles.length + 1) { //Quit
			backToUpperLayer();
			return;
		}
		
		// 對應選項的陣列索引
		int index = fileChoice - 1;
		
		//刪除檔案
		DataFiles[index].delete();
		
	}

}
