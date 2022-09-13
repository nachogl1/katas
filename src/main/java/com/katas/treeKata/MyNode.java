package com.katas.treeKata;

public class MyNode<T> {
    private int key;
    private T value;
    private MyNode<T> left;
    private MyNode<T> right;

    public MyNode(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return this.value;
    }

    public MyNode getLeft() {
        return this.left;
    }

    public MyNode getRight() {
        return this.right;
    }

    public void setLeft(MyNode newNode) {
        this.left = newNode;
    }

    public void setRight(MyNode newNode) {
        this.right = newNode;
    }

    public boolean isLocalKey(int key) {
        return key == this.key;
    }

    public boolean isLocalKeyBiggerThan(int key) {
        return this.key > key;
    }
}
