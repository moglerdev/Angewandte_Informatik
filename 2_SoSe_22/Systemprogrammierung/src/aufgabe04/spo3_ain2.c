//
// Created by mogler on 19.05.22.
//
#include "spo3_ain2.h"
#include <string.h>
#include <stdio.h>

bool is_spo_grade(int grade)
{
    static const int grades[] = { 10, 13, 17, 20, 23, 27, 30, 33, 37, 40, 50 };
    static const int grades_n = sizeof grades / sizeof *grades;

    for (int i = grades_n; i > -1; --i)
    {
        if (grade == *(grades + i))
        {
            return true;
        }
    }
    return false;
}

void format_grade(int grade, char str_grade[])
{
    sprintf(str_grade, "%.1f", grade / 10.0);
    str_grade[1] = ',';
}

bool is_spo_assessment(char assessment)
{
    return assessment == 'B' || assessment == 'N';
}


bool is_ain2_modul(const char* modul)
{
    static const char* moduls[] = { "Programmiertechnik 2", "Systemprogrammierung", "Stochastik", "Rechnerarchitekturen", "Mathematik 2"};
    static const int moduls_last = 4;
    for (int i = moduls_last; i >= 0; --i)
    {
        if (strcmp(modul, moduls[i]) == 0)
        {
            return true;
        }
    }
    return false;
}

