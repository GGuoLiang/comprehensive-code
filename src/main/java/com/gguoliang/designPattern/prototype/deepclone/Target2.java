package com.gguoliang.designPattern.prototype.deepclone;

import lombok.Data;

import java.io.*;

/**
 * @Author GGuoLiang
 * @Date 2020/10/10 8:19 上午
 * @Version 1.0
 * <p>
 * 深拷贝重新写clone方法
 */
@Data
public class Target2 implements Serializable, Cloneable {

    private String name;

    private Target1 target1;

    @Override
    protected Object clone() {
        Target2 target2 = null;
        try {
            target2 = (Target2) super.clone();
            // 对引用类型单独处理
            target2.target1 = (Target1) target1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return target2;
    }

    public Object deepClone() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        Object object = null;
        try {
            // 序列化
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            // 反序列化
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return object;
    }
}
