package com.tree;

public class Node<T> {
    T element;
    Node<T> left;
    Node<T> right;

    public Node(T element, Node<T> left, Node<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
