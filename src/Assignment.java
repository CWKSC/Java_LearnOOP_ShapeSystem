/*Assignment.java*/

import cHabit.c;
import processControl.MyScanner;

public class Assignment {
	
	// 整個 Program 的開始點
	public static void main(String[] args) {
		
		// 呼叫主菜單的部分
		new MainMenu().startPart();
		
		// 離開訊息 //
		c.ln();
		c.println("Exit Program, Thank you for your using~!");
		
		// 關閉 Scanner
		MyScanner.sc.close();
		
	}
	
}