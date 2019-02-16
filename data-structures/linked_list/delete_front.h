#include <iostream>
#include "node.h"
using namespace std;

// delete the front node
// the next node will become the front node 
template <typename T>
Node<T> *deleteFront(Node<T> *head) {
    if (head != NULL) {
        Node<T> *current = head;
        head = current->next; 
    }
    return head;
}