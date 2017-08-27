package designPattern.Command;

//命令模式
public class Test {
	public static void main(String[] args){
		ProcessArray pa = new ProcessArray();
		int[] target = {3,-4,6,4};
		pa.each(target,new Command(){
			@Override
			public void process(int[] target) {
				for(int tmp:target){
					System.out.println("迭代输出目标数组的元素：" + tmp);
				}
			}
		});
		System.out.println("----------------------");
		pa.each(target, new Command() {
			
			@Override
			public void process(int[] target) {
				int sum = 0;
				for(int tmp:target){
					sum += tmp;
				}
				System.out.println("数组元素的总和是：" + sum);
			}
		});
	}
}
