#include <iostream>
using namespace std;

void insertionSort(int arr[], int size) {

	int key, i;

	for (int j = 1; j < size; j++) {

		key = arr[j];
		i = j - 1; 
		while (i >= 0 && arr[i] > key) {
			arr[i+1] = arr[i];
			i--;
		}
		arr[i+1] = key; 
	}
}

void print(int arr[], int size) {
	for (int i = 0; i < size; i++) {
		cout << arr[i] << " ";
	}
	cout << endl;
}

int main() {

	int arr[] = {9,3,-6,1,-10,76};
	int size = sizeof(arr)/sizeof(arr[0]); 
	print(arr, size);
	insertionSort(arr, size);
	print(arr, size);

	return 0;
}