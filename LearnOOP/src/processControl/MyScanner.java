/*MyScanner.java*/

package processControl;

import java.util.Scanner;

import cHabit.c;

public class MyScanner {
	
	// 一個靜態, 全局使用的 Scanner
	// 將在程序結束前被關閉
	public static Scanner sc = new Scanner(System.in);
	
	/*有 inputIntWithQuestion() 的的功能外，加入了上界下界的限制*/
	public static int inputIntWithQuestionWithValueLimit(String question, int lowerLimit, int upperLimit) {
		boolean error;
		int input;
		do {
			error = false;
			input = inputIntWithQuestion(question);
			
			// 上界下界限制 //
			if(input < lowerLimit || input > upperLimit) {
				error = true;
				c.println("Wrong input, please input again.\n");
			}
		}while(error);
		return input;
	}
	
	/*詢問問題, 獲取整數類型的輸入, 包括錯誤處理*/
	public static int inputIntWithQuestion(String question) {
		int input = -1; //-1 is no meaning, just ensure input or return have initialization
		boolean error;
		
		do {
			error = false;
			
			// 詢問問題
			c.print(question);
			
			try {
				// 獲取整數類型的輸入
				input = Integer.parseInt( MyScanner.sc.nextLine() );
			} catch (NumberFormatException ex) {
				// 錯誤處理 //
				error = true;
				c.println("Wrong input, please input again.\n");
			}
		}while(error);
		
		// 返回正確的輸入
		return input;
	}

}
