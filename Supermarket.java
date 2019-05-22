package experiment03_Supermarket;
import java.util.*;

/** 

* @author :Mr.Young

* @version :2019年5月3日 上午10:14:11 

* Class description：超市管理,开始使用ArrayList，之后因为操作不方便换为二维数组，缺点不可变长度。
* 					ArrayList可以尝试使用，关键在于迭代器的赋值不可弄错。

*/
public class Supermarket {
	public static final int N = 5, M = 100;
	static String[] s = {"上架商品", "删除商品", "商品销售", "商品查询", "商品盘点", "退出系统"};
	Goods[][] shelves;
	static int[] count;
	static String[] category = {"食品", "蔬菜", "水果", "日用", "五金"};
	
	public Supermarket() {
		shelves = new Goods[N][M];
		count = new int[N];
	}
	
	String check() {
		String s1 = "", s2 = "";
		for(int i = 0; i < N; i++) {
			s1 += category[i]+"类商品	";
		}
		s1 += "\n";
		for(int i = 0; i < N; i++) {
			s2 += count[i]+"\t";
		}
		return s1 + s2;
	}
	
	//删除为删除单一商品，即重复只删一个。
	int delete(int l, String producer) {
		if(producer.equals("不使用")) {
			return 0;
		}
		for(int i = 0; i < count[l]; i++) {
			if(shelves[l][i].getProducer().equals(producer)) {
				update(l, i);
				return 1;
			}
		}
		return 2;
	}
	
	int delete(int l, double price) {
		if(price == 0.0) {
			return 0;
		}
		for(int i = 0; i < count[l]; i++) {
			if(shelves[l][i].getPrice() == price) {
				update(l, i);
				return 1;
			}
		}
		return 2;
	}
	
	int delete(int l, boolean l1, String name) {
		if(name.equals("")) {
			return 0;
		}
		for(int i = 0; i < count[l]; i++) {
			if(shelves[l][i].getName().equals(name)) {
				update(l, i);
				return 1;
			}
		}
		return 2;
	}
	
	String query(int l, String producer) {
		String s1 = "产地为"+producer+"的商品数量为:", s2 = "\n分别是:";
		int sum = 0;
		if(producer.equals("不使用")) {
			return "-1";
		}
		for(int i = 0; i < count[l]; i++) {
			if(shelves[l][i].getProducer().equals(producer)) {
				sum++;
				s2 += " "+shelves[l][i].getName();
			}
		}
		if(sum != 0)
			return s1 + sum + s2;
		else
			return s1 + sum;
	}
	
	String query(int l, double price) {
		String s1 = "价格为"+price+"的商品数量为:", s2 = "\n分别是:";
		int sum = 0;
		if(price == 0.0) {
			return "-1";
		}
		for(int i = 0; i < count[l]; i++) {
			if(shelves[l][i].getPrice() == price) {
				sum++;
				s2 += " "+shelves[l][i].getName();
			}
		}
		if(sum != 0)
			return s1 + sum + s2;
		else
			return s1 + sum;
	}
	
	String query(int l, boolean l1, String name) {
		String s1 = "名称为"+name+"的商品总量为:";
		int sum = 0;
		if(name.equals("")) {
			return "-1";
		}
		for(int i = 0; i < count[l]; i++) {
			if(shelves[l][i].getName().equals(name)) {
				sum += shelves[l][i].getAmount();
			}
		}
		return s1 + sum;
	}
	
	Goods query(int l, String name, String producer) {
		for(int i = 0; i < count[l]; i++) {
			if(shelves[l][i].getName().equals(name) && shelves[l][i].getProducer().equals(producer)) {
				return shelves[l][i];
			}
		}
		return null;
	}
	
	private void update(int l, int p) {
		for(int i = p; i < count[l]-1; i++) {
			shelves[l][i] = shelves[l][i+1];
		}
		shelves[l][count[l]-1] = null;		//不再指向堆内存
		count[l]--;
	}
	
	void Add(Goods good, int l) {
		shelves[l][count[l]] = good;
		count[l]++;
	}
	
	String Sale(int l, String name, String producer, double amount) throws InsufficientFundsException {
		if(name.equals("") || producer.equals("不使用") || amount == 0.0) {
			return "无效信息！";
		}
		Goods good = query(l, name, producer);
		
		if(good == null) {	//此处不能写为good.equals(null)，若为null则不能引用其静态方法了！！！
			return "商品不存在或已售出！";
		}
		return good.Sale(amount);
	}
	
}

class Goods{
	private  String name, producer;	//意在防止修改
	private  double price, amount;
	public Goods(String name, String producer, Double price, Double amount) {
		this.name = name;
		this.producer = producer;
		this.price = price;
		this.amount = amount;
	}
	
	String Sale(double amount) throws InsufficientFundsException {	//传参用于GUI
		if(this.amount < amount||this.amount <= 0) {
			throw new InsufficientFundsException(amount, this);
//			return "该类商品数量不足";
		}else {
			this.amount -= amount;
			return "售出"+amount+"件商品";
		}
	}
	
	String ShowMe() {
		return "名称\t产地\t价格\n"+name+"\t"+producer+"\t"+price;
	}
	
	String getProducer() {
		return this.producer;
	}
	
	double getPrice() {
		return this.price;
	}
	
	String getName() {
		return this.name;
	}
	
	double getAmount() {
		return this.amount;
	}
}

class InsufficientFundsException extends Exception{
	String s;
	public InsufficientFundsException(double amount, Goods good) {
		// TODO Auto-generated constructor stub
		s = "商品存货为：" + good.getAmount() +" , 用户需求为: " + amount + ".\n";
	}
	
	public void showException() {
		System.out.println(this.s);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "异常:商品存货不足！";
	}
}