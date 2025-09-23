#include <stdio.h>
#include <assert.h>

int signFunction(int n) {
  // return 1 if positive
  // 0 if zero
  // -1 if negative
  if (!n) {
    // If zero
    return 0;
  }
  if ((1 << 31) & n) {
    return -1;
  }
  // Only option left to be positive
  return 1;
}

int ternaryFunction(int a, int b, int c) {
  if (a) {
    return b;
  }
  return c;
}

int bang(int n) {
  // Compute !x without using !
}

int main(){
  // Test cases for sign function
  assert(signFunction(0) == 0);
  assert(signFunction(130) == 1);
  assert(signFunction(-23) == -1);

  // Test cases for ternaryFunction
  assert(ternaryFunction(2, 4, 5) == 4);
  assert(ternaryFunction(0, 4, 5) == 5);

  return 0;
}