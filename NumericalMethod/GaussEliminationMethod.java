package experiment2;

/**
 * @author ALK416
 *
 */

class GaussEliminationMethod{
	
	double augmentedMatrix[][]; //={ {1,2,3},{4,5,6},{7,8,9} };		//��Ҫ������������
	double resultVector[]={0,0,0,0,0,0,0,0,0,0};	//�ݶ��ɴ洢 10 �����
	int rowSum=0;
	int colSum=0;
	MatrixOperations matOpera1;
	
	/**
	 * ���� : ��ĳ�����巽�����Ӧ�������������ʼ������ʹ�ó�ʼ��֮�����ֱ�ӽ��� ��Ԫ�ͻش��Ӷ��õ���
	 * 
	 * @param ROWSUM	������������
	 * @param COLSUM	������������
	 * @param MATRIX	������� ( double[][]���� )	
	 */
	public GaussEliminationMethod(int ROWSUM,int COLSUM,double MATRIX[][]){	//�������������ʼ������
		
		augmentedMatrix=MATRIX;
		this.rowSum=ROWSUM;
		this.colSum=COLSUM;
		matOpera1=new MatrixOperations(this.rowSum,this.colSum,augmentedMatrix);
		
	}

	/**
	 * ���� : �����������и�˹��Ԫ,��������Ԫ��Ϻ�ľ���
	 * Instruction : 
	 * (1)for(int colTemp=0,rowCount=0;colTemp<=colSum - 2;colTemp++)
	 * 		���forѭ�����ڽ����˳���������㲿�ֵ���ȫ������һ��
	 * (2)for(int rowTemp=1+rowCount;rowTemp<rowSum;rowTemp++)
	 * 		�ڲ�ѭ�����ڽ�ÿһ�н�����Ԫ���� rowTemp��ÿһ��Ԫ����Ԫ��ʼ�����λ��(zero's position)
	 * 		rowCount��һ���������������ڶ�λÿһ����Ԫ��ʼλ�õ���һ��Ԫ��(��Ԫ���ݵ�Ԫ��)
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
	 * ���� : ���Ѿ�������˹��Ԫ������������лش�,������x,�洢�� resultVector ������
	 * (1)����ͨ�����ص���������ȡ���,Ҳ����ֱ�ӵ��� showResult() �������н���Ĵ�ӡ
	 * 
	 * @return X1~Xn�Ľ������
	 */
	public double[] gaussRegressionIteration(){
		
		double tempSum=0;
		
		//�ش����� : ��� X1~Xn-1	(�Ƚ�� Xn ,�ٻش��� Xn-1,���� Xn��Xn-1�ش��� Xn-2 �Դ�����)
		//�Ƚ�� Xn
		resultVector[rowSum-1] = augmentedMatrix[rowSum-1][rowSum] / augmentedMatrix[rowSum-1][rowSum-1];
		//���X[n-1]~X[1]
		for(int k=rowSum-2;k>=0;k--){		
			
			tempSum=0;	//ÿ��ѭ��ǰ�ǵý� tempSum ����
			for(int j=0;j<=rowSum-1;j++){		//�ش���Ҫ����� Xi ���Լ������������ϵ�����
				
				tempSum+=resultVector[j]*augmentedMatrix[k][j];
				
			}
			resultVector[k] = (augmentedMatrix[k][rowSum] - tempSum) / augmentedMatrix[k][k];
		}
			
		return(resultVector);
	}
	
	/**
	 * ���� : ������ ��Ԫ�ͻش��� ��� X �Ľ������
	 */
	public void showResult(){
		
		for(int temp=0;temp<rowSum;temp++){
			
			System.out.println(" x"+(temp+1)+": "+resultVector[temp]+" ");
			
		}
		
	}
	
	
	
}
