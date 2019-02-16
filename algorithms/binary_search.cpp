#include <iostream>
using namespace std;

int binarySearch(int arr[], int start, int end, int target) {
	
	if (end >= start) {
		int midPoint = (end + start)/2; 

		if (arr[midPoint] == target) {
			return midPoint; 
		}

		if (target < arr[midPoint]) {
			return binarySearch(arr, start, midPoint, target);
		}
		else {
			return binarySearch(arr, midPoint+1, end, target);
		}
	}
	return -1; 
}

int main() {
	
	int arr[] = {1, 6, 9, 20};
	int size = sizeof(arr)/sizeof(arr[0]);
	int result = binarySearch(arr, 0, size-1, 230);
    if (result == -1) {
        cout << "target is not found" << endl;
    }
	else {
	    cout << "position is located at " << result << endl;
	}
	
	return 0;
}

