#include <iostream>
#include "node.h"
using namespace std;

// locate the value of a node and delete the node 
// Node<T> *& head - '*&' this notation refers to 
// accessing the memory address of the pointer
template <typename T>
void deleteNode(Node<T> *& head, const T& value) {
    if (head == NULL) {
        return;
    }

    Node<T> *current = head, *prev = NULL;
   
    while (current != NULL) {
        if (current->nodeValue == value) {
            if (prev == NULL) {         // the item is the first node
                head = head->next;
            }
            else {
                prev->next = current->next; 
            }
            current = NULL;
            delete current;
            return;
        }
        else {
            prev = current; 
            current = current->next; 
        }
    }

    cout << "value is not found" << endl;
}