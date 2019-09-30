/*Quit.java*/

package processControl;

public class Quit extends ProcessControl{
	
	// 是否返回上一層的標記
	private static boolean quitState = false;
	
	// quitState 的 getter 和 setter
	public static boolean getState() { return quitState; }
	public static void setState(boolean input) { quitState = input; }
	
	// 沒有具體工作, 作為被 instanceof 檢查的存在, 默認標記返回上一層
	// 可參看 ProcessControl 中的 selection
	public void part() { }
	
}
