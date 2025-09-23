// Copyright 2025 Tarandeep Singh
#include <stdio.h>

int sumEvenFibo(int);
int sumEvenFibo2(int);


int main() {
  // 1 1 2 3 5 8
  int n = 5;
  printf("The sum of first %d elements in fibonacci series: %d\n", n, sumEvenFibo(n));
  printf("The sum of first %d elements in fibonacci series: %d\n", n, sumEvenFibo2(n));
}

int sumEvenFibo2(int n) {
  int a = 2;
  int b = 8;
  int sum = a + b;
  if (n == 1) return a;
  if (n == 2) return a + b;
  for (int i = 3; i <= n; i++) {
    int c = 4 * b + a;
    a = b;
    b = c;
    sum += b;
  }
  return sum;
}	

int sumEvenFibo(int n) {
  int a = 1;
  int b = 1;
  int sum = 0;
  int cnt = 0;
  while (cnt < n) {
    int c = a + b;
    a = b;
    b = c;
    if (b % 2 == 0) {
      sum += b;
      cnt++;
    }
  }
  return sum;
}

