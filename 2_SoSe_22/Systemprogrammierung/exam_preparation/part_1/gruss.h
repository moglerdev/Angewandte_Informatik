#include <string.h>
#include <stdio.h>

void ausgeben(const char* vorname) {
    static const char* gruss_format = "%s %s!\n";

    if (strcmp(vorname, "Sepp") == 0) {
        printf(gruss_format, "Servus", vorname);
    } else {
        printf(gruss_format, "Hallo", vorname);
    }
}

