package data_structure;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 通过
 * @author Administrator
 *  如何在 Eclipse 中使用命令行
 *  https://www.oschina.net/question/28_46291
 */
public class TestStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyStack myStack = new MyStack();
		
		
		//通过该行输入的数据, 需要以enter结尾
		Scanner in = new Scanner(System.in);
		
		while (true){
			log(">>>>>>>>>> 通过输入字符串选择要执行的方法,  push, pop, peek, tostring ");
			
			
			//接收终端输入的数据
			String str = in.nextLine();
			
			//将输入转化为小写
			switch(str.toLowerCase()){
				case "push":
					log("请输入你要入栈的元素:");
					str = in.nextLine();
					myStack.push(str);
					log("入栈的元素是:" + str + "\t 操作完成");
					
					break;
				case "pop":
					String popStr = (String)myStack.pop();
					log("出栈的元素是 =" + popStr + "\t 操作完成");
					break;
				case "peek":
					String peekStr = (String)myStack.peek();
					log("查看的元素是 =" + peekStr + "\t 操作完成");
					break;
				case "tostring":
					log("查看栈中的所有元素");
					log(myStack);
					log("查看所有元素操作完成");
					break;
				default:
					log("你输入了错误的命令，重新开始");
			}
		}
	}
	
	private static void log(Object obj){
		System.out.println(obj);
	}
	
}
