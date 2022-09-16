package com.katas.treeKata;

import java.util.ArrayList;
import java.util.List;

public class ReturnElementsPostOrderStrategyStartingFrom<T> implements TraversalStrategy {

    private List<T> orderingResultBuffer = new ArrayList<>();
    private MyNode root;

    public ReturnElementsPostOrderStrategyStartingFrom(MyNode root) {
        this.root = root;
    }

    @Override
    public List<T> execute() {
        internalOrderTraversal(this.root);
        return this.orderingResultBuffer;
    }

    private void internalOrderTraversal(MyNode<T> focusNode) {

        if (focusNode != null) {
            internalOrderTraversal(focusNode.getLeft());
            internalOrderTraversal(focusNode.getRight());
            orderingResultBuffer.add(focusNode.getValue());
        }

    }

}