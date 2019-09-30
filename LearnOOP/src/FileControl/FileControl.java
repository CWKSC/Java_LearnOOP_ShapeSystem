/*FileControl.java*/

package FileControl;

import java.io.*;

import AddNewShape.AddNewShape;
import cHabit.c;
import processControl.ProcessControl;
import shapes.ShapeListFileData;

public class FileControl extends ProcessControl{
	
	private static String fileName;
	private static ShapeListFileData shapeListFileData;
	
	/*getter and setter of fileName (String)*/
	public static String getFileName() { return fileName; }
	public static void setFileName(String fileName) { FileControl.fileName = fileName; }
	
	/*getter and setter of shapeListFileData (ShapeListFileData)*/
	public static ShapeListFileData getShapeListFileData() { return shapeListFileData; }
	public static void setShapeListFileData(ShapeListFileData shapeListFileData) { FileControl.shapeListFileData = shapeListFileData; }
	
	// 獲取檔案行數
	public static int getFileLineNum(String filename) {
		return getFileLineNum(new File(filename));
	}
	public static int getFileLineNum(File filename) {
		int count = 0;
		try {
			BufferedReader file = new BufferedReader(new FileReader(filename));
			
			// 計算行數
			while (file.readLine() != null) { count++; }
			
			file.close();
		}catch(IOException ex) {
			System.out.println(ex);
			return -1; //無法讀取檔案
		}
		
		// 返回行數
		return count;
	}
	
	// 獲取當前目錄中, 後綴名為 suffix 的檔案列表 ( 陣列 )
	public static File[] currentDirDataFileArr(String suffix) {
		
		// 當前目錄 Current directory
		File currentDir = new File(".");
		
		// 建立 FilenameFilter
		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return (name.indexOf(suffix) != -1);
			}
			
		};
		
		// 返回 FilenameFilter 過濾後的結果
		return currentDir.listFiles(filter);
	}
	
	// 返回當前目錄下可載入的檔案陣列, 並顯示檔案列表訊息
	public static File[] loadFileList(String text) {
		c.ln();
		
		// 獲取當前目錄中, 後綴名為 ".txt" 的檔案列表 ( 陣列 )
		File[] DataFiles = FileControl.currentDirDataFileArr(".txt");
		String strFileName;
		
		// 當前目錄下沒有可載入的檔案 //
		if(DataFiles.length == 0) {
			return null;
		}
		
		// 顯示檔案列表訊息 //
		c.println("There are " + DataFiles.length + " file can be " + text + " :");
		for(int i = 0; i < DataFiles.length; i++) {
			strFileName = DataFiles[i].toString();
			strFileName = strFileName.substring("./".length(), strFileName.length() - ".txt".length());
			c.println("\t" + (i+1) + ". " + strFileName);
		}
		c.println((DataFiles.length + 1) + ". Quit");
		c.ln();
		
		// 返回當前目錄下可載入的檔案陣列
		return DataFiles;
	}
	
	// 檢測非法的檔案名稱 //
	public static boolean isItIllFileName(String fileName) {
		final char[] illCharArr = { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};
		if(fileName.equals("")) {
			return true;
		}
		for(int i = 0; i < illCharArr.length; i++) {
			if(fileName.indexOf(illCharArr[i]) != -1) {
				return true;
			}
		}
		return false;
	}
	
	void display() {
		c.ln();
		c.println("Current File Name: [" + fileName + "]");
		c.println("1. Add new Shape");
		c.println("2. Edit exist Shape");
		c.println("3. Delect Shape");
		c.println("4. List infomation of All Shape and");
		c.println("    Show total Area and Perimeter");
		c.println("5. Save");
		c.println("6. Quit");
		c.ln();
	}
	
	public void part() {
		display();
		selection(new AddNewShape(),
				  new EditShape(),
				  new DelectShape(),
				  new ListShape(),
				  new SaveFile(),
				  new QuitFile());
	}
	
}
