package experiment03_Supermarket;
import java.util.*;

/** 

* @author :Mr.Young

* @version :2019年5月22日

* Class description：超市管理 version 2.0
* 					,主要改变：
* 					将存储容器改为ArrayList,可变。
* 					需要注意的就是泛型数组或带泛型的数组使用有很大可能不成功！
* 					本版本支持货架增加。
* 
* test ：
* 
	* 	public static void main(String[] args) {
			Supermarket2 s = new Supermarket2();
			Goods tmp = new Goods("123", "123", 123.0, 123.0);
			s.Add(tmp, 4);
			s.Add(tmp, 3);
			s.Add(tmp, 2);
			s.Add(tmp, 1);
			s.Add(tmp, 0);
			System.out.println(s.shelves.get(4).size());
			System.out.println(s.check());
			System.out.println(s.delete(4, "123"));
			System.out.println(s.check());
			System.out.println(s.shelves.get(4).size());
		}
	
* 					

*/
public class Supermarket2  extends Supermarket{
	String[] s = {"上架商品", "删除商品", "商品销售", "商品查询", "商品盘点", "退出系统"};
	List<ArrayList<Goods>> shelves;
	String[] category = {"食品", "蔬菜", "水果", "日用", "五金"};
	int N = category.length;		//用子超市可以考虑static，此处不用static
	
	public Supermarket2() {
		shelves = new ArrayList<>();	//分配内存
		for(int i = 0; i < N; i++) {	//初始化货架
			shelves.add(new ArrayList<>());
		}
	}
	
	String check() {
		String s1 = "", s2 = "";
		for(int i = 0; i < N; i++) {
			s1 += category[i]+"类商品	";
		}
		s1 += "\n";
		for(int i = 0; i < N; i++) {
			s2 += shelves.get(i).size()+"\t";
		}
		return s1 + s2;
	}
	
	//删除为删除单一商品，即重复只删一个。
	int delete(int l, String producer) {
		if(producer.equals("不使用")) {
			return 0;
		}
		
		ArrayList<Goods> it = shelves.get(l);	//不使用迭代器,迭代器的比较删除不易操作
		for(int i = 0; i < it.size(); i++) {
			if(it.get(i).getProducer().equals(producer)) {
				it.remove(i);
				return 1;
			}
		}
		
		return 2;
	}

	
	int delete(int l, double price) {
		if(price == 0.0) {
			return 0;
		}
		
		ArrayList<Goods> it = shelves.get(l);	//不使用迭代器,迭代器的比较删除不易操作
		for(int i = 0; i < it.size(); i++) {
			if(it.get(i).getPrice() == price) {
				it.remove(i);
				return 1;
			}
		}
		
		return 2;
	}
	
	int delete(int l, boolean l1, String name) {
		if(name.equals("")) {
			return 0;
		}
		
		ArrayList<Goods> it = shelves.get(l);	//不使用迭代器,迭代器的比较删除不易操作
		for(int i = 0; i < it.size(); i++) {
			if(it.get(i).getName().equals(name)) {
				it.remove(i);
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
		ArrayList<Goods> it = shelves.get(l);
		for(int i = 0; i < it.size(); i++) {
			if(it.get(i).getProducer().equals(producer)) {
				sum++;
				s2 += " "+it.get(i).getName();
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
		ArrayList<Goods> it = shelves.get(l);
		for(int i = 0; i < it.size(); i++) {
			if(it.get(i).getPrice() == price) {
				sum++;
				s2 += " "+it.get(i).getName();
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
		ArrayList<Goods> it = shelves.get(l);
		for(int i = 0; i < it.size(); i++) {
			if(it.get(i).getName().equals(name)) {
				sum += it.get(i).getAmount();
			}
		}
		return s1 + sum;
	}
	
	Goods query(int l, String name, String producer) {
		ArrayList<Goods> it = shelves.get(l);
		for(int i = 0; i < it.size(); i++) {
			if(it.get(i).getName().equals(name) && it.get(i).getProducer().equals(producer)) {
				return it.get(i);
			}
		}
		return null;
	}

	void Add(Goods good, int l) {
		shelves.get(l).add(good);
//		System.out.println("123");
	}
	
	String Sale(int l, String name, String producer, double amount) throws InsufficientFundsException {
		if(name.equals("") || producer.equals("不使用") || amount == 0.0) {
			return "无效的信息！";
		}
		Goods good = query(l, name, producer);
		
		if(good == null) {	//此处不能写为good.equals(null)，若为null则不能引用其静态方法了！！！
			return "商品不存在或者已经售出！";
		}
		return good.Sale(amount);
	}
	
}