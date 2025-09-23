// Copyright 2025 Tarandeep Singh
#include <stdio.h>

void swap(int *a, int i, int j) {
	if (i == j) return;
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
}

void sort(int *a, int L, int R) {
	if (L >= R) return;
	int last = L;
	int i;
	for (i = L + 1; i <= R; i++) {
		if (a[i] < a[L]) {
			swap(a, i, ++last);
		}
	}
	swap(a, L, last);
	sort(a, L, last - 1); 
	sort(a, last + 1, R);
}

int main() {
	int a[] = {5, 1, 3, 6, 7, 4};	
	sort(a, 0, 5);

	for (int i = 0; i < 6; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
}
