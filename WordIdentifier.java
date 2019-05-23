
/**
 * 将正则表达式类进一步封装成 单词个数检测类
 * 功能 : 
 * (1)通过传入目标字符串来构造一个 WordIdentifier 类
 * (2)进行匹配，得到结果
 * (3)输出匹配的结果 (每个匹配结果单独输出)
 * (4)输出 将单个结果拼接起来的 结果字符串
 * (5)返回目标字符串中的单词个数
 * 
 * @author Pro_ALK416
 *
 */
class WordIdentifier{
	private String finalOutput="";				//将识别的单词分隔开进行输出
	private String sourceString;				//用于识别的字符串
	private String regexString="[a-zA-Z]+";		//匹配规则
	private int wordCount=0;					//单词个数计数
	
	private Pattern p;
	private Matcher m;
	
	public WordIdentifier(String SOURCE_STRING){		//构造函数，初始化目标字符串
		
		sourceString=SOURCE_STRING;
		
	}
	
	public void matching(){			//进行字符串的匹配
		
		p=Pattern.compile(regexString);
		m=p.matcher(sourceString);
		
	}
	
	public void resultPrint(){			//输出结果
		
		System.out.println("Input : "+sourceString);

		while(m.find()){
			System.out.println("起始索引:"+m.start());
			System.out.println("结尾索引:"+m.end());
			System.out.println("匹配到的字符串:"+m.group());
			System.out.println("--------------------------");
			wordCount++;
			finalOutput+=" "+m.group();
			
		}
	}
	
	
	public void printSplittedString(){		//输出处理后的合并字符串
		
		System.out.println(finalOutput);
		
	}
	
	public int returnWordCount(){			//返回单词个数
		
		return (wordCount);
		
	}
	
}