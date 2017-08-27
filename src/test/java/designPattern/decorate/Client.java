package designPattern.decorate;

//装饰器模式：动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活
public class Client {
	public static void main(String args[]) { 
        Project employe = new Employe();        //代码工人 
        Project managerA = new ManagerA(employe); //项目经理 
        Project managerB = new ManagerB(employe); //项目经理 
        //以经理的名义将编码完成，功劳都是经理的，实际编码的是工人 
        managerA.doCoding(); 
        managerB.doCoding(); 
    } 
}
