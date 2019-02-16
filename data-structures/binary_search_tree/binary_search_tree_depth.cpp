

#include "binary_search_tree.h"
#include "binary_search_tree_create_node.h"
#include <iostream>
#include <cstddef>
using namespace std;

// calculate the depth of a binary tree
template <typename T>
int depth(BinarySearchTreeNode<T> *root) {

    int depthLeft, depthRight, depthValue;

    if (root == NULL) {
        return -1;
    }
    else {
        depthLeft = depth(root->left);
        depthRight = depth(root->right);
        depthValue = 1 + (depthLeft > depthRight ? depthLeft : depthRight);
    }

    return depthValue;
}

int main() {

    BinarySearchTreeNode<int> *root = new BinarySearchTreeNode<int>();
    root = NULL;
    root = insertNode(root, 70);
    root = insertNode(root, 90);
    root = insertNode(root, 65);
    root = insertNode(root, -2);
    root = insertNode(root, -43);
    root = insertNode(root, 4);
    root = insertNode(root, 200);

    cout << "The depth level of the tree is " << depth(root) << endl;
    delete root;
    root = NULL;

    return 0;
}
