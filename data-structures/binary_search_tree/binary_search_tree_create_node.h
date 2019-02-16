
#ifndef BINARY_SEARCH_TREE_CREATE_H_
#define BINARY_SEARCH_TREE_CREATE_H_
#include "binary_search_tree.h"
#include <iostream>

// create and return a new node
template <typename T>
BinarySearchTreeNode<T> *createNode(const T& value) {
    BinarySearchTreeNode<T> *newNode = new BinarySearchTreeNode<T>(value);
    return newNode;
}

// create a new node when the current node is empty, and
// insert the value into the current node
// if a new value is less than the current node value,
// insert the new value into the left node
// if a new value is greater than the current node value,
// insert the new value into the right node
template <typename T>
BinarySearchTreeNode<T> *insertNode(BinarySearchTreeNode<T> *root, const T& value) {
    if (root == NULL) {
        root = createNode(value);
        return root;
    }
    else if (value < root->nodeValue) {
        root->left = insertNode(root->left, value);
    }
    else if (value > root->nodeValue) {
        root->right = insertNode(root->right, value);
    }

    return root;
}

#endif // BINARY_SEARCH_TREE_CREATE_H_