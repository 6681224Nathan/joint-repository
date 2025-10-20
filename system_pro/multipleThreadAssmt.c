// multipleThreadAssmt.c
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//Pitchayut Boonporn     	6680741
//Wunna Aung Hein         	6680715
//Nathan Tanaboriboon     	6681224
//Prin Chinpanuwat         	6680744

#define NUM_THREADS 5
#define RANGE_START 1
#define RANGE_END 50000
#define CHUNK_SIZE 10000        // Each thread analyze 10,000 numbers
#define MAX_IN_SLICE CHUNK_SIZE  // Upper Bound for Primes stored per slice

// Per-thread result container
typedef struct {
    int start;      // inclusive
    int end;        // inclusive
    int *primes;    // buffer to store primes found
    int count;      // how many primes found
} ThreadArgs;

// Simple is_prime function
static int is_prime(int n){
    if (n<2) return 0;
    if (n == 2 || n == 3) return 1;
    if (n % 2 == 0) return 0;
    int limit = (int) sqrt((double) n);
    for (int f = 3; f <= limit; f+=2){
        if (n % f == 0) return 0;
    }
    return 1;
}

// Workers : find Primes in [start, end], write into args -> primes, set args -> count
static void *worker_find_primes(void *arg){
    ThreadArgs *a = (ThreadArgs*) arg;
    int idx = 0;
    for (int x = a->start; x<= a->end; ++x){
        if (is_prime(x)){
            a->primes[idx++] = x;
        }
    }
    a->count = idx;
    return NULL;
}

int main(void){
    pthread_t threads[NUM_THREADS];
    ThreadArgs args[NUM_THREADS];

    // Allocate per-thread prime buffers (no sharing -> no locks needed)
    for (int i = 0; i < NUM_THREADS; ++i){
        int start = RANGE_START + i * CHUNK_SIZE;
        int end = start + CHUNK_SIZE -1;
        args[i].start = start;
        args[i].end = end;
        args[i].primes = (int*) malloc(sizeof(int) * MAX_IN_SLICE);
        args[i].count = 0;
        if (!args[i].primes) {
            fprintf(stderr, "Allocation Failed for Thread %d \n", i);
            //Clean up previous allocations
            for (int k = 0; k < i; ++k){ free(args[k].primes);}
            return 1;
        }
    }

    // Spawn Threads
    for (int i = 0; i < NUM_THREADS; ++i){
        if (pthread_create(&threads[i], NULL, worker_find_primes, &args[i]) != 0){
            fprintf(stderr, "pthread_create failed for thread %d \n", i);

            // Attempt to join any previously created threads, then clean up
            for (int k = 0; k < i; ++k) pthread_join(threads[k], NULL);
            for (int k = 0; k < NUM_THREADS; ++k) free(args[k].primes);
            return 1;
        }
    }

    // Join and aggregate results. Requirement says: main thread prints all primes.
    // Printing by slice index 0..4 naturally yields sorted order (ranges are non-overlapping and increasing).
    int total_primes = 0;
    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_join(threads[i], NULL);
        total_primes += args[i].count;
    }

    // Print results (main thread only)
    // Optional: print a header
    printf("Prime numbers between %d and %d:\n", RANGE_START, RANGE_END);
    for (int i = 0; i < NUM_THREADS; ++i) {
        for (int j = 0; j < args[i].count; ++j) {
            printf("%d\n", args[i].primes[j]);
        }
    }
    printf("Total primes found: %d\n", total_primes); // should be 5133 for 1..50000

    // Cleanup
    for (int i = 0; i < NUM_THREADS; ++i) {
        free(args[i].primes);
    }
    return 0;
}

