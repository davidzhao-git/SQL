
#include <iostream>
#include <string>
#include <queue>
#include "binary_search_tree.h"
#include "binary_search_tree_create_node.h"
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
        return searchValue(root->left, value);
    }
    else {
        return searchValue(root->right, value);
    }
}

int main() {

    BinarySearchTreeNode<int> *root = NULL;
    root = insertNode(root, 70);
    root = insertNode(root, 90);
    root = insertNode(root, 65);
    root = insertNode(root, -2);
    root = insertNode(root, 4);
    root = insertNode(root, 200);

    bool found = searchValue(root, 70);
    if (found) {
        cout << "Found the value" << endl;
    }
    else {
        cout << "cannot find the value" << endl;
    }

    return 0;
}
