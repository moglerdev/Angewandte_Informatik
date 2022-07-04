//
// Created by mogler on 26.05.22.
//

#ifndef AIN2_SYSPROG_FACHNOTE_H
#define AIN2_SYSPROG_FACHNOTE_H

#include "benotung.h"
#include <string>
#include <memory>

class fachnote final
{
public:

    const std::string fach;
    const benotung note;

    fachnote(const std::string& fach, const benotung& note);

    fachnote(const fachnote&) = delete;
    fachnote(fachnote&&) = delete;

    fachnote& operator=(const fachnote&) = delete;
    fachnote& operator=(fachnote&&) = delete;


    friend bool operator==(fachnote a, fachnote b);

    friend bool operator<(fachnote a, fachnote b);

    friend bool operator>(fachnote a, fachnote b);
};


#endif //AIN2_SYSPROG_FACHNOTE_H
