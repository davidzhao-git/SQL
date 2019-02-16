#ifndef LINKED_HASH_CLASS_H_
#define LINKED_HASH_CLASS_H_
#include <iostream>

class LinkedHash {
    // each node represents key-value pairs and a pointer to the next node 
    private:
        int key;
        int value;
        LinkedHash *next;

    public:
        // constructor 
        LinkedHash(int key, int value) {
            this->key = key;
            this->value = value;
            this->next = NULL;
        }

        int getKey() {
            return key;
        }

        int getValue() {
            return value; 
        }

        LinkedHash *getNextPtr() {
            return next; 
        }

        void setValue(int value) {
            this->value = value;
        }

        void setNextPtr(LinkedHash *next) {
            this->next = next;
        }

};

#endif