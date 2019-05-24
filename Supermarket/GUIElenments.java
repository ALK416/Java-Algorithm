package experiment03_Supermarket;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUIElenments {	//专用GUI
	public static void main(String[] args) {
//		Supermarket sup = new Supermarket();
//		LoginDialog l1 = new LoginDialog(sup);
	}
}


class MainWindow extends JFrame {
	JButton[] b;
	GridLayout gridlayout;
	MainWindow(String name[]){
		b = new JButton[name.length];	//给索引new空间!
		for(int i = 0; i < name.length; i++) {
			b[i] = new JButton(name[i]);
		}
		gridlayout = new GridLayout(3, 3);
	}
	
	void load(Supermarket parameter) {
		this.setTitle("超市管理系统");
		this.setLayout(gridlayout);
		for(int i = 0; i < b.length; i++) {
			this.add(b[i]);
		}
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				exitSystem();
			}
		});
		for(int i = 0; i < b.length; i++) {
			b[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton nb = (JButton)e.getSource();
					String s = nb.getText();
//					System.out.println(nb.getText());
					switch(s){
						case "上架商品":
							InputScoresDialog a = new InputScoresDialog(parameter);
							a.setVisible(true);
							break; 
						case "删除商品":
							InputSD_Del b = new InputSD_Del(parameter);
							break;
						case "商品销售":
							Sale_Dialog c = new Sale_Dialog(parameter);
							break;
						case "商品查询":
							Query_Dialog d = new Query_Dialog(parameter);
							break;
						case "商品盘点":
							Check_Dialog e_e = new Check_Dialog(parameter);
							break;
						case "退出系统":
							exitSystem();
							break;
					}
						
				}
			});
		}
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(600, 600, 600, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	void exitSystem() // 处理退出系统事件
	{
		int ret = JOptionPane.showConfirmDialog(this, "退出系统吗？", "退出系统吗？",
				JOptionPane.YES_NO_OPTION);
		if (ret == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void setSubmit(String str) {
		// TODO Auto-generated method stub
		
	}
	
}

class LoginDialog extends JDialog {// 登录对话框类
	JLabel usernamelbl;
	JLabel passwordlbl;
	JComboBox username;
	JPasswordField password;
	JButton loginBtn;
	JButton cancelBtn;

	LoginDialog(Supermarket parameter) {
		createGUIElements(parameter);
		this.setVisible(true);
	}//

	void createGUIElements(Supermarket parameter) {
		// 设置登录对话框,并设置位置及大小、模态等
		setTitle("登录系统");
		setBounds(500, 250, 200, 120);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				logout();
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);	//需要加否则会有问题,因为默认是hide_on_close(也就是点了'X'键就会
																//反应)，所以需要说明一下
		setLayout(null);
		setModal(true);
		// 创建用户名与密码标签
		usernamelbl = new JLabel("用户名:");
		usernamelbl.setBounds(20, 10, 50, 20);
		this.add(usernamelbl);
		passwordlbl = new JLabel("密  码:");
		passwordlbl.setBounds(20, 32, 50, 20);
		this.add(passwordlbl);

		// 创建用户名与密码输入组件,并赋处值
		username = new JComboBox();
		username.addItem("administrator");
		username.setBounds(75, 10, 105, 20);
		this.add(username);
		password = new JPasswordField("123456");
		password.setBounds(75, 33, 105, 20);
		password.setEchoChar('*');
		this.add(password);

		// 创建登录与退出按钮,并添加事件
		loginBtn = new JButton("登录");
		loginBtn.setBounds(25, 60, 60, 20);
		add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login(parameter);
			} // 方法结束
		});
		cancelBtn = new JButton("退出");
		cancelBtn.setBounds(110, 60, 60, 20);
		add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
	}

	void login(Supermarket parameter) // 处理登录按钮事件
	{
		String accout = username.getSelectedItem().toString();
		String pwd = new String(password.getPassword());

		// 如果用户名与密码正确,则隐藏登录对话框,显示主窗体
		if (accout.equals("administrator") && pwd.equals("123456")) {
			setVisible(false);// 只隐藏存在潜在问题，可用dispose()彻底销毁
			showMianWindow(parameter);// 显示主窗体
		} else {
			JOptionPane.showMessageDialog(this, "登录失败, 请检查用户名或密码。");
		}
	}

	void logout()// 处理取消按钮事件
	{
		int ret = JOptionPane.showConfirmDialog(this, "是否取消登录?", "取消登录",
				JOptionPane.YES_NO_OPTION);
		if (ret == JOptionPane.YES_OPTION) {
			dispose();
		}
	}

	void showMianWindow(Supermarket parameter) {// 显示主窗体
		MainWindow frm = new MainWindow(Supermarket.s);
		frm.load(parameter);
	}
}// class LoginDialog 

class InputScoresDialog extends JDialog {// 录入成绩对话框类
	//将异常处理留在前端
	
	JComboBox name;//类别
	JTextField maths;//名称
	JComboBox english;//产地
	JTextField price, amount;

	InputScoresDialog(Supermarket parameter) {
		setTitle("商品信息录入");
		setBounds(500, 250, 240, 260);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);
		setModal(true);
		createGUIElements(parameter);
//		this.setVisible(true);
	}

	void createGUIElements(Supermarket parameter) {
		JLabel namelbl = new JLabel("类别:");
		namelbl.setBounds(10, 20, 60, 25);
		add(namelbl);
		
		JLabel englishlbl = new JLabel("产地:");
		englishlbl.setBounds(10, 50, 60, 25);
		add(englishlbl);
		
		JLabel mathslbl = new JLabel("名称:");
		mathslbl.setBounds(10, 80, 80, 25);
		add(mathslbl);
		
		JLabel pricelbl = new JLabel("价格:");
		pricelbl.setBounds(10, 110, 80, 25);
		add(pricelbl);
		
		JLabel amountlbl = new JLabel("数量:");
		amountlbl.setBounds(10, 140, 80, 25);
		add(amountlbl);
		
		name = new JComboBox(Supermarket.category);
		name.setBounds(100, 20, 120, 25);
		add(name);
		
		String[] ranks = { "山西", "河南", "重庆", "陕西", "四川", "北京", "新疆"};
		english = new JComboBox(ranks);
		english.setBounds(100, 50, 120, 25);
		add(english);
		
		maths = new JTextField();
		maths.setBounds(100, 80, 120, 25);
		maths.setText("");
		add(maths);
		
		price = new JTextField();
		price.setBounds(100, 110, 120, 25);
		price.setText("0.0");
		add(price);
		
		amount = new JTextField();
		amount.setBounds(100, 140, 120, 25);
		amount.setText("0.0");
		add(amount);
		
		JButton submitBtn = new JButton("提交");
		submitBtn.setBounds(20, 180, 80, 25);
		add(submitBtn);
		
		JButton cancelBtn = new JButton("取消");
		cancelBtn.setBounds(130, 180, 80, 25);
		add(cancelBtn);
		
		// 遍历容器中的所有组件，设置字体
		for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
			Component comp = this.getContentPane().getComponent(i);
			comp.setFont(new Font("宋体", Font.BOLD, 20));
		}
		// 添加提交成绩事件
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int line = name.getSelectedIndex();
				Goods t = new Goods(maths.getText(), english.getSelectedItem().toString(), 
				Double.parseDouble(price.getText()), Double.parseDouble(amount.getText()));
				parameter.Add(t, line);
				JOptionPane.showMessageDialog(null, "操作成功！");
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();// 撤销成绩录入对话框，返回主窗体
			}
		});
	}
}

class InputSD_Del extends JDialog{
	JComboBox name;//类别
	JTextField maths;//名称
	JComboBox english;//产地
	JTextField price, amount;
	
	InputSD_Del(Supermarket parameter) {
		setTitle("删除商品");
		setBounds(500, 250, 240, 260);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);
		setModal(true);
		createGUIElements(parameter);
		this.setVisible(true);
	}

	void createGUIElements(Supermarket parameter) {
		JLabel namelbl = new JLabel("类别:");
		namelbl.setBounds(10, 20, 60, 25);
		add(namelbl);
		
		JLabel englishlbl = new JLabel("产地:");
		englishlbl.setBounds(10, 50, 60, 25);
		add(englishlbl);
		
		JLabel mathslbl = new JLabel("名称:");
		mathslbl.setBounds(10, 80, 80, 25);
		add(mathslbl);
		
		JLabel pricelbl = new JLabel("价格:");
		pricelbl.setBounds(10, 110, 80, 25);
		add(pricelbl);
		
//		JLabel amountlbl = new JLabel("数量:");
//		amountlbl.setBounds(10, 140, 80, 25);
//		add(amountlbl);
		
		name = new JComboBox(Supermarket.category);
		name.setBounds(100, 20, 120, 25);
		add(name);
		
		String[] ranks = { "不使用", "山西", "河南", "重庆", "陕西", "四川", "北京", "新疆"};
		english = new JComboBox(ranks);
		english.setBounds(100, 50, 120, 25);
		add(english);
		
		maths = new JTextField();
		maths.setBounds(100, 80, 120, 25);
		maths.setText("");
		add(maths);
		
		price = new JTextField();
		price.setBounds(100, 110, 120, 25);
		price.setText("0.0");
		add(price);
		
//		amount = new JTextField();
//		amount.setBounds(100, 140, 120, 25);
//		amount.setText("0.0");
//		add(amount);
		
		JButton submitBtn = new JButton("提交");
		submitBtn.setBounds(20, 180, 80, 25);
		add(submitBtn);
		
		JButton cancelBtn = new JButton("取消");
		cancelBtn.setBounds(130, 180, 80, 25);
		add(cancelBtn);
		
		// 遍历容器中的所有组件，设置字体
		for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
			Component comp = this.getContentPane().getComponent(i);
			comp.setFont(new Font("宋体", Font.BOLD, 20));
		}
		// 添加提交成绩事件
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Goods tmp;
				int line = name.getSelectedIndex();				
				int flag = parameter.delete(line, english.getSelectedItem().toString());
				int flag1 = parameter.delete(line, true, maths.getText());
				int flag2 = parameter.delete(line, Double.parseDouble(price.getText()));
				if(flag > 0) {
					if(flag == 1) {
						JOptionPane.showMessageDialog(null, "删除成功!");
					}else {
						JOptionPane.showMessageDialog(null, "删除失败!");
					}
				}else if(flag1 > 0){
					if(flag1 == 1) {
						JOptionPane.showMessageDialog(null, "删除成功!");
					}else {
						JOptionPane.showMessageDialog(null, "删除失败!");
					}
				}else if(flag2 > 0) {
					if(flag2 == 1) {
						JOptionPane.showMessageDialog(null, "删除成功!");
					}else {
						JOptionPane.showMessageDialog(null, "删除失败!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "无效信息!");
				}
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();// 撤销成绩录入对话框，返回主窗体
			}
		});
	}
	
}

class Check_Dialog extends JDialog{
	JPanel p;
	JTextArea t;
	public Check_Dialog(Supermarket p){
		t = new JTextArea();
		this.p = new JPanel();
		this.setTitle("商品盘点");
		load(p);
	}
	public void load(Supermarket p) {
		t.setText(p.check());
		t.setEditable(false);
		this.p.add(t);
		this.add(this.p, BorderLayout.NORTH);
		
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

class Sale_Dialog extends JDialog{
	JComboBox name;//类别
	JTextField maths;//名称
	JComboBox english;//产地
	JTextField amount;
	
	Sale_Dialog(Supermarket parameter) {
		setTitle("商品销售");
		setBounds(500, 250, 240, 260);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);
		setModal(true);
		createGUIElements(parameter);
		this.setVisible(true);
	}

	void createGUIElements(Supermarket parameter) {
		JLabel namelbl = new JLabel("类别:");
		namelbl.setBounds(10, 20, 60, 25);
		add(namelbl);
		
		JLabel englishlbl = new JLabel("产地:");
		englishlbl.setBounds(10, 50, 60, 25);
		add(englishlbl);
		
		JLabel mathslbl = new JLabel("名称:");
		mathslbl.setBounds(10, 80, 80, 25);
		add(mathslbl);
		
		JLabel pricelbl = new JLabel("数量:");
		pricelbl.setBounds(10, 110, 80, 25);
		add(pricelbl);
		
		name = new JComboBox(Supermarket.category);
		name.setBounds(100, 20, 120, 25);
		add(name);
		
		String[] ranks = { "不使用", "山西", "河南", "重庆", "陕西", "四川", "北京", "新疆"};
		english = new JComboBox(ranks);
		english.setBounds(100, 50, 120, 25);
		add(english);
		
		maths = new JTextField();
		maths.setBounds(100, 80, 120, 25);
		maths.setText("");
		add(maths);
		
		amount = new JTextField();
		amount.setBounds(100, 110, 120, 25);
		amount.setText("0.0");
		add(amount);
		
		JButton submitBtn = new JButton("提交");
		submitBtn.setBounds(20, 180, 80, 25);
		add(submitBtn);
		
		JButton cancelBtn = new JButton("取消");
		cancelBtn.setBounds(130, 180, 80, 25);
		add(cancelBtn);
		
		// 遍历容器中的所有组件，设置字体
		for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
			Component comp = this.getContentPane().getComponent(i);
			comp.setFont(new Font("宋体", Font.BOLD, 20));
		}
		// 添加提交成绩事件
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Goods tmp;
				int line = name.getSelectedIndex();	
				String flag;
				try {
					flag = parameter.Sale(line, maths.getText(), 
							english.getSelectedItem().toString(), Double.parseDouble(amount.getText()));
					JOptionPane.showMessageDialog(null, flag);
				} catch (InsufficientFundsException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.showException();
					JOptionPane.showMessageDialog(null, "商品库存不足或已售出！");
//					e.printStackTrace();	//行数过多
				}
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();// 撤销成绩录入对话框，返回主窗体
			}
		});
	}
}

class Query_Dialog extends JDialog{
	JComboBox name;//类别
	JTextField maths;//名称
	JComboBox english;//产地
	JTextField price;
	
	Query_Dialog(Supermarket parameter) {
		setTitle("商品查询");
		setBounds(500, 250, 240, 260);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);
		setModal(true);
		createGUIElements(parameter);
		this.setVisible(true);
	}

	void createGUIElements(Supermarket parameter) {
		JLabel namelbl = new JLabel("类别:");
		namelbl.setBounds(10, 20, 60, 25);
		add(namelbl);
		
		JLabel englishlbl = new JLabel("产地:");
		englishlbl.setBounds(10, 50, 60, 25);
		add(englishlbl);
		
		JLabel mathslbl = new JLabel("名称:");
		mathslbl.setBounds(10, 80, 80, 25);
		add(mathslbl);
		
		JLabel pricelbl = new JLabel("价格:");
		pricelbl.setBounds(10, 110, 80, 25);
		add(pricelbl);
		
		name = new JComboBox(Supermarket.category);
		name.setBounds(100, 20, 120, 25);
		add(name);
		
		String[] ranks = { "不使用", "山西", "河南", "重庆", "陕西", "四川", "北京", "新疆"};
		english = new JComboBox(ranks);
		english.setBounds(100, 50, 120, 25);
		add(english);
		
		maths = new JTextField();
		maths.setBounds(100, 80, 120, 25);
		maths.setText("");
		add(maths);
		
		price = new JTextField();
		price.setBounds(100, 110, 120, 25);
		price.setText("0.0");
		add(price);
		
		JButton submitBtn = new JButton("提交");
		submitBtn.setBounds(20, 180, 80, 25);
		add(submitBtn);
		
		JButton cancelBtn = new JButton("取消");
		cancelBtn.setBounds(130, 180, 80, 25);
		add(cancelBtn);
		
		// 遍历容器中的所有组件，设置字体
		for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
			Component comp = this.getContentPane().getComponent(i);
			comp.setFont(new Font("宋体", Font.BOLD, 20));
		}
		// 添加提交成绩事件
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Goods tmp;
				int line = name.getSelectedIndex();				
				String flag = parameter.query(line, english.getSelectedItem().toString());
				String flag1 = parameter.query(line, true, maths.getText());
				String flag2 = parameter.query(line, Double.parseDouble(price.getText()));	//异常处理
				if(!flag.equals("-1")) {
					JOptionPane.showMessageDialog(null, flag);
				}else if(!flag1.equals("-1")){
					JOptionPane.showMessageDialog(null, flag1);
				}else if(!flag2.equals("-1")) {
					JOptionPane.showMessageDialog(null, flag2);
				}else {
					JOptionPane.showMessageDialog(null, "无效信息!");
				}
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();// 撤销成绩录入对话框，返回主窗体
			}
		});
	}
	
}
