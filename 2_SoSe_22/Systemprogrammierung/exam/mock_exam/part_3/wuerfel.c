
#include "wuerfel.h"

#include "quadrat.h"

double oberflaeche(double kantenlaenge)  {
    return flaeche(kantenlaenge) * 6;
}

double volumen(double kantenlaenge) {
    return flaeche(kantenlaenge) * kantenlaenge;
}
