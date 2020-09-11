package com.gguoliang.designPattern.iterator.social_networks;

import com.gguoliang.designPattern.iterator.iterators.ProfileIterator;

/**
 * @Author GGuoLiang
 * @Date 2020/9/10 10:58 上午
 * @Version 1.0
 */
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
