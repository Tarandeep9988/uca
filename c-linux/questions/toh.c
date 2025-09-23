// Copyright 2025 Tarandeep Singh
#include <stdio.h>

// Recursive Function
int recursiveToh(int);

// Using Maths
int mathsToh(int);

int main() {
  int n = 5;
  printf("Total number of moves required to transfer %d discs: "
    " %d\n", n, mathsToh(n));
}

int mathsToh(int n) {
  return (1 << n) - 1;
}

int recursiveToh(int n) {
  if (n == 1) {
    return 1;
  }
  return 2 * recursiveToh(n - 1) + 1;
}
