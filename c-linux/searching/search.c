#include <stdio.h>

int linearSearch(int *, int, int);
int recursiveBinarySearch(int *, int, int);
int iterativeBinarySearch(int *, int, int);


int main() {
    	int arr[] = {1, 5, 8, 20, 192};
    	int n = sizeof(arr) / sizeof(arr[0]);
    	int targets[] = {5, 192, 100};  
    	int t = sizeof(targets) / sizeof(targets[0]);

    	for (int i = 0; i < t; i++) {
        	int target = targets[i];
       		printf("\nSearching for %d:\n", target);
        	printf("Linear Search Index: %d\n", linearSearch(arr, n, target));
        	printf("Iterative Binary Search Index: %d\n", iterativeBinarySearch(arr, n, target));
        	printf("Recursive Binary Search Index: %d\n", recursiveBinarySearch(arr, n, target));
	}
}

int linearSearch(int *arr, int n, int target) {
	for (int i = 0; i < n; i++) {
		if (arr[i] == target) {
			return i;
		}
	}
	return -1;
}


int iterativeBinarySearch(int *arr, int n, int target) {
	int left = 0;
	int right = n - 1;	
	while (left <= right) {
		int mid = left + (right - left) / 2;
		if (arr[mid] == target) {
			return mid;
		}
		else if (arr[mid] < target) {
			// go right
			left = mid + 1;
		}
		else {
			// go left
			right = mid - 1;
		}
	}
	
	return -1;
}

int helper(int *arr, int left, int right, int target) {
	if (left > right) {
		return -1;
	}
	int mid = left + (right - left) / 2;
	if (arr[mid] == target) {
		return mid;
	}
	else if (arr[mid] < target) {
		// go right
		return helper(arr, mid + 1, right, target);
	}
	else {
		// go left
		return helper(arr, left, mid - 1, target);
		
	}
}

int recursiveBinarySearch(int *arr, int n, int target) {
	return helper(arr, 0, n - 1, target);
}
