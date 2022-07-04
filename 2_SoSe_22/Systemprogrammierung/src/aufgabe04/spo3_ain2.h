//
// Created by mogler on 18.05.22.
//

#ifndef AIN2_SYSPROG_SPO3_AIN2_H
#define AIN2_SYSPROG_SPO3_AIN2_H
#include <stdbool.h>

#define SPO_BEST_GRADE 10
#define SPO_WORST_GRADE 50
#define AIN2_MAX_COUNT_MODUL 11

extern bool is_spo_grade(int grade);

extern bool is_ain2_modul(const char* modul);

extern bool is_spo_assessment(char assessment);

extern void format_grade(int grade, char str_grade[]);

#endif //AIN2_SYSPROG_SPO3_AIN2_H
