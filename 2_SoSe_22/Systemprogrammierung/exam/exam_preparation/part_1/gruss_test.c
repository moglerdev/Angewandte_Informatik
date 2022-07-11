
#include "gruss.h"

#include <stdlib.h>

#define STR_HELPER(x) #x
#define STR(x) STR_HELPER(x)

#define MAX_SIZE_INPUT 64

int main(void) { // const int argc, const char** argv
    printf("Bitte Vorname eingeben: ");

    char* vorname = (char*) malloc(MAX_SIZE_INPUT);
    if(scanf("%"STR(MAX_SIZE_INPUT)"s", vorname) < 1) {
        printf("Fehler beim lesen der Eingabe!\n");
        free(vorname);
        return -1;
    }
    ausgeben(vorname);
    free(vorname);
    return 0;
}

