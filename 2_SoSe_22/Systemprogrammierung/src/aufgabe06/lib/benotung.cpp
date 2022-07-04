//
// Created by mogler on 26.05.22.
//

#include "benotung.h"
#include <stdexcept>

const benotung benotung::beste{10};
const benotung benotung::schlechteste{50};

namespace {
    bool is_valid(int note);
}

benotung::benotung(int note)
        : note(note)
{
    if (!is_valid(note))
    {
        throw std::invalid_argument("unzulaessige Note " + std::to_string(note));
    }
}

benotung::benotung(int note_1, int note_2)
    : note((note_1 + note_2) / 2)
{
    if (!is_valid(note_1))
    {
        throw std::invalid_argument("unzulaessige Note " + std::to_string(note_1));
    }
    if (!is_valid(note_2))
    {
        throw std::invalid_argument("unzulaessige Note " + std::to_string(note_2));
    }
}

int benotung::int_value() const
{
    return this->note;
}

bool benotung::ist_bestanden() const
{
    return this->note <= 40;
}

bool operator==(benotung a, benotung b)
{
    return a.note == b.note;
}

bool operator<(benotung a, benotung b)
{
    return a.note < b.note;
}

bool operator>(benotung a, benotung b)
{
    return a.note > b.note;
}


namespace {
    bool is_valid(int note)
    {
        switch (note)
        {
            case 10:
            case 13:
            case 17:
            case 20:
            case 23:
            case 27:
            case 30:
            case 33:
            case 37:
            case 40:
            case 50:
                return true;
            default:
                return false;
        }
    }
}