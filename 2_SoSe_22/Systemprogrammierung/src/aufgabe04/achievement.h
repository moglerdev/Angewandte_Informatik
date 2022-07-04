//
// Created by mogler on 18.05.22.
//

#ifndef AIN2_SYSPROG_ACHIEVEMENT_H
#define AIN2_SYSPROG_ACHIEVEMENT_H
#include <stdbool.h>

#include "spo3_ain2.h"

#define MAX_MODULE_NAME_LENGTH 20

enum achievement_type {graded, ungraded};
// Wieviel Byte Speicher benötigt eine Variabel vom Typ leistung? 32
struct Achievement
{
    char modul_name[MAX_MODULE_NAME_LENGTH + 1];    // + 21
    enum achievement_type type;                     // + 4
    union                                           // + 4
    {
        int grade;
        char assessment; // B = bestanden; N = nicht bestanden
    };
};

typedef struct Achievement achievement;

extern int format_modul_name(const char* _name);
extern bool read_achievement(achievement * _achievement);
extern void print_achievement(achievement * _achievement);

#endif //AIN2_SYSPROG_ACHIEVEMENT_H
