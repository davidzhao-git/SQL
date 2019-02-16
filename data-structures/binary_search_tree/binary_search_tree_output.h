#include "binary_search_tree.h"
#include "binary_search_tree_create_node.h"
#include <iostream>
#include <queue>
using namespace std;
// print the node value with following order:
// left node, current node, right node
template <typename T>
void inOrderOutput(BinarySearchTreeNode<T> *root, const string& separator = " ") {
    if (root != NULL) {
        inOrderOutput(root->left, separator);
        cout << root->nodeValue << separator;
        inOrderOutput(root->right, separator);
    }
}

// print the node value with following order:
// left node, right node, current node
template<typename T>
void postOrderOutput(BinarySearchTreeNode<T> *root, const string& separator = " ") {
    if (root != NULL) {
        postOrderOutput(root->left, separator);
        postOrderOutput(root->right, separator);
        cout << root->nodeValue << separator;
    }
}

// traverse the binary tree level by level and output each node value
template<typename T>
void levelOrderOutput(BinarySearchTreeNode<T> *root, const string& separator = " ") {
    if (root == NULL) {
        return;
    }

    BinarySearchTreeNode<T> *cur = NULL;
    // create a queue which can store the address of TreeNode
    queue<BinarySearchTreeNode<T> *> q;
    q.push(root);

    while (!q.empty()) {
        cur = q.front();
        q.pop();
        cout << cur->nodeValue << separator;

        if (cur->left != NULL) {
            q.push(cur->left);
        }

        if (cur->right != NULL) {
            q.push(cur->right);
        }
    }
}
