package experiment3;
import experiment2.MatrixOperations;

public class PowerMethodTest {

	public static void main(String[] args) {
		
		double[][] testData1={ { 2,-1,0 },{ -1,2,-1 },{ 0,-1,2 } };
		double[] testX={ 1,1,1 };
		PowerMethod testPower=new PowerMethod(3,3,testData1,testX);
		testPower.powerMethodIteration();
		//testPower.showResult();
		
	}
	
}

/**
 * 幂法类封装了 幂法迭代所需要的方法 向量 矩阵等等
 * 实现幂法时直接调用 共有函数即可
 * 
 * @author SZH
 *
 */
class PowerMethod{
	
	MatrixOperations dataMatrix;
	private double[] vectorY=new double[10];
	private double valMk=0;
	private double[] vectorX=new double[10];
	private int rowSum=0;
	private int colSum=0;
	private double[] resultVector=new double[10];
	
	/**
	 * 功能 : 构造一个 幂法 对象 
	 * 
	 * @param ROWSUM
	 * @param COLSUM
	 * @param DATAMATRIX
	 * @param VECTORX
	 */
	public PowerMethod(int ROWSUM,int COLSUM,double[][] DATAMATRIX,double[] VECTORX){
		
		this.rowSum = ROWSUM;
		this.colSum = COLSUM;
		vectorX = VECTORX;
		dataMatrix = new MatrixOperations(ROWSUM,COLSUM,DATAMATRIX);
		
	}
	
	public void powerMethodIteration(){
		
		int i=6;	//先迭代一次
		while(i>0){
			
			this.vectorY = dataMatrix.matrixVectorMultiply(vectorX);	// Yk = A*X
			this.valMk = dataMatrix.absMaxOfVector(vectorY, rowSum);		// Mk = max(Yk)
			this.vectorX = dataMatrix.vectorMultiply(vectorY, ( 1.0/valMk ));	//Xk = (1/Mk)*Yk
			showResult();
			i--;
		}

	}
	
	/**
	 * 打印迭代中间结果
	 * 
	 */
	public void showResult(){
		
		System.out.println("Y : ");
		this.dataMatrix.showVector(vectorX, 3);
		System.out.println("Mk : " + this.valMk);
		
	}
	
}
