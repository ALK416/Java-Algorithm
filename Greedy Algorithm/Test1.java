/**
 * 测试类 ActivityArrage
 * 目前只支持按升序将各个活动的开始和结束时间输入
 *
 */
public class Test1 {

    public static void main(String[] args) {
        int[] time1 = {1,3,2,5,4,5,6,8,8,2};    //测试例子 (10个活动)
        int[] time2 = {4,5,6,7,9,9,10,11,12,13};
        ActivityArrange test1 = new ActivityArrange(10,99,time1,time2);
        test1.executeCalc();
        test1.showResult();
    }

}

/**
 * 问题描述 :
 * 现有很多活动，每个活动都有自己固定的开始时间和结束时间
 * 现在给出一段时间，需要从所有活动中选择出一个序列
 * 使得这个执行序列包含的活动数目最多
 *
 * 贪心策略 :
 * 将所有活动的结束时间按照从小到大的顺序进行排序
 * 然后 首先将第一个活动选入序列(关键活动)
 *      然后按顺序检测之后的活动与关键活动的相容性
 *      若相容，则将此活动加入序列
 *      将 最新的活动更新为 关键活动
 *
 */
class ActivityArrange{

    private int activityNum = 0;
    private int arrangeResult = 0;
    private int[] startTimes;       //这里先不进行初始化
    private int[] endTimes;         //在 initialWork方法中初始化
    private int[] result;
    private int totalTime = 0;


    /**
     * 构造函数: 设置活动的开始时间与结束时间与可安排的时间总量
     *
     * @param TOTALTIME     可安排的时间总量
     * @param STARTTIMES    每一个活动的开始时间
     * @param ENDTIMES      每一个活动的结束时间
     */
    public ActivityArrange(int ACTNUM,int TOTALTIME,int[] STARTTIMES,int[] ENDTIMES){
        this.totalTime = TOTALTIME;
        this.startTimes = STARTTIMES;
        this.endTimes = ENDTIMES;
        this.activityNum = ACTNUM;
        result = new int[ACTNUM];
    }

    /**
     * 贪心策略 : 把活动时间按照截止时间从小到大排序
     * 然后从前向后选，只要与前面的活动相容，就安排这个活动
     */
    public void executeCalc(){

        result[0] = 0;      //第一个活动默认安排
        int helpJudge = 0;  //此时以第一个活动为基准进行判断
        int helpCount = 1;  //记录着结果数组中可以存储的下一个位置
        for(int temp=1;temp<this.activityNum;temp++){
            if(isCompatible(helpJudge,temp)){
                result[helpCount] = temp;
                helpCount++;
                helpJudge = temp;   //将次活动设置为下一个进行比较的活动
                this.arrangeResult++;
            }
        }
    }

    /**
     * 返回进行贪心计算后的结果
     * @return  结果数组
     */
    public int[] getResult(){
        return(this.result);
    }

    /**
     * 判断一个活动是否相容
     *
     * @param ACT1  活动一的下标
     * @param ACT2  活动二的下标
     * @return      true or false
     */
    public boolean isCompatible(int ACT1,int ACT2){
        if(this.startTimes[ACT1] >= this.endTimes[ACT2]){
            return(true);
        }else if(this.startTimes[ACT2] >= this.endTimes[ACT1]){
            return(true);
        }else{
            return(false);
        }
    }

    /**
     * 打印出结果
     */
    public void showResult(){

        System.out.println("Arrange result : ");
        for(int temp:this.result){
            System.out.print(temp+" ");
        }

    }

}

