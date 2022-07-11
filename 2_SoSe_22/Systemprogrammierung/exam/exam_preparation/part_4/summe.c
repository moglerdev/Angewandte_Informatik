#include <stdio.h>
#include <stdlib.h>

#define STR_HELPER(x) #x
#define STR(x) STR_HELPER(x)

#define MAX_SIZE_INPUT __INT_FAST64_WIDTH__

int main(const int argc, const char** argv) {

    if (argc < 3) {
        printf("Sie müssen min. 2 Zahlen als Argumente eingeben!\n");
        return -1;
    }

    long int result = 0;

    char add = ' ';
    for(int i = argc - 1; i > 0; --i) {
        const char* val = *(argv + i);
        printf("%c %s\n", add, val);
        result += strtol(val, NULL, 10);
        add = '+';
    }

    printf("--------------\n  %lu\n", result);
    return 0;
}