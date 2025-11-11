#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define HEAP_SIZE 1024 * 1024 // 1 MiB simulated heap
unsigned char *heap;

typedef struct Block {
  int size;
  void *address;
  bool isFree;
  struct Block *next;
  struct Block *prev;
} Block;

Block *blockList;
 

void *customMalloc(int); // size
void *customFree(void*); // address of allocated memory

int main(){
  heap = (unsigned char *)malloc(HEAP_SIZE);
  
  // Creating dummy blocks
  Block* dummyHead = malloc(sizeof(Block));
  dummyHead->size = -1;
  dummyHead->address = NULL;
  dummyHead->isFree = false;
  Block* dummyTail = malloc(sizeof(Block));
  dummyTail->size = -1;
  dummyTail->address = NULL;
  dummyTail->isFree = false;

  // Creating block list
  blockList = malloc(sizeof(Block));
  blockList->size = HEAP_SIZE;
  blockList->address = heap;
  blockList-> isFree = true;
  
  // Connecting blocks (nodes)
  dummyHead->prev = dummyTail->next = NULL;
  dummyHead->next = dummyTail->prev = blockList;
  blockList->next = dummyTail;
  blockList->prev = dummyHead;

  // Simulate allocation: create array of 100 ints
  int n = 100;
  int *ptr = customMalloc(sizeof(int) * n);
  if (ptr != NULL) {
      printf("Created array of size %d\n", n);
  } else {
      printf("Allocation failed!\n");
  }

  // Free the allocated memory
  customFree(ptr);
  printf("Memory freed and merged if possible.\n");

  // Free dummy nodes (cleanup)
  free(dummyHead);
  free(dummyTail);

  // Free allocated heap storage
  free(heap);
  return 0;
}

void *customMalloc(int size) {
  if (blockList == NULL) {
    return NULL; // no memory to allocate
  } 
  Block* allocatedBlockList = NULL;

  // Find continous chunk of memory of size from blockList
  for (Block *ptr = blockList; ptr->next != NULL; ptr = ptr-> next) {
    if (ptr->isFree) {
      if (ptr->isFree && ptr->size > size) {
        // Creating occupied node
        Block *occupied = malloc(sizeof(Block));
        occupied->size = size;
        occupied->address = ptr->address;
        occupied->next = ptr;
        occupied->prev = ptr->prev;
        occupied->next->prev = occupied;
        occupied->prev->next = occupied;
        occupied->isFree = false;

        ptr->address = (char *)ptr->address + size;
        ptr->size -= size;
        return occupied->address;
      }
      else if (ptr->size == size) {
        ptr->isFree = false;
        return ptr->address;
      }
    }
  }
  return NULL; // continous chunk of size is not available
}

void *customFree(void *addressToFree) {
  if (blockList == NULL) {
    return NULL; // Nothing to free
  }

  for (Block *ptr = blockList; ptr->next != NULL; ptr = ptr-> next) {
    if (addressToFree == ptr->address) {
      // Just free this block for now
      ptr->isFree = true;
      break;
    }
  }

  // Merging fragments into a single block;
  Block *ptr = blockList;
  while (ptr->next != NULL) {
    if (ptr->isFree) {
      int sizeSum = ptr->size;
      Block* frag = ptr->next;
      while (frag->isFree) {
        sizeSum += frag->size;
        Block *blockToFree = frag;
        frag = frag->next;
        free(blockToFree);
      }
      ptr->next = frag;
      frag->prev = ptr;

    }
    ptr = ptr->next;
  }
  return NULL; // addressToFree is invalid;
}

