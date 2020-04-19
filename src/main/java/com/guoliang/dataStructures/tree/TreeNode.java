package com.guoliang.dataStructures.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/3/30 9:38 上午
 * @Version 1.0
 */
@Data
public class TreeNode {
    private Integer id;
    private Integer parentId;
    private String name;
    private List<TreeNode> childNodes;

    public TreeNode(Integer id, Integer parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.childNodes = new ArrayList<>();
    }
}
