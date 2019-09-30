/*ProcessControl.java*/

package processControl;

import cHabit.c;

public abstract class ProcessControl{
	// 進程需要實現的具體工作部分
	public abstract void part();
	
	// 進程暫停
	public void SystemPause() {
		System.out.print("\nPress Enter To Continue...");
		MyScanner.sc.nextLine();
	}
	
	// 設定是否返回上一層的標記 //
	public void backToUpperLayer() { Quit.setState(true); }
	public void keepInThisLayer() { Quit.setState(false); }
	
	// 運行對應進程的部分, 內嵌在循環中, 直至返回上一層的標記為真
	public void startPart() {
		do {
			part();
		}while(!Quit.getState());
		Quit.setState(false);
	}
	
	// 選擇進程
	public void selection(ProcessControl... selectcase) {
		// 獲取用戶選擇的進程
		ProcessControl choice = selectUntilCorrectInput(selectcase);
		
		// 選擇的進程是 Quit
		if(choice instanceof Quit) {
			Quit.setState(true);
			choice.part();
			return;
		}
		
		// 執行對應進程的部分
		choice.startPart();
	}
	
	// 調用 selectProcess() 獲取輸入, 重複詢問, 直至獲得正確的輸入
	public ProcessControl selectUntilCorrectInput(ProcessControl... selectcase) {
		ProcessControl choice;
		
		do {
			//獲取用戶輸入
			choice = selectProcess(selectcase);
		}while(choice == null); // null 代表 錯誤輸入
		
		//返回正確的輸入所對應的進程
		return choice;
	}
	
	// 詢問, 輸入, 正確則返回所選擇的進程, 錯誤返回 null
	public ProcessControl selectProcess(ProcessControl... selectcase) {
		c.print("Input your choose: ");
		
		try {
			
			int index = Integer.parseInt( MyScanner.sc.nextLine() ) - 1;
			
			// 檢測上界下界 //
			if(index < 0 || index >= selectcase.length) {
				throw new NumberFormatException();
			}else {
				// 正確輸入
				return selectcase[index];
			}
		
		} catch (NumberFormatException ex) {
			// 錯誤輸入 //
			c.println("Wrong input, please input again.\n");
			return null;
		}
		
	}

}
