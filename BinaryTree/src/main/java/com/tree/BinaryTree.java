package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> implements Tree<E> {
    private final Node<E> root;

    public BinaryTree(E element) {
        root = new Node<>(element, null, null);
    }

    @Override
    public void add(E element) {
        insertNode(root, element);
    }

    @Override
    public boolean remove(E element) {
        List<Node<E>> nodes = findNodeToRemove(root, null, element);

        if (nodes.isEmpty()) {
            return false;
        }
        return removeNode(nodes);
    }

    private <T extends Comparable<T>> List<Node<T>> findNodeToRemove(Node<T> currentNode, Node<T> parentNode, T element) {
        List<Node<T>> currentAndParentNodes = new ArrayList<>(2);

        if (currentNode.element.equals(element)) {
            return addCurrentAndParentNodes(currentAndParentNodes, currentNode, parentNode);
        }

        if (element.compareTo(currentNode.element) < 0) {
            if (currentNode.left != null) {
                return checkNode(currentNode.left, element, currentAndParentNodes, currentNode);
            }
        } else {
            if (currentNode.right != null) {
                return checkNode(currentNode.right, element, currentAndParentNodes, currentNode);
            }
        }
        return currentAndParentNodes;
    }

    private <T extends Comparable<T>> void insertNode(Node<T> node, T element) {
        if (element.compareTo(node.element) < 0) {
            if (node.left == null) {
                node.left = new Node<>(element, null, null);
            } else {
                insertNode(node.left, element);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(element, null, null);
            } else {
                insertNode(node.right, element);
            }
        }
    }

    private boolean removeNode(List<Node<E>> node) {
        Node<E> currentNode = node.get(0);
        Node<E> parentNode = node.get(1);

        if (parentNode == null) {
            return false;
        }

        if (currentNode.left == null && currentNode.right == null) {
            addToParentNode(parentNode, currentNode, null);
            return true;
        }

        if (currentNode.left != null && currentNode.right == null) {
            addToParentNode(parentNode, currentNode, currentNode.left);
            return true;
        }

        if (currentNode.right.left == null) {
            currentNode.right.left = currentNode.left;
            addToParentNode(parentNode, currentNode, currentNode.right);
            return true;
        } else {
            currentNode.right.left = currentNode.left;
            addToParentNode(parentNode, currentNode, currentNode.right.left);
            return true;
        }
    }

    private <T extends Comparable<T>> List<Node<T>> checkNode(Node<T> node, T element, List<Node<T>> currentAndParentNodes, Node<T> currentNode) {
        if (node.element.compareTo(element) == 0) {
            return addCurrentAndParentNodes(currentAndParentNodes, node, currentNode);
        } else {
            return findNodeToRemove(node, currentNode, element);
        }
    }

    private <T> List<Node<T>> addCurrentAndParentNodes(List<Node<T>> currentAndParentNodes, Node<T> currentNode, Node<T> parentNode) {
        currentAndParentNodes.add(currentNode);
        currentAndParentNodes.add(parentNode);
        return currentAndParentNodes;
    }

    private void addToParentNode(Node<E> parentNode, Node<E> currentNode, Node<E> node) {
        if (parentNode.left.element.equals(currentNode.element)) {
            parentNode.left = node;
        } else {
            parentNode.right = node;
        }
    }
}
