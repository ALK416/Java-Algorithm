
/**
 * ��������ʽ���һ����װ�� ���ʸ��������
 * ���� : 
 * (1)ͨ������Ŀ���ַ���������һ�� WordIdentifier ��
 * (2)����ƥ�䣬�õ����
 * (3)���ƥ��Ľ�� (ÿ��ƥ�����������)
 * (4)��� ���������ƴ�������� ����ַ���
 * (5)����Ŀ���ַ����еĵ��ʸ���
 * 
 * @author Pro_ALK416
 *
 */
class WordIdentifier{
	private String finalOutput="";				//��ʶ��ĵ��ʷָ����������
	private String sourceString;				//����ʶ����ַ���
	private String regexString="[a-zA-Z]+";		//ƥ�����
	private int wordCount=0;					//���ʸ�������
	
	private Pattern p;
	private Matcher m;
	
	public WordIdentifier(String SOURCE_STRING){		//���캯������ʼ��Ŀ���ַ���
		
		sourceString=SOURCE_STRING;
		
	}
	
	public void matching(){			//�����ַ�����ƥ��
		
		p=Pattern.compile(regexString);
		m=p.matcher(sourceString);
		
	}
	
	public void resultPrint(){			//������
		
		System.out.println("Input : "+sourceString);

		while(m.find()){
			System.out.println("��ʼ����:"+m.start());
			System.out.println("��β����:"+m.end());
			System.out.println("ƥ�䵽���ַ���:"+m.group());
			System.out.println("--------------------------");
			wordCount++;
			finalOutput+=" "+m.group();
			
		}
	}
	
	
	public void printSplittedString(){		//��������ĺϲ��ַ���
		
		System.out.println(finalOutput);
		
	}
	
	public int returnWordCount(){			//���ص��ʸ���
		
		return (wordCount);
		
	}
	
}