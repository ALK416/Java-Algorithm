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
 * �ݷ����װ�� �ݷ���������Ҫ�ķ��� ���� ����ȵ�
 * ʵ���ݷ�ʱֱ�ӵ��� ���к�������
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
	 * ���� : ����һ�� �ݷ� ���� 
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
		
		int i=6;	//�ȵ���һ��
		while(i>0){
			
			this.vectorY = dataMatrix.matrixVectorMultiply(vectorX);	// Yk = A*X
			this.valMk = dataMatrix.absMaxOfVector(vectorY, rowSum);		// Mk = max(Yk)
			this.vectorX = dataMatrix.vectorMultiply(vectorY, ( 1.0/valMk ));	//Xk = (1/Mk)*Yk
			showResult();
			i--;
		}

	}
	
	/**
	 * ��ӡ�����м���
	 * 
	 */
	public void showResult(){
		
		System.out.println("Y : ");
		this.dataMatrix.showVector(vectorX, 3);
		System.out.println("Mk : " + this.valMk);
		
	}
	
}
