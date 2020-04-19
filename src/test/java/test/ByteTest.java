package test;

/**
 * @Author GGuoLiang
 * @Date 2020/4/18 5:43 下午
 * @Version 1.0
 */
public class ByteTest {

    public static void main(String[] args) {
        int temp = 4;
        temp = 0x01+0x01+0x01+0x01;
        System.out.println(temp);

    }
    /**
     * 整型转换为4位字节数组
     * @param intValue
     * @return
     */
    public static byte[] int2Byte(int intValue) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (intValue >> 8 * (3 - i) & 0xFF);
            //System.out.print(Integer.toBinaryString(b[i])+" ");
            //System.out.print((b[i] & 0xFF) + " ");
        }
        return b;
    }


    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        //由高位到低位
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }

    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value= 0;
        //由高位到低位
        for (int i = 0; i < 4; i++) {
            int shift= (4 - 1 - i) * 8;
            value +=(bytes[i] & 0x000000FF) << shift;//往高位游
        }
        return value;
    }


}

