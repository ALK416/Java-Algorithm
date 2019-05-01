package experiment2;

/**
 * MatrixOperations 类为了数值计算实验的矩阵操作而编写的,可以对一个 ( double )矩阵进行基本操作的类
 * 封装了如下方法 : 
 * (1)使用一个矩阵及其规格 ( 行数与列数 ) 初始化一个 MatrixOperations 对象
 * (2)改变对象中存储的矩阵数据 ( 通过传入一个新的矩阵 )
 * (3)打印此矩阵
 * (4)对矩阵中的两行进行操作 ( TargetRow = TargetRow + VALUE * SOURCEROW )
 * (5)交换矩阵中的两行
 * (6)返回这个矩阵本身
 * (7)返回这个矩阵的行数
 * (8)返回这个矩阵的列数
 * 
 * @author Pro_ALK416
 *
 */

public class MatrixOperations {

	private double dataMatrix[][];	//类中方法所操作的矩阵
	private int rowSum=0;	//矩阵的行数
	private int colSum=0;	//矩阵的列数
	
	/**
	 * 功能 : 构造一个矩阵操作对象 ( 使用一个二维double数组 )
	 * 
	 * @param ROWSUM	此矩阵的行数
	 * @param COLSUM	此矩阵的列数
	 * @param MATRIX	此二维double数组
	 */
	public MatrixOperations(int ROWSUM,int COLSUM,double[][] MATRIX){		//初始化矩阵
		
		this.dataMatrix=MATRIX;
		this.rowSum=ROWSUM;
		this.colSum=COLSUM;
		
	}
	
	/**
	 * 功能 : 改变此对象中存储的矩阵信息
	 * 
	 * @param MATRIX	需要更新的矩阵数据 ( double类型二维数组 )
	 */
	public void changeDataMatrix(double[][] MATRIX){
		
		this.dataMatrix=MATRIX;		//增加灵活性,使用一个矩阵构造了对象之后还可以在使用过程中修改矩阵
		
	}
	
	/**功能 : 对矩阵中的两个行进行操作 ( TargetRow = TargetRow + VALUE * SOURCEROW )
	 * 
	 * @param TARGETROW	
	 * @param VALUE
	 * @param SOURCEROW
	 */
	public void rowOperation(int TARGETROW,double VALUE,int SOURCEROW){
		
		for(int colTemp=0;colTemp<colSum;colTemp++){
			
			//将 SOURCEROW 上的每一个元素乘以 VALUE ,然后加到 TARGETROW 上对应的每一个元素上
			dataMatrix[TARGETROW][colTemp]+=dataMatrix[SOURCEROW][colTemp]*VALUE;
			
		}
		
	}

	/**交换一个矩阵中的两行
	 * 
	 * @param ROW1 行1
	 * @param ROW2 行2
	 */
	public void rowSwap(int ROW1,int ROW2){
		
		double temp=0;
		
		 for(int colTemp=0;colTemp<colSum;colTemp++){
			 
			 temp=dataMatrix[ROW1][colTemp];
			 dataMatrix[ROW1][colTemp]=dataMatrix[ROW2][colTemp];
			 dataMatrix[ROW2][colTemp]=temp;
			 
		 }
		
	}
	
	public void showMatrix(){		//打印对象中所存储的矩阵数据
		
		System.out.println("----------------\nData matrix : ");
		
		for(int row=0;row<rowSum;row++){
			
			for(int col=0;col<colSum;col++){
				
				System.out.print(dataMatrix[row][col]+" ");
				
			}
			
			System.out.print("\n");
			
		}
		System.out.println("----------------\n");
		
	}
	
	/**
	 * 功能 : 返回对象中存储的矩阵数据 ( double[][] 类型 )
	 * @return dataMatrix ( double[][] )
	 */
	public double[][] returnDataMatrix(){
		
		return (dataMatrix);
		
	}
	
	/**
	 * 功能 : 返回对象中存储矩阵的行数 
	 * @return 行数 (int)
	 */
	public int returnRowSum(){
		
		return(this.rowSum);
		
	}
	
	/**
	 * 功能 : 返回对象中存储矩阵的列数
	 * @return 列数 (int)
	 */
	public int returnColSum(){
		
		return(this.colSum);
		
	}
	
}
