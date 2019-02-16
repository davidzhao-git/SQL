
#include <iostream>
#include "binary_search_tree.h"
#include "binary_search_tree_create_node.h"
using namespace std;

// count the leaf nodes by using recursive function
template <typename T>
int countLeaf(BinarySearchTreeNode<T> *root) {
    if (root == NULL) {
        return 0;
    }

    if (root->left == NULL && root->right == NULL) {
        return 1;
    }
    else {
        return countLeaf(root->left) + countLeaf(root->right);
    }
}

int main() {

    BinarySearchTreeNode<int> *root = NULL;

    root = insertNode(root, 70);
    root = insertNode(root, 90);
    root = insertNode(root, 65);
    root = insertNode(root, -2);
    root = insertNode(root, -43);

    cout << "The total of leaf nodes is " << countLeaf(root) << endl;

    return 0;
}
