#include <iostream>
#include "node.h"
using namespace std;

// insert the new node at the front of the linked list
// return the pointer to the first node
template <typename T>
Node<T> *insertFront(Node<T> *newNode, const T& value, Node<T> *current) {
    newNode = new Node<T>(value, current); 
    current = newNode;
    return current; 
}
