//
// Created by mogler on 14.06.22.
//

#ifndef AIN2_SYSPROG_WUERFEL_H
#define AIN2_SYSPROG_WUERFEL_H

static double zumquadrat(const double d) {
    return d * d;
}

extern double flaeche(double seitenlaenge) {
    return zumquadrat(seitenlaenge);
}

#endif //AIN2_SYSPROG_WUERFEL_H

