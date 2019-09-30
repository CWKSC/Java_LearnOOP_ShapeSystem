/*QuitFile.java*/

package FileControl;

import cHabit.c;
import processControl.*;

public class QuitFile extends Quit {
	
	// 有沒有修改尚未儲存的標記
	private static boolean haveChange = false;
	
	// haveChange 的 getter 和 setter
	public static boolean isItHaveChange() { return haveChange; }
	public static void setHaveChange(boolean input) { haveChange = input; }
	
	//訊息, 詢問, 選項
	public void display() {
		c.ln();
		c.println("Since you have changes that have not been saved yet,");
		c.println("Area you sure Quit now?");
		c.println("1. Yes, Directly Quit and No Save.");
		c.println("2. Yes, but Save the changes.");
		c.println("3. No, go back, i want to do some change.");
		c.ln();
	}
	
	public void part() {
		
		// 離開前的檢測, 檢測有沒有修改尚未儲存
		if(haveChange) {
			
			// 告訴用戶有修改尚未儲存, 給出選項, 詢問
			display();
			
			// 獲取用戶輸入
			int choice = MyScanner.inputIntWithQuestionWithValueLimit(
					"Input your choose: ", //question
					1,					   //lowerLimit
					3);					   //UpperLimit
			
			// 對應用戶輸入的工作
			switch(choice) {
			
			//直接離開
			case 1: break;
			
			//儲存再離開
			case 2: new SaveFile().part(); break;
			
			//返回
			case 3: keepInThisLayer(); break;
			}
			
		}
		
		// 注意 QuitFile 繼承了 Quit 而並非 ProcessControl
		// 在 selection() 中會被視為 Quit, 默認返回上一層, 即: Quit.setState(true);
		// 故此不需要調用 backToUpperLayer(), 將直接離開
		
	}

}
