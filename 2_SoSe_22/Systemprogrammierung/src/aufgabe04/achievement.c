//
// Created by mogler on 19.05.22.
//
#include "achievement.h"

#include <stdio.h>
#include <string.h>

#define STR_HELPER(x) #x
#define STR(x) STR_HELPER(x)

int format_modul_name(const char* _name)
{
    char * pch = strchr(_name, '_');
    if (pch == NULL) return 0;
    int res = 0;
    while (NULL != (pch = strchr(pch, '_')))
    {
        ++res;
        *pch = ' ';
        pch = pch + 1;
    }
    return res;
}

bool read_achievement(achievement * _achievement)
{
    _achievement->type = graded;
    int l = scanf("%" STR(MAX_MODULE_NAME_LENGTH) "s %d", _achievement->modul_name, &_achievement->grade);
    if (l == EOF) return false;
    if (l != 2)
    {
        l = scanf("%c", &_achievement->assessment);
        if (l == EOF) return false;
        if (l != 1)
        {
            return false;
        }
        _achievement->type = ungraded;
    }
    if (format_modul_name(_achievement->modul_name) == -1)
    {
        return false;
    }

    return true;
}

static void print_ungraded(char state) {
    printf("S\t");
    if (is_spo_assessment(state))
    {
        printf("%s\n", state == 'B' ? "bestanden" : "nicht bestanden");
    }
    else
    {
        printf("Fehler: %c\n", state);
    }
}

static void print_graded(int grade) {
    printf("L\t");
    if (is_spo_grade(grade))
    {
        char str[11];
        format_grade(grade, str);
        printf("%s\n", str);
    }
    else
    {
        printf("Fehler: %d\n", grade);
    }
}

void print_achievement(achievement * _achievement)
{
    if (!is_ain2_modul(_achievement->modul_name))
    {
        printf("Fehler: %s\n", _achievement->modul_name);
    }
    else
    {
        printf("%-*s\t", MAX_MODULE_NAME_LENGTH, _achievement->modul_name);

        int _type = _achievement->type;
        if (_type == ungraded)
        {
            print_ungraded(_achievement->assessment);
        }
        else
        {
            print_graded(_achievement->grade);
        }
    }
}
