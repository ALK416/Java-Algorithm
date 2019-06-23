package Experi03;

public class byteToInt {

    /**
     * 将一个byte类型的数组转化为int类型的数组
     * 原理 :
     * (1)将每一个byte数据放在一个长度为4的byte数组中
     *    前三位始终为零，将要转化的byte变量放在 tempArray[3]中
     *    然后将tempArray[0]移到int类型的最高位字节中
     *    tempArray[1]移到次高位字节中，tempArray[2]同理
     *    最后将tempArray[3]放在最低字节中，到此就完成了byte->int的转化
     * @param SourceBytes   需要转化的byte数组
     * @return              转化完毕的int数组
     */
    public static int[] byteArrayToIntArray(byte[] SourceBytes){

        int[] result = new int[SourceBytes.length]; //创建一个与byte数组长度一样的int数组
        byte[] tempArray = new byte[4];
        tempArray[0] = (byte)0;
        tempArray[1] = (byte)0;
        tempArray[2] = (byte)0;
        for(int count= 0;count<SourceBytes.length;count++){
            tempArray[3] = SourceBytes[count];
            result[count] = byteArrayToInt(tempArray);
        }
        return(result);
    }

    /**
     * 将一个byte[4]数组转化为一个int类型的变量
     * @param bytes byte[4]: source data
     * @return      target int
     */
    public static int byteArrayToInt(byte[] bytes) {
        return (bytes[0]&0xff)<<24
                | (bytes[1]&0xff)<<16
                | (bytes[2]&0xff)<<8
                | (bytes[3]&0xff);
    }

}
