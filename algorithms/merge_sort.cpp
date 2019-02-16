#include <iostream>
#include <string>
using namespace std;

void merge(int arr[], int start, int midPoint, int end) {

	int indexL = midPoint - start + 1;		// # of elements on the left
	int indexR = end - midPoint;			// # of elements on the right 
	int newIndex = start;					
	int left_arr[indexL];
	int right_arr[indexR];
	int i = 0;
	int j = 0;

	// copy the elements into left subarray 
	for (i = 0; i < indexL; i++) {
		left_arr[i] = arr[start+i];
	}
	// copy the elements into the right subarray 
	for (j = 0; j < indexR; j++) {
		right_arr[j] = arr[midPoint+1+j]; 
	}

	i = 0;
	j = 0; 
	while (i < indexL && j < indexR ) {
		if (left_arr[i] < right_arr[j]) {
			arr[newIndex] = left_arr[i];
			i++;
		}
		else {
			arr[newIndex] = right_arr[j];
			j++;
		}
		newIndex++;
	}

	while (i < indexL) {
		arr[newIndex] = left_arr[i];
		i++;
		newIndex++;
	}
	
	while (j < indexR) {
		arr[newIndex] = right_arr[j];
		j++;
		newIndex++;
	}
}

void mergeSort(int arr[], int start, int end) {

	if (end - start <= 0) {
		// cout << "end is " << end << endl;
		// cout << "start is " << start << endl;
		return;
	}
	int midPoint = (start+end) / 2;

	mergeSort(arr, start, midPoint);
	mergeSort(arr, midPoint + 1, end);
	// cout << "Before calling merge, start " << start << " end " << end << endl; 
	// cout << "midPoint " << midPoint << endl;
	merge(arr, start, midPoint, end);

}

void print(int arr[], int size) {
	for (int i = 0; i < size; i++) {
		cout << arr[i] << " ";
	}
	cout << endl;
}

int main() {

	int arr[] = {9,3,6,1};
	int size = sizeof(arr)/sizeof(arr[0]);
	print(arr, size);

	mergeSort(arr, 0, size-1);
	print(arr, size);

	return 0;
}

