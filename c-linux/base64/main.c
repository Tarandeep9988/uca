#include <stdio.h>
#include <string.h>
#include <stdlib.h>


void encoder(char* input, int l, char* output) {
  char* map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

  int n = 0;
  int i = 0;
  int j = 0;
  while (i < l) {
    n += (input[i++]) << 16;
    if (i < l) n += (input[i++]) << 8;
    if (i < l) n += (input[i++]);
    if (i % 3) {
      int n1 = (n >> 18) & 63;
      int n2 = (n >> 12) & 63;
      int n3 = (n >> 6) & 63;
      int n4 = (n & 63);
      output[j++] = map[n1];
      output[j++] = map[n2];
      output[j++] = map[n3];
      output[j++] = map[n4];
      n = 0;
    }
  }
  if (l % 3 == 1) {
    int n1 = (n >> 18) & 63;
    int n2 = (n >> 12) & 63;
    output[j++] = map[n1];
    output[j++] = map[n2];
    output[j++] = '=';
    output[j++] = '=';
  }
  if (l % 3 == 2) {
    int n1 = (n >> 18) & 63;
    int n2 = (n >> 12) & 63;
    int n3 = (n >> 6) & 63;
    output[j++] = map[n1];
    output[j++] = map[n2];
    output[j++] = map[n3];
    output[j++] = '=';
  }

}

int main() {
  char* input = "abc";
  int l = strlen(input);
  char* output = malloc(4 * (l + 2) / 3);
  
  encoder(input, l, output);

  printf("%s\n", input);
  printf("%s\n", output);
}
