package Command;

/**
 * Created by sunpengwei on 2016/9/18.
 */
public class MyReceive implements Receive {
	@Override
	public boolean execCommand(String command) {
		if ("start".equals(command))
			return  true;
		return false;
	}
}
