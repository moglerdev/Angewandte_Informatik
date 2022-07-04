//
// Created by mogler on 26.05.22.
//

#ifndef AIN2_SYSPROG_BENOTUNG_H
#define AIN2_SYSPROG_BENOTUNG_H


class benotung final
{
public:
    static const benotung beste;
    static const benotung schlechteste;

    explicit benotung(int note);
    benotung(int note_1, int note_2);

    int int_value() const;
    bool ist_bestanden() const;

    friend bool operator==(benotung a, benotung b);
    friend bool operator<(benotung a, benotung b);
    friend bool operator>(benotung a, benotung b);
private:
    int note;
};


#endif //AIN2_SYSPROG_BENOTUNG_H
