package experiment2;

/**
 * MatrixOperations ��Ϊ����ֵ����ʵ��ľ����������д��,���Զ�һ�� ( double )������л�����������
 * ��װ�����·��� : 
 * (1)ʹ��һ���������� ( ���������� ) ��ʼ��һ�� MatrixOperations ����
 * (2)�ı�����д洢�ľ������� ( ͨ������һ���µľ��� )
 * (3)��ӡ�˾���
 * (3.5)��ӡָ������
 * (4)�Ծ����е����н��в��� ( TargetRow = TargetRow + VALUE * SOURCEROW )
 * (5)���������е�����
 * (6)�������������
 * (7)����������������
 * (8)����������������
 * (9)���ؾ����е�ָ��Ԫ��
 * (10)�Ծ����е�ÿһ�н��г˷�����
 * (11)���ؾ���������������õĽ������
 * (12)���������а�ģ�����Ǹ�Ԫ��
 * (13)��һ��������ÿһ��Ԫ��ȡ����ֵ,Ȼ�󷵻��������
 * (14)��ӡһ������
 * (15)�������е�ÿ��Ԫ�ؽ��г˷�����
 * 
 * @author Pro_ALK416
 *
 */

public class MatrixOperations {

	private double dataMatrix[][];	//���з����������ľ���
	private int rowSum=0;	//���������
	private int colSum=0;	//���������
	
	/**
	 * ���� : ����һ������������� ( ʹ��һ����άdouble���� )
	 * 
	 * @param ROWSUM	�˾��������
	 * @param COLSUM	�˾��������
	 * @param MATRIX	�˶�άdouble����
	 */
	public MatrixOperations(int ROWSUM,int COLSUM,double[][] MATRIX){		//��ʼ������
		
		this.dataMatrix=MATRIX;
		this.rowSum=ROWSUM;
		this.colSum=COLSUM;
		
	}
	
	/**
	 * ���� : �ı�˶����д洢�ľ�����Ϣ
	 * 
	 * @param MATRIX	��Ҫ���µľ������� ( double���Ͷ�ά���� )
	 */
	public void changeDataMatrix(double[][] MATRIX){
		
		this.dataMatrix=MATRIX;		//���������,ʹ��һ���������˶���֮�󻹿�����ʹ�ù������޸ľ���
		
	}
	
	/**���� : �Ծ����е������н��в��� ( TargetRow = TargetRow + VALUE * SOURCEROW )
	 * 
	 * @param TARGETROW	
	 * @param VALUE
	 * @param SOURCEROW
	 */
	public void rowOperation(int TARGETROW,double VALUE,int SOURCEROW){
		
		for(int colTemp=0;colTemp<colSum;colTemp++){
			
			//�� SOURCEROW �ϵ�ÿһ��Ԫ�س��� VALUE ,Ȼ��ӵ� TARGETROW �϶�Ӧ��ÿһ��Ԫ����
			dataMatrix[TARGETROW][colTemp]+=dataMatrix[SOURCEROW][colTemp]*VALUE;
			
		}
		
	}

	/**����һ�������е�����
	 * 
	 * @param ROW1 ��1
	 * @param ROW2 ��2
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
	 * ���� : ��ӡ���������洢�ľ���
	 */
	public void showMatrix(){		//��ӡ���������洢�ľ�������
		
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
	 * ��ӡָ������
	 * ����Ϊ��������
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
	 * ���� : ���ض����д洢�ľ������� ( double[][] ���� )
	 * @return dataMatrix ( double[][] )
	 */
	public double[][] returnDataMatrix(){
		
		return (dataMatrix);
		
	}
	
	/**
	 * ���� : ����ͨ��ϵ��ָ�������е�Ԫ��ֵ
	 * 
	 * @param ROWINDEX	������
	 * @param COLINDEX	������
	 * @return	Ҫ��ѯ��ֵ
	 */
	public double returnDataElement(int ROWINDEX, int COLINDEX){
		
		return(dataMatrix[ROWINDEX][COLINDEX]);
		
	}
	
	/**
	 * ���� : ���ض����д洢��������� 
	 * @return ���� (int)
	 */
	public int returnRowSum(){
		
		return(this.rowSum);
		
	}
	
	/**
	 * ���� : ���ض����д洢���������
	 * @return ���� (int)
	 */
	public int returnColSum(){
		
		return(this.colSum);
		
	}
	
	/**
	 * ���� : �Ծ����еĵ��н��г˵Ĳ���
	 * 
	 * @param rowIndex	Ҫ���г˷��������е�����
	 * @param VAL		Ҫ�˵�����
	 */	
	public void rowMultiply(int rowIndex,double VAL){
		
		for(int rowTemp=0;rowTemp<colSum;rowTemp++){	//���г˷�����
			
			dataMatrix[rowIndex][rowTemp]*=VAL;
			
		}
		
	}
	
	/**
	 * ���� : �����ſɱ���Ԫ�� ��������ʽ�����е��в���
	 * �˴��� XiIndex �Ǵ� 0 ��ʼ�� ( XiIndex = 0 ʱ��ʾ  X1 ����˼ )
	 * 
	 * @param XiIndex	��ʾ�Ե� i �н��в��� ( Xiλ������,����λ�����ֱ��(����������) )
	 * 
	 */
	public void rowJacobiOperation(int XiIndex){
		
		dataMatrix[XiIndex][XiIndex]=0;		//Xiλ������
		for(int rowTemp=0;rowTemp<colSum-1;rowTemp++){		//��Ϊ���Ὣ �������ϵ����ţ������ rowTemp < rowSum - 1
			
			dataMatrix[XiIndex][rowTemp]*=-1;
			
		}
		
	}
	
	/**
	 * ���� : �������������,���ؽ������
	 * 
	 * @param Vector
	 * @return
	 */
	public double[] matrixVectorMultiply(double[] Vector){
		
		double[] resultVector=new double[this.rowSum];		//����һ������Ϊ rowSum ��������,�洢���
		for(int rowTemp=0;rowTemp<rowSum;rowTemp++){
			
			for(int rowCount=0;rowCount<rowSum;rowCount++){	//ʵ�� dataMatrix ��һ���� Vector �����
				
				resultVector[rowTemp] += this.dataMatrix[rowTemp][rowCount] * Vector[rowCount];
				
			}
			
		}
		return(resultVector);
	}
	
	/**
	 * ��һ������������� VAL Ȼ�󷵻��������
	 * 
	 * @param Vector	��Ҫ����������
	 * @param VAL		Ҫ�˵�����
	 * @return			���ز����������
	 */
	public double[] vectorMultiply(double[] Vector,double VAL){
		
		double[] resultVector=Vector;
		for(int rowTemp=0;rowTemp<rowSum;rowTemp++){
			
			resultVector[rowTemp] *= VAL;
			
		}
		return(resultVector);
	}
	
	/**
	 * ���� : ����һ�������еİ�ģ���ֵ
	 * 
	 * @param DATAVECTOR
	 * @param LENGTH
	 * @return
	 */
	public double absMaxOfVector(double[] DATAVECTOR,int LENGTH){
		
		double[] dataVector=DATAVECTOR;
		double[] absVector=vectorAbsMax(DATAVECTOR,LENGTH);

		int maxValIndex=0;	//�ȼ����һ��Ԫ��������
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
	 * ��ӡһ������
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
	 * ���� : ����������ֵ��������(����ȫ��ת��Ϊ����)
	 * 
	 * @param DATAVECTOR	ת���������
	 * @param LENGTH		�����ĳ���
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