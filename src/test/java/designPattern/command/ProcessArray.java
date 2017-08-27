package designPattern.command;

public class ProcessArray {
	public void each(int[] target,Command cmd){
		cmd.process(target);
	}
}
