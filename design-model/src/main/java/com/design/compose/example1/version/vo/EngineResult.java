package com.design.compose.example1.version.vo;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/31 22:47
 */
@Data
public class EngineResult {

    private boolean isSuccess; //执行结果

    private String userId;   //用户ID

    private Long treeId;     //规则树ID

    private Long nodeId;   //果实节点ID

    private String nodeValue;//果实节点值
}
