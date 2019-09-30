/*SaveFile.java*/

package FileControl;

import java.io.*;

import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class SaveFile extends ProcessControl {

	public void part() {
		try {
			
			// 為檔案名稱加入後綴名 //
			File fileName = new File(FileControl.getFileName() + ".txt");
			FileWriter file = new FileWriter(fileName);
			BufferedWriter fout = new BufferedWriter(file);
			
			// 取得檔案資料的引用
			ShapeListFileData shapeListFileData = FileControl.getShapeListFileData();
			
			// 取得檔案資料中的 Shape 陣列和元素數目 //
			Shape[] shapeList = shapeListFileData.getShapeList();
			int elementNum = shapeListFileData.getElementNum();
			
			// 這是一個空的陣列, 元素數目為零
			if(elementNum != 0) {
				// 遍歷 shapeList , toWriteFileString() 會返回一個符合輸出格式的字串
				for(int i = 0; i < elementNum - 1; i++) {
					fout.write(shapeList[i].toWriteFileString());
					fout.newLine();
				}
				fout.write(shapeList[elementNum - 1].toWriteFileString());
			}
			
	        fout.close();
	        
	        c.ln();
	        c.println("Save file Successfully.");
	        
	        // 標記修改已儲存, 沒有尚未儲存的修改
	        QuitFile.setHaveChange(false);
	        
	        SystemPause();
		}catch (Exception ex) {
	         ex.printStackTrace();
	    }
		backToUpperLayer();
	}

}
