package com.gguoliang.designPattern.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author GGuoLiang
 * @Date 2020/11/8 4:15 下午
 * @Version 1.0
 */
@Data
public class University extends Component {

    private List<Component> departmentList = new ArrayList<>();

    public University(String name,String desc){
        super(name,desc);

    }

    @Override
    public void add(Component component) {
        departmentList.add(component);
    }

    @Override
    public void remove(Component component) {
       departmentList.remove(component);
    }


    @Override
    public void foreach() {
        departmentList.stream().forEach(component -> {
            System.out.println(component.toString());
        });
    }
}
