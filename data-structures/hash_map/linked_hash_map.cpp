// use Chaining 
#include "linked_hash_class.h"
#include <iostream>
using namespace std;

const int Array_Size = 10;
class HashMap {
    private: 
        LinkedHash **table;
    
    public:     
        HashMap() {
            // each table is a pointer to the first node 
            table = new LinkedHash *[Array_Size];
            for (int i = 0; i < Array_Size; i++) {
                table[i] = NULL;
            }
        }

        ~HashMap() {
            for (int i = 0; i < Array_Size; i++) {
                if (table[i] != NULL) {
                    LinkedHash *prevPtr = NULL;
                    LinkedHash *currentPtr = table[i];
                    // deallocate memory for each node
                    while (currentPtr != NULL) {
                        prevPtr = currentPtr;
                        currentPtr = currentPtr->getNextPtr();
                        delete prevPtr; 
                    }
                }
            }
            delete[] table;
        }

        void enterKeyValue(int key, int value) {
            int hashIndex = (key % Array_Size);

            // when the address of the index is NULL, create a pointer to hold 
            // the address of the first key-value pairs
            if (table[hashIndex] == NULL) {
                table[hashIndex] = new LinkedHash(key, value);
                cout << "new index = " << hashIndex;
                cout << ", key = " << table[hashIndex]->getKey();
                cout << ", value = " << table[hashIndex]->getValue() << endl;
            }
            // the address is NOT NULL
            else {
                LinkedHash *entryPtr = table[hashIndex];
                while (entryPtr->getNextPtr() != NULL) {
                    entryPtr = entryPtr->getNextPtr();
                }
                
                // if the key already exists, update the existing value to the new value
                if (entryPtr->getKey() == key) {
                    entryPtr->setValue(value);
                    cout << "key " << entryPtr->getKey() << " exists, update the value to " 
                         << entryPtr->getValue() << endl;
                }
                // if the key does not exist, create a pointer to hold 
                // the new key-value pairs and insert them at the end of the list 
                else {
                    entryPtr->setNextPtr(new LinkedHash(key, value));
                    cout << "created a new node, key = " << entryPtr->getNextPtr()->getKey() 
                         << ", value = " << entryPtr->getNextPtr()->getValue() << endl;
                }
            }
        }

        int locateValue(int key, int value) {
            // use the key to locate the right table 
            int hashIndex = key % Array_Size;
            if (table[hashIndex] == NULL) {
                return -1;
            }
            else {
                LinkedHash *entryPtr = table[hashIndex];
                while (entryPtr != NULL && entryPtr->getValue() != value) {
                    entryPtr = entryPtr->getNextPtr(); 
                }
                // end of the list 
                if (entryPtr == NULL) {
                    return -1;
                }
                // found the value 
                else {
                    return entryPtr->getValue();
                }
            }
        }

        void removeKey(int key) {
            int hashIndex = key % Array_Size;
            
            // only can perform removing node when table is NOT NULL
            if (table[hashIndex] != NULL) {
                LinkedHash *prevPtr = NULL;
                LinkedHash *currentPtr = table[hashIndex];
                while (currentPtr->getNextPtr() != NULL && currentPtr->getKey() != key) {
                    // advance the pointers 
                    prevPtr = currentPtr;
                    currentPtr = currentPtr->getNextPtr();
                }
                // found the key 
                if (currentPtr->getKey() == key) {
                    if (prevPtr != NULL) {
                        LinkedHash *nextPtr = currentPtr->getNextPtr();
                        delete currentPtr;
                        prevPtr->setNextPtr(nextPtr);
                        cout << "Key has been removed" << endl;
                    }
                    else {
                        // beginning of the list
                        cout << "found the key at the beginning of the table, remove key = " 
                             << currentPtr->getKey() << endl;
                        LinkedHash *nextPtr = currentPtr->getNextPtr();
                        delete currentPtr;
                        table[hashIndex] = nextPtr;
                    }
                }
            }
            else {
                cout << "Key is not found" << endl;
            }
        }
};


int main() {
    
    HashMap myHashMap = HashMap();

    myHashMap.enterKeyValue(1, 200);
    myHashMap.enterKeyValue(11, 10);
    myHashMap.enterKeyValue(11, 76);
    myHashMap.enterKeyValue(55, 32);
    myHashMap.enterKeyValue(65, 32);
    int key, value;
    cout << "Enter a key you want to search: ";
    cin >> key; 
    cout << "Enter a value you want to find: "; 
    cin >> value;
    if (myHashMap.locateValue(key, value) == -1) {
        cout << "value is not found" << endl;
    }
    else {
        cout << "The value is found: " << myHashMap.locateValue(key, value) << endl;
    }

    int removeKey;
    cout << "Enter a key you want to remove: ";
    cin >> removeKey; 
    myHashMap.removeKey(removeKey);
    
    return 0;

}