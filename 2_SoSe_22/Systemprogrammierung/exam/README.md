**Systemprogrammierung Spickzettel**

**ILP32 vs LP64**

| Data Type                          | 32-bit sizes (in bytes) | 64-bit sizes (in bytes) |
| ---------------------------------- | ----------------------- | ----------------------- |
| char                               | 1                       | 1                       |
| short                              | 2                       | 2                       |
| int                                | 4                       | 4                       |
| long                               | 4                       | 8                       |
| long long                          | 8                       | 8                       |
| float                              | 4                       | 4                       |
| double                             | 8                       | 8                       |
| long double                        | 16                      | 16                      |
| pointer                            | 4                       | 8                       |
| wchar_t                            | 2                       | 4                       |
| size_t (This is an unsigned type.) | 4                       | 8                       |
| ptrdiff_t (This is a signed type.) | 4                       | 8                       |

**nicht ausgerichtet**

```c
struct adr {
    int x;          	// 4    |   4 (+4)
    const char* z;   	// 8    |   8 (+0)
    char y;  			// 1    |   1 (+7)
                        // _____|__________
}                       // = 13 |   24
```

![img](https://media.geeksforgeeks.org/wp-content/uploads/struct_sizeof_ex1-300x154.png)

**ausgerichtet**

```c
struct adr {
    const char* z;   	// 8    |   8 (+0)
    int x;          	// 4    |   4 (+0)
    char y;  			// 1    |   1 (+3)
                        // _____|__________
}                       // = 13 |   16
```

![img](https://media.geeksforgeeks.org/wp-content/uploads/struct_sizeof_ex2-300x124.png)

**makefile**


```makefile
TARGET = hello
LATEX = pdflatex

.PHONY: all clean

all: $(TARGET).pdf

clean:
	rm *.pdf *.aux *.log

%.pdf: %.tex	
	$(LATEX) $^
```

```makefile
CC = gcc -g -fno-stack-protector -Wwrite-strings
CFLAGS = -Wall -Wextra -std=$(STD) -pedantic
CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
STD = c11

TARGET = minecraft

OBJECTS = \

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	$(RM) $(TARGET) $(TARGET).o $(OBJECTS)

$(TARGET): $(TARGET).o $(OBJECTS)
	$(CC) $(LDFLAGS) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $<
```

**Speicherplan zu C-Anweisung**

![image-20220711230928142](/home/mogler/.config/Typora/typora-user-images/image-20220711230928142.png)

```c
struct zimmer { int zimmer; const char* art; char gebaeude; };
int main(void) {
    struct zimmer d = { 124, "Buero", 'F'};
    struct zimmer *e = &d;
    return 0;
}
```

**C++ Klasse** (das ist ja klasse!)

```c++
class person final {
public:
    person() = default;
    explicit person(int);
    person(double);
    
    friend person operator&&(const person&, const person&);
    friend person operator||(const person&, const person&);
    
    // RULE OF FIVE (werden immer vom Compiler definiert, wenn nicht angegeben)
    // Destructor, wird beim löschen (delete) des Objektes ausgeführt. 
    ~person() = default;
    // Copy Constructor und Assignment
    person(const person&) = default; // person p2{ p1 };
    person& operator=(const person&) = default; // p2 = p1;
    // Move Constructor und Assignment
    person(person&&) = default; // person p2 = std::move()
    person& operator=(person&&) = default;
    // END RULE OF FIVE
private:
    int alter;
}
```

**rule of five** (früher **rule of three**, seit C++11 ist der Move-Befehl dazu gekommen)
wenn einer der Fünf definiert wird, müssen alle anderen auch definiert oder als deleted markiert sein!

**Übersetzungseinheit** (bsp. Quadrat)

```c
// quadrat.h
#ifndef QUADRAT_H // damit de
#define QUADRAT_H
extern double flaeche(double seitenlaenge); //extern = public
#endif //AIN2_SYSPROG_QUADRAT_H
```

```c
// quadrat.c
#include "quadrat.h"
static double zumquadrat(const double d) { //static = private
    return d * d;
}
double flaeche(double seitenlaenge) {
    return zumquadrat(seitenlaenge);
}
```

**sscanf**

```c
#include <stdio.h> 	// printf, sscanf
#include <stdlib.h>	// malloc, free
#include <string.h> // strcat, strlen (e.g. strXXX)

int main(const int argc, const char** argv) {
    double k = 0.0; int r = sscanf(argv[1], "%lf ", &k);
    if (r < 1) { return 1; } // fehler beende das Programm
    printf("%lf", k);
    const char* s = argv[1]; const char* t = argv[2];
    const char* st = malloc(strlen(s) + strlen(t) + 1);
    strcat(st, s); strcat(st, t);
    printf("%s\n", st); free(st);
    return 0;
}
```

