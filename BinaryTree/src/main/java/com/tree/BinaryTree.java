package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> implements Tree<E> {
    private Node<E> root;

    public BinaryTree(E element) {
        root = new Node<>(element, null, null);
    }

    public BinaryTree() {
        root = new Node<>();
    }

    @Override
    public void add(E element) {
        insertNode(root, element);
    }

    @Override
    public boolean remove(E element) {
        if (root.element == null) {
            return false;
        }

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

        if (currentNode.element.compareTo(element) > 0) {
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
        if (node.element == null) {
            node.element = element;
        }

        if (element.compareTo(node.element) < 0) {
            if (node.left == null) {
                node.left = new Node<>(element, null, null);
            } else {
                insertNode(node.left, element);
            }
        }

        if (element.compareTo(node.element) > 0) {
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

        if (currentNode.left == null && currentNode.right == null) {
            return removeCurrentNode(parentNode, currentNode.element, null);
        }

        if (currentNode.left != null && currentNode.right == null) {
            return removeCurrentNode(parentNode, currentNode.element, currentNode.left);
        }

        if (currentNode.right.left == null) {
            Node<E> lastLeftNode = getLastLeftNode(currentNode.right);
            lastLeftNode.left = currentNode.left;

            return removeCurrentNode(parentNode, currentNode.element, currentNode.right);
        }

        if (currentNode.right.right == null) {
            Node<E> lastLeftNode = getLastLeftNode(currentNode.right);
            lastLeftNode.left = currentNode.left;

            Node<E> lastRightNode = getLastRightNode(lastLeftNode);
            lastRightNode.right = currentNode.right;
            currentNode.right.left = null;

            return removeCurrentNode(parentNode, currentNode.element, lastLeftNode);
        }

        Node<E> lastLeftNode = getLastLeftNode(currentNode.right);
        lastLeftNode.left = currentNode.left;

        return removeCurrentNode(parentNode, currentNode.element, currentNode.right);

    }

    private Node<E> getLastLeftNode(Node<E> current) {
        if (current.left == null) {
            return current;
        }
        return getLastLeftNode(current.left);
    }

    private Node<E> getLastRightNode(Node<E> current) {
        if (current.right == null) {
            return current;
        }
        return getLastLeftNode(current.right);
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

    private boolean removeCurrentNode(Node<E> parentNode, E element, Node<E> node) {
        if (parentNode == null && node == null) {
            return false; // don't remove root node that it not has child
        }

        if (parentNode == null) {
            root = node;
            return true;
        }

        if (parentNode.left.element.equals(element)) {
            parentNode.left = node;
        } else {
            parentNode.right = node;
        }
        return true;
    }
}
