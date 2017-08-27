package designPattern.Command;

public class ProcessArray {
	public void each(int[] target,Command cmd){
		cmd.process(target);
	}
}
