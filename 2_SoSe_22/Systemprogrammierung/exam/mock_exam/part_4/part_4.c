#include <string.h> // strlen, strcat
#include <stdlib.h> // malloc 
#include <stdio.h>  // printf

int main(const int argc, const char** argv) {
    const char* s = argv[1];
    const char* t = argv[2];

    const char* st = malloc(strlen(s) + strlen(t) + 1);
    strcat(st, s);
    strcat(st, t);

    printf("%s\n", st);

    free(st);
    return 0;
}