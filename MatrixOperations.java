package experiment2;

/**
 * MatrixOperations ��Ϊ����ֵ����ʵ��ľ����������д��,���Զ�һ�� ( double )������л�����������
 * ��װ�����·��� : 
 * (1)ʹ��һ���������� ( ���������� ) ��ʼ��һ�� MatrixOperations ����
 * (2)�ı�����д洢�ľ������� ( ͨ������һ���µľ��� )
 * (3)��ӡ�˾���
 * (4)�Ծ����е����н��в��� ( TargetRow = TargetRow + VALUE * SOURCEROW )
 * (5)���������е�����
 * (6)�������������
 * (7)����������������
 * (8)����������������
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
	 * ���� : ���ض����д洢�ľ������� ( double[][] ���� )
	 * @return dataMatrix ( double[][] )
	 */
	public double[][] returnDataMatrix(){
		
		return (dataMatrix);
		
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
	
}
