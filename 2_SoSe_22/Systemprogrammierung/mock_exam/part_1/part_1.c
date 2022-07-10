#include <stdio.h>

typedef struct {
    int zimmer;     // 4 | 8
    char* art;      // 8 | 8
    char gebaeude;  // 1 | 8
    char test[100];
} room;             // 


int part1_main(const int argc, const char** argv) {
    int a = 1;
    int* b = &a;

    double c[] = { 2.3, 4.5 };

    room d = {
        109,
        "Hoersaal",
        'C'
    };

    room* e = &((room){
        124,
        "Buero",
        'F'
    });

    printf("\nint a = 1\n\tsize: %lu\n", sizeof(a));

    printf("\nint* b = &a\n\tsize: %lu\n", sizeof(b));

    printf("\ndouble c[] = {...}\n\tsize: %lu\n", sizeof(c));

    printf("\nroom d = {...}\n\tsize: %lu\n", sizeof(d));

    printf("\nroom* e = {...}\n\tsize: %lu\n", sizeof(e));

    printf("\nroom.zimmer\n\tsize: %lu\n", sizeof(d.zimmer));
    printf("\nroom.art\n\tsize: %lu\n", sizeof(d.art));
    printf("\nroom.gebaeude\n\tsize: %lu\n", sizeof(d.gebaeude));
    printf("\nroom.test\n\tsize: %lu\n", sizeof(d.test));

    return 0;
}


// 0x5555555592a0

// 0x5555555592c0