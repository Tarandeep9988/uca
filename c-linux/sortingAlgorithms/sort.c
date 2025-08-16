#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void selectionSort(int *, int);
void bubbleSort(int *, int);
void insertionSort(int *, int);
void mergeSort(int*, int);

int main() {
	int arr[] = {5, 4, 3, 2, 1};
	int n = 5;

	// selectionSort(arr, n);
	// bubbleSort(arr, n);
	// insertionSort(arr, n);
	mergeSort(arr, n);
	for (int i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");
}

void swap(int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

void insertionSort(int *arr, int n) {
	for (int i = 1; i < n; i++) {
		int key = arr[i];
		int j = i;
		while (j > 0 && key < arr[j - 1]) {
			arr[j] = arr[j - 1];
			j--;
		}
		arr[j] = key;
	}
}

void bubbleSort(int *arr, int n) {
	bool isSwapped = false;
	do {
		isSwapped = false;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(&arr[i], &arr[i + 1]);
				isSwapped = true;
			}
		}
		n--;

	} while (isSwapped);
}


void selectionSort(int *arr, int n) {
	for (int i = 0; i < n - 1; i++) {
		int minEleIndex = i;
		for (int j = i + 1; j < n; j++) {
			if (arr[j] < arr[minEleIndex]) {
				minEleIndex = j;
			}
		}
		swap(&arr[minEleIndex], &arr[i]);
	}
}


void merge(int *arr, int start, int end, int *temp) {
	int mid = start + (end - start) / 2;
	int i = start;
	int j = mid + 1;
	int n = end - start + 1;
	int k = 0;
	while (i <= mid && j <= end) {
		if (arr[i] <= arr[j]) {
			temp[k++] = arr[i++];
		}
		else {
			temp[k++] = arr[j++];
		}
	}
	while (i <= mid) temp[k++] = arr[i++];
	while (j <= end) temp[k++] = arr[j++];

	// copying temp to main array
	for (k = 0; k < n; k++) {
		arr[start + k] = temp[k];
	}
}


void mergeSortHelper(int *arr, int start, int end, int *temp) {
	if (start >= end) {
		return;
	}
	int mid = start + (end - start) / 2;
	
	// sort the left half
	mergeSortHelper(arr, start, mid, temp);
	
	// sort the right half
	mergeSortHelper(arr, mid + 1, end, temp);

	// merge left and right
	merge(arr, start, end, temp);
}

void mergeSort(int *arr, int n) {
	int *temp = malloc(n * sizeof(int));
	mergeSortHelper(arr, 0, n - 1, temp);
	free(temp);
}
