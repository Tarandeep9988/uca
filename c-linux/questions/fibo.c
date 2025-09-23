// Copyright 2025 Tarandeep Singh
#include <stdio.h>

int recursiveFibo(int);

int main() {
  // 1 1 2 3 5 8 13 21

  int n = 20;

  printf("fibo(%d) : %d\n", n, recursiveFibo(n));
}

int recursiveFibo(int n) {
  if (n <= 1) return 1;
  return recursiveFibo(n - 1) + recursiveFibo(n - 2);
}

