
#ifndef BINARY_SEARCH_TREE_H_
#define BINARY_SEARCH_TREE_H_
#include <cstddef>

template <typename T>
class BinarySearchTreeNode {
    
public:
    T nodeValue;
    BinarySearchTreeNode<T> *left, *right;
    
    BinarySearchTreeNode() {}
    
    BinarySearchTreeNode(const T& value,
                         BinarySearchTreeNode<T> *leftPtr = NULL,
                         BinarySearchTreeNode<T> *rightPtr = NULL):
    nodeValue(value), left(leftPtr), right(rightPtr) {}
};

#endif  // BINARY_SEARCH_TREE_H_

