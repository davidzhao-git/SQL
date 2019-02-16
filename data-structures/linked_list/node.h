#ifndef NODE_H_
#define NODE_H_
#include <iostream>
using namespace std;

template <typename T>
class Node {
    public:
        T nodeValue;
        Node *next;

        Node() : next(NULL){}
        Node(const T& value, Node<T> *nextNode = NULL) : 
            nodeValue(value), next(nextNode){}
};

#endif
