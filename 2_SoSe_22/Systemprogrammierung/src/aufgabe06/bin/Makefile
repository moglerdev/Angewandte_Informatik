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

CXX = g++ -g#-fno-elide-constructors
STD=c++11

LIBRARY =

LIBNAME = aufgabe06
LDLIBS = -l$(LIBNAME)
LIBTYPE = a
LDFLAGS = -L$(LIBRARY)

CPPFLAGS =-I$(LIBRARY)
CXXFLAGS = -Wall -fPIC -Wextra -Werror -std=$(STD) -pedantic

CPPCHECK = cppcheck --enable=warning,style --std=$(STD)
RM = rm -f

TARGET = notenspiegel


OBJECTS = \
	$(TARGET).o

SOURCES = $(OBJECTS:.o=.cpp)
HEADERS = \
	$(LIBRARY)benotung.h \
	$(LIBRARY)fachnote.h \
	$(LIBRARY)fachnoten_liste.h \

.PHONY: all clean cppcheck

all: $(TARGET)

clean:
	rm -f $(TARGET) $(OBJECTS) depend

$(TARGET): $(OBJECTS) $(LIBRARY)lib$(LIBNAME).$(LIBTYPE)
	$(CXX) $(LDFLAGS) $< $(LDLIBS) -o $@

%.o: %.cpp
	$(CXX) $(CPPFLAGS) $(CXXFLAGS) $(LDLIBS) -c  $< -o $@

depend: $(SOURCES) $(HEADERS)
	$(CXX) $(CPPFLAGS) -MM $(SOURCES) > $@

include depend