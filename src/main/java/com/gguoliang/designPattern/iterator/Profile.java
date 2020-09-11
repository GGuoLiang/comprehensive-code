package com.gguoliang.designPattern.iterator;

import lombok.Data;

import java.util.*;

/**
 * @Author GGuoLiang
 * @Date 2020/9/10 10:17 上午
 * @Version 1.0
 */
@Data
public class Profile {

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮件
     */
    private String email;

    private Map<String, List<String>> contacts = new HashMap<>();

    public Profile(String name,String email,String ... contacts){
        this.name = name;
        this.email = email;
        for (String contact : contacts) {
            String[] parts = contact.split(":");
            if(!this.contacts.containsKey(parts[0])){
                this.contacts.put(parts[0],new ArrayList<>());
            }
            List<String> list = this.contacts.get(parts[0]);
            list.add(parts[1]);
            this.contacts.put(parts[0],list);
        }
    }

    public List<String> getContacts(String contactType) {
        if (!this.contacts.containsKey(contactType)) {
            this.contacts.put(contactType, new ArrayList<>());
        }
        return contacts.get(contactType);
    }
}
