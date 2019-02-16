// demonstrate that delete a node from binary search tree
// based on different conditions

#include <iostream>
#include <string>
#include "binary_search_tree.h"
#include "binary_search_tree_create_node.h"
#include "binary_search_tree_output.h"
using namespace std;

// search for a value in a binary search tree
template <typename T>
bool searchValue(BinarySearchTreeNode<T> *root, const T& value) {
    if (root == NULL) {
        return false;
    }
    else if (value == root->nodeValue) {
        return true;
    }
    else if (value < root->nodeValue) {
        searchValue(root->left, value);
    }
    else {
        searchValue(root->right, value);
    }
}

// find the next node to replace the node that is going to be deleted
// return the address of that available node
template <typename T>
BinarySearchTreeNode<T> *findNextNode(BinarySearchTreeNode<T> *root) {
    while (root->left != NULL) {
        root = root->left;
    }
    return root;
}

template <typename T>
BinarySearchTreeNode<T> *deleteNode(BinarySearchTreeNode<T> *root, int data) {
    if (root == NULL) {
        return root;
    }

    if (data < root->nodeValue) {
        root->left = deleteNode(root->left, data);
    }
    else if (data > root->nodeValue) {
        root->right = deleteNode(root->right, data);
    }
    // found the node value
    else {
        if (root->left == NULL && root->right == NULL) {
            // for a leaf node, just delete
            delete root;
            root = NULL;
        }
        else if (root->left == NULL) {
            // declare a temp pointer to hold the address of the current node
            BinarySearchTreeNode<T> *temp = root;

            // since only root->left == NULL, root->right must have a address
            // assign that address to the current node
            root = root->right;
            delete temp;
        }
        else if (root->right == NULL) {
            BinarySearchTreeNode<T> *temp = root;
            root = root->left;
            delete temp;
        }
        else {
            // when the current node has two children
            BinarySearchTreeNode<T> *temp = findNextNode(root->right);
            root->nodeValue = temp->nodeValue;
            root->right = deleteNode(root->right, temp->nodeValue);
        }
    }
    return root;
}

int main() {
    BinarySearchTreeNode<int> *root = NULL;
    root = insertNode(root, 70);
    root = insertNode(root, 90);
    root = insertNode(root, 65);
    root = insertNode(root, -2);
    root = insertNode(root, -43);
    root = insertNode(root, 4);
    root = insertNode(root, 200);
    root = insertNode(root, 88);
    root = insertNode(root, 602);
    root = insertNode(root, 68);
    root = insertNode(root, 177);
    root = insertNode(root, 900);
    root = insertNode(root, 512);

    inOrderOutput(root);

    root = deleteNode(root, 88);
    cout << endl;
    inOrderOutput(root);
    cout << endl;

    return 0;
}
