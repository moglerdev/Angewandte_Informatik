//
// Created by mogler on 26.05.22.
//

#include "fachnote.h"

#include <stdexcept>

fachnote::fachnote(const std::string& fach, const benotung& note)
    : fach(fach), note(note)
{
    if (fach.length() < 1)
    {
        throw std::invalid_argument("Der Fachname darf nicht die Länge 0 haben!");
    }
}


bool operator==(fachnote a, fachnote b)
{
    return a.note == b.note;
}

bool operator<(fachnote a, fachnote b)
{
    return a.note < b.note;
}

bool operator>(fachnote a, fachnote b)
{
    return a.note > b.note;
}
