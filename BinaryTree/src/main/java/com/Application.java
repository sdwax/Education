package com;

import com.tree.BinaryTree;
import com.tree.Tree;

public class Application {
    public static void main(String[] args) {
        Tree<Integer> tree = new BinaryTree<>();
        tree.add(20);
        tree.add(10);
        tree.add(27);
        tree.add(5);
        tree.add(25);
        tree.add(30);
        tree.add(6);
        tree.add(24);
        tree.add(26);
        tree.add(28);
        tree.add(29);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(2);
        tree.add(7);
        tree.add(8);
        tree.add(9);

        tree.remove(20);
    }
}
