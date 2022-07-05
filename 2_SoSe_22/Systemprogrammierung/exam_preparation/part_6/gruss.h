
#ifndef __GRUSS_H__
#define __GRUSS_H__

#include <iostream>

class Gruss
{
    Gruss(/* args */) = delete;
    ~Gruss() = delete;

public:
    static void ausgeben(std::string vorname);
};

#endif // __GRUSS_H__