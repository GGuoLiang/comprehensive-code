package com.gguoliang.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author GGuoLiang
 * @Date 2020/4/30 2:39 下午
 * @Version 1.0
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution20 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    /**
     * 思路
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // 字符串长度为奇数 直接判断不匹配
        if (s.length() % 2 != 0) {
            return false;
        }
        // 出现的第一符号为右边空号
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 左边括号进栈
            if (map.containsKey(c)) {
                stack.add(c);
                //右边括号出栈
            } else if (map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.size() == 0;
    }


    @Test
    public void test() {
        String str = "{[]}}";
        System.out.println(isValid(str));
    }

}
