
#include "gruss.h"
#include <iostream>

int main() {

    std::cout << "Bitte Vorname eingeben: ";

    std::string vorname;
    std::cin >> vorname;

    Gruss::ausgeben(vorname);

    return 0;
}