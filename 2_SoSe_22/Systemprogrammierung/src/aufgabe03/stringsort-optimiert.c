#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int bubblesort(void *base, size_t n, size_t size, int (*compar)(const void *, const void*)) {
    char* a = (char*)base;
    char* tmp = malloc(size);
    if (tmp == NULL) {
        return -1;
    }

    for (int i = n; i > 1; --i) {
        for (int j = 0; j < i - 1; ++j) {
            size_t curIn = j * size;
            size_t nextIn = curIn + size;
            if (compar(&a[curIn], &a[nextIn]) > 0) {
                strncpy(tmp, &a[nextIn], size);
                strncpy(&a[nextIn], &a[curIn], size);
                strncpy(&a[curIn], tmp, size);
            }
        }
    }
    free(tmp);
    return 0;
}

int main(const int argc, const char** argv) {
    //--------------------------------------------- Arraygroesse bestimmen
    if (argc != 2) {
        printf("Aufruf: %s [ANZAHL:int]\n", argv[0]);
        return -1;
    }

    const int n = atoi(argv[1]);
    size_t max = strlen(argv[1]) + 1;

    if(n < 1) {
        printf("ANZAHL darf nicht kleiner als 1 sein\n"
               "und muss ein Integer Wert sein!\n");
        return -1;
    }

    //--------------------------------------------------- Strings wuerfeln
    char *a = malloc(n * max);

    if (a == NULL) {
        printf("ERROR: Array-Speicher konnte nicht allokiert werden!\n");
        return -1;
    }

    // Initialisierung der Random-Bibliothek
    time_t t;
    srand((unsigned) time(&t));

    printf("Unsortiertes Array:\n");

    for (int i = n -1; i > -1; --i) {
        int r = rand() % n;
        size_t jmpAdr = i * max;
        snprintf(&a[jmpAdr], max, "%d", r);
        printf("%s ",&a[jmpAdr]);
    }

    //-------------------------------------------------- Strings sortieren
    if (bubblesort(a, n, max, (int(*)(const void *, const void*)) strcmp) == -1){
        printf("ERROR: Im Bubblesort konnte keine Speicher allokiert werden!\n");
        return -1;
    }

    printf("\n");

    //--------------------------------------------------- Strings ausgeben
    printf("Sortiertes Array:\n");
    char* s = malloc((n + 1) * max);
    if (s == NULL) {
        printf("ERROR: Der Speicher für den Ausgabe-String konnte"
               " nicht allokiert werden");
        return -1;
    }

    strncat(s, &a[0], max);
    for (int j = 1; j < n; ++j) {
        size_t curIn = j * max;
        if (strncmp(&a[curIn], &a[curIn - max], max) == 0) {
            strcat(s, "*");
        } else {
            strcat(s, " ");
            strncat(s, &a[curIn], max);
        }
    }
    printf("%s\n", s);
    free(s);
    free(a);
    return 0;
}