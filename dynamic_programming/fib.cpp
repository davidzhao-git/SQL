#include <iostream>
using namespace std;

int fib(int n) {

	if (n == 1 || n == 2) {
		return 1; 
	}
	// int arr[n+1];   
	int *arr;
	arr = new int[n+1];
	arr[1] = 1;
	arr[2] = 1;
	
    cout << arr[1] << "\n" << arr[2] << "\n"; 
    
	for (int i = 3; i <= n; i++) {
		arr[i] = arr[i-1] + arr[i-2];
		cout << arr[i] << endl;
	}
	int result = arr[n];
	delete[] arr;
	return result;
}

int main() {

	int result = fib(1000);
	cout << "result " << result << endl;

	return 0;
}	

