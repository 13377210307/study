package com.design.compose.example1.version.entity;

import com.design.compose.example1.version.vo.TreeNode;
import com.design.compose.example1.version.vo.TreeRoot;
import lombok.Data;

import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/5/31 22:12
 */
@Data
public class TreeRich {

    // 树根信息
    private TreeRoot treeRoot;

    // 叶子节点
    private Map<Long, TreeNode> treeNodeMap;
}
