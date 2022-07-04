# Aufgabe6/bin/Makefile
# ------------------------
# erstellt ein ausführbares Programm notenspiegel,
# das mit einer der Bibliotheken aus dem Unterverzeichnis lib gebunden ist.
# Es sind die gleichen Stilregeln und Anforderungen wie bei Aufgabe6/lib/Makefile umzusetzen.
#
# Verwenden Sie im Makefile die gcc-Optionen -I, -L und -l,
# damit die Bibliothek und deren Header-Dateien gefunden werden.
# Die Option -I gehört zu den Präprozessor-Optionen, für die die Variable
# CPPFLAGS vorgesehen ist. Die Option -L gehört zu den Linker-Optionen,
# für die die Variable LDFLAGS vorgesehen ist.

CPP = g++ #-fno-elide-constructors
STD=c++11

CPPFLAGS = -I ../lib -Wall -Wextra -Werror -Weffc++ -Wold-style-cast -std=$(STD) -pedantic
LDFLAGS = -L../lib -laufgabe06

CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
RM = rm -f $(OBJECTS) $(TARGET) depend

OBJECTS = \
	notenspiegel.o
SOURCES = $(OBJECTS:.o=.cpp)
# HEADERS = $(OBJECTS:.o=.h)

TARGET = notenspiegel

.PHONY: all clean cppcheck

all: $(TARGET)

$(TARGET): $(TARGET).o $(OBJECTS)
	$(CPP) -c $(CPPFLAGS) $(SOURCES)
	$(CPP) -g $(CPPFLAGS) -o $@ $^ $(LDFLAGS)

clean:
	$(RM)

depend: $(SOURCES) $(HEADERS)
	$(CPP) -g $(CPPFLAGS) -MM $(SOURCES) > $@

cppcheck: $(OBJECTS:.o=.cpp)
	$(CPPCHECK) $^

include depend