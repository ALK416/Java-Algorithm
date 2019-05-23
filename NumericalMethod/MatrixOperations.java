package experiment2;

/**
 * MatrixOperations 类为了数值计算实验的矩阵操作而编写的,可以对一个 ( double )矩阵进行基本操作的类
 * 封装了如下方法 : 
 * (1)使用一个矩阵及其规格 ( 行数与列数 ) 初始化一个 MatrixOperations 对象
 * (2)改变对象中存储的矩阵数据 ( 通过传入一个新的矩阵 )
 * (3)打印此矩阵
 * (3.5)打印指定矩阵
 * (4)对矩阵中的两行进行操作 ( TargetRow = TargetRow + VALUE * SOURCEROW )
 * (5)交换矩阵中的两行
 * (6)返回这个矩阵本身
 * (7)返回这个矩阵的行数
 * (8)返回这个矩阵的列数
 * (9)返回矩阵中的指定元素
 * (10)对矩阵中的每一行进行乘法操作
 * (11)返回矩阵与向量相乘所得的结果向量
 * (12)返回向量中按模最大的那个元素
 * (13)将一个向量的每一个元素取绝对值,然后返回这个向量
 * (14)打印一个向量
 * (15)对向量中的每个元素进行乘法操作
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
	
	/**
	 * 功能 : 打印对象中所存储的矩阵
	 */
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
	 * 打印指定矩阵
	 * 参数为矩阵及其规格
	 * 
	 * @param DATAMATRIX
	 * @param ROWSUM
	 * @param COLSUM
	 */
	public void showMatrix(double[][] DATAMATRIX,int ROWSUM,int COLSUM){
		
		System.out.println("----------------\nData matrix : ");
		
		for(int row=0;row<ROWSUM;row++){
			
			for(int col=0;col<COLSUM;col++){
				
				System.out.print(DATAMATRIX[row][col]+" ");
				
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
	 * 功能 : 返回通过系数指定矩阵中的元素值
	 * 
	 * @param ROWINDEX	行索引
	 * @param COLINDEX	列索引
	 * @return	要查询的值
	 */
	public double returnDataElement(int ROWINDEX, int COLINDEX){
		
		return(dataMatrix[ROWINDEX][COLINDEX]);
		
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
	
	/**
	 * 功能 : 对矩阵中的单行进行乘的操作
	 * 
	 * @param rowIndex	要进行乘法操作的行的索引
	 * @param VAL		要乘的数字
	 */	
	public void rowMultiply(int rowIndex,double VAL){
		
		for(int rowTemp=0;rowTemp<colSum;rowTemp++){	//进行乘法操作
			
			dataMatrix[rowIndex][rowTemp]*=VAL;
			
		}
		
	}
	
	/**
	 * 功能 : 用于雅可比消元中 构建迭代式过程中的行操作
	 * 此处的 XiIndex 是从 0 开始的 ( XiIndex = 0 时表示  X1 的意思 )
	 * 
	 * @param XiIndex	表示对第 i 行进行操作 ( Xi位置置零,其余位置数字变号(除常数项外) )
	 * 
	 */
	public void rowJacobiOperation(int XiIndex){
		
		dataMatrix[XiIndex][XiIndex]=0;		//Xi位置置零
		for(int rowTemp=0;rowTemp<colSum-1;rowTemp++){		//因为不会将 常数项的系数变号，因而是 rowTemp < rowSum - 1
			
			dataMatrix[XiIndex][rowTemp]*=-1;
			
		}
		
	}
	
	/**
	 * 功能 : 矩阵与向量相乘,返回结果向量
	 * 
	 * @param Vector
	 * @return
	 */
	public double[] matrixVectorMultiply(double[] Vector){
		
		double[] resultVector=new double[this.rowSum];		//建立一个长度为 rowSum 长的数组,存储结果
		for(int rowTemp=0;rowTemp<rowSum;rowTemp++){
			
			for(int rowCount=0;rowCount<rowSum;rowCount++){	//实现 dataMatrix 的一行与 Vector 的相乘
				
				resultVector[rowTemp] += this.dataMatrix[rowTemp][rowCount] * Vector[rowCount];
				
			}
			
		}
		return(resultVector);
	}
	
	/**
	 * 对一个向量整体乘以 VAL 然后返回这个向量
	 * 
	 * @param Vector	需要操作的向量
	 * @param VAL		要乘的数字
	 * @return			返回操作后的向量
	 */
	public double[] vectorMultiply(double[] Vector,double VAL){
		
		double[] resultVector=Vector;
		for(int rowTemp=0;rowTemp<rowSum;rowTemp++){
			
			resultVector[rowTemp] *= VAL;
			
		}
		return(resultVector);
	}
	
	/**
	 * 功能 : 返回一个向量中的按模最大值
	 * 
	 * @param DATAVECTOR
	 * @param LENGTH
	 * @return
	 */
	public double absMaxOfVector(double[] DATAVECTOR,int LENGTH){
		
		double[] dataVector=DATAVECTOR;
		double[] absVector=vectorAbsMax(DATAVECTOR,LENGTH);

		int maxValIndex=0;	//先假设第一个元素是最大的
		double maxVal=0;
		for(int count=1;count<LENGTH;count++){
			
			if(absVector[count]>maxVal){
				
				maxVal = absVector[count];
				maxValIndex = count;
				
			}
			
		}
		return(dataVector[maxValIndex]);
	}
	
	/**
	 * 打印一个向量
	 * 
	 * @param DATAVECTOR
	 * @param LENGTH
	 */
	public void showVector(double[] DATAVECTOR,int LENGTH){
		
		for(int count=0;count<LENGTH;count++){
			
			System.out.print(DATAVECTOR[count]+" ");
			
		}
		
	}
	
	/**
	 * 功能 : 将向量绝对值化，返回(负数全部转化为正数)
	 * 
	 * @param DATAVECTOR	转化后的向量
	 * @param LENGTH		向量的长度
	 * @return
	 */
	public double[] vectorAbsMax(double[] DATAVECTOR,int LENGTH){
		
		double[] tempVector=new double[LENGTH];
		double tempDouble;
		
		for(int temp=0;temp<LENGTH;temp++){
			
			tempDouble=DATAVECTOR[temp];
			tempVector[temp]=tempDouble;
			
		}
		
		for(int count=0;count<LENGTH;count++){
			
			if(tempVector[count]<0){
				
				tempVector[count]*=-1;
				
			}
			
		}
		return(tempVector);
	}
	
}