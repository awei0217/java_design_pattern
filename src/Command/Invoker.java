package Command;

/**
 * Created by sunpengwei on 2016/9/18.
 */

/**
 * 命令的发起者
 */
public class Invoker {


	public static void main(String[] args) {
		String command = "start";
		Receive myReceive = new MyReceive();
		Command myCommand = new MyCommand(myReceive);
		boolean result = myCommand.exec(command);
		if (result){
			System.out.println("命令执行成功");
		}else {
			System.out.println("命令执行失败");
		}

	}


}
