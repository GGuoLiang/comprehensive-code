package test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author GGuoLiang
 * @Date 2020/12/4 5:34 下午
 * @Version 1.0
 */
public class DoubleTest {

    @Test
    public void test(){
        Double aa = 2.0E-4;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(aa));
        System.out.println(bigDecimal.toPlainString());
    }
}
