package designPattern.factory.simpleFactory;

/**
 * @date 2017年8月17日10:43:09
 * @author cqw
 * @description 工厂类
 *
 */
public class Factory {

   public BMW createBMW(int type) {  
        switch (type) {  
	        case 320:  
	            return new BMW320();  
	        case 523:  
	            return new BMW523();  
	        default:  
	            break;  
        }  
        return null;  
    }
}
