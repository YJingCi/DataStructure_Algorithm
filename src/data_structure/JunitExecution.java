package data_structure;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 在 project  property > Build Path > Add libraries -> 选择junit4就好
 * 
 * @author yaowen 
 *
 */

public class JunitExecution {
	
	private static final String TAG = "  JunitExecution  ";
	
	
	/**
	 * 故意制造错误
	 * 
	 * beforClass 可以去掉 static
	 * before 添加 static 看看什么情况
	 */
	
	@BeforeClass
	public static void  beforClass() {
		System.out.println(TAG + "beforClass() 运行了");
	}
	
	@Before
	public void before(){
		System.out.println(TAG + "befor() 运行了");
	}
	
	
	/**
	 * 我们在这个方法中，测试 push和pop 方法
	 */
	@Test
	public void testPushAndPopManyTime(){
		System.out.println(TAG + " 进 入 testPushAndPopManyTime() 方法 ");
		
		MyStack myStack = new MyStack();
		
//		int[] count = {10, 100, 1000, 1000, 10000};
		
		int[] count = {10};
		
		for (int i=0; i<count.length; i++){
			myStack.clear();
			
			for (int j=0; j<count[i]; j++){
				myStack.push(j);
			}
			
			for (int k= 0; k<count[i]; k++){
				myStack.peek();
				//不管stack peek了多少次， 都只是查看，不应该改变其本来的操作
				Assert.assertEquals(myStack.isEmpty(), false);
				Assert.assertTrue(myStack.size() > 0);
			}
			
			/**
			 * 之前第一行这样写的 
			 * for (int m=count[i]; m>=0; m--){
			 * 
			 * 是错误的，
			 * 
			 * 可以作为 错误示例试试
			 */
			
			for (int m=count[i]-1; m>=0; m--){
				//根据我们push的顺序，这个pop的得到的数字应该正好是相反的。
				int popValue= (int)myStack.pop();
				Assert.assertEquals(popValue, m);
			}
			
			//数据都已经 被 pop了。   那么此时栈肯定是0了。
			Assert.assertTrue(myStack.isEmpty());
			Assert.assertEquals(myStack.size(), 0);
			
			// 此时不管pop，peek多少次，他都应该为null.
			for (int n=0; n<count[i]; n++){
				Assert.assertNull(myStack.peek());
				Assert.assertNull(myStack.pop());
			}
		
		}
		
	}
	
	
	
//	public static  void afterClass(){
	@AfterClass
	public static  void afterClass(){
		System.out.println(TAG + "afterClass() 运行了");
	}
	
	@After
	public  void after(){
		System.out.println(TAG + "after() 运行了");
	}
}
