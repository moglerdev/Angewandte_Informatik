//
// Created by mogler on 20.04.22.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int get_int(int* result);

int main(int argc, char *argv[])
{
    // --------------- Arraygroesse einlesen
    if (argc < 1)
    {
        printf("%s [ANZAHL]\n", argv[0]);
        return 1;
    }

    const int n = atoi(argv[1]);
    int* a = calloc(n, sizeof(int));

    if (a == NULL) {
        printf("Das Array für die Eingabe konnte nicht allokiert werden");
        return 1;
    }

    // --------------- Zahlen einlesen

    printf("Bitte %d ganze Zahlen eingeben:\n", n);
    int k = 0;

    while (k < n && get_int(&a[k])  == 0)
    {
        ++k;
    }

    time_t t;
    /* Initialisierung der Random-Bibliothek */
    srand((unsigned) time(&t));

    for (int i = k; i < n; ++i)
    {
        // fill the rest space with random integers
        a[i] = rand();
    }

    // --------------- Zahlen sortieren
    for (int i = n; i > 1; --i)
    {
        // groesste Werte nach hinten schieben
        for (int j = 0; j < i - 1; ++j)
        {
            if (a[j] > a[j + 1])
            {
                int tmp = a[j + 1];
                a[j + 1] = a[j];
                a[j] = tmp;
            }
        }
    }

    // --------------- Zahlen ausgeben
    printf("Sortierte Zahlenfolge:\n");
    for (int i = 0; i < n; ++i)
    {
        printf("%d\n", a[i]);
    }

    // --------------- Reservierter Speicher freigeben

    free(a); // free allocated space from "a" Array

    return 0;
}

// Integer über die Konsole einlesen,
//      mit Buffer-Overflow schutz.
int get_int(int* result)
{
    int stat = 1;
    const int line_size = sizeof(int) * 4;
    char *line = malloc(line_size);
    if (line == NULL) {
        printf("get_int konnte keine Arrayspeicher allokieren!");
        return -1;
    }

    // fgets ist sicherer gegen Buffer-Overflow.
    if (line != NULL && fgets(line, line_size, stdin) != NULL)
    {
        int val = 0;
        int t = sscanf(line, "%d", &val); //
        if (t > 0)
        {
            *result = val;
            stat = 0;
        }
    }
    free((void *)line);
    return stat;
}
