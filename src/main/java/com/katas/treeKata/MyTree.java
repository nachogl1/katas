package com.katas.treeKata;

public class MyTree<T> {

    private MyNode<T> root;

    public void add(int key, T value) {
        MyNode<T> newNode = new MyNode(key, value);

        if (root == null) {
            root = newNode;

        } else {

            MyNode<T> focusNode = root;
            MyNode<T> parent;

            while (true) {
                parent = focusNode;
                if (focusNode.isLocalKeyBiggerThan(key)) {
                    focusNode = focusNode.getLeft();

                    if (focusNode == null) {
                        parent.setLeft(newNode);
                        return;
                    }

                } else {
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

}
