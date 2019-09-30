/*MainMenu.java*/

import cHabit.c;
import processControl.*;

public class MainMenu extends ProcessControl {
	
	public void display() {
		c.ln();
		c.println("1. Create new empty file");
		c.println("2. Load exist file");
		c.println("3. Delect exist file");
		c.println("4. Quit");
		c.ln();
	}
	
	public void part() {
		
		// 顯示選項, 主菜單表
		display();
		
		// 詢問, 獲取用戶輸入, 執行對應的進程
		selection(new CreateNewEmptyFile(),
				  new LoadExistFile(),
				  new DelectExistFile(),
				  new Quit());
	}
	
}
