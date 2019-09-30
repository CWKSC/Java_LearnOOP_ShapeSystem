/*LoadExistFile.java*/

import java.io.*;

import FileControl.FileControl;
import cHabit.c;
import processControl.*;
import shapes.*;

public class LoadExistFile extends ProcessControl {
	
	public void part() {
		
		// 取得當前目錄下可載入的檔案陣列
		File[] DataFiles = FileControl.loadFileList("load");
		
		// 當前目錄下沒有可載入的檔案 //
		if(DataFiles == null) {
			c.println("No exist file can be load.");
			backToUpperLayer();
			SystemPause();
			return;
		}
		
		// 詢問, 取得用戶的輸入
		int fileChoice = MyScanner.inputIntWithQuestionWithValueLimit(
				"Input your choose: ", //Question
				1,					   //LowerLimit
				DataFiles.length + 1); //UpperLimit
		// 編號 DataFiles.length + 1 為離開選項
		
		// 用戶選擇了離開的選項
		if(fileChoice == DataFiles.length + 1) { 
			backToUpperLayer();
			return;
		}
		
		// 對應選項的陣列索引
		int index = fileChoice - 1;
		
		// 取得檔案的字串名稱, 去除頭尾部分後載入 FileControl //
		String strFileName = DataFiles[index].toString();
		String strWithOutHeadAndTail = strFileName.substring("./".length(),
				strFileName.length() - ".txt".length());
		FileControl.setFileName(strWithOutHeadAndTail);
		
		// 按格式讀取檔案 //
		try {
			FileReader file = new FileReader(strFileName);
			BufferedReader fin = new BufferedReader(file);
			
			// 取得檔案行數
			int fileLineNum = FileControl.getFileLineNum(strFileName);
			
			// 行數為零, 這是一個空檔案
			if(fileLineNum == 0) {
				fin.close();
				
				// 生成空檔案 //
				// 載入檔案名稱, 空的 ShapeListFileData
				FileControl.setFileName(strWithOutHeadAndTail);
				FileControl.setShapeListFileData(new ShapeListFileData());
				
				// 進入編輯, 控制檔案資料的部分
				(new FileControl()).startPart();
				
				backToUpperLayer();
				return;
			}
			
			Shape[] shapeList = new Shape[fileLineNum];
			
			String[] tempStr = new String[fileLineNum];
			String[] fields = new String[fileLineNum];
			
			// 遍歷, 一行一行地把檔案資料載入 tempStr, 然後進行格式拆分//
			for(int i = 0; i < fileLineNum; i++) {
				tempStr[i] = fin.readLine();
				
				// 不應存在空行 //
				if(tempStr[i].equals("")) {
					fin.close();
					c.println("Should not be empty line.");
					throw new NumberFormatException();
				}
				
				// 按照格式拆分
				fields = tempStr[i].split(",");
				
				// 應該至少有四個 attributes
				if(fields.length < 4) {
					fin.close();
					c.println("At least 4 attributes.");
					throw new NumberFormatException();
				}
				
				/*遍歷 fields ，去除頭尾空格*/
				for(int j = 0; j < fields.length; j++) {
					fields[j] = fields[j].trim();
				}
				
				// 載入 x, y 座標
				int x = Integer.parseInt(fields[1]);
				int y = Integer.parseInt(fields[2]);
				
				// 對應第一項參數的類型名稱, 載入對應的 shape 到 shapeList 中
				if(fields[0].equals("Circle")) {
					int r = Integer.parseInt(fields[3]);
					shapeList[i] = new Circle(x, y, r);
					
				}else if(fields[0].equals("EquivalentTriangle")) {
					int l = Integer.parseInt(fields[3]);
					shapeList[i] = new EquivalentTriangle(x, y, l);
					
				}else if(fields[0].equals("Rectangle")) {
					int w = Integer.parseInt(fields[3]);
					int h = Integer.parseInt(fields[3]);
					shapeList[i] = new Rectangle(x, y, w, h);
					
				}else if(fields[0].equals("Square")) {
					int l = Integer.parseInt(fields[3]);
					shapeList[i] = new Square(x, y, l);
					
				}else {
					// 找不到對應的類型名稱 //
					fin.close();
					c.println("No corresponding shape type name.");
					throw new NumberFormatException();
				}
			}
			
			fin.close();
			
			//進入編輯, 控制檔案資料的部分
			(new FileControl()).startPart();
			
		}catch (NumberFormatException ex) {
			
			// 存在格式錯誤的訊息
	    	c.println("The loading file have wrong format. 載入的檔案存在錯誤格式。");
	    	
		}catch (IOException ex) {
	         ex.printStackTrace();
	    }
		
		backToUpperLayer();
	}
	
}
