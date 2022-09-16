package com.katas.treeKata;

import java.util.List;

public class MyTree<T> {

    private MyNode<T> root;

    public void add(int key, T value) {
        MyNode<T> newNode = new MyNode(key, value);
        if (root == null) {
            root = newNode;
        } else {
            MyNode<T> focusNode = root;
            MyNode<T> parent;
            if (isElementRepeated(key)) throw new RepeatedElementNotAllowed();
            while (true) {
                parent = focusNode;
                if (focusNode.isLocalKeyBiggerThan(key)) {
                    focusNode = focusNode.getLeft();

                    if (focusNode == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else if (!focusNode.isLocalKeyBiggerThan(key)) {
                    focusNode = focusNode.getRight();
                    if (focusNode == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public T getValueByKey(int key) {
        MyNode<T> node = findNode(key);
        return node.getValue();
    }

    public List<T> inOrderTraversal() {
        return this.executeTraversalCommand(new ReturnElementsInOrderStrategyStartingFrom(root));
    }

    public List<T> preOrderTraversal() {
        return this.executeTraversalCommand(new ReturnElementsPreOrderStrategyStartingFrom(root));
    }

    public List<T> postOrderTraversal() {
        return this.executeTraversalCommand(new ReturnElementsPostOrderStrategyStartingFrom(root));
    }

    private boolean isElementRepeated(int key) {
        try {
            findNode(key);
            return true;
        } catch (NodeNotFound exception) {
            return false;
        }
    }

    private MyNode<T> findNode(int key) {
        MyNode<T> focusNode = root;
        try {
            while (true) {

                if (focusNode.isLocalKey(key)) {
                    return focusNode;
                }
                if (focusNode.isLocalKeyBiggerThan(key)) {
                    focusNode = focusNode.getLeft();

                    if (focusNode.isLocalKey(key)) {
                        return focusNode;
                    }
                } else {
                    focusNode = focusNode.getRight();
                    if (focusNode.isLocalKey(key)) {
                        return focusNode;
                    }
                }
            }
        } catch (NullPointerException exception) {
            throw new NodeNotFound();
        }
    }

    private List<T> executeTraversalCommand(TraversalStrategy command) {
        return command.execute();
    }
}
