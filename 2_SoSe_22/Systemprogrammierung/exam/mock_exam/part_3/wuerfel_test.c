#include <stdio.h>
#include <stdlib.h>

#include "wuerfel.h"
#include "quadrat.h"

int main(const int argc, const char** argv) {
    double k = 0.0; 
    int r = sscanf(argv[1], "%lf ", &k);
    if (r < 1) {
        printf("Fehlerhafte Eingabe %lf\n", k);
        return 1;
    }

    double f = oberflaeche(k);
    double v = volumen(k);

    printf("Kantenlaenge %lf, Oberflaeche %lf, Volumen %lf\n",
        k, f, v);

    return 0;
}