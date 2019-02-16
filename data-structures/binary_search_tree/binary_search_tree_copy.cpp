
#include <iostream>
#include "binary_search_tree.h"
#include "binary_search_tree_create_node.h"
#include "binary_search_tree_output.h"
using namespace std;

// make a copy of the tree
template <typename T>
BinarySearchTreeNode<T> *copyTree(BinarySearchTreeNode<T> *root) {

    if (root == NULL) {
        return NULL;
    }

    // declare pointers to hold the address for left node and right node
    BinarySearchTreeNode<T> *newLeft = NULL, *newRight = NULL, *newNode = NULL;
    newLeft = copyTree(root->left);
    newRight = copyTree(root->right);
    newNode = new BinarySearchTreeNode<T>(root->nodeValue, newLeft, newRight);

    return newNode;
}

int main() {

    BinarySearchTreeNode<int> *root = NULL, *newTree = NULL;
    root = insertNode(root, 70);
    root = insertNode(root, 90);
    root = insertNode(root, 65);
    root = insertNode(root, -2);
    root = insertNode(root, -43);
    root = insertNode(root, 4);
    root = insertNode(root, 200);

    inOrderOutput(root, " ");
    newTree = copyTree(root);
    cout << endl;
    inOrderOutput(newTree, " ");

    return 0;
}
