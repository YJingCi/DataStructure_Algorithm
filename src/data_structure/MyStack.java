package data_structure;


/**
 * 当然，一个栈中应该可以存放各种数据类型，或者 对象等。。
 * 
 * 所以在 相关的书上，关于类型直接使用了 泛型。(就是 T 符号)
 * 为了简单起见，在这里，我们使用了 Object 类型。
 * 而在实际测试时，也为了方便起见，直接使用了   整数  来进行测试
 * @author yaowen
 *
 */
public class MyStack {

	
	private Object[] arr;  //用来保存数据的 数组
	private int  count = 0;  //当前的栈中，保存了的 元素的数量 
	
	private static int INIT_LENGTH = 64;
	
	public MyStack() {
		super();
		// TODO Auto-generated constructor stub
		arr = new Object[INIT_LENGTH];
	}

	//入栈操作
	public void push(Object obj){
		//如果这个数组已经满了，那么我们就需要给数组扩容了。
		if (count == arr.length){
			Object[] newArr = new Object[arr.length*2];
			//把旧数组的数据 复制到新数组中
			for (int i=0; i<count; i++){
				newArr[i] = arr[i];
			}
			
			arr = newArr;
 		}
		
		arr[count] = obj;
		count++;
	}
	
	//出栈操作, 若没有数组则返回null
	public Object pop(){
		if (count == 0){
			return null;
		} else{
			Object tmp = arr[count-1];
			count--;
			return tmp;
		}
	}
	
	//查看栈顶元素
	public Object peek(){
		if (count == 0){
			return null;
		} else{
			return arr[count-1];
		}
	}
	
	//返回栈的长度
	public int size() {
		return count;
	}
	
	public void clear(){
		arr = new Object[INIT_LENGTH];
		count = 0;
	}
	
	//判断这个栈是否为null。  true为空，   false 表示不为空
	public boolean isEmpty(){
		return (count==0) ? true : false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("该栈中 元素的数量 =" + count + "  它们依次是：");
		for (int i=0; i<count; i++){
			sb.append(arr[i] + "  ");
		}
		
		return sb.toString();
	}
	
	
	
}
