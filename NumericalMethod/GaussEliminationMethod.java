package experiment2;

/**
 * @author ALK416
 *
 */

class GaussEliminationMethod{
	
	double augmentedMatrix[][]; //={ {1,2,3},{4,5,6},{7,8,9} };		//所要计算的增广矩阵
	double resultVector[]={0,0,0,0,0,0,0,0,0,0};	//暂定可存储 10 个结果
	int rowSum=0;
	int colSum=0;
	MatrixOperations matOpera1;
	
	/**
	 * 功能 : 以某个具体方程组对应的增广矩阵来初始化对象，使得初始化之后可以直接进行 消元和回代从而得到答案
	 * 
	 * @param ROWSUM	增广矩阵的行数
	 * @param COLSUM	增广矩阵的列数
	 * @param MATRIX	增广矩阵 ( double[][]类型 )	
	 */
	public GaussEliminationMethod(int ROWSUM,int COLSUM,double MATRIX[][]){	//以增广矩阵来初始化对象
		
		augmentedMatrix=MATRIX;
		this.rowSum=ROWSUM;
		this.colSum=COLSUM;
		matOpera1=new MatrixOperations(this.rowSum,this.colSum,augmentedMatrix);
		
	}

	/**
	 * 功能 : 对增广矩阵进行高斯消元,并返回消元完毕后的矩阵
	 * Instruction : 
	 * (1)for(int colTemp=0,rowCount=0;colTemp<=colSum - 2;colTemp++)
	 * 		外层for循环用于将除了常数项的增广部分的列全部遍历一遍
	 * (2)for(int rowTemp=1+rowCount;rowTemp<rowSum;rowTemp++)
	 * 		内层循环用于将每一行进行消元操作 rowTemp是每一列元素消元开始置零的位置(zero's position)
	 * 		rowCount是一个辅助变量，用于定位每一列消元开始位置的上一个元素(消元依据的元素)
	 * 
	 */
	public void gaussEliminationIteration(){
		
		for(int colTemp=0,rowCount=0;colTemp<=colSum - 2;colTemp++){
			
			for(int rowTemp=1+rowCount;rowTemp<rowSum;rowTemp++){
								
				this.matOpera1.rowOperation(rowTemp, ( augmentedMatrix[rowTemp][colTemp] / augmentedMatrix[rowCount][colTemp] )*( -1 ), rowCount);
				
			}
			rowCount++;
		}
		
	}
	
	/**
	 * 功能 : 对已经经过高斯消元后的增广矩阵进行回代,并计算x,存储在 resultVector 数组中
	 * (1)可以通过返回的数组来获取结果,也可以直接调用 showResult() 方法进行结果的打印
	 * 
	 * @return X1~Xn的结果数组
	 */
	public double[] gaussRegressionIteration(){
		
		double tempSum=0;
		
		//回代过程 : 解出 X1~Xn-1	(先解出 Xn ,再回代得 Xn-1,再由 Xn与Xn-1回代得 Xn-2 以此类推)
		//先解得 Xn
		resultVector[rowSum-1] = augmentedMatrix[rowSum-1][rowSum] / augmentedMatrix[rowSum-1][rowSum-1];
		//求解X[n-1]~X[1]
		for(int k=rowSum-2;k>=0;k--){		
			
			tempSum=0;	//每次循环前记得将 tempSum 清零
			for(int j=0;j<=rowSum-1;j++){		//回代需要计算除 Xi 项以及常数项以外的系数项和
				
				tempSum+=resultVector[j]*augmentedMatrix[k][j];
				
			}
			resultVector[k] = (augmentedMatrix[k][rowSum] - tempSum) / augmentedMatrix[k][k];
		}
			
		return(resultVector);
	}
	
	/**
	 * 功能 : 用于在 消元和回代后 输出 X 的结果数组
	 */
	public void showResult(){
		
		for(int temp=0;temp<rowSum;temp++){
			
			System.out.println(" x"+(temp+1)+": "+resultVector[temp]+" ");
			
		}
		
	}
	
	
	
}
