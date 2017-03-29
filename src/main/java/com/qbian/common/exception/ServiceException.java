package com.qbian.common.exception;

import com.qbian.common.dto.Node;

/**
 * Created by Qbian on 2017/3/24.
 */
public class ServiceException extends RuntimeException {

    private Node node;

    public ServiceException() {
        this.node = new Node(-999);
    }

    public ServiceException(Node node) {
        super(node.getMsg());
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
