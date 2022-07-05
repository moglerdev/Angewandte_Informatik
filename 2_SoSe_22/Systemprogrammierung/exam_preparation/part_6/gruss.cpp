#include "gruss.h"

#include <cstdio>

namespace {
    const char* GRUSS_FORMAT = "%s %s!\n";
}

void Gruss::ausgeben(std::string vorname)
{
    printf(
        GRUSS_FORMAT,
        vorname == "Sepp" ? "Servus" : "Hallo",
        vorname.c_str());
}