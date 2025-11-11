// Copyright 2025 Tarandeep Singh
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void mergeSort(int*, int, int (*)(int, int));

int compareAsc(int a, int b) {
  return a - b;
}
int compareDesc(int a, int b) {
  return b - a; 
}

int main() {
    int arr[] = {5, 2, 9, 1, 3};
    int n = sizeof(arr) / sizeof(arr[0]);

    // Printing original array
    printf("Original Array:\t");
    for (int i = 0; i < n; i++) {
      printf("%d ", arr[i]);
    }
    printf("\n");

    // Sort in ascending order
    mergeSort(arr, n, compareAsc);
    printf("Ascending:\t");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Sort in descending order
    mergeSort(arr, n, compareDesc);
    printf("Descending:\t");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}


void merge(int *arr, int start, int end, int *temp, int (*compare)(int, int)) {
  int mid = start + (end - start) / 2;
  int i = start;
  int j = mid + 1;
  int n = end - start + 1;
  int k = 0;
  while (i <= mid && j <= end) {
    if (compare(arr[i], arr[j]) <= 0) {
      temp[k++] = arr[i++];
    } else {
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


void mergeSortHelper(int *arr, int start, int end, int *temp, int (*compare)(int, int)) {
  if (start >= end) {
    return;
  }
  int mid = start + (end - start) / 2;

  // sort the left half
  mergeSortHelper(arr, start, mid, temp, compare);

  // sort the right half
  mergeSortHelper(arr, mid + 1, end, temp, compare);

  // merge left and right
  merge(arr, start, end, temp, compare);
}

void mergeSort(int *arr, int n, int (* compare)(int, int)) {
  if (n == 0) {
    return; // Empty array
  }
  int *temp = malloc(n * sizeof(int));
  mergeSortHelper(arr, 0, n - 1, temp, compare);
  free(temp);
}
