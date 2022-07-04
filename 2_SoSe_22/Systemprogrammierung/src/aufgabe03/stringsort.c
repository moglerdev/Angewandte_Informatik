//
// Created by mogler on 29.04.22.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>


int bubblesort(const int n, char** a)
{
    char* tmp;
    for (int i = n; i > 1; --i)
    {
        for (int j = 0; j < i - 1; ++j)
        {
            size_t nextIn = (j + 1);
            size_t curIn = j;
            if (strcmp(a[curIn], a[nextIn]) > 0)
            {
                tmp = a[nextIn];
                a[nextIn] = a[curIn];
                a[curIn] = tmp;
            }
        }
    }
    return 0;
}

int main(const int argc, const char** argv)
{
    //--------------------------------------------- Arraygroesse bestimmen
    if (argc != 2)
    {
        printf("Aufruf: %s [ANZAHL:int]\n", argv[0]);
        return -1;
    }

    const int n = atoi(argv[1]);
    size_t max = strlen(argv[1]) + 1;
    if (n < 1)
    {
        printf("ANZAHL darf nicht kleiner als 1 sein\n"
               "und muss ein Integer Wert sein!\n");
        return -1;
    }

    //--------------------------------------------------- Strings wuerfeln
    char **a = malloc(n * sizeof (char*));
    if (a == NULL)
    {
        printf("ERROR: Array-Speicher konnte nicht allokiert werden!\n");
        return -1;
    }

    // Initialisierung der Random-Bibliothek
    time_t t;
    srand((unsigned) time(&t));

    printf("Unsortiertes Array:\n");

    for (int i = n - 1; i > -1; --i)
    {
        int r = rand() % n;
        char *str = malloc(max);
        if (str == NULL)
        {
            printf("ERROR: Es konnte keine Speicher für das Array allokiert werden!\n");
            return -1;
        }
        snprintf(str, max, "%d", r);
        a[i] = str;
        printf("%s ", a[i]);
    }

    //-------------------------------------------------- Strings sortieren
    if (bubblesort(n, a) == -1)
    {
        printf("ERROR: Im Bubblesort konnte keine Speicher allokiert werden!\n");
        return -1;
    }

    //--------------------------------------------------- Strings ausgeben
    printf("\nSortiertes Array:\n");
    char* s = calloc(n * max, sizeof (char));
    if (s == NULL)
    {
        printf("ERROR: Der Speicher für den Ausgabe-String konnte"
               " nicht allokiert werden");
        return -1;
    }

    strncat(s, a[0], max);
    for (int j = 1; j < n; ++j)
    {
        if (strncmp(a[j], a[j - 1], max) == 0)
        {
            strcat(s, "*");
        }
        else
        {
            strcat(s, " ");
            strncat(s, a[j], max);
        }
    }
    printf("%s\n", s);
    free(s);

    for (int i = 0; i < n; ++i)
    {
        free(a[i]);
    }
    free(a);
    return 0;
}
