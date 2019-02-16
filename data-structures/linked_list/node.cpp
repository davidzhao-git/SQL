#include "node.h"
#include "print_linked_list.h"
#include "insert_front.h"
#include "delete_front.h"
#include "delete_node.h"
#include <iostream>
using namespace std;

int main() {

    Node<int> *head = new Node<int>(20);
    Node<int> *secondNode = new Node<int>(30);
    head->next = secondNode;

    Node<int> *newNode;
    head = insertFront(newNode, 66, head);
    head = insertFront(newNode, 97, head);
    printLinkedList(head);

    head = deleteFront(head);
    printLinkedList(head);

    head = insertFront(newNode, -5, head);
    printLinkedList(head);

    deleteNode(head, 30);
    printLinkedList(head);

    delete head;
    delete secondNode; 

    return 0;
}