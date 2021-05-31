package com.design.compose.example1.version.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/31 22:41
 */
@Data
public class TreeNode {

    // 树id
    private Long treeId;

    // 树节点id
    private Long treeNodeId;

    // 节点类型  1：叶子  2：果实
    private Integer nodeType;

    // 节点值：果实名
    private String nodeValue;

    // 规则key
    private String ruleKey;

    // 规则描述
    private String ruleDesc;

    // 节点链路
    private List<TreeNodeLink> treeNodeLinks;


}
