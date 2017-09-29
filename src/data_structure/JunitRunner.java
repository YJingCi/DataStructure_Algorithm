package data_structure;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



public class JunitRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" 开始执行测试case ");
		
		Result result = JUnitCore.runClasses(JunitExecution.class);
		for (Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
		
		System.out.println("测试case运行结果  =   " + result.wasSuccessful());
	}

}
