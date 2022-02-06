package com;

import com.tree.BinaryTree;

public class Application {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(8);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(10);
        tree.add(6);
        tree.add(7);

        System.out.println(tree.remove(4));
        System.out.println(tree.remove(10));
        System.out.println(tree.remove(7));
        System.out.println(tree.remove(20));
        System.out.println(tree.remove(8));
    }
}
