
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(const int argc, const char** argv) {
    static const char* combinations = "0123456789";
    static const int length = 11;

    static const size_t size = 5;

    char* value = malloc(size);

    int column = size;
    int row = length;

    int counter = 0;

    while (1) {
        counter += 1;
        while(1) {
            counter % length;
        }
        *(value + column) = *(combinations + row);
        if (row) {

        }
    }

    /*
        char* a = malloc();

        sprintf("")  22 

    */



    

    return 0;
}