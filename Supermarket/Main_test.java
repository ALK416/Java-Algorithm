package experiment03_Supermarket;

public class Main_test {
	public static void main(String[] args) {
		Supermarket sup = new Supermarket();	//底层存储为二维数组
		Supermarket2 sup2 = new Supermarket2(); //底层存储为二维ArrayList，即二维动态数组
//		LoginDialog l1 = new LoginDialog(sup);
		LoginDialog l1 = new LoginDialog(sup2);	//此处用到上转型,上转型不能操作子类新增加变量方法是出于安全性、实际性考虑
		
	}
}
