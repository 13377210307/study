package com.design.compose.example1.version.vo;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/31 22:40
 */
@Data
public class TreeRoot {

    // 规则树id
    private Long treeId;

    // 规则树根id
    private Long treeRootNodeId;

    // 规则树名
    private String treeName;
}
