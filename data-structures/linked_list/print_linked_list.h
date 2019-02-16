#include <iostream>
#include "node.h"
using namespace std;

// print out the value for each node
template <typename T>
void printLinkedList(Node<T> *front) {
    
    if (front == NULL) {
        return; 
    }
    Node<T> *current; 
    current = front; 
    while (current != NULL) {
        cout << current->nodeValue << " "; 
        current = current->next; 
    }
    cout << endl;
}