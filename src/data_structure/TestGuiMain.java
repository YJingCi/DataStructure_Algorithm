package data_structure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestGuiMain {
	
	
	public static void main(String[] args) {
		new TestGuiMain().showMe();
	}
	
	//////////// ------------------  以及内容是 测试栈的 界面以及相关内容 ------------------------------///////////////////
	
	private JFrame jFrame;
	private JPanel jpanel_1, jpanel_2, jpanel_3;
	private JTextField inputTextField;
	private JButton[] jButtons;
//	private JButton c_jbs;
	
	private JTextField operateDisplayTextField;
	private JTextField toStringTextFiled;
	
	private String flag=null;
	private double s1 = 0.0;
	private double s2 = 0.0;
	
	private static final String PUSH = "push";
	private static final String POP = "pop";
	private static final String PEEK = "peek";
	private static final String QUERY = "查看信息";

	private String str0 = "";
	
	//测试主题 
	private MyStack myStack = new MyStack();
	
	public TestGuiMain() {
		jFrame = new JFrame("简单测试的界面");
		
		inputTextField = new JTextField(15);
		
		operateDisplayTextField = new JTextField(100);
		operateDisplayTextField.setText("你还没有操作");
		operateDisplayTextField.setEditable(false);
		
		toStringTextFiled = new JTextField(100);
		toStringTextFiled.setText("");
		toStringTextFiled.setEditable(false);
		
		jButtons = new JButton[5];
		for (int i=0; i<jButtons.length; i++){
			jButtons[i] = new JButton();
		}
		
		jButtons[0].setText(PUSH);
		jButtons[1].setText(POP);
		jButtons[2].setText(PEEK);
		jButtons[3].setText(QUERY);
		jButtons[4].setText("");
		
		
		jpanel_1 = new JPanel();
		jpanel_2 = new JPanel();
		jpanel_3 = new JPanel();
		
		initView();
		initListener();
	}

	private void initView() {
		jpanel_1.setLayout(new FlowLayout());
		jpanel_1.add(inputTextField);
		inputTextField.setEditable(true);

		inputTextField.setText("0");
		
		jpanel_2.setLayout(new FlowLayout());
		for (int i = 0; i < jButtons.length; i++) {
			jpanel_2.add(jButtons[i]);
		}
		
		jpanel_3.setLayout(new GridLayout(2, 1));
		jpanel_3.add(operateDisplayTextField);
		jpanel_3.add(toStringTextFiled);
		
		jFrame.add(jpanel_1, BorderLayout.NORTH);
		jFrame.add(jpanel_2, BorderLayout.CENTER);
		jFrame.add(jpanel_3, BorderLayout.SOUTH);
	}

	public void showMe() {
		jFrame.setVisible(true);
//		jFrame.setSize(500, 500);
		jFrame.pack(); //自动匹配大小
		jFrame.setLocation(200, 200);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFontAndColor();
	}

	private void setFontAndColor() {
		// 设置字体和颜色
		Font f = new Font("楷体", Font.BOLD, 14);
		inputTextField.setFont(f);
		Color c = new Color(128, 198, 077);
		jpanel_1.setBackground(Color.DARK_GRAY);
		for (int i = 0; i < jButtons.length; i++) {
			jButtons[i].setBackground(Color.gray);
		}
	}

	public void initListener() {	
		for (int i = 0; i < jButtons.length; i++) {
			jButtons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 拿到按钮上的名字
					String str = e.getActionCommand();

					switch (str){
					case PUSH:
						setOperateDisplay("push操作 -> 操作数  = "  + getInputStr());
						myStack.push(getInputStr());
						break;
					case POP:
						setOperateDisplay("pop操作 -> 弹出内容= " + myStack.pop());
						break;
					case PEEK:
						setOperateDisplay("peek操作 -> 查看内容= " + myStack.peek());
						break;
					case QUERY:
						setToString();
						break;
						default:
							break;
					}
					
					setToString();
				}
			});
		}
	}
	
	private void setOperateDisplay(String  operStr){
		operateDisplayTextField.setText(getHHMMSSTime() + "  " + operStr);
	}
	
	private void setToString(){
		toStringTextFiled.setText(getHHMMSSTime() + "  " + "栈中的内容 -> " + myStack);
	}
	
	private String getInputStr(){
		String input = inputTextField.getText().trim();
		return input;
	}
	
	//得到 类似  19:46:52 分的时间格式， (基本上是为了显示操作时间) 
	private static String getHHMMSSTime(){
		String time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			time = sdf.format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return time;
	}
	
	
}
