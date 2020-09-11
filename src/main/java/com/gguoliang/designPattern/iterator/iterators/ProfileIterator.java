package com.gguoliang.designPattern.iterator.iterators;

import com.gguoliang.designPattern.iterator.Profile;

/**
 * @Author GGuoLiang
 * @Date 2020/9/10 10:17 上午
 * @Version 1.0
 */
public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();

}
