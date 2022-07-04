/*
 * notenspiegel.c
 *
 * Liest Fachnamen mit Beurteilung ein und gibt dann einen Notenspiegel aus.
 *
 * Autor: H.Drachenfels
 * Erstellt am: 29.11.2019
 */

#include <stdio.h>
#include <stdlib.h>

#include "spo3_ain2.h"
#include "achievement.h"

#ifdef __unix__
#define EOI "Strg-D"
#else
#define EOI "Strg-Z"
#endif

int main(void)
{
    //-------------------------------------------------- Notenspiegel einlesen
    fprintf(stderr,
            "Leistungen eingeben "
            "(Noten zwichen %d und %d, Scheine B oder N, Ende mit %s):\n",
            SPO_BEST_GRADE, SPO_WORST_GRADE, EOI);

    achievement grade[AIN2_MAX_COUNT_MODUL];
    int n = 0;

    for (;;)
    {
        achievement f;
        if (! read_achievement(&f))
        {
            break;
        }
        if (n >= AIN2_MAX_COUNT_MODUL)
        {
            fprintf(stderr, "Zu viele Eingaben!\n");
            break;
        }
        grade[n++] = f;
    }

    //-------------------------------------------------- Notenspiegel ausgeben
    printf("NOTENSPIEGEL:\n");
    for (int i = 0; i < n; ++i)
    {
        print_achievement(&grade[i]);
    }

    return 0;
}
