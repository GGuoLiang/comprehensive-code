package com.gguoliang.designPattern.proxy.dynamic;

import java.sql.SQLOutput;

/**
 * @Author GGuoLiang
 * @Date 2020/11/12 9:26 上午
 * @Version 1.0
 */
public class TeacherDaoImpl implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("teach............");
    }
}
