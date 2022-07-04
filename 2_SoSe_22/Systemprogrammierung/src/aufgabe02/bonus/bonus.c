//
// Created by Christopher Mogler on 20.04.22.
//
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(const int argc, const char** argv)
{
    if (argc < 3)
    {
        printf("%s [0 for first | 1 for second version] [size of the array, as int]\n", argv[0]);
        return -1;
    }

    const int run = atoi(argv[1]);
    if (run != 1 && run != 0)
    {
        printf("1 for the second part and 0 for the first part!\n");
        return -1;
    }

    const int n = atoi(argv[2]);
    if (n < 1)
    {
        printf("Set a bigger size, for the array!\n");
        return -1;
    }

    int* a = calloc(n, sizeof(int));
    if (a == NULL) {
        printf("Arrayspeicher konnte nicht allokiert werden!");
        return -1;
    }


    time_t t;
    /* init random methods */
    srand((unsigned) time(&t));

    if (run == 0)
    {
        printf("a[r] = r");
        for (int i = 0; i < n; ++i)
        {
            int r = rand() % n;
            a[r] = r;
        }
    }
    else if (run == 1)
    {
        printf("a[i] = r");
        for (int i = 0; i < n; ++i)
        {
            int r = rand() % n;
            a[i] = r;
        }
    }

    free(a);

    return 0;
}